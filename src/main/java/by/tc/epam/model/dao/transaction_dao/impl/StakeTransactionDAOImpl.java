package by.tc.epam.model.dao.transaction_dao.impl;

import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.dao.transaction_dao.StakeTransactionDAO;
import by.tc.epam.model.entity.EntityBuilder;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.entity.Stacke;
import by.tc.epam.util.ConstantContainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StakeTransactionDAOImpl implements StakeTransactionDAO {

    @Override
    public void createStake(Connection conn, int userId, int oddId, double money, double coef)
            throws DAOSQLException{

        try(PreparedStatement createStackeStatement =
                conn.prepareStatement(RequestContainer.CREATE_STACKE)) {

            createStackeStatement.setString(1, null);
            createStackeStatement.setInt(2, oddId);
            createStackeStatement.setInt(3, userId);
            createStackeStatement.setDouble(4, money);
            createStackeStatement.setDouble(5, coef);

            createStackeStatement.executeUpdate();

        }catch (SQLException e){
            throw new DAOSQLException(e);
        }
    }

    @Override
    public List<Stacke> getStakesByUserId(Connection conn, int userId, String locale)
            throws DAOSQLException {

        EntityBuilder entityBuilder = EntityBuilder.getInstance();

        List<Stacke> foundRes = new ArrayList<>();

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.getRequestForGetUserStakes(locale))){

            statement.setInt(1, userId);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){


                Stacke stacke = entityBuilder.createStacke();

                stacke.setTeam1(rs.getString(ConstantContainer.TEAM1_LOCALE + locale));
                stacke.setTeam2(rs.getString(ConstantContainer.TEAM2_LOCALE + locale));
                stacke.setSportType(rs.getString(ConstantContainer.SPORT_TYPE_2 + locale));
                stacke.setStakeType(OddType.valueOf(rs.getString(ConstantContainer.ODD_TYPE_2)));
                stacke.setBetSum(rs.getDouble(ConstantContainer.MONEY));
                stacke.setKoef(rs.getDouble(ConstantContainer.COEFFICIENT));
                stacke.setScore1(rs.getInt(ConstantContainer.SCORE1));
                stacke.setScore2(rs.getInt(ConstantContainer.SCORE2));
                stacke.setParam(rs.getDouble(ConstantContainer.PARAMETER));


                stacke.setWon
                        (stacke.getStakeType().isWon
                                (stacke.getScore1(), stacke.getScore2(), stacke.getParam()));


                foundRes.add(stacke);

            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return foundRes;
    }
}
