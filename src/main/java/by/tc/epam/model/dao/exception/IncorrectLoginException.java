package by.tc.epam.model.dao.exception;

public class IncorrectLoginException extends Exception {

    public IncorrectLoginException() {
    }

    public IncorrectLoginException(String s) {
        super(s);
    }

    public IncorrectLoginException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public IncorrectLoginException(Throwable throwable) {
        super(throwable);
    }
}
