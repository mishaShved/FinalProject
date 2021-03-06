package by.tc.epam.model.dao.connection_pool;

import by.tc.epam.model.dao.connection_pool.util.DBProperty;
import by.tc.epam.model.dao.exception.ConnectionPoolException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {

    private static ConnectionPool instance = new ConnectionPool();
    private BlockingQueue<Connection> connectionQueue;
    private BlockingQueue<Connection> givenConnections;
    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;
    private boolean isBlocked;

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

    /**
     * method create connections
     * @throws ConnectionPoolException
     */
    public void initPoolData() throws ConnectionPoolException {

        isBlocked = false;

        try {

            Class.forName(driverName);
            connectionQueue = new ArrayBlockingQueue<>(poolSize);
            givenConnections = new ArrayBlockingQueue<>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                Connection conn = DriverManager.getConnection(url, user, password);
                connectionQueue.add(conn);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionPoolException(e);
        }
    }

    /**
     * method get connection from connection pool and return him
     * @return
     * @throws ConnectionPoolException
     */
    public Connection getConnection() throws ConnectionPoolException {

        Connection connection;

        if(this.isBlocked){
            return null;
        }

        try {
            connection = connectionQueue.take();
            givenConnections.add(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException(e);
        }
        return connection;
    }

    /**
     * method return connection to connection pool
     * @param conn
     */
    public void returnConnection(Connection conn) {

        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        givenConnections.remove(conn);
        connectionQueue.add(conn);
    }

    /**
     *  method close all connections
     * @throws ConnectionPoolException
     * @throws InterruptedException
     */
    public void closeConnections() throws ConnectionPoolException, InterruptedException {

        while(givenConnections.size() != 0) {

            try {
                givenConnections.take().close();

            } catch (SQLException e) {
                throw new ConnectionPoolException(e);
            }

        }

        while(connectionQueue.size() != 0) {

            try {
                connectionQueue.take().close();

            } catch (SQLException e) {
                throw new ConnectionPoolException(e);
            }
        }

    }
}