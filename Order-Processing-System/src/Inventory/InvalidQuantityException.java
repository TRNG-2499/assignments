package Inventory;

import Inventory.InventoryException;

public class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
