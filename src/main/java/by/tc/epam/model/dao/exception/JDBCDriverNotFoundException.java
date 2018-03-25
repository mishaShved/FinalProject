package by.tc.epam.model.dao.exception;

public class JDBCDriverNotFoundException extends Exception {

    public JDBCDriverNotFoundException() {
    }

    public JDBCDriverNotFoundException(String s) {
        super(s);
    }

    public JDBCDriverNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public JDBCDriverNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
