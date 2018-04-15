package by.tc.epam.model.dao.transaction_dao.impl;

import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.dao.transaction_dao.StakeTransactionDAO;
import by.tc.epam.model.entity.EntityBuilder;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.entity.Stacke;
import by.tc.epam.util.FinalStringsContainer;
import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;

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
    public List<Stacke> getStakesByUserId(Connection conn, int userId)
            throws DAOSQLException {

        EntityBuilder entityBuilder = EntityBuilder.getInstance();

        List<Stacke> foundRes = new ArrayList<>();

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.GET_ALL_USER_STAKES_REQUEST)){


            statement.setInt(1, userId);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){


                Stacke stacke = entityBuilder.createStacke();

                stacke.setTeam1(rs.getString(FinalStringsContainer.TEAM1));
                stacke.setTeam2(rs.getString(FinalStringsContainer.TEAM2));
                stacke.setSportType(Sport.valueOf(rs.getString(FinalStringsContainer.SPORT_TYPE_2)));
                stacke.setStakeType(OddType.valueOf(rs.getString(FinalStringsContainer.ODD_TYPE_2)));
                stacke.setBetSum(rs.getDouble(FinalStringsContainer.MONEY));
                stacke.setKoef(rs.getDouble(FinalStringsContainer.COEFFICIENT));
                stacke.setScore1(rs.getInt(FinalStringsContainer.SCORE1));
                stacke.setScore2(rs.getInt(FinalStringsContainer.SCORE2));
                stacke.setParam(rs.getDouble(FinalStringsContainer.PARAMETER));


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
