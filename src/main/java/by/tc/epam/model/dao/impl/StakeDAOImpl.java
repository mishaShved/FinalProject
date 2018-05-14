package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.StakeDAO;
import by.tc.epam.model.dao.connection_pool.ConnectionPool;
import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.NotEnoughMoneyException;
import by.tc.epam.model.dao.transaction_dao.OddTransactionDAO;
import by.tc.epam.model.dao.transaction_dao.StakeTransactionDAO;
import by.tc.epam.model.dao.transaction_dao.TransactionDAOFactory;
import by.tc.epam.model.dao.transaction_dao.UserTransactionDAO;
import by.tc.epam.model.entity.Stacke;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StakeDAOImpl implements StakeDAO {

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param userId
     * @param oddId
     * @param money
     * @throws ConnectionPoolException
     * @throws DAOSQLException
     * @throws NotEnoughMoneyException
     */
    @Override
    public void createStake(int userId, int oddId, double money)
            throws ConnectionPoolException, DAOSQLException,
            NotEnoughMoneyException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        StakeTransactionDAO stackeTransactionDAO = transactionDAOFactory.getStackeTransactionDAO();
        UserTransactionDAO userTransactionDAO = transactionDAOFactory.getUserTransactionDAO();
        OddTransactionDAO oddTransactionDAO = transactionDAOFactory.getOddTransactionDAO();

        double currentBalance;
        double coef;

        try{

            conn.setAutoCommit(false);

            currentBalance = userTransactionDAO.getUserBalance(conn, userId);

            if(currentBalance < money){
                throw new NotEnoughMoneyException();
            }

            coef = oddTransactionDAO.getCoef(conn, oddId);

            stackeTransactionDAO.createStake(conn, userId, oddId, money, coef);

            userTransactionDAO.setBalance(conn, userId,currentBalance - money);

            conn.commit();

        } catch (SQLException e) {

            try {

                conn.rollback();

            } catch (SQLException e1) {
                throw new DAOSQLException(e1);
            }

            throw new DAOSQLException(e);

        }finally {
            pool.returnConnection(conn);
        }


    }

    /**
     * method get connection from connection pool and invoke
     * appropriate method from transactionDAO
     * @param userId
     * @param locale
     * @return
     * @throws ConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public List<Stacke> getStakesByUserId(int userId, String locale)
            throws ConnectionPoolException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        StakeTransactionDAO transactionDAO = transactionDAOFactory.getStackeTransactionDAO();

        List<Stacke> foundRes;

        try{

            foundRes = transactionDAO.getStakesByUserId(conn, userId, locale);

        } finally {
            pool.returnConnection(conn);
        }

        return foundRes;

    }
}
