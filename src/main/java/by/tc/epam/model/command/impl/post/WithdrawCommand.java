package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.impl.get.GetEventsBySportTypeCommand;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WithdrawCommand implements Command{

    private static final Logger log = Logger.getLogger(WithdrawCommand.class);

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService service = serviceFactory.getUserService();

        double money = Double.parseDouble(request.getParameter(ConstantContainer.VALUE));
        User user = (User)request.getSession().getAttribute(ConstantContainer.USER);

        try {

            service.withdraw(user.getId(), money);

            response.sendRedirect("/MishaBet");

        } catch (DataSourceException e) {
            log.error("Problems with data source", e);
        } catch (ServiceSQLException e) {
            log.error("SQL error", e);
        } catch (IOException e) {
            log.error("Error in pages path", e);
        } catch (SmallBalanceException e) {
            e.printStackTrace();
        }
    }
}
