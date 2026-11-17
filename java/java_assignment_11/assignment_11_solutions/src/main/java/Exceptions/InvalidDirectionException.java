package Exceptions;

public class InvalidDirectionException extends Exception{
    public InvalidDirectionException(String message) {
        super(message);
    }
    public InvalidDirectionException() {
        super("Exception: Invalid direction.");
    }

}
