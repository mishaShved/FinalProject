package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.ConnectionPool;
import by.tc.epam.model.dao.StackeDAO;
import by.tc.epam.model.dao.exception.*;
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

public class StackeDAOImpl implements StackeDAO {


    @Override
    public void createStake(int userId, int oddId, double money, double coef)
            throws ConnectionPollIsEmptyException, DBLoginException,
            JDBCDriverNotFoundException, DAOSQLException, NotEnoughMoneyException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        try{

            conn.setAutoCommit(false);

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
            createStackeStatement.setDouble(5, coef);

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

    @Override
    public List<Stacke> getStackesByUserId(int userId)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        List<Stacke> foundRes = new ArrayList<>();
        EntityBuilder entityBuilder = EntityBuilder.getInstance();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.GET_ALL_USER_STAKES_REQUEST)){


            statement.setInt(1, userId);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){


                Stacke stacke = entityBuilder.createStacke();

                stacke.setTeam1(rs.getString("team1"));
                stacke.setTeam2(rs.getString("team2"));
                stacke.setSportType(Sport.valueOf(rs.getString("sport_type")));
                stacke.setStakeType(OddType.valueOf(rs.getString("odd_type")));
                stacke.setBetSum(rs.getDouble("money"));
                stacke.setKoef(rs.getDouble("coefficient"));
                stacke.setScore1(rs.getInt("score1"));
                stacke.setScore2(rs.getInt("score2"));
                stacke.setParam(rs.getDouble("param"));


                stacke.setWon
                        (stacke.getStakeType().isWon
                                (stacke.getScore1(), stacke.getScore2(), stacke.getParam()));


                foundRes.add(stacke);

            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
        }

        return foundRes;

    }
}
