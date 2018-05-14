package by.tc.epam.controller;

import by.tc.epam.controller.command.Command;
import by.tc.epam.controller.command.CommandNavigator;
import by.tc.epam.util.ConstantContainer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BukmakerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        processRequest(request, response);
    }

    /**
     *
     * @param request
     * @param response
     *
     * method navigte request to concrete command and execute him
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response){

        String command = request.getParameter(ConstantContainer.COMAND);
        String urlPrefix = request.getContextPath();

        CommandNavigator commandNavigator = CommandNavigator.getInstance();
        Command concreteCommand = commandNavigator.getCommand(command);

        concreteCommand.execute(this, request, response, urlPrefix);
    }
}
