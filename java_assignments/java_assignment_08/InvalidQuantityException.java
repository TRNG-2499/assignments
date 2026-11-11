package java_assignments.java_assignment_08;

public class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException(){
        super("Invalid quantity requested. Quantity should be greater than 0.");
    }
}
