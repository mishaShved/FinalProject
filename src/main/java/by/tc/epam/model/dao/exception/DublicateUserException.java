package by.tc.epam.model.dao.exception;

public class DublicateUserException extends Exception {

    public DublicateUserException() {
    }

    public DublicateUserException(String s) {
        super(s);
    }

    public DublicateUserException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DublicateUserException(Throwable throwable) {
        super(throwable);
    }
}
