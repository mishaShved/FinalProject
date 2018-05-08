package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Sport;

import java.util.List;

public interface EventDAO {

    void createEvent(String date, String team1RU, String team2RU, String team1EN, String team2EN, Sport sportType)
            throws ConnectionPoolException, DAOSQLException;

    void setScore(int eventId, int score1, int score2)
            throws ConnectionPoolException, DAOSQLException;

    List<Event> getAllEvents(String locale)
            throws ConnectionPoolException, DAOSQLException;

    List<Event> getEventsBySport(Sport sportType, String locale)
            throws DAOSQLException, ConnectionPoolException;

    List<Event> getEventsForAddOdd(String locale)
            throws ConnectionPoolException, DAOSQLException;

}
