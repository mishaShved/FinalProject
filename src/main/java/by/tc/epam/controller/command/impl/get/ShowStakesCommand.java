package by.tc.epam.controller.command.impl.get;

import by.tc.epam.controller.command.Command;
import by.tc.epam.model.entity.Stacke;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.StakeService;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.util.ConstantContainer;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ShowStakesCommand implements Command{

    private static final Logger log = Logger.getLogger(ShowStakesCommand.class);

    /**
     *
     * @param servlet
     * @param request
     * @param response
     * @param urlPrefix
     *
     * Shows the stakes of a particular user
     *
     */

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {

        ServiceFactory factory = ServiceFactory.getInstance();
        StakeService stackeService = factory.getStackeService();
        UserService userService = factory.getUserService();

        User user = (User)request.getSession().getAttribute(ConstantContainer.USER);
        String locale = (String)request.getSession().getAttribute(ConstantContainer.LOCALE);

        int userId = user.getId();
        int page = Integer.parseInt(request.getParameter(ConstantContainer.PAGE));

        int pageCount;
        List<Stacke> stakes;

        try {

            stakes = stackeService.getStakesByUserId(userId, page, locale);
            pageCount = stackeService.getPageCount(userId);

            double balance = userService.getUserBalance(userId);


            request.setAttribute(ConstantContainer.STAKES, stakes);
            request.setAttribute(ConstantContainer.BALANCE, balance);
            request.setAttribute(ConstantContainer.PAGE_COUNT, pageCount);
            request.setAttribute(ConstantContainer.PAGE, page);

            servlet.getServletContext().
                    getRequestDispatcher(ConstantContainer.ACCOUNT_HISTORY).
                    forward(request,response);

        } catch (DataSourceException e) {
            log.error("Problems with data source", e);
        } catch (ServiceSQLException e) {
            log.error("SQL error", e);
        } catch (ServletException e) {
            log.error("Servlet error", e);
        } catch (IOException e) {
            log.error("Error in pages path", e);
        }


    }

}
