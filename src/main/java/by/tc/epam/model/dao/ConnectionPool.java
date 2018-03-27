package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPool {


    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bukmaker";

    private static final String USER = "root";
    private static final String PASS = "mischa98";
    private static final int CONNECTIONS_COUNT = 10;


    private static ConnectionPool ourInstance = null;
    private Stack<Connection> pool = new Stack<>();


    public static synchronized ConnectionPool getInstance() throws DBLoginException, JDBCDriverNotFoundException {
        if(ourInstance == null){
            ourInstance = new ConnectionPool();
        }
        return ourInstance;
    }


    private ConnectionPool() throws DBLoginException, JDBCDriverNotFoundException {

            try {

                Class.forName(JDBC_DRIVER);

            } catch (ClassNotFoundException e) {
                throw new JDBCDriverNotFoundException(e);
            }

            try {

                for (int i = 0; i < CONNECTIONS_COUNT; i++) {
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    pool.push(conn);
                }

            } catch (SQLException e) {
                throw new DBLoginException(e);
            }


    }


    public synchronized Connection getConnection() throws ConnectionPollIsEmptyException {
        if(pool.empty()){
            throw new ConnectionPollIsEmptyException();
        }
        return pool.pop();
    }

    public synchronized void returnConnection(Connection connection) throws DAOSQLException {

        try {

            connection.setAutoCommit(true);

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }

        pool.push(connection);
    }

}
