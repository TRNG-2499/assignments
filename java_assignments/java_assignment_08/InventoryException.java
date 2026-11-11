package java_assignments.java_assignment_08;

public class InventoryException extends Exception{
    public InventoryException(){
        super("Inventory error.");
    }

    public InventoryException(String message){
        super(message);
    }
}
