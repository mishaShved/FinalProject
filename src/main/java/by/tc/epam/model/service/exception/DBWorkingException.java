package by.tc.epam.model.service.exception;

public class DBWorkingException extends Exception {

    public DBWorkingException() {
    }

    public DBWorkingException(String s) {
        super(s);
    }

    public DBWorkingException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DBWorkingException(Throwable throwable) {
        super(throwable);
    }
}
