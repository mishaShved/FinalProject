package by.tc.epam.model.command.impl;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.entity.Event;
import by.tc.epam.model.service.EventService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllEventsCommand implements Command {

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory factory = ServiceFactory.getInstance();
        EventService service = factory.getEventService();

        try {


            List<Event> allEvents = service.getAllEvents();
            request.setAttribute("events", allEvents);

            servlet.getServletContext().getRequestDispatcher("/WEB-INF/jsp/AllEvents.jsp").
                    forward(request,response);

        } catch (DBWorkingException e) {
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
