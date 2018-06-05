package exceptions;

public class CreatingBotByNameException extends RuntimeException {

    public CreatingBotByNameException() {
    }

    public CreatingBotByNameException(String message) {
        super(message);
    }
}
