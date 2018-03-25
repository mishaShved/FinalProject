package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.Odd;
import by.tc.epam.model.entity.OddType;

import java.util.List;

public interface OddDAO {

    void createOdd(int eventId, OddType oddType, double koef, double param)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException;

    void setKoef();
    void setParam();


    List<Odd> getOddsByEvent(int eventId)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException;

}
