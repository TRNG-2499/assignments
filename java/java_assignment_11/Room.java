public class Room {

    private String name;
    private String description;
    
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private Entity[] entities;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.entities = new Entity[0];
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room room) {
        north = room;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room room) {
        east = room;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room room) {
        south = room;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room room) {
        west = room;
    }

    public Entity[] getEntities() {
        return entities;
    }

    public Entity getEntity(int index) {
        return entities[index];
    }

    public void setEntities(Entity[] entities) {
        this.entities = entities;
    }

    public void setEntity(int index, Entity entity) {
        entities[index] = entity;
    }

    public void addEntity(Entity entity) {
        Entity[] updatedEntities = new Entity[entities.length + 1];
        System.arraycopy(entities, 0, updatedEntities, 0, entities.length);
        updatedEntities[entities.length] = entity;
        entities = updatedEntities;
    }
}
