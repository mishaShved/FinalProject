package by.tc.epam.model.service.impl;

import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.OddDAO;
import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;
import by.tc.epam.model.service.OddService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;

public class OddServiceImpl implements OddService{

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final OddDAO oddDAO = daoFactory.getOddDAO();

    /**
     *  prepare parameters for invoke dao
     * @param eventId
     * @param oddType
     * @param koef
     * @param param
     * @throws DataSourceException
     * @throws ServiceSQLException
     */
    @Override
    public void createOdd(int eventId, OddType oddType, double koef, double param)
            throws DataSourceException,
            ServiceSQLException {

        try {
            oddDAO.createOdd(eventId, oddType, koef, param);
        } catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }


    }

    /**
     *  prepare parameters for invoke dao
     * @param eventId
     * @param locale
     * @return
     * @throws ServiceSQLException
     * @throws DataSourceException
     */

    @Override
    public OddsList getOddsByEvent(int eventId, String locale)
            throws ServiceSQLException, DataSourceException {

        OddsList odds;

        try {
            odds = oddDAO.getOddsByEvent(eventId, locale);
        } catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return odds;
    }

    /**
     *  prepare parameters for invoke dao
     * @param oddId
     * @param locale
     * @return
     * @throws DataSourceException
     * @throws ServiceSQLException
     */
    @Override
    public String getInfoAboutOdd(int oddId, String locale)
            throws DataSourceException, ServiceSQLException {

        String oddInfo;

        try{
            oddInfo = oddDAO.getInfoAboutOdd(oddId, locale);
        } catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return oddInfo;


    }

    /**
     *  prepare parameters for invoke dao
     * @param oddId
     * @return
     * @throws DataSourceException
     * @throws ServiceSQLException
     */
    @Override
    public String getOddType(int oddId)
            throws DataSourceException, ServiceSQLException {

        String oddType;

        try{
            oddType = oddDAO.getOddType(oddId);
        }catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return oddType;
    }

    /**
     *  prepare parameters for invoke dao
     * @param oddId
     * @return
     * @throws DataSourceException
     * @throws ServiceSQLException
     */
    @Override
    public double getCoef(int oddId)
            throws DataSourceException, ServiceSQLException {

        double coef;

        try{
            coef = oddDAO.getCoef(oddId);
        } catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return coef;
    }
}
