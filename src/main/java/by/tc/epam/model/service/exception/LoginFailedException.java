package by.tc.epam.model.service.exception;

public class LoginFailedException extends Exception {
    public LoginFailedException() {
    }

    public LoginFailedException(String s) {
        super(s);
    }

    public LoginFailedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public LoginFailedException(Throwable throwable) {
        super(throwable);
    }
}
