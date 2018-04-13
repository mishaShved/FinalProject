package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.Odd;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;

import java.util.List;

public interface OddDAO {

    void createOdd(int eventId, OddType oddType, double coef, double param)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException;

    OddsList getOddsByEvent(int eventId)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException;

    String getInfoAboutOdd(int oddId) throws DBLoginException, JDBCDriverNotFoundException, ConnectionPollIsEmptyException, DAOSQLException;

    String getOddType(int oddId) throws DAOSQLException, ConnectionPollIsEmptyException, DBLoginException, JDBCDriverNotFoundException;

    double getCoef(int oddId) throws ConnectionPollIsEmptyException, DBLoginException, JDBCDriverNotFoundException, DAOSQLException;

}
