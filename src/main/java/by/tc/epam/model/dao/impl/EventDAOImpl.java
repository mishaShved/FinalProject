package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.EventDAO;
import by.tc.epam.model.dao.connection_pool.ConnectionPool;
import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.dao.transaction_dao.EventTransactionDAO;
import by.tc.epam.model.dao.transaction_dao.TransactionDAOFactory;
import by.tc.epam.model.entity.*;

import java.sql.*;
import java.util.List;

public class EventDAOImpl implements EventDAO {

    @Override
    public void createEvent(String date, String team1RU, String team2RU,
                            String team1EN, String  team2EN, Sport sportType)
            throws ConnectionPoolException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        EventTransactionDAO transactionDAO = transactionDAOFactory.getEventTransactionDAO();

        try{

            transactionDAO.createEvent(conn, date, team1RU, team2RU, team1EN, team2EN, sportType);

        } finally {
            pool.returnConnection(conn);
        }
    }


    @Override
    public void setScore(int eventId, int score1, int score2)
            throws ConnectionPoolException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory factory = TransactionDAOFactory.getInstance();
        EventTransactionDAO eventTransactionDAO = factory.getEventTransactionDAO();

        try{

            conn.setAutoCommit(false);

            eventTransactionDAO.setScore(conn, eventId, score1, score2);
            eventTransactionDAO.calculateBet(conn, eventId, score1, score2);

            conn.commit();

        } catch (SQLException e) {

            try {
                conn.rollback();
            } catch (SQLException e1) {
                throw new DAOSQLException(e);
            }

            throw new DAOSQLException(e);

        }finally {

            pool.returnConnection(conn);

        }
    }


    @Override
    public List<Event> getAllEvents(String locale)
            throws ConnectionPoolException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        EventTransactionDAO transactionDAO = transactionDAOFactory.getEventTransactionDAO();

        List<Event> allEvents;

        try {

            allEvents = transactionDAO.getAllEvents(conn, locale);

        }finally {
            pool.returnConnection(conn);
        }

        return allEvents;
    }


    @Override
    public List<Event> getEventsBySport(Sport sportType, String locale)
            throws DAOSQLException, ConnectionPoolException {


        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        EventTransactionDAO transactionDAO = transactionDAOFactory.getEventTransactionDAO();

        List<Event> partEvent;

        try{

            partEvent = transactionDAO.getEventsBySport(conn, sportType, locale);

        }finally {
            pool.returnConnection(conn);
        }

        return partEvent;
    }

    @Override
    public List<Event> getEventsForAddOdd(String locale)
            throws ConnectionPoolException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        EventTransactionDAO transactionDAO = transactionDAOFactory.getEventTransactionDAO();

        List<Event> allEvents;

        try{

            allEvents = transactionDAO.getEventsForAddOdd(conn, locale);

        } finally {
            pool.returnConnection(conn);
        }

        return allEvents;
    }

}
