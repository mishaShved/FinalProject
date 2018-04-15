package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.ConnectionPool;
import by.tc.epam.model.dao.StakeDAO;
import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.dao.transaction_dao.OddTransactionDAO;
import by.tc.epam.model.dao.transaction_dao.StakeTransactionDAO;
import by.tc.epam.model.dao.transaction_dao.TransactionDAOFactory;
import by.tc.epam.model.dao.transaction_dao.UserTransactionDAO;
import by.tc.epam.model.dao.transaction_dao.impl.RequestContainer;
import by.tc.epam.model.entity.EntityBuilder;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.entity.Stacke;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StakeDAOImpl implements StakeDAO {


    @Override
    public void createStake(int userId, int oddId, double money)
            throws ConnectionPollIsEmptyException, DBLoginException,
            JDBCDriverNotFoundException, DAOSQLException, NotEnoughMoneyException {

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

    @Override
    public List<Stacke> getStakesByUserId(int userId)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        StakeTransactionDAO transactionDAO = transactionDAOFactory.getStackeTransactionDAO();

        List<Stacke> foundRes;

        try{

            foundRes = transactionDAO.getStakesByUserId(conn, userId);

        } finally {
            pool.returnConnection(conn);
        }

        return foundRes;

    }
}
