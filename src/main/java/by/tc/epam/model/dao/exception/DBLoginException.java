package by.tc.epam.model.dao.exception;

public class DBLoginException extends Exception {

    public DBLoginException() {
    }

    public DBLoginException(String s) {
        super(s);
    }

    public DBLoginException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DBLoginException(Throwable throwable) {
        super(throwable);
    }
}
