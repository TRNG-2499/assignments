public class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException() {
        String message = "Invalid quantity!";
        super(message);
    }
}
