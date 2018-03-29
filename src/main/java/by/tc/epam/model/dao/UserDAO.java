package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.entity.User;

import java.sql.Connection;

public interface UserDAO {

    void registration(String name, String email, String password)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DublicateUserException, DAOSQLException;


    User login(int id, String password)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException,
            IncorrectLoginException;


    void setPassword(int id, String oldPassword, String newPassword);

    void setName(int id, String newName);

    void logOut();

    void withdraw(int id, double money)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException,
            NotEnoughMoneyException;


    void deposit(int id, double money)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException;


    double getUserBalance(int id)
            throws DAOSQLException, ConnectionPollIsEmptyException,
            DBLoginException, JDBCDriverNotFoundException;
}
