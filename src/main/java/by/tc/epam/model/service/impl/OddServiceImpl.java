package by.tc.epam.model.service.impl;

import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.OddDAO;
import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;
import by.tc.epam.model.service.OddService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;

public class OddServiceImpl implements OddService{

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final OddDAO oddDAO = daoFactory.getOddDAO();

    @Override
    public void createOdd(int eventId, OddType oddType, double koef, double param)
            throws DataSourceException,
            ServiceSQLException {

        try {
            oddDAO.createOdd(eventId, oddType, koef, param);
        } catch (DBLoginException | JDBCDriverNotFoundException | ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }


    }

    @Override
    public OddsList getOddsByEvent(int eventId, String locale)
            throws ServiceSQLException, DataSourceException {

        OddsList odds;

        try {
            odds = oddDAO.getOddsByEvent(eventId, locale);
        } catch (DBLoginException | JDBCDriverNotFoundException | ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return odds;
    }

    @Override
    public String getInfoAboutOdd(int oddId, String locale)
            throws DataSourceException, ServiceSQLException {

        String oddInfo;

        try{
            oddInfo = oddDAO.getInfoAboutOdd(oddId, locale);
        } catch (DBLoginException | JDBCDriverNotFoundException | ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return oddInfo;


    }

    @Override
    public String getOddType(int oddId)
            throws DataSourceException, ServiceSQLException {

        String oddType;

        try{
            oddType = oddDAO.getOddType(oddId);
        }catch (DBLoginException | JDBCDriverNotFoundException | ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return oddType;
    }

    @Override
    public double getCoef(int oddId)
            throws DataSourceException, ServiceSQLException {

        double coef;

        try{
            coef = oddDAO.getCoef(oddId);
        } catch (DBLoginException | JDBCDriverNotFoundException | ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return coef;
    }
}
