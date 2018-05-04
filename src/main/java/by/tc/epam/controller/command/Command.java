package by.tc.epam.controller.command;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response);

}
