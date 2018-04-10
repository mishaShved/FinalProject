package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.impl.FinalStringsContainer;
import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.UserDAO;
import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.dao.impl.UserDAOImpl;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.entity.UserType;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.LoginFailedException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter(FinalStringsContainer.ID));
        String password = request.getParameter(FinalStringsContainer.PASSWORD);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService service = serviceFactory.getUserService();

        double balance;
        User user;

        try {

            user = service.login(id, password);
            balance = service.getUserBalance(id);

            request.getSession().setAttribute(FinalStringsContainer.USER, user);

            if(user.getUserType() == UserType.USER) {

                request.setAttribute(FinalStringsContainer.BALANCE, balance);

                servlet.getServletContext().getRequestDispatcher
                        ("/jsp/StartPage.jsp").forward(request, response);
            }else{
                servlet.getServletContext().getRequestDispatcher
                        ("/jsp/admin_page/AdminPage.jsp").forward(request, response);
            }


        } catch (ServerOverloadException | ServiceSQLException
                | DBWorkingException | LoginFailedException e) {

            try {

                servlet.getServletContext().getRequestDispatcher
                        ("/WEB-INF/jsp/Failed.jsp").forward(request,response);

            } catch (ServletException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
