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

    private static final String USER_ADD_REQUEST =
            "INSERT INTO `bukmaker`.`user` (`id`, `name`, `password`, `balance`, `user_type_id`, `email`)" +
                    " VALUES (?, ?, ?, '0', '2', ?);";

    private static final String GET_USER_REQUEST =
            "SELECT u.id, u.name, u.balance, u.email, t.type AS userType FROM bukmaker.user AS u\n" +
                    "JOIN user_type AS t ON u.user_type_id = t.id\n" +
                    "WHERE u.id = ? AND u.password = ?";

    private static final String SET_BALANCE_REQUEST =
            "UPDATE `bukmaker`.`user` SET `balance`=? WHERE `id`=?;";

    private static final String GET_BALANCE_REQUEST =
            "SELECT `user`.`balance` FROM `bukmaker`.`user` WHERE `id`=?;";



    @Override
    public void registration(String name, String email, String password)
            throws DBLoginException, JDBCDriverNotFoundException, ConnectionPollIsEmptyException,
            DublicateUserException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();

        try (PreparedStatement statement = conn.prepareStatement(USER_ADD_REQUEST)){

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


        try (PreparedStatement statement = conn.prepareStatement(GET_USER_REQUEST)) {

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
    public void placeBet(int id, int oddId, double money) {

    }

    @Override
    public void withdraw(int id, double money) throws DBLoginException, JDBCDriverNotFoundException, ConnectionPollIsEmptyException, DAOSQLException, NotEnoughMoneyException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        double balance = 0;

        try (PreparedStatement withdrawStatment = conn.prepareStatement(SET_BALANCE_REQUEST)) {

            balance += getUserBalance(id);

            if(balance < money){
                throw new NotEnoughMoneyException();
            }

            withdrawStatment.setDouble(1, balance - money);
            withdrawStatment.setInt(2, id);

            withdrawStatment.executeUpdate();

        } catch (SQLException e){
            throw new DAOSQLException(e);
        } finally {
            pool.returnConnection(conn);
        }

    }

    @Override
    public void deposit(int id, double money)
            throws DBLoginException, JDBCDriverNotFoundException, ConnectionPollIsEmptyException, DAOSQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        double balance = 0;

        try (PreparedStatement depositStatment = conn.prepareStatement(SET_BALANCE_REQUEST)) {

            balance += getUserBalance(id);

            depositStatment.setDouble(1, balance + money);
            depositStatment.setInt(2, id);

            depositStatment.executeUpdate();

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

        try (PreparedStatement getBalanceStatment = conn.prepareStatement(GET_BALANCE_REQUEST)) {

            getBalanceStatment.setInt(1, id);

            ResultSet rs = getBalanceStatment.executeQuery();

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
