package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.ConnectionPool;
import by.tc.epam.model.dao.OddDAO;
import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.dao.transaction_dao.OddTransactionDAO;
import by.tc.epam.model.dao.transaction_dao.TransactionDAOFactory;
import by.tc.epam.model.dao.transaction_dao.impl.RequestContainer;
import by.tc.epam.model.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OddDAOImpl implements OddDAO {


    @Override
    public void createOdd(int eventId, OddType oddType, double koef, double param)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        OddTransactionDAO transactionDAO = transactionDAOFactory.getOddTransactionDAO();

        try{

            transactionDAO.createOdd(conn, eventId, oddType, koef, param);

        } finally {
            pool.returnConnection(conn);
        }

    }

    @Override
    public OddsList getOddsByEvent(int eventId)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        OddTransactionDAO transactionDAO = transactionDAOFactory.getOddTransactionDAO();

        OddsList odds;

        try{

            odds = transactionDAO.getOddsByEvent(conn, eventId);

        }finally {
            pool.returnConnection(conn);
        }

        return odds;
    }

    @Override
    public String getInfoAboutOdd(int oddId)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        OddTransactionDAO transactionDAO = transactionDAOFactory.getOddTransactionDAO();

        String oddInfo;

        try{

            oddInfo = transactionDAO.getInfoAboutOdd(conn, oddId);

        }finally {
            pool.returnConnection(conn);
        }

        return oddInfo;

    }

    @Override
    public String getOddType(int oddId)
            throws DAOSQLException, ConnectionPollIsEmptyException,
            DBLoginException, JDBCDriverNotFoundException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        OddTransactionDAO transactionDAO = transactionDAOFactory.getOddTransactionDAO();

        String oddOutcome;

        try{

            oddOutcome = transactionDAO.getOddType(conn, oddId);

        }finally {
            pool.returnConnection(conn);
        }

        return oddOutcome;
    }

    @Override
    public double getCoef(int oddId)
            throws ConnectionPollIsEmptyException, DBLoginException,
            JDBCDriverNotFoundException, DAOSQLException {


        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        OddTransactionDAO transactionDAO = transactionDAOFactory.getOddTransactionDAO();

        double coef;

        try{

            coef = transactionDAO.getCoef(conn, oddId);

        }finally {
            pool.returnConnection(conn);
        }

        return coef;

    }

}
