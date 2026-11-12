package Exceptions;

public class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException() {
        super("Error: Inventory contains invalid quantity.");
    }
    public InvalidQuantityException(String message) {
        super(message);
    }
}