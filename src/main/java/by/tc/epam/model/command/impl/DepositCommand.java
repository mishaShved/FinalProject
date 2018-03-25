package by.tc.epam.model.command.impl;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.UserDAO;
import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.dao.impl.UserDAOImpl;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepositCommand implements Command {

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService service = serviceFactory.getUserService();

        User user = (User)request.getSession().getAttribute(FinalStringsContainer.USER);
        double money = Double.parseDouble(request.getParameter(FinalStringsContainer.VALUE));
        double value;

        try {

            service.deposit(user.getId(), money);
            value = service.getUserBalance(user.getId());

            request.setAttribute(FinalStringsContainer.BALANCE, value);


            try {
                servlet.getServletContext().getRequestDispatcher
                        ("/WEB-INF/jsp/RegistredUser.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }


        } catch (ServerOverloadException | ServiceSQLException
                | DBWorkingException | IOException e) {

            e.printStackTrace();
        }

    }

}
