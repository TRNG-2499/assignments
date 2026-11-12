package Inventory;

import Inventory.InventoryException;

public class OutOfStockException extends InventoryException {
    public OutOfStockException(String message) {
        super(message);
    }
}
