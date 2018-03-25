package by.tc.epam.model.service.exception;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException() {
    }

    public UserAlreadyExistException(String s) {
        super(s);
    }

    public UserAlreadyExistException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UserAlreadyExistException(Throwable throwable) {
        super(throwable);
    }
}
