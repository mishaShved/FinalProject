package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.service.EventService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EventCreateCommand implements Command {
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

        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (DataSourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
