public class Entity {
    private final String name;
    private final String description;
    private final String interactResponse;

    public Entity (String name, String description, String interactResponse){
        this.name = name;
        this.description = description;
        this.interactResponse = interactResponse;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String interact() {
        return interactResponse;
    }
    
}
