package com.revature;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private final String name;
    private final String description;
    // directions are stored lowercase, so "North" and "north" find the same exit
    private final Map<String, Room> exits = new LinkedHashMap<>();
    private final List<Entity> entities = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    // sets the exit on both rooms at once, so a connection can never go only one way
    public void connect(String direction, Room other) {
        exits.put(direction.toLowerCase(), other);
        other.exits.put(opposite(direction), this);
    }

    private static String opposite(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                return "south";
            case "south":
                return "north";
            case "east":
                return "west";
            case "west":
                return "east";
            case "up":
                return "down";
            case "down":
                return "up";
            default:
                // only reached if the house is built with a typo, not from player input
                throw new IllegalArgumentException("Unknown direction: " + direction);
        }
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room next = exits.get(direction.toLowerCase());
        if (next == null) {
            throw new InvalidDirectionException(direction);
        }
        return next;
    }

    public Entity findEntity(String entityName) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }
        throw new EntityNotFoundException(entityName);
    }

    // stretch goal 1
    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void display() {
        System.out.println("You are in the " + name);
        System.out.println(description);

        if (entities.isEmpty()) {
            System.out.println("Interactable entities: none");
            return;
        }
        List<String> names = new ArrayList<>();
        for (Entity entity : entities) {
            names.add(entity.getName());
        }
        System.out.println("Interactable entities: " + String.join(", ", names));
    }
}
