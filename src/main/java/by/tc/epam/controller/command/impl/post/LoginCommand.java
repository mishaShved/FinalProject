package by.tc.epam.controller.command.impl.post;

import by.tc.epam.controller.command.Command;
import by.tc.epam.model.validation.Validation;
import by.tc.epam.model.validation.ValidationFactory;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.entity.UserType;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.LoginFailedException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {

    private static final Logger log = Logger.getLogger(LoginCommand.class);


    /**
     *
     * @param servlet
     * @param request
     * @param response
     * @param urlPrefix
     *
     * Command execute user login
     *
     */
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {

        ValidationFactory validationFactory = ValidationFactory.getInstance();
        Validation validation = validationFactory.getLoginValidation();

        if(validation.validate(request)) {

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

                if (user.getUserType() == UserType.USER) {

                    request.setAttribute(ConstantContainer.BALANCE, balance);

                    if (oddID == null) {

                        servletContext.getRequestDispatcher
                                (ConstantContainer.START_PAGE).forward(request, response);
                    } else {

                        servletContext.getRequestDispatcher
                                (ConstantContainer.CONCRETE_ODD_PAGE + oddID)
                                .forward(request, response);
                        request.getSession().setAttribute(ConstantContainer.ODD_ID, null);
                    }


                } else {

                    servletContext.getRequestDispatcher
                            (ConstantContainer.ADMIN_PAGE).forward(request, response);
                }


            } catch (DataSourceException e) {
                log.error("Problems with data source", e);
            } catch (ServiceSQLException e) {
                log.error("SQL error", e);
            } catch (ServletException e) {
                log.error("Servlet error", e);
            } catch (IOException e) {
                log.error("Error in pages path", e);
            } catch (LoginFailedException e) {

                request.setAttribute("loginFalse", true);

                try {
                    servlet.getServletContext().getRequestDispatcher
                            ("/jsp/LoginPage.jsp")
                            .forward(request, response);
                } catch (IOException e1) {
                    log.error("Error in pages path", e);
                } catch (ServletException e1) {
                    log.error("Servlet error", e);
                }
                request.setAttribute("loginFalse", false);
            }

        }else{
            try {
                response.sendRedirect(urlPrefix + ConstantContainer.BAD_REQUEST_PAGE);
            } catch (IOException e) {
                log.error("Error page not found " + e);
            }
        }
    }
}
