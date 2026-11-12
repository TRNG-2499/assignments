package assignments.java.java_assignment_08.exceptions;

public class InvalidQuantityException extends InventoryException {

    public InvalidQuantityException(int quantity) {
        super("Invalid Quantity — The order requests a zero or negative quantity of an item. Current quantity: "
                + quantity);
    }
}
