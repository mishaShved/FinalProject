package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.OddDAO;
import by.tc.epam.model.dao.connection_pool.ConnectionPool;
import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.dao.transaction_dao.OddTransactionDAO;
import by.tc.epam.model.dao.transaction_dao.TransactionDAOFactory;
import by.tc.epam.model.entity.*;

import java.sql.Connection;

public class OddDAOImpl implements OddDAO {

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param eventId
     * @param oddType
     * @param koef
     * @param param
     * @throws DBLoginException
     * @throws JDBCDriverNotFoundException
     * @throws ConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public void createOdd(int eventId, OddType oddType, double koef, double param)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException {

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

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param eventId
     * @param locale
     * @return
     * @throws ConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public OddsList getOddsByEvent(int eventId, String locale)
            throws ConnectionPoolException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        OddTransactionDAO transactionDAO = transactionDAOFactory.getOddTransactionDAO();

        OddsList odds;

        try{

            odds = transactionDAO.getOddsByEvent(conn, eventId, locale);

        }finally {
            pool.returnConnection(conn);
        }

        return odds;
    }

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param oddId
     * @param locale
     * @return
     * @throws ConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public String getInfoAboutOdd(int oddId, String locale)
            throws ConnectionPoolException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        OddTransactionDAO transactionDAO = transactionDAOFactory.getOddTransactionDAO();

        String oddInfo;

        try{

            oddInfo = transactionDAO.getInfoAboutOdd(conn, oddId, locale);

        }finally {
            pool.returnConnection(conn);
        }

        return oddInfo;

    }

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param oddId
     * @return
     * @throws DAOSQLException
     * @throws ConnectionPoolException
     */
    @Override
    public String getOddType(int oddId)
            throws DAOSQLException, ConnectionPoolException{

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

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param oddId
     * @return
     * @throws ConnectionPoolException
     * @throws DBLoginException
     * @throws JDBCDriverNotFoundException
     * @throws DAOSQLException
     */
    @Override
    public double getCoef(int oddId)
            throws ConnectionPoolException, DBLoginException,
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
