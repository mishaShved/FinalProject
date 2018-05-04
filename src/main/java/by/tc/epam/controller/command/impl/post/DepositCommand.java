package by.tc.epam.controller.command.impl.post;

import by.tc.epam.controller.command.Command;
import by.tc.epam.controller.command.impl.get.GetEventsBySportTypeCommand;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepositCommand implements Command {

    private static final Logger log = Logger.getLogger(DepositCommand.class);

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService service = serviceFactory.getUserService();

        User user = (User)request.getSession().getAttribute(ConstantContainer.USER);
        double money = Double.parseDouble(request.getParameter(ConstantContainer.VALUE));

        try {

            service.deposit(user.getId(), money);

            response.sendRedirect("/MishaBet");

        }  catch (DataSourceException e) {
            log.error("Problems with data source", e);
        } catch (IOException e) {
            log.error("Error in pages path", e);
        } catch (ServiceSQLException e) {
            e.printStackTrace();
        }


    }

}
