import java.util.Set;

public class DarkRoom extends Room {
    private boolean light = false;
    private Entity lightSwitch;

    public DarkRoom(Set<Entity> entities, String name, String description, Entity lightSwitch) {
        super(entities, name, description);
        this.lightSwitch = lightSwitch;
    }

    @Override 
    public Set<Entity> getEntities() {
        if (light) {
            return entities;
        } else {
            return Set.of(lightSwitch);
        }
    }

    @Override
    public String getDescription() {
        if (light){
            return description;
        } else {
            return "It's too dark to make anything out but the lightswitch on the wall...";
        }
    }

    public void toggleLight() {
        light = !light;
    }

    
}
