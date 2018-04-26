package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.impl.get.GetEventsBySportTypeCommand;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.UserAlreadyExistException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command{

    private static final Logger log = Logger.getLogger(RegistrationCommand.class);

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter(ConstantContainer.NAME);
        String password = request.getParameter(ConstantContainer.PASSWORD);
        String email = request.getParameter(ConstantContainer.EMAIL);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService service = serviceFactory.getUserService();

        try {


            service.registration(name, email, password);
            response.sendRedirect("/MishaBet");


        } catch (DataSourceException e) {
            log.error("Problems with data source", e);
        } catch (ServiceSQLException e) {
            log.error("SQL error", e);
        } catch (IOException e) {
            log.error("Error in pages path", e);
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
        }

    }
}
