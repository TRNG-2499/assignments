import java.util.Set;

public class OpenRoom extends Room{
    public OpenRoom(Set<Entity> entities, String name, String description) {
        super(entities, name, description);
    }

    @Override 
    public Set<Entity> getEntities() {
        return entities;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
