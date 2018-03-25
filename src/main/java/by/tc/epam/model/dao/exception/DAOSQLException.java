package by.tc.epam.model.dao.exception;

public class DAOSQLException extends Exception {

    public DAOSQLException() {
    }

    public DAOSQLException(String s) {
        super(s);
    }

    public DAOSQLException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DAOSQLException(Throwable throwable) {
        super(throwable);
    }
}
