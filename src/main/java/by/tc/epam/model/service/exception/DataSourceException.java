package by.tc.epam.model.service.exception;

public class DataSourceException extends Exception {

    public DataSourceException() {
    }

    public DataSourceException(String s) {
        super(s);
    }

    public DataSourceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DataSourceException(Throwable throwable) {
        super(throwable);
    }
}
