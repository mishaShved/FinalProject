package by.tc.epam.model.service;

import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import java.util.List;

public interface EventService {

    void createEvent(String date, String time, String team1, String team2, Sport sportType)
            throws ServiceSQLException, ServerOverloadException, DBWorkingException;

    List<Event> getAllEvents() throws DBWorkingException, ServerOverloadException, ServiceSQLException;

    List<Event> getEventsBySport(Sport sport) throws ServiceSQLException, DBWorkingException, ServerOverloadException;

}
