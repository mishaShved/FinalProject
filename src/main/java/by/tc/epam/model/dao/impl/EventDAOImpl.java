package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.ConnectionPool;
import by.tc.epam.model.dao.EventDAO;
import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO {

    @Override
    public void createEvent(String date, String team1, String team2, Sport sportType)
            throws ConnectionPollIsEmptyException,
            DBLoginException, JDBCDriverNotFoundException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.ADD_EVENT_REQUEST)){

            statement.setString(1, null);
            statement.setString(2, date);
            statement.setString(3, team1);
            statement.setString(4, team2);
            statement.setInt(5, sportType.ordinal() + 1);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }  finally {
            pool.returnConnection(conn);
        }
    }


    @Override
    public void setScore(int eventId, int score1, int score2)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        OddType oddType;
        double param;
        int userId;
        double wonSum;
        double oldSumValue;
        double newSumValue = 0;

        try(PreparedStatement setScoreStatement = conn.prepareStatement(RequestContainer.SET_SCORE_REQUEST);
            PreparedStatement setUserBalanceStatement = conn.prepareStatement(RequestContainer.SET_BALANCE_REQUEST);
            PreparedStatement getUserBalanceStatement = conn.prepareStatement(RequestContainer.GET_BALANCE_REQUEST);
            PreparedStatement getStakesByEvent = conn.prepareStatement(RequestContainer.GET_ALL_STAKES_BY_EVENT_REQUEST)) {

            conn.setAutoCommit(false);

            setScoreStatement.setInt(1, score1);
            setScoreStatement.setInt(2, score2);
            setScoreStatement.setInt(3, eventId);

            setScoreStatement.executeUpdate();

            getStakesByEvent.setInt(1, eventId);

            ResultSet stakesResSet = getStakesByEvent.executeQuery();

            while(stakesResSet.next()){

                oddType = OddType.valueOf(stakesResSet.getString("type"));
                param = stakesResSet.getDouble("param");
                userId = stakesResSet.getInt("user_id");
                wonSum = stakesResSet.getDouble("res");

                if(oddType.isWon(score1, score2, param)){

                    getUserBalanceStatement.setInt(1, userId);

                    ResultSet userResSet = getUserBalanceStatement.executeQuery();

                    while(userResSet.next()){

                        oldSumValue = userResSet.getInt("balance");
                        newSumValue = wonSum + oldSumValue;

                    }

                    setUserBalanceStatement.setDouble(1, newSumValue);
                    setUserBalanceStatement.setInt(2, userId);

                    setUserBalanceStatement.executeUpdate();

                }
            }

        conn.commit();

        } catch (SQLException e) {

            try {
                conn.rollback();
            } catch (SQLException e1) {
                throw new DAOSQLException(e);
            }

            throw new DAOSQLException(e);
        }
    }


    @Override
    public List<Event> getAllEvents()
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        EntityBuilder entityBuilder = EntityBuilder.getInstance();

        List<Event> allEvents;

        try(Statement statement = conn.createStatement()){

            ResultSet rs = statement.executeQuery(RequestContainer.SELECT_EVENTS_REQUEST_FOR_SET_SCORE);

            allEvents = createEventList(rs);


        } catch (SQLException e) {
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
        }


        return allEvents;
    }


    @Override
    public List<Event> getEventsBySport(Sport sportType)
            throws DAOSQLException, DBLoginException,
            JDBCDriverNotFoundException, ConnectionPollIsEmptyException {


        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        List<Event> partEvent;

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.SELECT_EVENTS_REQUEST_BY_SPORT)){

            statement.setString(1, sportType.name());

            ResultSet rs = statement.executeQuery();

            partEvent = createEventList(rs);


        } catch (SQLException e) {
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
        }

        return partEvent;
    }


    private List<Event> createEventList(ResultSet rs) throws SQLException {

        List<Event> eventList = new ArrayList<>();

        EntityBuilder entityBuilder = EntityBuilder.getInstance();

        while(rs.next()){

            Event event = entityBuilder.createEvent();

            event.setId(rs.getInt("id"));
            event.setTeam1(rs.getString("team1"));
            event.setTeam2(rs.getString("team2"));
            event.setSportType(Sport.valueOf(rs.getString("sport_type")));
            event.setStartTime(rs.getString("time"));

            eventList.add(event);
        }

        return eventList;

    }
}
