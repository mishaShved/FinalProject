package by.tc.epam.model.service;

import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import java.util.List;

public interface EventService {

    void createEvent(String date, String time, String team1, String team2, Sport sportType)
            throws ServiceSQLException, DataSourceException;

    List<Event> getAllEvents()
            throws DataSourceException, ServiceSQLException;

    List<Event> getEventsBySport(Sport sport)
            throws ServiceSQLException, DataSourceException;

    List<Event> getEventsForAddOdd()
            throws DataSourceException, ServiceSQLException;

    void setScore(int eventId, int score1, int score2)
            throws ServiceSQLException, DataSourceException;

}
