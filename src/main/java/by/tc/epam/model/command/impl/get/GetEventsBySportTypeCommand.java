package by.tc.epam.model.command.impl.get;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.service.EventService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.util.ConstantContainer;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GetEventsBySportTypeCommand implements Command {

    private static final Logger log = Logger.getLogger(GetEventsBySportTypeCommand.class);

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {


        ServiceFactory factory = ServiceFactory.getInstance();
        EventService service = factory.getEventService();

        Sport sportType = Sport.valueOf(request.getParameter(ConstantContainer.SPORT_TYPE));

        try {

            List<Event> events = service.getEventsBySport(sportType);
            request.setAttribute(ConstantContainer.EVENTS, events);

            servlet.getServletContext().getRequestDispatcher("/jsp/TableBody.jsp")
                    .forward(request,response);

            log.info("sddd");

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
