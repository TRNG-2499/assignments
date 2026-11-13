package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Entity> entities;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
        entities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }
    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }


    public void display() {
        System.out.println("You are currently in the " + name + ".");
        System.out.println(description);
        System.out.print("Interactable entities: ");
        for (int i = 0; i < entities.size(); i++) {
            System.out.print(entities.get(i).getName());
            if (i < entities.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        if (!exits.containsKey(direction)) {
            throw new InvalidDirectionException("There is no exit to the " + direction + " from here.");
        }
        return exits.get(direction);
    }

    public Entity getEntities(String name) throws EntityNotFoundException {
        for (Entity e : entities) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        throw new EntityNotFoundException("There is no '" + name + "' here.");
    }


}