package by.tc.epam.model.command.impl;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.StackeService;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateStackeCommand implements Command{

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    StackeService service = serviceFactory.getStackeService();

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        User user = (User) request.getSession().getAttribute(FinalStringsContainer.USER);
        int oddId = Integer.parseInt(request.getParameter(FinalStringsContainer.ODD_ID));
        double money =  Double.parseDouble(request.getParameter(FinalStringsContainer.MONEY));
        double koef = Double.parseDouble(request.getParameter(FinalStringsContainer.KOEF));


        try {


            service.createStake(user.getId(), oddId, money, koef);


        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (DBWorkingException e) {
            e.printStackTrace();
        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (SmallBalanceException e) {
            e.printStackTrace();
        }

    }

}
