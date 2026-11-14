public class Entity {
    private String name;
    private String description;

    public Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return  name;
    }

    public String interact() {
        return "You check the" + name + "." + description;
    }
}
