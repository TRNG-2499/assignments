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


    public Room(){
        this(null, "north");
    }

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

        if(from != null){
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

    public int getEntityCount(){
        return this.entities.size();
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
            if(this.northRoom == null) throw new InvalidDirectionException(direction);
            return this.northRoom;
        } else if(direction.equals("south")){
            if(this.southRoom == null) throw new InvalidDirectionException(direction);
            return this.southRoom;
        } else if(direction.equals("east")){
            if(this.eastRoom == null) throw new InvalidDirectionException(direction);
            return this.eastRoom;
        } else if(direction.equals("west")){
            if(this.westRoom == null) throw new InvalidDirectionException(direction);
            return this.westRoom;
        } else if(direction.equals("up")){
            if(this.upRoom == null) throw new InvalidDirectionException(direction);
            return this.upRoom;
        } else if(direction.equals("down")){
            if(this.downRoom == null) throw new InvalidDirectionException(direction);
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