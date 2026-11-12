package assignments.java.java_assignment_08;

public class OutOfStockException extends InventoryException {
    public OutOfStockException(String message) {
		super("Order failed: Inventory is out of stock. "+message);
	}
}
