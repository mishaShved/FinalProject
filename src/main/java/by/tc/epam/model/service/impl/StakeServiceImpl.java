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
import by.tc.epam.util.ConstantContainer;

import java.util.ArrayList;
import java.util.List;


public class StakeServiceImpl implements StakeService {

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final StakeDAO dao = daoFactory.getStackeDAO();

    @Override
    public void createStake(int userId, int oddId, double money)
            throws ServerOverloadException, DataSourceException,
            ServiceSQLException, SmallBalanceException {

        try {
            dao.createStake(userId, oddId, money);
        } catch (ConnectionPoolException e) {
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
    public List<Stacke> getStakesByUserId(int userId, int page)
            throws ServiceSQLException, DataSourceException,
            ServerOverloadException {

        List<Stacke> allStakes;
        List<Stacke> foundRes = new ArrayList<>();

        try{

            allStakes = dao.getStakesByUserId(userId);

            for(int i = (page - 1) * 5, j = 0; j < 5 && allStakes.size() > i; i++, j++){
                foundRes.add(allStakes.get(i));
            }

        } catch (ConnectionPoolException e) {
            throw new ServerOverloadException();
        } catch (JDBCDriverNotFoundException | DBLoginException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return foundRes;
    }

    @Override
    public int getPageCount(int userId)
            throws ServerOverloadException,
            DataSourceException, ServiceSQLException{

        List<Stacke> allStakes;
        int pageCount;

        try{

            allStakes = dao.getStakesByUserId(userId);

            pageCount = getPageCount(allStakes, ConstantContainer.COUNT_STAKE_ON_PAGE);

        } catch (ConnectionPoolException e) {
            throw new ServerOverloadException();
        } catch (JDBCDriverNotFoundException | DBLoginException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return pageCount;
    }

    private int getPageCount(List<?> stake, int countStakesOnPage){

        int pageCount = stake.size() / countStakesOnPage;

        if(stake.size() % countStakesOnPage != 0){
            pageCount ++;
        }

        return pageCount;
    }

}
