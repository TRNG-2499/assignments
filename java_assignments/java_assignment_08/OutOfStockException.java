package java_assignments.java_assignment_08;

public class OutOfStockException extends InventoryException{
    public OutOfStockException(){
        super("Quantity requested unavailable.");
    }

    public OutOfStockException(int req, int avail){
        super("Quantity requested: "+req+" Quantity available: "+avail);
    }
}
