package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.ConnectionPool;
import by.tc.epam.model.dao.StackeDAO;
import by.tc.epam.model.dao.exception.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StackeDAOImpl implements StackeDAO {


    @Override
    public void createStake(int userId, int oddId, double money, double koef)
            throws ConnectionPollIsEmptyException, DBLoginException,
            JDBCDriverNotFoundException, DAOSQLException, NotEnoughMoneyException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }


        try{

            PreparedStatement getUserBalanceStatement =
                    conn.prepareStatement(RequestContainer.GET_BALANCE_REQUEST);

            getUserBalanceStatement.setInt(1, userId);

            ResultSet rs  = getUserBalanceStatement.executeQuery();

            double currentMoney = 0;

            while(rs.next()){
                currentMoney = rs.getDouble("balance");
            }

            if(currentMoney < money){
                throw new NotEnoughMoneyException();
            }


            PreparedStatement createStackeStatement =
                    conn.prepareStatement(RequestContainer.CREATE_STACKE);

            createStackeStatement.setString(1, null);
            createStackeStatement.setInt(2, oddId);
            createStackeStatement.setInt(3, userId);
            createStackeStatement.setDouble(4, money);
            createStackeStatement.setDouble(5, koef);

            createStackeStatement.executeUpdate();



            PreparedStatement setBalanceStatement =
                    conn.prepareStatement(RequestContainer.SET_BALANCE_REQUEST);

            setBalanceStatement.setDouble(1, currentMoney - money);
            setBalanceStatement.setInt(2, userId);

            setBalanceStatement.executeUpdate();

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
}
