package by.tc.epam.controller;



import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.CommandNavigator;
import by.tc.epam.model.dao.UserDAO;
import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.dao.impl.UserDAOImpl;
import by.tc.epam.model.entity.User;
import by.tc.epam.util.FinalStringsContainer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

        String command = request.getParameter(FinalStringsContainer.COMAND);

        CommandNavigator commandNavigator = CommandNavigator.getInstance();
        Command concreteCommand = commandNavigator.getCommand(command);

        concreteCommand.execute(this, request, response);
    }
}
