public class House {

    private Room livingroom;
    private Room kitchen;
    private Room bathroom;
    private Room bedroom;

    private Room currentRoom;

    public House() {
        livingroom = new Room("Livingroom", "A place people go to live.");
        kitchen = new Room("Kitchen", "A place where food is prepared.");
        bathroom = new Room("Bathroom", "A place for bathing and personal hygiene.");
        bedroom = new Room("Bedroom", "A place for sleeping and resting.");

        livingroom.setNorth(bedroom);
        livingroom.setWest(kitchen);
        bedroom.setWest(bathroom);
        bedroom.setSouth(livingroom);
        bathroom.setEast(bedroom);
        bathroom.setSouth(kitchen);
        kitchen.setNorth(bathroom);
        kitchen.setEast(livingroom);

        Entity toilet = new Entity("Toilet", "It's dirty, you don't want look at it, let alone touch it...");
        kitchen.addEntity(toilet); // on purpose, not an accident.

        currentRoom = livingroom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) throws InvalidDirectionException {
        if (direction == null) {
            throw new InvalidDirectionException("Direction cannot be null.");
        }

        Room nextRoom;
        switch (direction.toLowerCase()) {
            case "north":
                nextRoom = currentRoom.getNorth();
                break;
            case "south":
                nextRoom = currentRoom.getSouth();
                break;
            case "east":
                nextRoom = currentRoom.getEast();
                break;
            case "west":
                nextRoom = currentRoom.getWest();
                break;
            default:
                throw new InvalidDirectionException("Unknown direction: " + direction);
        }

        if (nextRoom == null) {
            throw new InvalidDirectionException("Cannot move " + direction + " from this room.");
        }
        currentRoom = nextRoom;
    }

    public String interact(String entity) throws EntityNotFoundException {
        if (entity != null) { // this could be done with a map in O(1) but I'm too silly.
            for (Entity e : currentRoom.getEntities()) {
                if (e.getName().equalsIgnoreCase(entity)) {
                    return e.getDescription();
                }
            }
        }
        throw new EntityNotFoundException(entity);
    }

    
}
