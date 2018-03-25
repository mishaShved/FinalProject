package by.tc.epam.model.service;


import by.tc.epam.model.entity.Odd;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import java.util.List;

public interface OddService {

    void createOdd(int eventId, OddType oddType, double koef, double param)
            throws ServerOverloadException, DBWorkingException,
            ServiceSQLException;

    List<Odd> getOddsByEvent(int eventId) throws ServiceSQLException, ServerOverloadException, DBWorkingException;

}
