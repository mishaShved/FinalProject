package by.tc.epam.model.dao.transaction_dao.impl;

import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.transaction_dao.OddTransactionDAO;
import by.tc.epam.model.entity.EntityBuilder;
import by.tc.epam.model.entity.Odd;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;
import by.tc.epam.util.ConstantContainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OddTransactionDAOImpl implements OddTransactionDAO {
    @Override
    public void createOdd(Connection conn, int eventId, OddType oddType, double coef, double param)
            throws DAOSQLException {

        try(PreparedStatement statement = conn.prepareStatement(RequestContainer.CREATE_ODD)){

            statement.setString(1, null);
            statement.setInt(2, eventId);
            statement.setInt(3, oddType.ordinal() + 1);
            statement.setDouble(4, coef);
            statement.setDouble(5, param);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

    }

    @Override
    public OddsList getOddsByEvent(Connection conn, int eventId, String locale)
            throws DAOSQLException {

        OddsList odds = new OddsList();

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.getRequestForGetOddsByEvent(locale))){

            statement.setInt(1, eventId);

            ResultSet rs = statement.executeQuery();
            EntityBuilder builder = EntityBuilder.getInstance();

            while(rs.next()){

                Odd odd = builder.createOdd();

                odd.setId(rs.getInt(ConstantContainer.ID));
                odd.setTeam1(rs.getString(ConstantContainer.TEAM1));
                odd.setTeam2(rs.getString(ConstantContainer.TEAM2));
                odd.setKoef(rs.getDouble(ConstantContainer.COEFFICIENT));
                odd.setParam(rs.getDouble(ConstantContainer.PARAMETER));
                odd.setOddType(OddType.valueOf(rs.getString(ConstantContainer.TYPE)));

                odds.addOdd(odd);

            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return odds;

    }

    @Override
    public String getInfoAboutOdd(Connection conn, int oddId, String locale)
            throws DAOSQLException {

        String info = null;

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.getRequestForGetInfoAboutOdd(locale))){

            statement.setInt(1, oddId);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                info = rs.getString(ConstantContainer.INFO);
            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return info;
    }

    @Override
    public String getOddType(Connection conn, int oddId)
            throws DAOSQLException {

        String oddOutcome = "";

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.GET_ODD_OUTCOME)){

            statement.setInt(1, oddId);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                oddOutcome = rs.getString(ConstantContainer.INFO);
            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return oddOutcome;
    }

    @Override
    public double getCoef(Connection conn, int oddId)
            throws DAOSQLException {

        double coef = 0;

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.GET_ODD_COEF)){

            statement.setInt(1, oddId);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                coef = rs.getDouble(ConstantContainer.COEFFICIENT);
            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return coef;
    }
}
