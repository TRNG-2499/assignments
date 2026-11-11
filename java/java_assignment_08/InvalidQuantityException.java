import java.io.*;
import java.util.*;

public class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException(int itemQuantity){
        super(String.format("Item Quantity is invalid: change %d to a number greater than 0!", itemQuantity));
    }
}
