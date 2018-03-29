package by.tc.epam.model.service;

import by.tc.epam.model.entity.Stacke;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;

import java.util.List;

public interface StackeService {

    void createStake(int userId, int oddId, double money, double koef) throws ServerOverloadException, DBWorkingException, ServiceSQLException, SmallBalanceException;

    List<Stacke> getStakesByUserId(int userId) throws ServiceSQLException, DBWorkingException, ServerOverloadException;
}
