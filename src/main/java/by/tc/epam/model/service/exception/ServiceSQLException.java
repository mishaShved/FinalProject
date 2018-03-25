package by.tc.epam.model.service.exception;

public class ServiceSQLException extends Exception {

    public ServiceSQLException() {
    }

    public ServiceSQLException(String s) {
        super(s);
    }

    public ServiceSQLException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceSQLException(Throwable throwable) {
        super(throwable);
    }
}
