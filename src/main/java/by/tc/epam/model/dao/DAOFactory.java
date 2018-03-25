package by.tc.epam.model.dao;


import by.tc.epam.model.dao.impl.EventDAOImpl;
import by.tc.epam.model.dao.impl.OddDAOImpl;
import by.tc.epam.model.dao.impl.UserDAOImpl;
import by.tc.epam.model.entity.Stacke;

import java.util.List;

public class DAOFactory {

    private static final DAOFactory ourInstance = new DAOFactory();
    private static final UserDAO userDAO = new UserDAOImpl();
    private static final EventDAO eventDAO = new EventDAOImpl();
    private static final OddDAO oddDAO = new OddDAOImpl();

    public static DAOFactory getInstance() {
        return ourInstance;
    }

    private DAOFactory() {
    }

    public UserDAO getUserDAO(){
        return userDAO;
    }

    public EventDAO getEventDAO() {
        return eventDAO;
    }

    public OddDAO getOddDAO() {
        return oddDAO;
    }
}
