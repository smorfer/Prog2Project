package Exceptions;

public class ScanException extends RuntimeException{
    public ScanException(String message){
        super(message);
    }

    public ScanException(){
        super();
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
