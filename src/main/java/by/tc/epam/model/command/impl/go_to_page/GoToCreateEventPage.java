package by.tc.epam.model.command.impl.go_to_page;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.impl.get.GetEventsBySportTypeCommand;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToCreateEventPage implements Command {

    private static final Logger log = Logger.getLogger(GoToCreateEventPage.class);

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

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
