import java.util.*;

public class Room {
    public enum Exit { NORTH, EAST, SOUTH, WEST, UP, DOWN }

    public final String name;
    public final String description;
    public final Map<Exit, Room> exits;
    public final List<Entity> entities = new ArrayList<>();

    public Room(String name, String description, Map<Exit, Room> exits, Entity... entities) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>(exits);
        this.entities.addAll(Arrays.asList(entities));
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Exit exit;
        try {
            exit = Exit.valueOf(direction.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidDirectionException("'" + direction + "' is not a valid direction.");
        }

        Room destination = exits.get(exit);
        if (destination == null)
            throw new InvalidDirectionException(
                    "There is no exit to the " + exit.name().toLowerCase() + " from here.");
        return destination;
    }

    public Entity findEntity(String entityName) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.name.equalsIgnoreCase(entityName))
                return entity;
        }
        throw new EntityNotFoundException("There is no '" + entityName + "' here to interact with.");
    }
}
