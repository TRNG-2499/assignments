package java_assignment_11;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;

    private Map<String, Room> exits;
    private Map<String, Entity> entities;


    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.entities = new HashMap<>();
    }

    public void addExit(String direction, Room room) {
        this.exits.put(direction.toLowerCase().trim(), room);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        direction = direction.toLowerCase().trim();

        if (!this.exits.containsKey(direction)) {
            throw new InvalidDirectionException(
                "There is no exit to the " + direction.toLowerCase() + " from here."
            );
        }

        return this.exits.get(direction);
    }

    public void addEntity(Entity entity) {
        this.entities.put(entity.getName().toLowerCase(), entity);
    }

    public Entity getEntity(String entityName) throws EntityNotFoundException {
        entityName = entityName.toLowerCase().trim();

        if (!this.entities.containsKey(entityName)) {
            throw new EntityNotFoundException(
                "There is no '" + entityName + "' here to interact with."
            );
        }

        return this.entities.get(entityName);
    }

    public void displayRoom() {
        System.out.println("\nYou are in the " + this.name + ".");
        System.out.println(this.description);
        System.out.println("Interactable entities:");
        for (Entity entity : this.entities.values()) {
            System.out.println("- " + entity.getName());
        }

    }

    public String getName() {
        return this.name;
    }
    // public String setName(String name) {
    //     this.name = name;
    //     return this.name;
    // }

    public String getDescription() {
        return this.description;
    }
    // public String setDescription(String description) {
    //     this.description = description;
    //     return this.description;
    // }

}
