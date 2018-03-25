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

    @Override
    public void registration(String name, String email, String password)
            throws ServiceSQLException, DBWorkingException,
            ServerOverloadException, UserAlreadyExistException {

        try {
            userDAO.registration(name, email, password);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        } catch (DublicateUserException e) {
            throw new UserAlreadyExistException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }
    }

    @Override
    public User login(int id, String password)
            throws DBWorkingException, ServerOverloadException,
            ServiceSQLException, LoginFailedException {

        User user;

        try {
            user = userDAO.login(id, password);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
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

    @Override
    public void placeBet(int id, int oddId, double money) {

    }

    @Override
    public void withdraw(int id, double money)
            throws DBWorkingException, ServiceSQLException,
            ServerOverloadException, SmallBalanceException {

        try {
            userDAO.withdraw(id, money);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (NotEnoughMoneyException e) {
            throw new SmallBalanceException(e);
        }

    }

    @Override
    public void deposit(int id, double money)
            throws DBWorkingException, ServerOverloadException,
            ServiceSQLException {

        try {
            userDAO.deposit(id, money);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }


    }

    @Override
    public double getUserBalance(int id)
            throws ServiceSQLException, ServerOverloadException,
            DBWorkingException {

        double balance;

        try {
            balance = userDAO.getUserBalance(id);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (ConnectionPollIsEmptyException e) {
            throw new ServerOverloadException(e);
        } catch (DBLoginException | JDBCDriverNotFoundException e) {
            throw new DBWorkingException(e);
        }

        return balance;
    }
}
