package by.tc.epam.model.service.impl;

import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.StakeDAO;
import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.entity.Stacke;
import by.tc.epam.model.service.StakeService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;

import java.util.List;


public class StakeServiceImpl implements StakeService {

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final StakeDAO dao = daoFactory.getStackeDAO();

    @Override
    public void createStake(int userId, int oddId, double money)
            throws ServerOverloadException, DataSourceException, ServiceSQLException, SmallBalanceException {

        try {
            dao.createStake(userId, oddId, money);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException();
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (NotEnoughMoneyException e) {
            throw new SmallBalanceException(e);
        }

    }

    @Override
    public List<Stacke> getStakesByUserId(int userId) throws ServiceSQLException, DataSourceException, ServerOverloadException {

        List<Stacke> foundRes;

        try{
            foundRes = dao.getStakesByUserId(userId);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException();
        } catch (JDBCDriverNotFoundException | DBLoginException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return foundRes;
    }


}
