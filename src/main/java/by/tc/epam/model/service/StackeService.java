package by.tc.epam.model.service;

import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.SmallBalanceException;

public interface StackeService {

    void createStake(int userId, int oddId, double money, double koef) throws ServerOverloadException, DBWorkingException, ServiceSQLException, SmallBalanceException;


}
