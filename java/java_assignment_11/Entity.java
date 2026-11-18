package java_assignment_11;

public class Entity {
    // Basic properties
    private String name;
    private String description;

    // Constructor
    public Entity(String name, String description){
        this.name = name;
        this.description = description;
    }

    // Getter
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }

    // No setter; properties final upon construction/instantiation

    // Behavior
    public String interact(){
        return description;
    }
}
