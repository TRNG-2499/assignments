import java.io.*;
import java.util.*;

public class Kitchen extends Room {
    
    public Kitchen(Room from, String exitDirection){
        super(from, exitDirection);
    }

    @Override 
    public String name(){
        return "Kitchen";
    }

    @Override 
    public String description(){
        return "This is the kitchen where you can cook";
    }

    @Override
    public Entity[] initEntities(){
        return new Entity[] {
            new Entity("Stove", "This is where you can cook your meals"),
            new Entity("Table", "This is where you can eat your meals")
        };
    }

    @Override 
    public Room initNorthRoom(){
        return null;
    }

    @Override 
    public Room initSouthRoom(){
        return null;
    }

    @Override 
    public Room initEastRoom(){
        return null;
    }

    @Override
    public Room initWestRoom(){
        return null;
    }

    @Override
    public Room initUpRoom(){
        return null;
    }

    @Override
    public Room initDownRoom(){
        return null;
    }
}
