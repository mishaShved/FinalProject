package by.tc.epam.model.service.impl;

import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.OddDAO;
import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.Odd;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.OddsList;
import by.tc.epam.model.service.OddService;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import java.util.List;

public class OddServiceImpl implements OddService{

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final OddDAO oddDAO = daoFactory.getOddDAO();

    @Override
    public void createOdd(int eventId, OddType oddType, double koef, double param)
            throws ServerOverloadException, DBWorkingException,
            ServiceSQLException {

        try {
            oddDAO.createOdd(eventId, oddType, koef, param);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }


    }

    @Override
    public OddsList getOddsByEvent(int eventId)
            throws ServiceSQLException, ServerOverloadException,
            DBWorkingException {

        OddsList odds;

        try {
            odds = oddDAO.getOddsByEvent(eventId);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return odds;
    }

    @Override
    public String getInfoAboutOdd(int oddId)
            throws DBWorkingException, ServerOverloadException,
            ServiceSQLException {

        String oddInfo;

        try{
            oddInfo = oddDAO.getInfoAboutOdd(oddId);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return oddInfo;


    }

    @Override
    public String getOddType(int oddId)
            throws DBWorkingException, ServerOverloadException,
            ServiceSQLException {

        String oddType;

        try{
            oddType = oddDAO.getOddType(oddId);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return oddType;
    }

    @Override
    public double getCoef(int oddId)
            throws DBWorkingException, ServerOverloadException,
            ServiceSQLException {

        double coef;

        try{
            coef = oddDAO.getCoef(oddId);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return coef;
    }
}
