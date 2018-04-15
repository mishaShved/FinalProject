package by.tc.epam.model.dao.transaction_dao;

import by.tc.epam.model.dao.transaction_dao.impl.EventTransactionDAOImpl;
import by.tc.epam.model.dao.transaction_dao.impl.OddTransactionDAOImpl;
import by.tc.epam.model.dao.transaction_dao.impl.StakeTransactionDAOImpl;
import by.tc.epam.model.dao.transaction_dao.impl.UserTransactionDAOImpl;

public final class TransactionDAOFactory {

    private static TransactionDAOFactory ourInstance = new TransactionDAOFactory();
    private final UserTransactionDAO userTransactionDAO = new UserTransactionDAOImpl();
    private final EventTransactionDAO eventTransactionDAO = new EventTransactionDAOImpl();
    private final OddTransactionDAO oddTransactionDAO = new OddTransactionDAOImpl();
    private final StakeTransactionDAO stackeTransactionDAO = new StakeTransactionDAOImpl();

    public static TransactionDAOFactory getInstance() {
        return ourInstance;
    }

    private TransactionDAOFactory() {
    }

    public UserTransactionDAO getUserTransactionDAO() {
        return userTransactionDAO;
    }

    public EventTransactionDAO getEventTransactionDAO() {
        return eventTransactionDAO;
    }

    public OddTransactionDAO getOddTransactionDAO() {
        return oddTransactionDAO;
    }

    public StakeTransactionDAO getStackeTransactionDAO() {
        return stackeTransactionDAO;
    }
}
