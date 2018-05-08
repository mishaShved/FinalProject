package by.tc.epam.model.dao;


import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DublicateUserException;
import by.tc.epam.model.dao.exception.IncorrectLoginException;
import by.tc.epam.model.dao.exception.NotEnoughMoneyException;
import by.tc.epam.model.entity.User;

public interface UserDAO {

    int registration(String name, String email, String password)
            throws ConnectionPoolException, DublicateUserException, DAOSQLException;


    User login(int id, String password)
            throws ConnectionPoolException, DAOSQLException,
            IncorrectLoginException;


    void setPassword(int id, String oldPassword, String newPassword);

    void setName(int id, String newName);

    void withdraw(int id, double money)
            throws ConnectionPoolException, DAOSQLException,
            NotEnoughMoneyException;


    void deposit(int id, double money)
            throws ConnectionPoolException, DAOSQLException;


    double getUserBalance(int id)
            throws DAOSQLException, ConnectionPoolException;
}
