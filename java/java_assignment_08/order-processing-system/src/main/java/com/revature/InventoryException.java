package com.revature;

// parent for every stock-related problem, so callers can catch them all with one catch block
public class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);
    }
}
