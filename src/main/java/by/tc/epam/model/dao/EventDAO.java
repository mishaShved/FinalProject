package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Sport;

import java.util.Date;
import java.util.List;

public interface EventDAO {

    void createEvent(String date, String team1, String team2, Sport sportType)
            throws ConnectionPollIsEmptyException, DBLoginException,
            JDBCDriverNotFoundException, DAOSQLException;

    void setScore(int eventId, int score1, int score2)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException;

    List<Event> getAllEvents()
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException;

    List<Event> getEventsBySport(Sport sportType)
            throws DAOSQLException, DBLoginException,
            JDBCDriverNotFoundException, ConnectionPollIsEmptyException;

    List<Event> getEventsForAddOdd()
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException;

}
