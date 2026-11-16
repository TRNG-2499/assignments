import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rooms {
  private final String name;
  private final String description;
  private final Map<String, Rooms> exits;
  private final List<Entities> entities;

  public Rooms(String name, String description) {
    this.name = name;
    this.description = description;
    exits = new HashMap<>();
    entities = new ArrayList<>();
  }
    public String getName() {
        return name;
    }
    public void addExit(String direction, Rooms room) {
        exits.put(direction.toLowerCase(), room);
    }
    public void addEntity(Entities entity) {
        entities.add(entity);
    }

    //exception handling for invalid direction
    public Rooms getExit(String direction) throws InvalidDirectionException {
    Rooms nextRoom = exits.get(direction.toLowerCase());

    if (nextRoom == null) {
      throw new InvalidDirectionException(
        "There is no exit to the " + direction + " from here."
      );
    }
    return nextRoom;
  }

  //exception handling for entity not found
  public Entities getEntity(String entityName) throws EntityNotFoundException {
    for (Entities entity : entities) {
      if (entity.getName().equalsIgnoreCase(entityName)) {
        return entity;
      }
    }
    throw new EntityNotFoundException(
        "There is no '" + entityName + "' here to interact with."
    );
  }

  //display current room information
  public void displayRoom() {
    System.out.println("\nYou are in the " + name + ".");
    System.out.println(description);
    System.out.print("Interactable entities: ");

    for (Entities entity : entities) {
        System.out.print(entity.getName() + " ");
    }
    System.out.println();
  }
}
