package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.impl.get.GetEventsBySportTypeCommand;
import by.tc.epam.util.ConstantContainer;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command{

    private static final Logger log = Logger.getLogger(LogoutCommand.class);

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        request.getSession().setAttribute(ConstantContainer.USER, null);

        try {

            response.sendRedirect("/MishaBet");

        } catch (IOException e) {
            log.error("Error in pages path", e);
        }



    }

}
