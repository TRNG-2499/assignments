package java_assignment_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private static final String[] DIRECTIONS = {"north", "south", "east", "west"};

    private final String name;
    private final String description;
    private final Map<String, Room> exits = new LinkedHashMap<>();
    private final List<Entity> entities = new ArrayList<>();

    public Room(String name, String description) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Room name must not be empty.");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Room description must not be empty.");
        }

        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addExit(String direction, Room room) {
        String normalizedDirection = normalizeDirection(direction);
        if (room == null) {
            throw new IllegalArgumentException("Exit room must not be null.");
        }

        String oppositeDirection = oppositeDirection(normalizedDirection);
        Room existingExit = exits.get(normalizedDirection);
        Room existingReturnExit = room.exits.get(oppositeDirection);
        if ((existingExit != null && existingExit != room)
                || (existingReturnExit != null && existingReturnExit != this)) {
            throw new IllegalStateException("A room is already connected in that direction.");
        }

        exits.put(normalizedDirection, room);
        room.exits.put(oppositeDirection, this);
    }

    public Room getExit(String direction) {
        String normalizedDirection = normalizeDirection(direction);
        Room room = exits.get(normalizedDirection);
        if (room == null) {
            throw new InvalidDirectionException(normalizedDirection, name);
        }
        return room;
    }

    public void addEntity(Entity entity) {
        if (entity == null || entity.getName().isEmpty()) {
            throw new IllegalArgumentException("Entity must not be null or have an empty name.");
        }
        for (Entity existing : entities) {
            if (existing.getName().equalsIgnoreCase(entity.getName())) {
                throw new IllegalArgumentException("An entity named '" + entity.getName() + "' is already in this room.");
            }
        }
        entities.add(entity);
    }

    public Entity getEntity(String entityName) {
        if (entityName != null) {
            for (Entity entity : entities) {
                if (entity.getName().equalsIgnoreCase(entityName)) {
                    return entity;
                }
            }
        }
        throw new EntityNotFoundException(entityName, name);
    }

    public List<Entity> getEntities() {
        return Collections.unmodifiableList(entities);
    }

    private String normalizeDirection(String direction) {
        if (direction != null) {
            String normalizedDirection = direction.toLowerCase();
            for (String validDirection : DIRECTIONS) {
                if (validDirection.equals(normalizedDirection)) {
                    return normalizedDirection;
                }
            }
        }
        throw new IllegalArgumentException("Direction must be north, south, east, or west.");
    }

    private String oppositeDirection(String direction) {
        switch (direction) {
            case "north":
                return "south";
            case "south":
                return "north";
            case "east":
                return "west";
            case "west":
                return "east";
            default:
                throw new IllegalArgumentException("Unknown direction: " + direction);
        }
    }
}
