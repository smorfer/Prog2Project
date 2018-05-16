package exceptions;

public class NotEnoughEnergyException extends Exception{
    public NotEnoughEnergyException() {
    }

    public NotEnoughEnergyException(String message) {
        super(message);
    }
}
