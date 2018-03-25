package by.tc.epam.model.service.exception;

public class ServerOverloadException extends Exception {

    public ServerOverloadException() {
    }

    public ServerOverloadException(String s) {
        super(s);
    }

    public ServerOverloadException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServerOverloadException(Throwable throwable) {
        super(throwable);
    }

}
