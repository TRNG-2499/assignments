import java.util.Scanner;
public class Entity {
    private String name;
    private String description;
    private String interact;

    public Entity(String name, String description, String interact){
        this.name = name;
        this.description = description;
        this.interact = interact;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){ 
        return description;
    }

    public String getInteract(){
        return interact;
    }

}
