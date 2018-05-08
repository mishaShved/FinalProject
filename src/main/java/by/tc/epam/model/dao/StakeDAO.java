package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.entity.Stacke;

import java.util.List;

public interface StakeDAO {

    void createStake(int userId, int oddId, double money)
            throws ConnectionPoolException,
            DBLoginException, JDBCDriverNotFoundException,
            DAOSQLException, NotEnoughMoneyException;

    List<Stacke> getStakesByUserId(int userId, String locale)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException;

}