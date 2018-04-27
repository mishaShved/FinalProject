package by.tc.epam.event_listener;

import by.tc.epam.model.dao.connection_pool.ConnectionPool;
import by.tc.epam.model.dao.exception.ConnectionPoolException;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionPoolInit implements ServletContextListener{

    private static final Logger log = Logger.getLogger(ConnectionPoolInit.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ConnectionPool pool = ConnectionPool.getInstance();

        try {
            pool.initPoolData();
        } catch (ConnectionPoolException e) {
            log.error("Cannot init connection pool", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {



    }
}
