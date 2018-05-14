package by.tc.epam.controller.command.impl.go_to_page;

import by.tc.epam.controller.command.Command;
import by.tc.epam.controller.command.impl.get.GetEventsBySportTypeCommand;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.ServiceFactory;
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

public class GoToStartPage implements Command{

    private static final Logger log = Logger.getLogger(GoToStartPage.class);

    /**
     *
     * @param servlet
     * @param request
     * @param response
     * @param urlPrefix
     *
     * Prepare attributes for start page
     *
     */
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService service = factory.getUserService();

        int userId = 0;

        User user = (User)request.getSession().getAttribute(ConstantContainer.USER);
        if(user != null) {
            userId = user.getId();
        }

        try{

            if(user != null) {
                double balance = service.getUserBalance(userId);
                request.setAttribute(ConstantContainer.BALANCE, balance);
            }

            servlet.getServletContext().
                    getRequestDispatcher("/jsp/StartPage.jsp").
                    forward(request, response);

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
