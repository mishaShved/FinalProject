package by.tc.epam.model.command.impl.go_to_page;

import by.tc.epam.model.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToCreateEventPage implements Command {

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        try {
            servlet.getServletContext().getRequestDispatcher("/jsp/admin_page/CreateEventPage.jsp")
                    .forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
