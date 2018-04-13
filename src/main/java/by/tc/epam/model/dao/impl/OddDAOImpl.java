package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.ConnectionPool;
import by.tc.epam.model.dao.OddDAO;
import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OddDAOImpl implements OddDAO {


    @Override
    public void createOdd(int eventId, OddType oddType, double koef, double param)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        try(PreparedStatement statement = conn.prepareStatement(RequestContainer.CREATE_ODD)){

            statement.setString(1, null);
            statement.setInt(2, eventId);
            statement.setInt(3, oddType.ordinal() + 1);
            statement.setDouble(4, koef);
            statement.setDouble(5, param);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
        }


    }

    @Override
    public OddsList getOddsByEvent(int eventId)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        OddsList odds = new OddsList();

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.GET_ODD_BY_EVENT)){

            statement.setInt(1, eventId);

            ResultSet rs = statement.executeQuery();
            EntityBuilder builder = EntityBuilder.getInstance();

            while(rs.next()){

                Odd odd = builder.createOdd();

                odd.setId(rs.getInt("id"));
                odd.setTeam1(rs.getString("team1"));
                odd.setTeam2(rs.getString("team2"));
                odd.setKoef(rs.getDouble("coefficient"));
                odd.setParam(rs.getDouble("param"));
                odd.setOddType(OddType.valueOf(rs.getString("type")));

                odds.addOdd(odd);

            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }


        return odds;
    }

    @Override
    public String getInfoAboutOdd(int oddId)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        String oddInfo = "";

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.GET_INFO_ABOUT_ODD)){

            statement.setInt(1, oddId);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                oddInfo = rs.getString("info");
            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return oddInfo;

    }

    @Override
    public String getOddType(int oddId)
            throws DAOSQLException, ConnectionPollIsEmptyException,
            DBLoginException, JDBCDriverNotFoundException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        String oddOutcome = "";

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.GET_ODD_OUTCOME)){

            statement.setInt(1, oddId);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                oddOutcome = rs.getString("info");
            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return oddOutcome;
    }

    @Override
    public double getCoef(int oddId)
            throws ConnectionPollIsEmptyException, DBLoginException,
            JDBCDriverNotFoundException, DAOSQLException {


        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        double coef = 0;

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.GET_ODD_COEF)){

            statement.setInt(1, oddId);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                coef = rs.getDouble("coefficient");
            }

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return coef;

    }

}
