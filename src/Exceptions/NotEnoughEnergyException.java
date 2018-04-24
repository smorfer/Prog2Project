package Exceptions;

public class NotEnoughEnergyException extends RuntimeException{

    public NotEnoughEnergyException(){
        super("Not enough energy to do that!");
    }

}
