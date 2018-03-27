package by.tc.epam.model.service.impl;

import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.StackeDAO;
import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.service.StackeService;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;


public class StackeServiceImpl implements StackeService {

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final StackeDAO dao = daoFactory.getStackeDAO();

    @Override
    public void createStake(int userId, int oddId, double money, double koef)
            throws ServerOverloadException, DBWorkingException, ServiceSQLException, SmallBalanceException {

        try {
            dao.createStake(userId, oddId, money, koef);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException();
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (NotEnoughMoneyException e) {
            throw new SmallBalanceException(e);
        }

    }


}
