package by.tc.epam.controller.command.impl.go_to_page;

import by.tc.epam.controller.command.Command;
import by.tc.epam.controller.command.impl.get.GetEventsBySportTypeCommand;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToCreateEventPage implements Command {

    private static final Logger log = Logger.getLogger(GoToCreateEventPage.class);


    /**
     *
     * @param servlet
     * @param request
     * @param response
     * @param urlPrefix
     *
     * Prepare attributes for page to create event
     *
     */
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {

        try {

            servlet.getServletContext().getRequestDispatcher("/jsp/admin_page/CreateEventPage.jsp")
                    .forward(request, response);

        } catch (ServletException e) {
            log.error("Servlet error", e);
        } catch (IOException e) {
            log.error("Error in pages path", e);
        }


    }
}
