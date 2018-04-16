package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.util.ConstantContainer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command{

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        request.getSession().setAttribute(ConstantContainer.USER, null);

        try {

            response.sendRedirect("/MishaBet");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
