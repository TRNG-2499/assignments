public class Entity {
    protected String name;
    protected String description;
    protected String response;
    protected boolean canTake;

    public Entity(String name, String description, String response, boolean canTake) {
        this.name = name.toLowerCase();
        this.description = description;
        this.response = response;
        this.canTake = canTake;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String interact() {
        return response;
    }

    public boolean canTake() {
        return canTake;
    }
}
