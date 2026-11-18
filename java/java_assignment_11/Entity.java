public class Entity {

    String name;
    String description;
    

    public Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String interact(){
        return description;
    }
}
