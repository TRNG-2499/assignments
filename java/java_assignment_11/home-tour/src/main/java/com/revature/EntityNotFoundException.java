package com.revature;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String entityName) {
        // "here" covers both interact and take, so one message works for both commands
        super("There is no '" + entityName + "' here");
    }
}
