package by.tc.epam.controller;



import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.CommandNavigator;
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response){

        String command = request.getParameter(ConstantContainer.COMAND);

        CommandNavigator commandNavigator = CommandNavigator.getInstance();
        Command concreteCommand = commandNavigator.getCommand(command);

        concreteCommand.execute(this, request, response);
    }
}
