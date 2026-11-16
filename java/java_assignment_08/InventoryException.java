public class InventoryException extends Exception {
    public InventoryException(String message)
    {
        super("Order Failed: " + message);
    }
}
