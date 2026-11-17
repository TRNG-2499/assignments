import Exceptions.EntityNotFoundException;
import Exceptions.InvalidDirectionException;

import java.lang.reflect.Array;
import java.util.*;

public class HomeTour {

    // First room is the starting room
    public Map<String, Room> rooms;
    public String[] roomNames;

    public static final List<String> validPrompts = new ArrayList<>(List.of(
            "move",
            "look",
            "interact",
            "exit"
    ));

    public static final List<String> validDirections = new ArrayList<>(List.of(
            "north",
            "south",
            "east",
            "west"
    ));

    static void main() {
        HomeTour instance = new HomeTour();
        instance.setupHouseOne();
        instance.loop();
    }

    public void loop() {
        System.out.println("Welcome to house tour! You are standing in a room.");
        boolean exit = false;
        Scanner userInput = new Scanner(System.in);

        setupHouseOne();
        String currentRoom = "entry";
        System.out.println(this.rooms.get(currentRoom).getDescription());
        System.out.println("Entities: " + getEntityNames(this.rooms.get(currentRoom).getEntities()).toString());

        while (!exit) {
            System.out.println("Available commands: " + validPrompts.toString());
            String nextInput = userInput.nextLine();
            String[] command = nextInput.trim().split("\\s+");
            if (command.length < 1 || !validPrompts.contains(command[0].toLowerCase())) {
                System.out.println("Invalid command. Please re-enter.");
                continue;
            }
            switch(command[0].toLowerCase()) {
                case("move") -> {
                    try {
                        currentRoom = moveToRoom(command, currentRoom);
                        System.out.println(currentRoom);
                        System.out.println(rooms.get(currentRoom).getDescription());
                        System.out.println("Entities: " + getEntityNames(this.rooms.get(currentRoom).getEntities()).toString());
                    } catch (InvalidDirectionException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case("look") -> {
                    System.out.println(rooms.get(currentRoom).getDescription());
                    System.out.println("Entities: " + getEntityNames(this.rooms.get(currentRoom).getEntities()).toString());
                }
                case("interact") -> {
                    try {
                        interactWithObject(command, currentRoom);
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case("exit") -> {
                    exit = true;
                }
            }
        }

        userInput.close();
    }

    public List<String> getEntityNames(Entity[] entities) {
        List<String> entityNames = new ArrayList<>();
        for (Entity e : entities) {
           entityNames.add(e.getName());
        }
        return entityNames;
    }

    public String moveToRoom(String[] command, String currentRoom) throws InvalidDirectionException {
        Room currentRoomObject = this.rooms.get(currentRoom);
        if (command.length < 2
                || !validDirections.contains(command[1].toLowerCase())
                || !currentRoomObject.getDirectionalExits().contains(command[1].toLowerCase())) {
            throw new InvalidDirectionException("Direction to move in is not valid.");
        }

        return this.roomNames[currentRoomObject.getDirectionalExitRoomIndices().get(command[1].toLowerCase())];
    }

    public void interactWithObject(String[] command, String currentRoom) throws EntityNotFoundException {
        if (command.length < 2) {
            throw new EntityNotFoundException("Entity not found in the room.");
        }

        for (Entity e : this.rooms.get(currentRoom).getEntities()) {
            if (e.getName().toLowerCase().equals(command[1].toLowerCase())) {
                System.out.println(e.getInteraction());
                return;
            }
        }
        throw new EntityNotFoundException("Entity not found in the room.");
    }

    /*
     Setup rooms and their entities. Each room gets put into the rooms map,
     where they can be accessed by their name.
     */
    public void setupRooms(
            String[] roomNames, String[] roomDescriptions,
            List<Set> roomExits, List<Entity[]> entities,
            List<Map<String, Integer>> exitRoomIndices) {

        HashMap rooms = new HashMap<>();
        int roomCount = roomNames.length;

        for (int i = 0; i < roomCount; i++) {
            Room newRoom = new Room(
                    roomNames[i],
                    roomDescriptions[i],
                    roomExits.get(i),
                    entities.get(i),
                    exitRoomIndices.get(i)
            );
            rooms.put(roomNames[i], newRoom);
        }
        this.rooms = rooms;
    }

    /*
    Set up the house 1 design.
     */
    public void setupHouseOne() {
        // Names
        String[] roomNames = {
                "entry", "bed", "living", "kitchen"
        };
        this.roomNames = roomNames;

        // Descriptions
        String[] roomDescriptions = {
                "Entry hall of the house. There is a door in front of you and to your left, and the exit behind you.",
                "The bedroom. There is a door behind you.",
                "The living room. There is a door to your left and behind you.",
                "The kitchen. There is a door behind you and an exit door in front of you."
        };

        // Exits
        List<Set> roomExits = new ArrayList<>();
        roomExits.add(Set.of("north", "west"));
        roomExits.add(Set.of("south"));
        roomExits.add(Set.of("west", "south"));
        roomExits.add(Set.of("south", "north"));

        // Exit room indices
        List<Map<String, Integer>> exitRoomIndices = new ArrayList<>();
        exitRoomIndices.add(Map.of("north", 2, "west", 1)); // entry room
        exitRoomIndices.add(Map.of("south", 0)); // bedroom
        exitRoomIndices.add(Map.of("west", 3, "south", 0)); // living room
        exitRoomIndices.add(Map.of("south", 2)); // kitchen room

        // Entities
        List<Entity[]> entities = new ArrayList<>();

        Entity[] entryEntities = new Entity[2];
        entryEntities[0] = (
                new Entity(
                        "Chair",
                        "A chair to sit on.",
                        "You sit on the chair"
                )
        );
        entryEntities[1] = (
                new Entity(
                        "Table",
                        "A table to put things on.",
                        "You knock on the table - it's solid wood."
                )
        );
        entities.add(entryEntities);

        Entity[] bedEntities = new Entity[2];
        bedEntities[0] = (
                new Entity(
                        "Chair",
                        "A chair to sit on.",
                        "You sit on the chair."
                )
        );
        bedEntities[1] = (
                new Entity(
                        "Table",
                        "A table to put things on.",
                        "You knock on the table - it's solid wood."
                )
        );
        entities.add(bedEntities);

        Entity[] livingEntities = new Entity[2];
        livingEntities[0] = (
                new Entity(
                        "Chair",
                        "A chair to sit on.",
                        "You sit on the chair."
                )
        );
        livingEntities[1] = (
                new Entity(
                        "TV",
                        "A TV playing 'Love is Blind'",
                        "You try to change the channel but the remote doesn't work."
                )
        );
        entities.add(livingEntities);

        Entity[] kitchenEntities = new Entity[2];
        kitchenEntities[0] = (
                new Entity(
                        "Chair",
                        "A chair to sit on.",
                        "You sit on the chair."
                )
        );
        kitchenEntities[1] = (
                new Entity(
                        "Kitchen Table",
                        "A table to put things on.",
                        "You knock on the table - it's made of marble."
                )
        );
        entities.add(kitchenEntities);

        setupRooms(roomNames, roomDescriptions, roomExits, entities, exitRoomIndices);
    }
}