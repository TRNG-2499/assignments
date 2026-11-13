//`Room` class (or class hierarchy) is defined with a name, description, exits, and entities, using either Pattern A or Pattern B
//At least 4 rooms exist and are connected consistently (exits go both ways between connected rooms)
public class room {
    private String name;
    private String description;
    private room north;
    private room south;
    private room east;
    private room west;
    private entity entity;

    public room(String name, String description) {
        this.name = name;
        this.description = description;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
        this.entity = null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public room getNorth() {
        return this.north;
    }

    public void setNorth(room north) {
        this.north = north;
    }

    public room getSouth() {
        return this.south;
    }

    public void setSouth(room south) {
        this.south = south;
    }

    public room getEast() {
        return this.east;
    }

    public void setEast(room east) {
        this.east = east;
    }

    public room getWest() {
        return this.west;
    }

    public void setWest(room west) {
        this.west = west;
    }

    public entity getEntity() {
        return this.entity;
    }

    public void setEntity(entity entity) {
        this.entity = entity;
    }
}
