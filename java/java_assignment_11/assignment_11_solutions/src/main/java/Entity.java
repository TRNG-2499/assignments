public class Entity {
    private String name;
    private String description;
    private String interaction;

    public Entity(String name, String description, String interaction) {
        this.name = name;
        this.description = description;
        this.interaction = interaction;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
