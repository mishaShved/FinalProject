package by.tc.epam.event_listener;

import by.tc.epam.model.dao.connection_pool.ConnectionPool;
import by.tc.epam.model.dao.exception.ConnectionPoolException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionPoolInit implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ConnectionPool pool = ConnectionPool.getInstance();

        try {
            pool.initPoolData();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
