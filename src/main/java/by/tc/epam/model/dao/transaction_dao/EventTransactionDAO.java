package by.tc.epam.model.dao.transaction_dao;

import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.entity.Stacke;

import java.sql.Connection;
import java.util.List;

public interface EventTransactionDAO {

    void createEvent(Connection conn, String date, String team1RU, String team2RU,
                     String team1EN, String team2EN, Sport sportType)
            throws DAOSQLException;

    void setScore(Connection conn, int eventId, int score1, int score2)
            throws DAOSQLException;

    List<Event> getAllEvents(Connection conn, String locale)
            throws DAOSQLException;

    List<Event> getEventsBySport(Connection conn, Sport sportType, String locale)
            throws DAOSQLException;

    List<Event> getEventsForAddOdd(Connection conn, String locale)
            throws DAOSQLException;

    void calculateBet(Connection conn, int eventId, int score1, int score2)
            throws DAOSQLException;
}