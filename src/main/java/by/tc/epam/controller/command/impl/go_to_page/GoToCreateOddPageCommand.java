package by.tc.epam.controller.command.impl.go_to_page;

import by.tc.epam.controller.command.Command;
import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.OddType;
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

public class GoToCreateOddPageCommand implements Command{

    private static final Logger log = Logger.getLogger(GoToCreateEventPage.class);

    /**
     *
     * @param servlet
     * @param request
     * @param response
     * @param urlPrefix
     *
     * Prepare attributes for page to create odd
     *
     */
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {

        ServiceFactory factory = ServiceFactory.getInstance();
        EventService service = factory.getEventService();

        String locale = (String)request.getSession().getAttribute(ConstantContainer.LOCALE);

        try {

            List<Event> events = service.getEventsForAddOdd(locale);

            request.setAttribute(ConstantContainer.EVENTS_LIST, events);
            request.setAttribute(ConstantContainer.ODD_TYPES, OddType.values());
            request.setAttribute(ConstantContainer.ODD_TYPES_COUNT, OddType.values().length - 1);

            servlet.getServletContext().getRequestDispatcher(ConstantContainer.CREATE_ODD_PAGE)
                    .forward(request, response);


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
