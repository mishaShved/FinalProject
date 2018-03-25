package by.tc.epam.model.dao.exception;

public class ConnectionPollIsEmptyException extends Exception {

    public ConnectionPollIsEmptyException() {
    }

    public ConnectionPollIsEmptyException(String s) {
        super(s);
    }

    public ConnectionPollIsEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ConnectionPollIsEmptyException(Throwable throwable) {
        super(throwable);
    }
}
