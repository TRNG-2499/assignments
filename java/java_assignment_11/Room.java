package java_assignment_11;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Room {

    private String name;
    private Map<String, Room> exits;
    private List<Entity> entities;

    public Room(String name) {
        this.name = name;
        this.exits = new HashMap<>();
        this.entities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();

    public void addExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public Room move(String direction) throws InvalidDirectionException {
        Room nextRoom = exits.get(direction.toLowerCase());

        if (nextRoom == null) {
            throw new InvalidDirectionException(
                "There is no exit to the " + direction + " from here."
            );
        }

        return nextRoom;
    }

    public Entity findEntity(String entityName)
            throws EntityNotFoundException {

        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }

        throw new EntityNotFoundException(
            "There is no '" + entityName + "' here to interact with."
        );
    }

    public void display() {
        System.out.println("\nYou are in the " + name + ".");
        System.out.println(getDescription());

        System.out.print("Interactable entities: ");

        if (entities.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < entities.size(); i++) {
                System.out.print(entities.get(i).getName());

                if (i < entities.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }
    }
}
