package by.tc.epam.model.service;


import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import java.util.List;

public interface OddService {

    void createOdd(int eventId, OddType oddType, double koef, double param)
            throws ServerOverloadException, DBWorkingException,
            ServiceSQLException;

    OddsList getOddsByEvent(int eventId)
            throws ServiceSQLException, ServerOverloadException, DBWorkingException;

    String getInfoAboutOdd(int oddId) throws DBWorkingException, ServerOverloadException, ServiceSQLException;

    String getOddType(int oddId) throws DBWorkingException, ServerOverloadException, ServiceSQLException;

    double getCoef(int oddId) throws DBWorkingException, ServerOverloadException, ServiceSQLException;

}
