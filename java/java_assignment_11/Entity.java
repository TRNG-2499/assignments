public class Entity {
    private String name;
    private String description;
    private boolean takeable;

    public Entity(String name, String description, boolean takeable) {
        this.name = name;
        this.description = description;
        this.takeable = takeable;
    }

    public String getName() {
        return  name;
    }

    public boolean isTakeable() {
        return takeable;
    }

    public String interact() {
        return "You check the" + name + "." + description;
    }
}
