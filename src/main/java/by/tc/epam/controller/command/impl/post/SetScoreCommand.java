package by.tc.epam.controller.command.impl.post;

import by.tc.epam.controller.command.Command;
import by.tc.epam.controller.command.impl.get.GetEventsBySportTypeCommand;
import by.tc.epam.model.service.EventService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.util.ConstantContainer;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetScoreCommand implements Command{

    private static final Logger log = Logger.getLogger(SetScoreCommand.class);

    ServiceFactory factory = ServiceFactory.getInstance();
    EventService service = factory.getEventService();

    /**
     *
     * @param servlet
     * @param request
     * @param response
     * @param urlPrefix
     *
     * Command execute set score and calculation of all bets
     *
     */
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {

        int eventId = Integer.parseInt(request.getParameter(ConstantContainer.EVENT_ID));
        int score1 = Integer.parseInt(request.getParameter(ConstantContainer.SCORE1));
        int score2 = Integer.parseInt(request.getParameter(ConstantContainer.SCORE2));


        try {


            service.setScore(eventId, score1, score2);

            request.getSession().setAttribute(ConstantContainer.IS_UPDATE, true);
            response.sendRedirect(urlPrefix + "/jsp/admin_page/AdminPage.jsp");



        } catch (DataSourceException e) {
            log.error("Problems with data source", e);
        } catch (ServiceSQLException e) {
            log.error("SQL error", e);
        } catch (IOException e) {
            log.error("Error in pages path", e);
        }


    }
}
