package by.tc.epam.model.dao.transaction_dao;

import by.tc.epam.model.dao.connection_pool.ConnectionPool;
import by.tc.epam.model.dao.exception.ConnectionPoolException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EventDAOTest {

    private static Connection getH2Connection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testDB");
    }

    @Test
    public void createEventTest() throws SQLException {

        Connection conn = getH2Connection();



    }
}
