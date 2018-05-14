package by.tc.epam.model.service.impl;

import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.UserDAO;
import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.UserService;
import by.tc.epam.model.service.exception.*;

public class UserServiceImpl implements UserService {

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final UserDAO userDAO = daoFactory.getUserDAO();

    /**
     *  prepare parameters for invoke dao
     * @param name
     * @param email
     * @param password
     * @return
     * @throws ServiceSQLException
     * @throws UserAlreadyExistException
     * @throws DataSourceException
     */
    @Override
    public int registration(String name, String email, String password)
            throws ServiceSQLException, UserAlreadyExistException,
            DataSourceException {

        int userID;

        try {
            userID = userDAO.registration(name, email, password);
        } catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DublicateUserException e) {
            throw new UserAlreadyExistException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return userID;
    }

    /**
     *  prepare parameters for invoke dao
     * @param id
     * @param password
     * @return
     * @throws DataSourceException
     * @throws ServiceSQLException
     * @throws LoginFailedException
     */
    @Override
    public User login(int id, String password)
            throws DataSourceException,
            ServiceSQLException, LoginFailedException {

        User user;

        try {
            user = userDAO.login(id, password);
        } catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (IncorrectLoginException e) {
            throw new LoginFailedException(e);
        }

        return user;
    }

    @Override
    public void setPassword(int id, String oldPassword, String newPassword) {

    }

    @Override
    public void setName(int id, String newName) {

    }

    /**
     *  prepare parameters for invoke dao
     * @param id
     * @param money
     * @throws DataSourceException
     * @throws ServiceSQLException
     * @throws SmallBalanceException
     */
    @Override
    public void withdraw(int id, double money)
            throws DataSourceException, ServiceSQLException,
            SmallBalanceException {

        try {
            userDAO.withdraw(id, money);
        } catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (NotEnoughMoneyException e) {
            throw new SmallBalanceException(e);
        }

    }

    /**
     *  prepare parameters for invoke dao
     * @param id
     * @param money
     * @throws DataSourceException
     * @throws ServiceSQLException
     */
    @Override
    public void deposit(int id, double money)
            throws DataSourceException, ServiceSQLException {

        try {
            userDAO.deposit(id, money);
        } catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }


    }

    /**
     *  prepare parameters for invoke dao
     * @param id
     * @return
     * @throws ServiceSQLException
     * @throws DataSourceException
     */
    @Override
    public double getUserBalance(int id)
            throws ServiceSQLException, DataSourceException {

        double balance;

        try {
            balance = userDAO.getUserBalance(id);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (ConnectionPoolException e) {
            throw new DataSourceException(e);
        }

        return balance;
    }
}
