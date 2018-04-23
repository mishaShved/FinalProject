package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.entity.User;

public interface UserDAO {

    void registration(String name, String email, String password)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DublicateUserException, DAOSQLException;


    User login(int id, String password)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException,
            IncorrectLoginException;


    void setPassword(int id, String oldPassword, String newPassword);

    void setName(int id, String newName);

    void withdraw(int id, double money)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException,
            NotEnoughMoneyException;


    void deposit(int id, double money)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPoolException, DAOSQLException;


    double getUserBalance(int id)
            throws DAOSQLException, ConnectionPoolException,
            DBLoginException, JDBCDriverNotFoundException;
}
