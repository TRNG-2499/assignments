public class Entity  {
    private String name;
    private String description;
    private String interaction;

    public Entity(String name, String description, String interaction) {
        this.name = name;
        this.description = description;
        this.interaction = interaction;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public String interact() {
        return interaction;
    }
}