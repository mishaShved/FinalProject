package by.tc.epam.model.command.impl.get;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.entity.Stacke;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.StakeService;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.util.ConstantContainer;

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
        StakeService stackeService = factory.getStackeService();
        UserService userService = factory.getUserService();

        User user = (User)request.getSession().getAttribute(ConstantContainer.USER);

        int userId = user.getId();
        int page = Integer.parseInt(request.getParameter(ConstantContainer.PAGE));

        int pageCount;
        List<Stacke> stakes;

        try {

            stakes = stackeService.getStakesByUserId(userId, page);
            pageCount = stackeService.getPageCount(userId);

            double balance = userService.getUserBalance(userId);

            request.setAttribute(ConstantContainer.STAKES, stakes);
            request.setAttribute(ConstantContainer.BALANCE, balance);
            request.setAttribute(ConstantContainer.PAGE_COUNT, pageCount);
            request.setAttribute(ConstantContainer.PAGE, page);

            servlet.getServletContext().
                    getRequestDispatcher("/jsp/AccountHistory.jsp").
                    forward(request,response);

        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (DataSourceException e) {
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
