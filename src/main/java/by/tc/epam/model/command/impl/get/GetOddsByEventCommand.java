package by.tc.epam.model.command.impl.get;

import by.tc.epam.model.command.Command;
import by.tc.epam.util.FinalStringsContainer;
import by.tc.epam.model.entity.OddsList;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.OddService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOddsByEventCommand implements Command{



    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory factory = ServiceFactory.getInstance();
        OddService oddService = factory.getOddService();
        UserService userService = factory.getUserService();

        int eventId = Integer.parseInt(request.getParameter(FinalStringsContainer.EVENT_ID));

        User user = (User)request.getSession().getAttribute(FinalStringsContainer.USER);
        int userId = 0;
        double balance;

        if(user != null) {
            userId = user.getId();
        }

        try {

            OddsList odds = oddService.getOddsByEvent(eventId);

            if(user != null){
                balance = userService.getUserBalance(userId);
                request.setAttribute(FinalStringsContainer.BALANCE, balance);
            }

            request.setAttribute(FinalStringsContainer.ODDS, odds);

            servlet.getServletContext().getRequestDispatcher("/jsp/ShowOdds.jsp").
                    forward(request, response);

        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (DataSourceException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
