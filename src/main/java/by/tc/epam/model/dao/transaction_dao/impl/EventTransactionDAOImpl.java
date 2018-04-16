package by.tc.epam.model.dao.transaction_dao.impl;

import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.transaction_dao.EventTransactionDAO;
import by.tc.epam.model.dao.transaction_dao.TransactionDAOFactory;
import by.tc.epam.model.dao.transaction_dao.UserTransactionDAO;
import by.tc.epam.model.entity.*;
import by.tc.epam.util.ConstantContainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventTransactionDAOImpl implements EventTransactionDAO {
    @Override
    public void createEvent(Connection conn, String date, String team1, String team2, Sport sportType)
            throws DAOSQLException {

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
        }
    }

    @Override
    public void setScore(Connection conn, int eventId, int score1, int score2)
            throws DAOSQLException {

        try(PreparedStatement setScoreStatement = conn.prepareStatement(RequestContainer.SET_SCORE_REQUEST)) {

            setScoreStatement.setInt(1, score1);
            setScoreStatement.setInt(2, score2);
            setScoreStatement.setInt(3, eventId);

            setScoreStatement.executeUpdate();
        }catch (SQLException e){
            throw new DAOSQLException(e);
        }

    }

    @Override
    public List<Event> getAllEvents(Connection conn)
            throws DAOSQLException {

        List<Event> allEvents;

        try(Statement statement = conn.createStatement()){

            ResultSet rs = statement.executeQuery(RequestContainer.SELECT_EVENTS_REQUEST_FOR_SET_SCORE);

            allEvents = createEventList(rs);


        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return allEvents;
    }

    @Override
    public List<Event> getEventsBySport(Connection conn, Sport sportType)
            throws DAOSQLException{

        List<Event> partEvent;

        try(PreparedStatement statement =
                    conn.prepareStatement(RequestContainer.SELECT_EVENTS_REQUEST_BY_SPORT)){

            statement.setString(1, sportType.name());

            ResultSet rs = statement.executeQuery();

            partEvent = createEventList(rs);


        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return partEvent;
    }

    @Override
    public List<Event> getEventsForAddOdd(Connection conn)
            throws DAOSQLException {

        List<Event> events;

        try(Statement statement = conn.createStatement()){

            ResultSet rs = statement.executeQuery(RequestContainer.SELECT_EVENTS_REQUEST_FOR_ADD_ODD);

            events = createEventList(rs);


        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        return events;
    }

    @Override
    public void calculateBet(Connection conn, int eventId, int score1, int score2)
            throws DAOSQLException {

        TransactionDAOFactory transactionDAOFactory = TransactionDAOFactory.getInstance();
        UserTransactionDAO userTransactionDAO = transactionDAOFactory.getUserTransactionDAO();

        OddType oddType;
        double param;
        int userId;
        double wonSum;
        double currentBalance;

        try(PreparedStatement getStakesByEvent =
                    conn.prepareStatement(RequestContainer.GET_ALL_STAKES_BY_EVENT_REQUEST)) {

            getStakesByEvent.setInt(1, eventId);

            ResultSet stakesResSet = getStakesByEvent.executeQuery();

            while(stakesResSet.next()){

                oddType = OddType.valueOf(stakesResSet.getString(ConstantContainer.TYPE));
                param = stakesResSet.getDouble(ConstantContainer.PARAMETER);
                userId = stakesResSet.getInt(ConstantContainer.USER_ID);
                wonSum = stakesResSet.getDouble(ConstantContainer.RES);

                if(oddType.isWon(score1, score2, param)){

                    currentBalance = userTransactionDAO.getUserBalance(conn, userId);
                    userTransactionDAO.setBalance(conn, userId, currentBalance + wonSum);
                }
            }
            
        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

    }


    private List<Event> createEventList(ResultSet rs) throws SQLException {

        List<Event> eventList = new ArrayList<>();

        EntityBuilder entityBuilder = EntityBuilder.getInstance();

        while(rs.next()){

            Event event = entityBuilder.createEvent();

            event.setId(rs.getInt(ConstantContainer.ID));
            event.setTeam1(rs.getString(ConstantContainer.TEAM1));
            event.setTeam2(rs.getString(ConstantContainer.TEAM2));
            event.setSportType(Sport.valueOf(rs.getString(ConstantContainer.SPORT_TYPE_2)));
            event.setStartTime(rs.getString(ConstantContainer.TIME));

            eventList.add(event);
        }

        return eventList;

    }
}
