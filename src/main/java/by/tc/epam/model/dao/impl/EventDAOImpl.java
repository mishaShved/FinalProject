package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.ConnectionPool;
import by.tc.epam.model.dao.EventDAO;
import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.EntityBuilder;
import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Odd;
import by.tc.epam.model.entity.Sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDAOImpl implements EventDAO {

    private static final String ADD_EVENT_REQUEST =
            "INSERT INTO `bukmaker`.`event` (`id`, `time`, `team1`, `team2`, `sport_id`)" +
                    " VALUES (?, ?, ?, ?, ?);";

    private static final String SELECT_ALL_EVENTS_REQUEST =
            "SELECT b.id, b.time, b.team1, b.team2, s.sport_type FROM bukmaker.event as b " +
                    "join bukmaker.sport as s on b.sport_id = s.id " +
                    "where b.time > curdate();";


    private static final String SELECT_PART_EVENTS_REQUEST =
            "SELECT b.id, b.time, b.team1, b.team2, s.sport_type FROM bukmaker.event as b " +
                    "join bukmaker.sport as s on b.sport_id = s.id " +
                    "where s.sport_type = ? " +
                    "and b.time > curdate();";

    @Override
    public void createEvent(String date, String team1, String team2, Sport sportType) throws ConnectionPollIsEmptyException,
            DBLoginException, JDBCDriverNotFoundException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        try(PreparedStatement statement = conn.prepareStatement(ADD_EVENT_REQUEST)){

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
    public void setScore(int score1, int score2) {

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

            ResultSet rs = statement.executeQuery(SELECT_ALL_EVENTS_REQUEST);

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

        try(PreparedStatement statement = conn.prepareStatement(SELECT_PART_EVENTS_REQUEST)){

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
