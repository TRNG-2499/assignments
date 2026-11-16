import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Room{
   private String name;
   private String description;

    Map<String, Room> exit = new HashMap<>();
    List <Entity> entities = new ArrayList<>();

    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

    public void addExit(String direction, Room room){
        exit.put(direction, room);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room next = exit.get(direction);
        if (next == null) {
            throw new InvalidDirectionException("There is no exit to the " + direction + " from here.");
        }
        return next;
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }
    public void getEntities() {
        for (int i = 0; i < entities.size(); i++) {
            System.out.print(entities.get(i).getName());
            if (i < entities.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    public Entity getEntity(String name) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(name)) {
                return entity;
            }
        }
        throw new EntityNotFoundException("There is no '" + name + "' here to interact with.");
    }

    public boolean hasEntities(){
        return !entities.isEmpty();
    }
}