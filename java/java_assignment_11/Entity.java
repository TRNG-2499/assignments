package java_assignment_11;

public class Entity {
    private String name;
    private String description;
    private String interactionResponse;

    public Entity(String name, String description, String interactionResponse) {
        this.name = name;
        this.description = description;
        this.interactionResponse = interactionResponse;
    } 

    public String getName() {
        return this.name;
    }
    // public String setName(String name) {
    //     this.name = name;
    //     return this.name;
    // }

    public String getDescription() {
        return this.description;
    }
    // public String setDescription(String description) {
    //     this.description = description;
    //     return this.description;
    // }

    public String interact() {
        return this.interactionResponse;
    }
}