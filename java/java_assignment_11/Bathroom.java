import java.io.*;
import java.util.*;

public class Bathroom extends Room {
    public Bathroom(Room from, String exitDirection){
        super(from, exitDirection);
    }

    @Override
    public String name(){
        return "Bathroom";
    }

    @Override
    public String description(){
        return "This is the bathroom with a sink";
    }
    
    @Override
    protected Entity[] initEntities(){
        return new Entity[] {};
    }

    @Override
    protected Room initNorthRoom(){
        return null;
    }

    @Override
    protected Room initSouthRoom(){
        return null;
    }

    @Override
    protected Room initEastRoom(){
        return null;
    }

    @Override
    protected Room initWestRoom(){
        return null;
    }

    @Override 
    protected Room initUpRoom(){
        return null;
    }

    @Override
    protected Room initDownRoom(){
        return null;
    }
}
