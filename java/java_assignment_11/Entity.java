import java.io.*;
import java.util.*;

public class Entity {
    private String name;
    protected String description;

    public Entity(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String interact() {
        return String.format("You touched %s", this.name);
    }
}
