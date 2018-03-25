package by.tc.epam.model.service.exception;

public class SmallBalanceException extends Exception {

    public SmallBalanceException() {
    }

    public SmallBalanceException(String s) {
        super(s);
    }

    public SmallBalanceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public SmallBalanceException(Throwable throwable) {
        super(throwable);
    }
}
