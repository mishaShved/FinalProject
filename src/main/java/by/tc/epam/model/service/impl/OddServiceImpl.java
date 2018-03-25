package by.tc.epam.model.service.impl;

import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.OddDAO;
import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.service.OddService;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;

public class OddServiceImpl implements OddService{

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final OddDAO oddDAO = daoFactory.getOddDAO();

    @Override
    public void createOdd(int eventId, OddType oddType, double koef, double param)
            throws ServerOverloadException, DBWorkingException {

        try {
            oddDAO.createOdd(eventId, oddType, koef, param);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        }


    }
}
