import java.util.List;
import java.util.Map;
import java.util.Set;

public class Room {
    private String name;
    private String description;
    private Set<String> directionalExits;
    private Entity[] entities;
    private Map<String, Integer> directionalExitRoomIndices;

    public Room(String name, String description,
                Set<String> directionalExits,
                Entity[] entities, Map<String, Integer> directionalExitRoomIndices) {
        this.name = name;
        this.description = description;
        this.directionalExits = directionalExits;
        this.entities = entities;
        this.directionalExitRoomIndices = directionalExitRoomIndices;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getDirectionalExits() {
        return this.directionalExits;
    }
    public void setDirectionalExits(Set<String> directionalExits) {
        this.directionalExits = directionalExits;
    }

    public Entity[] getEntities() {
        return entities;
    }
    public void setEntities(Entity[] entities) {
        this.entities = entities;
    }

    public Map<String, Integer> getDirectionalExitRoomIndices() {
        return this.directionalExitRoomIndices;
    }
    public void setDirectionalExitRoomIndices(Map<String, Integer> directionalExitRoomIndices) {
        this.directionalExitRoomIndices = directionalExitRoomIndices;
    }
}
