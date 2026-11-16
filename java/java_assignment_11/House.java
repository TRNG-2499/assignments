package assignments.java.java_assignment_11;

import assignments.java.java_assignment_11.Exceptions.InvalidDirectionException;
import lombok.Getter;

public class House {

    @Getter
    private Room startingRoom;

    public House() throws InvalidDirectionException {
        createHouse();
    }

    private void createHouse() throws InvalidDirectionException {

        Room masterBedroom = new Room(
                "Master Bedroom",
                "A large room with a king size bed.");

        Room kitchen = new Room(
                "Kitchen",
                "Someone forgot to do the dishes.");

        Room livingRoom = new Room(
                "Living Room",
                "It has 3 couches in it, who needs that many couches.");

        Room bedroom = new Room(
                "Bedroom",
                "A twin sized bed, easy to roll out of.");

        Room diningRoom = new Room(
                "Dining Room",
                "A spacious dining room with a large wooden table.");

        livingRoom.addExit("north", kitchen);
        kitchen.addExit("south", livingRoom);

        livingRoom.addExit("east", masterBedroom);
        masterBedroom.addExit("west", livingRoom);

        livingRoom.addExit("west", diningRoom);
        diningRoom.addExit("east", livingRoom);

        livingRoom.addExit("up", bedroom);
        bedroom.addExit("down", livingRoom);

        masterBedroom.addEntity(new Entity(
                "Bed",
                "A king size bed, probably takes up half the room.",
                "You lay down, this is actually pretty comfortable."));

        kitchen.addEntity(new Entity(
                "CoffeeMaker",
                "An old coffee maker, looks like it has seen better days.",
                "You make some coffee, tastes like it was made yesterday."));

        kitchen.addEntity(new Entity(
                "Refrigerator",
                "A fridge that probably needs cleaned out.",
                "You open it, something in there smells terrible."));

        livingRoom.addEntity(new Entity(
                "Television",
                "A large TV, probably the most expensive thing in the house.",
                "You turn it on, nothing good is playing."));

        livingRoom.addEntity(new Entity(
                "Couch",
                "One of the three couches in here, no idea why there are so many.",
                "You sit down, at least this one is comfortable."));

        bedroom.addEntity(new Entity(
                "Bed",
                "A twin size bed, barely enough room to sleep.",
                "You lay down and almost roll off the side."));

        diningRoom.addEntity(new Entity(
                "DiningTable",
                "A big wooden table, nobody ever eats here.",
                "You sit down, the chair makes a concerning noise."));

        startingRoom = kitchen;
    }
}