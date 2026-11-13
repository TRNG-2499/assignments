package com.revature;

// stretch goal 1
public class ItemNotTakeableException extends Exception {
    public ItemNotTakeableException(String entityName) {
        super("The " + entityName + " is too big to take with you");
    }
}
