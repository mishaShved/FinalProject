package by.tc.epam.model.service;

import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import java.util.List;

public interface EventService {

    void createEvent(String date, String time, String team1RU, String team2RU,
                     String team1EN, String team2EN, Sport sportType)
            throws ServiceSQLException, DataSourceException;

    List<Event> getAllEvents(String locale)
            throws DataSourceException, ServiceSQLException;

    List<Event> getEventsBySport(Sport sport, String locale)
            throws ServiceSQLException, DataSourceException;

    List<Event> getEventsForAddOdd(String locale)
            throws DataSourceException, ServiceSQLException;

    void setScore(int eventId, int score1, int score2)
            throws ServiceSQLException, DataSourceException;

}
