package by.tc.epam.model.dao;


import by.tc.epam.model.dao.impl.EventDAOImpl;
import by.tc.epam.model.dao.impl.OddDAOImpl;
import by.tc.epam.model.dao.impl.StackeDAOImpl;
import by.tc.epam.model.dao.impl.UserDAOImpl;

import java.util.List;

public class DAOFactory {

    private static final DAOFactory ourInstance = new DAOFactory();
    private final UserDAO userDAO = new UserDAOImpl();
    private final EventDAO eventDAO = new EventDAOImpl();
    private final OddDAO oddDAO = new OddDAOImpl();
    private final StackeDAO stackeDAO = new StackeDAOImpl();

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

    public StackeDAO getStackeDAO() {
        return stackeDAO;
    }
}
