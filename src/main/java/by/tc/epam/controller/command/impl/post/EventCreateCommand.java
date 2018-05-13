package by.tc.epam.controller.command.impl.post;

import by.tc.epam.controller.command.Command;
import by.tc.epam.controller.command.impl.get.GetEventsBySportTypeCommand;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.service.EventService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EventCreateCommand implements Command {

    private static final Logger log = Logger.getLogger(EventCreateCommand.class);

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService service = serviceFactory.getEventService();

        String time = request.getParameter(ConstantContainer.TIME);
        String date = request.getParameter(ConstantContainer.DATE);
        Sport sportType = Sport.valueOf(request.getParameter(ConstantContainer.SPORT));
        String team1EN = request.getParameter(ConstantContainer.TEAM1EN);
        String team2EN = request.getParameter(ConstantContainer.TEAM2EN);
        String team1RU = request.getParameter(ConstantContainer.TEAM1RU);
        String team2RU = request.getParameter(ConstantContainer.TEAM2RU);

        try {
            service.createEvent(date, time, team1RU, team2RU, team1EN, team2EN, sportType);

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
