package by.tc.epam.model.service;

import by.tc.epam.model.entity.User;
import by.tc.epam.model.service.exception.*;

public interface UserService {

    void registration(String name, String email, String password) throws ServiceSQLException, DBWorkingException, ServerOverloadException, UserAlreadyExistException;
    User login(int id, String password) throws DBWorkingException, ServerOverloadException, ServiceSQLException, LoginFailedException;
    void setPassword(int id, String oldPassword, String newPassword);
    void setName(int id, String newName);
    void placeBet(int id, int oddId, double money);
    void withdraw(int id, double money) throws DBWorkingException, ServiceSQLException, ServerOverloadException, SmallBalanceException;
    void deposit(int id, double money) throws DBWorkingException, ServerOverloadException, ServiceSQLException;
    double getUserBalance(int id) throws ServiceSQLException, ServerOverloadException, DBWorkingException;


}
