public class Entity {
    public final String name;
    public final String description;
    private final String interactionResponse;

    public Entity(String name, String desc, String interaction) {
        this.name = name;
        this.description = desc;
        this.interactionResponse = interaction;
    }

    public String interact() {
        return interactionResponse;
    }
}
