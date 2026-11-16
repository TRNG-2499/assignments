import java.io.*;
import java.util.*;

public class Bedroom extends Room {
    public Bedroom(Room from, String exitDirection){
        super(from, exitDirection);
    }

    @Override 
    public String name(){
        return "Bedroom";
    }

    @Override 
    public String description(){
        return "This is your bedroom where you can sleep";
    }

    @Override
    protected Entity[] initEntities(){
        return new Entity[]{};
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
