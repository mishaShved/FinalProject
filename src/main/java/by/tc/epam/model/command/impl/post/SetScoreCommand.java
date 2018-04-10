package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.service.EventService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetScoreCommand implements Command{

    ServiceFactory factory = ServiceFactory.getInstance();
    EventService service = factory.getEventService();

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        int eventId = Integer.parseInt(request.getParameter("eventId"));
        int score1 = Integer.parseInt(request.getParameter("score1"));
        int score2 = Integer.parseInt(request.getParameter("score2"));


        try {


            service.setScore(eventId, score1, score2);


        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (DBWorkingException e) {
            e.printStackTrace();
        }

    }
}
