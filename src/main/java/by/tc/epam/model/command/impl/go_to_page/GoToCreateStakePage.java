package by.tc.epam.model.command.impl.go_to_page;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.OddService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.util.FinalStringsContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToCreateStakePage implements Command{


    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory factory = ServiceFactory.getInstance();
        OddService oddService = factory.getOddService();
        UserService userService = factory.getUserService();

        User user = (User)request.getSession().getAttribute(FinalStringsContainer.USER);

        int userId = user.getId();
        int oddId = Integer.parseInt(request.getParameter(FinalStringsContainer.ODD_ID));

        String oddInfo;
        String oddOutcome;
        double coef;
        double balance;

        try {

            balance = userService.getUserBalance(userId);
            oddInfo = oddService.getInfoAboutOdd(oddId);
            oddOutcome = oddService.getOddType(oddId);
            coef = oddService.getCoef(oddId);

            request.setAttribute(FinalStringsContainer.ODD_INFO, oddInfo);
            request.setAttribute(FinalStringsContainer.ODD_OUTCOME, oddOutcome);
            request.setAttribute(FinalStringsContainer.COEF, coef);
            request.setAttribute(FinalStringsContainer.BALANCE, balance);
            request.setAttribute(FinalStringsContainer.ODD_ID, oddId);

            servlet.getServletContext().getRequestDispatcher("/jsp/CreateStakePage.jsp").forward(request, response);

        } catch (DataSourceException e) {
            e.printStackTrace();
        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
