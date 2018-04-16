package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepositCommand implements Command {

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService service = serviceFactory.getUserService();

        User user = (User)request.getSession().getAttribute(ConstantContainer.USER);
        double money = Double.parseDouble(request.getParameter(ConstantContainer.VALUE));
        double value;

        try {

            service.deposit(user.getId(), money);
            value = service.getUserBalance(user.getId());


            response.sendRedirect("/MishaBet");



        } catch (ServerOverloadException | ServiceSQLException
                | DataSourceException | IOException e) {

            e.printStackTrace();
        }

    }

}
