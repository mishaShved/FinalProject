package by.tc.epam.model.service;

import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.LoginFailedException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import by.tc.epam.model.service.exception.UserAlreadyExistException;
import by.tc.epam.model.service.exception.SmallBalanceException;


public interface UserService {

    int registration(String name, String email, String password)
            throws ServiceSQLException, DataSourceException,
            UserAlreadyExistException;

    User login(int id, String password)
            throws DataSourceException,
            ServiceSQLException, LoginFailedException;

    void setPassword(int id, String oldPassword, String newPassword);

    void setName(int id, String newName);

    void withdraw(int id, double money)
            throws DataSourceException, ServiceSQLException,
            SmallBalanceException;

    void deposit(int id, double money)
            throws DataSourceException, ServiceSQLException;

    double getUserBalance(int id)
            throws ServiceSQLException, DataSourceException;
}
