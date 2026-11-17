import java.io.*;
import java.util.*;

public abstract class Room {

    private HashMap<String, Entity> entities;

    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;
    private Room upRoom;
    private Room downRoom;


    public Room(Room from, String exitDirection){
        this.entities = new HashMap<>();

        for(Entity e : this.initEntities()){
            this.entities.put(e.getName(), e);
        }

        this.northRoom = initNorthRoom();
        this.southRoom = initSouthRoom();
        this.eastRoom = initEastRoom();
        this.westRoom = initWestRoom();
        this.upRoom = initUpRoom();
        this.downRoom = initDownRoom();

        if(exitDirection.equals("north")){
            this.southRoom = from;
        } else if(exitDirection.equals("south")){
            this.northRoom = from;
        } else if(exitDirection.equals("east")){
            this.westRoom = from;
        } else if(exitDirection.equals("west")){
            this.eastRoom = from;
        } else if(exitDirection.equals("up")){
            this.downRoom = from;
        } else if(exitDirection.equals("down")){
            this.upRoom = from;
        }
    }

    public abstract String name();
    public abstract String description();

    public Entity getEntity(String name) throws EntityNotFoundException {
        Entity e = this.entities.get(name);
        if(e == null){
            throw new EntityNotFoundException(name);
        }

        return e;
    }

    public Iterable<Entity> getEntities(){
        return this.entities.values();
    }

    public Room enter(String direction) throws InvalidDirectionException {
        try {
            return this.enterp(direction);
        } catch(NullPointerException e){
            throw new InvalidDirectionException(direction);
        }
    }

    private Room enterp(String direction) throws InvalidDirectionException {
        if(direction.equals("north")){
            return this.northRoom;
        } else if(direction.equals("south")){
            return this.southRoom;
        } else if(direction.equals("east")){
            return this.eastRoom;
        } else if(direction.equals("west")){
            return this.westRoom;
        } else if(direction.equals("up")){
            return this.upRoom;
        } else if(direction.equals("down")){
            return this.downRoom;
        } else {
            throw new InvalidDirectionException(direction);
        }
    }

    protected abstract Entity[] initEntities();
    protected abstract Room initNorthRoom();
    protected abstract Room initSouthRoom();
    protected abstract Room initEastRoom();
    protected abstract Room initWestRoom();
    protected abstract Room initUpRoom();
    protected abstract Room initDownRoom();
}