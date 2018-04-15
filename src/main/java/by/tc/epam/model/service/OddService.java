package by.tc.epam.model.service;


import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

public interface OddService {

    void createOdd(int eventId, OddType oddType, double koef, double param)
            throws ServerOverloadException, DataSourceException,
            ServiceSQLException;

    OddsList getOddsByEvent(int eventId)
            throws ServiceSQLException, ServerOverloadException, DataSourceException;

    String getInfoAboutOdd(int oddId) throws DataSourceException, ServerOverloadException, ServiceSQLException;

    String getOddType(int oddId) throws DataSourceException, ServerOverloadException, ServiceSQLException;

    double getCoef(int oddId) throws DataSourceException, ServerOverloadException, ServiceSQLException;

}
