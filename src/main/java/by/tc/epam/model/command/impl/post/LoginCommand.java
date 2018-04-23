package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.dao.transaction_dao.impl.RequestContainer;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.entity.UserType;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.LoginFailedException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter(ConstantContainer.ID));
        String password = request.getParameter(ConstantContainer.PASSWORD);
        Integer oddID = (Integer) request.getSession().getAttribute(ConstantContainer.ODD_ID);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService service = serviceFactory.getUserService();

        ServletContext servletContext;
        double balance;
        User user;

        try {

            servletContext = servlet.getServletContext();

            user = service.login(id, password);
            balance = service.getUserBalance(id);

            request.getSession().setAttribute(ConstantContainer.USER, user);

            if(user.getUserType() == UserType.USER) {

                request.setAttribute(ConstantContainer.BALANCE, balance);

                if(oddID == null) {

                    servletContext.getRequestDispatcher
                            ("/jsp/StartPage.jsp").forward(request, response);
                }else{

                    servletContext.getRequestDispatcher
                            ("/MishaBet?command=goToCreateStakePage&oddId=" + oddID)
                            .forward(request, response);
                    request.getSession().setAttribute(ConstantContainer.ODD_ID, null);
                }


            }else{

                servletContext.getRequestDispatcher
                        ("/jsp/admin_page/AdminPage.jsp").forward(request, response);
            }


        } catch (ServerOverloadException | ServiceSQLException
                | DataSourceException | LoginFailedException e) {

            try {

                response.sendRedirect("/WEB-INF/jsp/Failed.jsp");

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
