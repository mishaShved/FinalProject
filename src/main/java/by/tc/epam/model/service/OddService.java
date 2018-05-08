package by.tc.epam.model.service;


import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;

public interface OddService {

    void createOdd(int eventId, OddType oddType, double koef, double param)
            throws DataSourceException, ServiceSQLException;

    OddsList getOddsByEvent(int eventId, String locale)
            throws ServiceSQLException, DataSourceException;

    String getInfoAboutOdd(int oddId)
            throws DataSourceException, ServiceSQLException;

    String getOddType(int oddId)
            throws DataSourceException, ServiceSQLException;

    double getCoef(int oddId)
            throws DataSourceException, ServiceSQLException;

}
