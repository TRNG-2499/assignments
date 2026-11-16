import java.util.Arrays;

public abstract class Room {

    String roomName;
    String description;
    Room north = null;
    Room east = null;
    Room south = null;
    Room west = null;

    public abstract String getName();
    public abstract String getDescription();
    public abstract Entity[] getEntities();

    public Room getNorth(){
        return this.north;
    }

    public Room getEast(){
        return this.east;
    }

    public Room getSouth(){
        return this.south;
    }

    public Room getWest(){
        return this.west;
    }

    public void setNorth(Room north){
        this.north = north;
    }

    public void setEast(Room east){
        this.east = east;
    }

    public void setSouth(Room south){
        this.south = south;
    }

    public void setWest(Room west){
        this.west = west;
    }

    public void look(){
        System.out.println("You are currently in the " + getName());
        System.out.println(getDescription());
        System.out.println("Interactable Items: " + Arrays.toString(getEntities()));
    }

}
