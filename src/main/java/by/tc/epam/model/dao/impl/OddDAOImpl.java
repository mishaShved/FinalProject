package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.ConnectionPool;
import by.tc.epam.model.dao.OddDAO;
import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.Stacke;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OddDAOImpl implements OddDAO {

    private static final String CREATE_ODD =
            "INSERT INTO `bukmaker`.`odd` (`id`, `event_id`, `type_id`, `coefficient`, `param`) " +
                    "VALUES (?, ?, ?, ?, ?);";

    @Override
    public void createOdd(int eventId, OddType oddType, double koef, double param)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        try(PreparedStatement statement = conn.prepareStatement(CREATE_ODD)){

            statement.setString(1, null);
            statement.setInt(2, eventId);
            statement.setInt(3, oddType.ordinal() - 1);
            statement.setDouble(4, koef);
            statement.setDouble(5, param);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.returnConnection(conn);
        }


    }

    @Override
    public void setKoef() {

    }

    @Override
    public void setParam() {

    }

    @Override
    public List<Stacke> getStakes() {
        return null;
    }
}
