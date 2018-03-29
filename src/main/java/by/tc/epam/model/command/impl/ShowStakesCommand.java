package by.tc.epam.model.command.impl;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.entity.Stacke;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.StackeService;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ShowStakesCommand implements Command{


    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory factory = ServiceFactory.getInstance();
        StackeService service = factory.getStackeService();

        User user = (User)request.getSession().getAttribute("user");
        int userId = user.getId();

        try {
            List<Stacke> stackes = service.getStakesByUserId(userId);

            request.setAttribute("stackes", stackes);

            servlet.getServletContext().
                    getRequestDispatcher("/WEB-INF/jsp/StackesList.jsp").
                    forward(request,response);

        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (DBWorkingException e) {
            e.printStackTrace();
        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
