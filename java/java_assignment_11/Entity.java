public class Entity {
    
    private String name;
    private String description;
    private String response;
    
    public Entity(String name, String description, String response){
        
        if(name == null || name.isBlank() || name.contains(" ")){
            throw new IllegalArgumentException("Entity must have a name and be a single word");
        }
        this.name = name;
        this.description = description;
        this.response = response;
    }

    String getName(){return name;}
    String getDescription(){return description;}
    String getResponse(){return response;}
}
