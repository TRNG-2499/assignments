// Since it extends InventoryException, it needs to have the same method signature
// as one of the parent constructors
public class OutOfStockException extends InventoryException {
    public OutOfStockException() {
        String message = "Item is out of stock!";
        super(message);
    }
}
