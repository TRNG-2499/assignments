public class InvalidQuantityException extends InventoryException {

    public InvalidQuantityException() {
        super("Order failed: Invalid Quantity. Quantity must be greater than 0.");
    }
}
