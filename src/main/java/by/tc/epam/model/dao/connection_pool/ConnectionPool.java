package by.tc.epam.model.dao.connection_pool;

import by.tc.epam.model.dao.connection_pool.util.DBProperty;
import by.tc.epam.model.dao.exception.ConnectionPoolException;

import java.sql.*;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {


    private static ConnectionPool instance = new ConnectionPool();
    private BlockingQueue<Connection> connectionQueue;
    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    private ConnectionPool() {

        this.driverName = DBProperty.JDBC_DRIVER;
        this.url = DBProperty.DB_URL;
        this.user = DBProperty.DB_USER;
        this.password = DBProperty.DB_PASS;
        this.poolSize = DBProperty.CONNECTIONS_COUNT;

    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public void initPoolData() throws ConnectionPoolException {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName(driverName);
            connectionQueue = new ArrayBlockingQueue<>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                Connection conn = DriverManager.getConnection(url, user, password);
                connectionQueue.add(conn);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionPoolException(e);
        }
    }


    public Connection getConnection() throws ConnectionPoolException {

        Connection connection;

        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {
            throw new ConnectionPoolException(e);
        }
        return connection;
    }

    public void returnConnection(Connection conn) {

        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connectionQueue.add(conn);
    }


    private void closeConnectionQueue(BlockingQueue<Connection> queue) throws SQLException {
        Connection connection;
        while ((connection = queue.poll()) != null) {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            connection.close();
        }
    }
}