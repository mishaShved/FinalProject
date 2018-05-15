package by.tc.epam.controller.command.impl.post;

import by.tc.epam.controller.command.Command;
import by.tc.epam.model.validation.Validation;
import by.tc.epam.model.validation.ValidationFactory;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.UserAlreadyExistException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command{

    private static final Logger log = Logger.getLogger(RegistrationCommand.class);

    /**
     *
     * @param servlet
     * @param request
     * @param response
     * @param urlPrefix
     *
     * Command execute user registration
     *
     */
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {

        ValidationFactory validationFactory = ValidationFactory.getInstance();
        Validation validation = validationFactory.getRegistrationValidation();

        if(validation.validate(request)) {


            String name = request.getParameter(ConstantContainer.NAME);
            String password = request.getParameter(ConstantContainer.PASSWORD);
            String email = request.getParameter(ConstantContainer.EMAIL);

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService service = serviceFactory.getUserService();

            int userID;

            try {


                userID = service.registration(name, email, password);
                request.getSession().setAttribute(ConstantContainer.USER_ID, userID);
                response.sendRedirect(urlPrefix + ConstantContainer.DEFAULT_APPLICATION_URL);


            } catch (DataSourceException e) {
                log.error("Problems with data source", e);
            } catch (ServiceSQLException e) {
                log.error("SQL error", e);
            } catch (IOException e) {
                log.error("Error in pages path", e);
            } catch (UserAlreadyExistException e) {
                request.setAttribute(ConstantContainer.USER_EXISTS, true);
                try {
                    request.getRequestDispatcher(ConstantContainer.REGISTRATION_PAGE).forward(request, response);
                } catch (ServletException e1) {
                    log.error("Servlet error", e1);
                } catch (IOException e1) {
                    log.error("Error in pages path", e1);
                }
                request.setAttribute(ConstantContainer.USER_EXISTS, false);
            }

        }else {
            try {
                response.sendRedirect(urlPrefix + ConstantContainer.BAD_REQUEST_PAGE);
            } catch (IOException e) {
                log.error("Error page not found " + e);
            }
        }

    }
}
