package by.tc.epam.model.dao.transaction_dao;

import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;

import java.sql.Connection;

public interface OddTransactionDAO {

    void createOdd(Connection conn, int eventId, OddType oddType, double coef, double param)
            throws DAOSQLException;

    OddsList getOddsByEvent(Connection conn, int eventId, String locale)
            throws DAOSQLException;

    String getInfoAboutOdd(Connection conn, int oddId, String locale)
            throws DAOSQLException;

    String getOddType(Connection conn, int oddId)
            throws DAOSQLException;

    double getCoef(Connection conn, int oddId)
            throws DAOSQLException;

}

