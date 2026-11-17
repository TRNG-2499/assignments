package HomeTour;
//submitted unfinished code because deadline was close, and I'm stuck.

public class Room{

    private String name;
    private String description;
    private Room[] directionExit;
    private Entity[] objectsInRoom;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Room[] getExits() {
        return directionExit;
    }
    public Entity[] getEntities() {
        return objectsInRoom;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.name = description;
    }
    public void setExits(Room[] directionExit) {
        this.directionExit = directionExit;
    }
    public void setObjects(Entity[] objectsInRoom) {
        this.objectsInRoom = objectsInRoom;
    }
    public String interact(){

        return null;
    }

}
