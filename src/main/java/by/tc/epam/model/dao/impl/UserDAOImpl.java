package by.tc.epam.model.dao.impl;

import by.tc.epam.model.dao.ConnectionPool;
import by.tc.epam.model.dao.UserDAO;
import by.tc.epam.model.dao.exception.*;
import by.tc.epam.model.entity.User;
import by.tc.epam.model.entity.UserType;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {

    @Override
    public void registration(String name, String email, String password)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DublicateUserException,
            DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        try (PreparedStatement statement =
                     conn.prepareStatement(RequestContainer.USER_ADD_REQUEST)){

            statement.setString(1, null);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setString(4, email);

            statement.executeUpdate();


        } catch (MySQLIntegrityConstraintViolationException e) {
            throw new DublicateUserException(e);
        } catch (SQLException e){
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
        }

    }

    @Override
    public User login(int id, String password) throws DBLoginException,
            JDBCDriverNotFoundException, ConnectionPollIsEmptyException,
            DAOSQLException, IncorrectLoginException {


        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        User user = new User();


        try (PreparedStatement statement =
                     conn.prepareStatement(RequestContainer.GET_USER_REQUEST)) {

            statement.setInt(1, id);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (!rs.next()){
                throw new IncorrectLoginException();
            }

            user.setId(rs.getInt("id"));
            user.setBalance(rs.getDouble("balance"));
            user.setUserType(UserType.valueOf(rs.getString("userType").toUpperCase()));
            user.setEmail(rs.getString("email"));
            user.setName(rs.getString("name"));

        } catch (SQLException e){
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
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
    public void logOut() {

    }

    @Override
    public void withdraw(int id, double money) throws DBLoginException, JDBCDriverNotFoundException, ConnectionPollIsEmptyException, DAOSQLException, NotEnoughMoneyException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        double balance = 0;

        try (PreparedStatement withdrawStatement =
                     conn.prepareStatement(RequestContainer.SET_BALANCE_REQUEST)) {

            balance += getUserBalance(id);

            if(balance < money){
                throw new NotEnoughMoneyException();
            }

            withdrawStatement.setDouble(1, balance - money);
            withdrawStatement.setInt(2, id);

            withdrawStatement.executeUpdate();

        } catch (SQLException e){
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
        }

    }

    @Override
    public void deposit(int id, double money)
            throws DBLoginException, JDBCDriverNotFoundException,
            ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        double balance = 0;

        try (PreparedStatement preparedStatement =
                     conn.prepareStatement(RequestContainer.SET_BALANCE_REQUEST)) {

            balance += getUserBalance(id);

            preparedStatement.setDouble(1, balance + money);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e){
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
        }

    }

    @Override
    public double getUserBalance(int id) throws DAOSQLException, ConnectionPollIsEmptyException, DBLoginException, JDBCDriverNotFoundException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        double balance = 0;

        try (PreparedStatement getBalanceStatement =
                     conn.prepareStatement(RequestContainer.GET_BALANCE_REQUEST)) {

            getBalanceStatement.setInt(1, id);

            ResultSet rs = getBalanceStatement.executeQuery();

            if (rs.next()){
                balance += rs.getDouble("balance");
            }

        } catch (SQLException e){
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
        }

        return balance;
    }

}
