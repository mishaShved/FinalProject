package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.UserDAO;
import by.tc.epam.model.dao.connection_pool.ConnectionPool;
import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.dao.transaction_dao.TransactionDAOFactory;
import by.tc.epam.model.dao.transaction_dao.UserTransactionDAO;
import by.tc.epam.model.entity.User;

import java.sql.Connection;


public class UserDAOImpl implements UserDAO {

    @Override
    public void registration(String name, String email, String password)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DublicateUserException,
            DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        UserTransactionDAO transactionDAO = transactionDAOFactory.getUserTransactionDAO();

        try{

            transactionDAO.registration(conn, name, email, password);

        }finally {
            pool.returnConnection(conn);
        }

    }

    @Override
    public User login(int userId, String password) throws DBLoginException,
            JDBCDriverNotFoundException, ConnectionPoolException,
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

    @Override
    public void withdraw(int userId, double money)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException, NotEnoughMoneyException {

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

    @Override
    public void deposit(int userId, double money)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException {

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

    @Override
    public double getUserBalance(int userId)
            throws DAOSQLException, ConnectionPoolException,
            DBLoginException, JDBCDriverNotFoundException {

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
