package by.tc.epam.controller.command.impl.post;

import by.tc.epam.controller.command.Command;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.StakeService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateStackeCommand implements Command{

    private static final Logger log = Logger.getLogger(CreateStackeCommand.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    StakeService stackeService = serviceFactory.getStackeService();

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        User user = (User) request.getSession().getAttribute(ConstantContainer.USER);
        int oddId = Integer.parseInt(request.getParameter(ConstantContainer.ODD_ID));
        double money =  Double.parseDouble(request.getParameter(ConstantContainer.MONEY));


        try {

            stackeService.createStake(user.getId(), oddId, money);

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
