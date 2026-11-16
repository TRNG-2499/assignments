import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

enum Direction {
        NORTH, WEST, EAST, SOUTH, UP, DOWN;

        public Direction inverse() {
            return switch (this) {
                case NORTH -> SOUTH;
                case SOUTH -> NORTH;
                case EAST -> WEST;
                case WEST -> EAST;
                case UP -> DOWN;
                case DOWN -> UP;
            };
        }
    }

public abstract class Room {
    protected Set<Entity> entities = new HashSet<>();
    protected String name;
    protected String description;
    private final Map<Direction, Room> exits = new EnumMap<>(Direction.class);
    private final Map<String, Entity> nameToEntity = new HashMap<>();

    public Room(Set<Entity> entities, String name, String description) {
        this.entities = new HashSet<>(entities);
        this.name = name;
        this.description = description;

        for (Entity e : entities) {
            nameToEntity.put(e.getName().toLowerCase(),e);
        }
    }

    public Entity getEntityByName(String name) {
        if (name == null) return null;
        for (Entity e : getEntities()) {
            if (e.getName().equalsIgnoreCase(name.trim())) {
                return e;
            }
        }
        return null;
    }

    public abstract String getDescription();
    public abstract Set<Entity> getEntities();

    public void addEntity(Entity entity) {
        entities.add(entity);
        nameToEntity.put(entity.getName().toLowerCase(), entity);
    }

    public void takeEntity(Entity entity) {
        if (entities.contains(entity)) {
            entities.remove(entity);
            nameToEntity.remove(entity.getName().toLowerCase());
        }
    }

    public String getName() {
        return name;
    }

    public Room getExit(Direction dir) {
        return exits.get(dir);
    }

    public void connect(Direction dir, Room other) {
        exits.put(dir, other);
        other.exits.put(dir.inverse(), this);
    }
}
