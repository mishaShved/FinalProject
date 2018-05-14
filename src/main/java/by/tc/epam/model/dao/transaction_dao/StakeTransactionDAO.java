package by.tc.epam.model.dao.transaction_dao;


import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.entity.Stacke;

import java.sql.Connection;
import java.util.List;

public interface StakeTransactionDAO {

    void createStake(Connection conn, int userId, int oddId, double money, double koef)
            throws DAOSQLException;

    List<Stacke> getStakesByUserId(Connection conn, int userId, String locale)
            throws DAOSQLException;

}
