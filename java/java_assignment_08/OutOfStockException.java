import java.io.*;
import java.util.*;

public class OutOfStockException extends InventoryException {
    public OutOfStockException(String itemName, int requestedQuantity, int availableStock){
        super(String.format("# of %s: %d requested, but %d available!", itemName, requestedQuantity, availableStock));
    }
}