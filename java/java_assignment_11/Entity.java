import java.io.*;
import java.util.*;

public class Entity {
    private String name;
    private String description;
    

    public Entity(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String interact(){
        return "";
    }
}
