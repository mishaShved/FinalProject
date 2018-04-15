package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.service.EventService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.util.FinalStringsContainer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetScoreCommand implements Command{

    ServiceFactory factory = ServiceFactory.getInstance();
    EventService service = factory.getEventService();

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        int eventId = Integer.parseInt(request.getParameter(FinalStringsContainer.EVENT_ID));
        int score1 = Integer.parseInt(request.getParameter(FinalStringsContainer.SCORE1));
        int score2 = Integer.parseInt(request.getParameter(FinalStringsContainer.SCORE2));


        try {


            service.setScore(eventId, score1, score2);
            response.sendRedirect("/jsp/admin_page/AdminPage.jsp");


        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (DataSourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
