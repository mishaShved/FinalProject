package by.tc.epam.model.dao.transaction_dao.impl;

import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.dao.transaction_dao.UserTransactionDAO;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.entity.UserType;
import by.tc.epam.util.ConstantContainer;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTransactionDAOImpl implements UserTransactionDAO {

    @Override
    public void registration(Connection conn, String name, String email, String password)
            throws DublicateUserException, DAOSQLException {

        try (PreparedStatement statement =
                     conn.prepareStatement(RequestContainer.USER_ADD_REQUEST)){

            statement.setString(1, null);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setString(4, email);

            statement.executeUpdate();

            System.out.println(statement.toString());


        } catch (MySQLIntegrityConstraintViolationException e) {
            throw new DublicateUserException(e);
        } catch (SQLException e){
            throw new DAOSQLException(e);
        }

    }

    @Override
    public User login(Connection conn, int id, String password)
            throws DAOSQLException, IncorrectLoginException {

        User user = new User();

        try (PreparedStatement statement =
                     conn.prepareStatement(RequestContainer.GET_USER_REQUEST)) {

            statement.setInt(1, id);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (!rs.next()){
                throw new IncorrectLoginException();
            }

            user.setId(rs.getInt(ConstantContainer.ID));
            user.setUserType(UserType.valueOf(rs.getString(ConstantContainer.USER_TYPE).toUpperCase()));
            user.setName(rs.getString(ConstantContainer.NAME));

        } catch (SQLException e){
            throw new DAOSQLException(e);
        }

        return user;

    }

    @Override
    public void setPassword(Connection conn, int id, String oldPassword, String newPassword) {

    }

    @Override
    public void setName(Connection conn, int id, String newName) {

    }

    @Override
    public void setBalance(Connection conn, int id, double money)
            throws DAOSQLException{

        try (PreparedStatement preparedStatement =
                     conn.prepareStatement(RequestContainer.SET_BALANCE_REQUEST)) {

            preparedStatement.setDouble(1, money);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }
    }

    @Override
    public double getUserBalance(Connection conn, int id)
            throws DAOSQLException{

        double balance = 0;

        try (PreparedStatement getBalanceStatement =
                     conn.prepareStatement(RequestContainer.GET_BALANCE_REQUEST)) {

            getBalanceStatement.setInt(1, id);

            ResultSet rs = getBalanceStatement.executeQuery();

            if (rs.next()){
                balance += rs.getDouble(ConstantContainer.BALANCE);
            }

        } catch (SQLException e){
            throw new DAOSQLException(e);
        }

        return balance;
    }
}
