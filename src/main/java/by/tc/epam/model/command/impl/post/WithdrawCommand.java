package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.impl.FinalStringsContainer;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WithdrawCommand implements Command{
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService service = serviceFactory.getUserService();

        double money = Double.parseDouble(request.getParameter(FinalStringsContainer.VALUE));
        User user = (User)request.getSession().getAttribute(FinalStringsContainer.USER);

        try {

            service.withdraw(user.getId(), money);
            double value = service.getUserBalance(user.getId());


            response.sendRedirect("/MishaBet");



        } catch (DBWorkingException | ServiceSQLException | ServerOverloadException e) {
            e.printStackTrace();
        } catch (SmallBalanceException e) {

            try {
                servlet.getServletContext().getRequestDispatcher
                        ("/WEB-INF/jsp/Failed.jsp").forward(request, response);
            } catch (ServletException e1) {
                e.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
