package assignments.java.java_assignment_08;

public class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException(String message) {
		super("Order failed: Amount requested is invalid. "+message);
	}
}
