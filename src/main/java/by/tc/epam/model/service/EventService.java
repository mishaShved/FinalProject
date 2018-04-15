package by.tc.epam.model.service;

import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import java.util.List;

public interface EventService {

    void createEvent(String date, String time, String team1, String team2, Sport sportType)
            throws ServiceSQLException, ServerOverloadException, DataSourceException;

    List<Event> getAllEvents()
            throws DataSourceException, ServerOverloadException, ServiceSQLException;

    List<Event> getEventsBySport(Sport sport)
            throws ServiceSQLException, DataSourceException, ServerOverloadException;

    List<Event> getEventsForAddOdd() throws DataSourceException, ServerOverloadException, ServiceSQLException;

    void setScore(int eventId, int score1, int score2)
            throws ServiceSQLException, ServerOverloadException, DataSourceException;

}
