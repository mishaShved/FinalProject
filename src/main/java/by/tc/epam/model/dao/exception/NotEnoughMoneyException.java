package by.tc.epam.model.dao.exception;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException() {
    }

    public NotEnoughMoneyException(String s) {
        super(s);
    }

    public NotEnoughMoneyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotEnoughMoneyException(Throwable throwable) {
        super(throwable);
    }
}
