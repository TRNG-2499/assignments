package Exceptions;

public class InventoryException extends Exception {
    public InventoryException() {
        super("Error: Inventory exception.");
    }
    public InventoryException(String message) {
        super(message);
    }
}