package by.tc.epam.model.service;

import by.tc.epam.model.entity.Stacke;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;

import java.util.List;

public interface StakeService {

    void createStake(int userId, int oddId, double money)
            throws ServerOverloadException, DataSourceException,
            ServiceSQLException, SmallBalanceException;

    List<Stacke> getStakesByUserId(int userId, int page)
            throws ServiceSQLException, DataSourceException, ServerOverloadException;
}
