package by.tc.epam.model.dao.transaction_dao.impl;

import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.dao.transaction_dao.UserTransactionDAO;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.entity.UserType;
import by.tc.epam.util.ConstantContainer;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.*;

public class UserTransactionDAOImpl implements UserTransactionDAO {

    @Override
    public int registration(Connection conn, String name, String email, String password)
            throws DublicateUserException, DAOSQLException {

        int userId;

        try (CallableStatement statement =
                     conn.prepareCall(RequestContainer.USER_ADD_REQUEST)){

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.registerOutParameter(4,java.sql.Types.INTEGER);
            statement.execute();
            userId = statement.getInt(4);


        } catch (MySQLIntegrityConstraintViolationException e) {
            throw new DublicateUserException(e);
        } catch (SQLException e){
            throw new DAOSQLException(e);
        }

        return userId;
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
