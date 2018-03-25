package by.tc.epam.model.command.impl;

import by.tc.epam.model.command.Command;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.service.EventService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;

public class EventCreateCommand implements Command {
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService service = serviceFactory.getEventService();

        String time = request.getParameter(FinalStringsContainer.TIME);
        String date = request.getParameter(FinalStringsContainer.DATE);
        Sport sportType = Sport.valueOf(request.getParameter(FinalStringsContainer.SPORT));
        String team1 = request.getParameter(FinalStringsContainer.TEAM1);
        String team2 = request.getParameter(FinalStringsContainer.TEAM2);

        try {
            service.createEvent(date, time, team1, team2, sportType);
        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (DBWorkingException e) {
            e.printStackTrace();
        }

    }
}
