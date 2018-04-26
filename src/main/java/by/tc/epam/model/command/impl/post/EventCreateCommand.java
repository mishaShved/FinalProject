package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.command.impl.get.GetEventsBySportTypeCommand;
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
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService service = serviceFactory.getEventService();

        String time = request.getParameter(ConstantContainer.TIME);
        String date = request.getParameter(ConstantContainer.DATE);
        Sport sportType = Sport.valueOf(request.getParameter(ConstantContainer.SPORT));
        String team1 = request.getParameter(ConstantContainer.TEAM1);
        String team2 = request.getParameter(ConstantContainer.TEAM2);

        try {
            service.createEvent(date, time, team1, team2, sportType);

            response.sendRedirect("/jsp/admin_page/AdminPage.jsp");

        } catch (DataSourceException e) {
            log.error("Problems with data source", e);
        } catch (ServiceSQLException e) {
            log.error("SQL error", e);
        } catch (IOException e) {
            log.error("Error in pages path", e);
        }


    }
}
