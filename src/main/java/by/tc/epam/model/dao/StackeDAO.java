package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.*;

public interface StackeDAO {

    void createStake(int userId, int oddId, double money, double koef)
            throws ConnectionPollIsEmptyException,
            DBLoginException, JDBCDriverNotFoundException, DAOSQLException, NotEnoughMoneyException;

}
