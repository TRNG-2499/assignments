import java.util.Set;

public class LockedRoom extends Room {
    private boolean locked = true;
    private DoorEntity door;

    public LockedRoom(Set<Entity> entities, String name, String description, DoorEntity door) {
        super(entities, name, description);
        this.door = door;
    }

    @Override 
    public Set<Entity> getEntities() {
        if (!locked) {
            return entities;
        } else {
            return Set.of(door);
        }
    }

    @Override
    public String getDescription() {
        if (!locked){
            return description;
        } else {
            return "The door to this room is still locked...";
        }
    }

    public void unlock() {
        locked = false;
    }
}
