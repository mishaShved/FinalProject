package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.UserDAO;
import by.tc.epam.model.dao.connection_pool.ConnectionPool;
import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DublicateUserException;
import by.tc.epam.model.dao.exception.IncorrectLoginException;
import by.tc.epam.model.dao.exception.NotEnoughMoneyException;
import by.tc.epam.model.dao.transaction_dao.TransactionDAOFactory;
import by.tc.epam.model.dao.transaction_dao.UserTransactionDAO;
import by.tc.epam.model.entity.User;

import java.sql.Connection;


public class UserDAOImpl implements UserDAO {
    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param name
     * @param email
     * @param password
     * @return
     * @throws ConnectionPoolException
     * @throws DublicateUserException
     * @throws DAOSQLException
     */
    @Override
    public int registration(String name, String email, String password)
            throws ConnectionPoolException, DublicateUserException,
            DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        UserTransactionDAO transactionDAO = transactionDAOFactory.getUserTransactionDAO();

        int userID;

        try{

            userID = transactionDAO.registration(conn, name, email, password);

        }finally {
            pool.returnConnection(conn);
        }

        return userID;
    }

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param userId
     * @param password
     * @return
     * @throws ConnectionPoolException
     * @throws DAOSQLException
     * @throws IncorrectLoginException
     */
    @Override
    public User login(int userId, String password)
            throws ConnectionPoolException,
            DAOSQLException, IncorrectLoginException {


        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        UserTransactionDAO transactionDAO = transactionDAOFactory.getUserTransactionDAO();

        User user;

        try{

            user = transactionDAO.login(conn, userId, password);

        }finally {
            pool.returnConnection(conn);
        }

        return user;
    }

    @Override
    public void setPassword(int id, String oldPassword, String newPassword) {

    }

    @Override
    public void setName(int id, String newName) {

    }

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param userId
     * @param money
     * @throws ConnectionPoolException
     * @throws DAOSQLException
     * @throws NotEnoughMoneyException
     */
    @Override
    public void withdraw(int userId, double money)
            throws ConnectionPoolException, DAOSQLException, NotEnoughMoneyException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        UserTransactionDAO transactionDAO = transactionDAOFactory.getUserTransactionDAO();

        double currentBalance;

        try{

            currentBalance = transactionDAO.getUserBalance(conn, userId);

            if (currentBalance < money) {
                throw new NotEnoughMoneyException();
            }

            transactionDAO.setBalance(conn, userId, currentBalance - money);

        }finally {
            pool.returnConnection(conn);
        }

    }

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param userId
     * @param money
     * @throws ConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public void deposit(int userId, double money)
            throws ConnectionPoolException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        UserTransactionDAO transactionDAO = transactionDAOFactory.getUserTransactionDAO();

        double currentBalance = 0;

        try{

            currentBalance = transactionDAO.getUserBalance(conn, userId);
            transactionDAO.setBalance(conn, userId, currentBalance + money);

        }finally {
            pool.returnConnection(conn);
        }

    }

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param userId
     * @return
     * @throws DAOSQLException
     * @throws ConnectionPoolException
     */
    @Override
    public double getUserBalance(int userId)
            throws DAOSQLException, ConnectionPoolException{

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        UserTransactionDAO transactionDAO = transactionDAOFactory.getUserTransactionDAO();

        double balance;

        try{

            balance = transactionDAO.getUserBalance(conn, userId);

        }finally {
            pool.returnConnection(conn);
        }

        return balance;
    }

}
