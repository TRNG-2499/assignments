package com.revature;

public class Entity {
    private final String name;
    private final String description;
    private final String interactResponse;
    // stretch goal 1
    // large furniture is false, so it stays in its room
    private final boolean takeable;

    public Entity(String name, String description, String interactResponse, boolean takeable) {
        this.name = name;
        this.description = description;
        this.interactResponse = interactResponse;
        this.takeable = takeable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String interact() {
        return interactResponse;
    }

    // stretch goal 1
    public boolean isTakeable() {
        return takeable;
    }
}
