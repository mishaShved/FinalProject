package by.tc.epam.model.service;

import by.tc.epam.model.entity.Stacke;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;

import java.util.List;

public interface StakeService {

    void createStake(int userId, int oddId, double money)
            throws DataSourceException,
            ServiceSQLException, SmallBalanceException;

    List<Stacke> getStakesByUserId(int userId, int page, String locale)
            throws ServiceSQLException, DataSourceException;

    int getPageCount(int userId)
            throws DataSourceException, ServiceSQLException;
}
