package by.tc.epam.model.command.impl.go_to_page;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.impl.get.GetEventsBySportTypeCommand;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.OddService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.util.ConstantContainer;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToCreateStakePage implements Command{

    private static final Logger log = Logger.getLogger(GoToCreateStakePage.class);

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory factory = ServiceFactory.getInstance();
        OddService oddService = factory.getOddService();
        UserService userService = factory.getUserService();

        User user = (User)request.getSession().getAttribute(ConstantContainer.USER);
        int oddId = Integer.parseInt(request.getParameter(ConstantContainer.ODD_ID));

        if(user == null){
            try {
                request.getSession().setAttribute(ConstantContainer.ODD_ID, oddId);
                servlet.getServletContext().getRequestDispatcher("/jsp/LoginPage.jsp").forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }else {

            int userId = user.getId();

            String oddInfo;
            String oddOutcome;
            double coef;
            double balance = 0;

            try {

                balance = userService.getUserBalance(userId);
                oddInfo = oddService.getInfoAboutOdd(oddId);
                oddOutcome = oddService.getOddType(oddId);
                coef = oddService.getCoef(oddId);

                request.setAttribute(ConstantContainer.ODD_INFO, oddInfo);
                request.setAttribute(ConstantContainer.ODD_OUTCOME, oddOutcome);
                request.setAttribute(ConstantContainer.COEF, coef);
                request.setAttribute(ConstantContainer.BALANCE, balance);
                request.setAttribute(ConstantContainer.ODD_ID, oddId);

                servlet.getServletContext().getRequestDispatcher("/jsp/CreateStakePage.jsp").forward(request, response);

            } catch (DataSourceException e) {
                log.error("Problems with data source", e);
            } catch (ServiceSQLException e) {
                log.error("SQL error", e);
            } catch (ServletException e) {
                log.error("Servlet error", e);
            } catch (IOException e) {
                log.error("Error in pages path", e);
            }

        }

    }
}
