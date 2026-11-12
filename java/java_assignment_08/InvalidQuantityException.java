public class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException() {
        super("Order failed: Invalid quantity. Quantity must be greater than 0.");
    }
}
