public class Entity {
    private final String name;
    private final String description;
    private final String interaction;

    public Entity(String name, String description, String interaction) {

        this.name = name;
        this.description = description;
        this.interaction = interaction;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String interact() {
        return interaction;
    }
    
}
