package Exceptions;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message) {
        super(message);
    }
    public EntityNotFoundException() {
        super("Exception: Entity not found.");
    }
}