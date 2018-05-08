package by.tc.epam.model.dao.transaction_dao;


import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DublicateUserException;
import by.tc.epam.model.dao.exception.IncorrectLoginException;
import by.tc.epam.model.entity.User;

import java.sql.Connection;

public interface UserTransactionDAO {

    int registration(Connection conn, String name, String email, String password)
            throws DublicateUserException, DAOSQLException;


    User login(Connection conn, int id, String password)
            throws DAOSQLException, IncorrectLoginException;


    void setPassword(Connection conn, int id, String oldPassword, String newPassword);

    void setName(Connection conn, int id, String newName);

    void setBalance(Connection conn, int id, double money)
            throws DAOSQLException;


    double getUserBalance(Connection conn, int id)
            throws DAOSQLException;
}

