package exceptions;

public class WrongMethodUsageException extends RuntimeException{
    public WrongMethodUsageException() {
    }

    public WrongMethodUsageException(String message) {
        super(message);
    }
}
