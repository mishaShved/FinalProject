package by.tc.epam.model.dao.exception;

public class ConnectionPoolException extends Exception {

    public ConnectionPoolException() {
    }

    public ConnectionPoolException(String s) {
        super(s);
    }

    public ConnectionPoolException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ConnectionPoolException(Throwable throwable) {
        super(throwable);
    }
}
