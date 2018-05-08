package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;

public interface OddDAO {

    void createOdd(int eventId, OddType oddType, double coef, double param)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException;

    OddsList getOddsByEvent(int eventId, String locale)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException;

    String getInfoAboutOdd(int oddId, String locale)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException;

    String getOddType(int oddId)
            throws DAOSQLException, ConnectionPoolException,
            DBLoginException, JDBCDriverNotFoundException;

    double getCoef(int oddId)
            throws ConnectionPoolException, DBLoginException,
            JDBCDriverNotFoundException, DAOSQLException;

}
