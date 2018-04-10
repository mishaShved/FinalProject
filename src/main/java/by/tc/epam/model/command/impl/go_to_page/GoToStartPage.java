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

public class GoToStartPage implements Command{


    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService service = factory.getUserService();

        int userId = 0;

        User user = (User)request.getSession().getAttribute("user");
        if(user != null) {
            userId = user.getId();
        }


        try{

            if(user != null) {
                double balance = service.getUserBalance(userId);
                request.setAttribute("balance", balance);
            }

            servlet.getServletContext().
                    getRequestDispatcher("/jsp/StartPage.jsp").
                    forward(request, response);

        }catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (ServiceSQLException e) {
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
