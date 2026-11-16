package java_assignment_11;


public class Entity {

    private String name;
    private String description;
    private String response;

    public Entity(String name, String description, String response) {
        this.name = name;
        this.description = description;
        this.response = response;
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
}

