package by.tc.epam.model.command.impl.go_to_page;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToDepositWithdrawPage implements Command{


    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService service = serviceFactory.getUserService();

        User user = (User)request.getSession().getAttribute("user");

        int userId = user.getId();
        double userBalance = 0;


        try {

            userBalance = service.getUserBalance(userId);
            request.setAttribute("balance", userBalance);

            servlet.getServletContext().
                    getRequestDispatcher("/jsp/DepositWithdrawPage.jsp").forward(request, response);


        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (DBWorkingException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
