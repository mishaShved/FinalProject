package by.tc.epam.controller.command.impl.get;

import by.tc.epam.controller.command.Command;
import by.tc.epam.model.entity.OddsList;
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

public class GetOddsByEventCommand implements Command{

    private static final Logger log = Logger.getLogger(GetOddsByEventCommand.class);

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory factory = ServiceFactory.getInstance();
        OddService oddService = factory.getOddService();
        UserService userService = factory.getUserService();

        int eventId = Integer.parseInt(request.getParameter(ConstantContainer.EVENT_ID));

        User user = (User)request.getSession().getAttribute(ConstantContainer.USER);
        int userId = 0;
        double balance;

        if(user != null) {
            userId = user.getId();
        }

        try {

            OddsList odds = oddService.getOddsByEvent(eventId);

            if(user != null){
                balance = userService.getUserBalance(userId);
                request.setAttribute(ConstantContainer.BALANCE, balance);
            }

            request.setAttribute(ConstantContainer.ODDS, odds);

            servlet.getServletContext().getRequestDispatcher("/jsp/ShowOdds.jsp").
                    forward(request, response);

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
