package assignments.java.java_assignment_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import assignments.java.java_assignment_11.Exceptions.EntityNotFoundException;
import assignments.java.java_assignment_11.Exceptions.InvalidDirectionException;
import lombok.Getter;
import lombok.Setter;

public class Room {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;

    private static String[] directions = { "north", "south", "east", "west", "up", "down" };

    private HashMap<String, Room> exits = new HashMap<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private void validDirection(String direction) throws InvalidDirectionException {
        if (direction == null || !Arrays.asList(directions).contains(direction.toLowerCase())) {
            throw new InvalidDirectionException(
                    direction,
                    InvalidDirectionException.Reason.INVALID);
        }
    }

    public void addExit(String direction, Room room) throws InvalidDirectionException {
        validDirection(direction);
        direction = direction.toLowerCase();
        if (room == null) {
            throw new IllegalArgumentException("Exit destination cannot be null.");
        }
        if (exits.containsKey(direction)) {
            throw new InvalidDirectionException(
                    direction,
                    InvalidDirectionException.Reason.OCCUPIED);
        }
        exits.put(direction, room);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        validDirection(direction);
        direction = direction.toLowerCase();
        if (!exits.containsKey(direction)) {
            throw new InvalidDirectionException(
                    direction,
                    InvalidDirectionException.Reason.NO_EXIT);
        }
        return exits.get(direction);
    }

    public void addEntity(Entity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null.");
        }

        for (Entity existing : entities) {
            if (existing.getName().equalsIgnoreCase(entity.getName())) {
                throw new IllegalArgumentException(
                        "Entity '" + entity.getName() + "' already exists in this room.");
            }
        }
        entities.add(entity);
    }

    private Entity getEntity(String name) throws EntityNotFoundException {
        if (name != null) {
            for (Entity entity : entities) {
                if (entity.getName().equalsIgnoreCase(name))
                    return entity;
            }
        }
        throw new EntityNotFoundException(name);
    }

    public void interactEntity(String name) throws EntityNotFoundException {
        Entity entity = getEntity(name);
        System.out.println(entity.getName() + " : " + entity.getDescription());
        System.out.println(entity.interact());
    }

    public void getDisplay() {
        System.out.printf("""
                Room Name: %s
                Room Description: %s
                Room Entities:
                """, name, description);
        if (entities.isEmpty()) {
            System.out.println("None");
            return;
        }
        for (Entity entity : entities) {
            System.out.println(entity.getName());
        }
        displayExits();
    }

    public void displayExits() {
        System.out.println("Available exits:");
        if (exits.isEmpty()) {
            System.out.println("None");
            return;
        }
        for (String direction : exits.keySet()) {
            System.out.println(direction);
        }
    }
}