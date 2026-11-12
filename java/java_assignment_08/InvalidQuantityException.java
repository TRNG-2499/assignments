package java.java_assignment_08;

public class InvalidQuantityException extends Inventoryexception {
    InvalidQuantityException(String itemName, int quantity){
        super("Invalid quantity for \"" + itemName + "\": " + quantity + ". Quantity must be at least 1.");
    }
    
}
