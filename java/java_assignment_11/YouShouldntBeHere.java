package assignments.java.java_assignment_11;

import java.util.HashMap;
import java.util.Scanner;

public class YouShouldntBeHere {

    static Room currentRoom;

    public static void main(String[] args) {
        HashMap<String, Room> tempExits1 = new HashMap<>();
        HashMap<String, Room> tempExits2 = new HashMap<>();
        HashMap<String, Room> tempExits3 = new HashMap<>();
        HashMap<String, Room> tempExits4 = new HashMap<>();

        String foyerDesc = "A small dilapidated entryway. There are worn down stairways on one side, and on the other side a messy table stands beside a closet door.";
        String stairsDesc = "A pile of broken wooden beams and dry wall blocks the way up. A big hole in the ceiling stands above it.";
        Entity stairs = new Entity("Stairs", stairsDesc);
        String entryTableDesc = "An old lamp covered in cobwebs sits in the middle. It is surrounded by random miscellaneous objects, such as rusty keys, moth eaten gloves and hats, and a broken flashlight, all covered in a thick layer of cobwebs.";
        Entity entryTable = new Entity("EntryTable", entryTableDesc);
        Entity[] foyerEntities = {stairs, entryTable};
        Room foyer = new Room("Foyer", foyerDesc, tempExits1, foyerEntities);
        
        String hallwayDesc = "A narrow hallway covered in black mold that is more prevalent on its south side. It contains two doors, one to the north and one to the south.";
        String southDoorDesc = "Roaches scatter out before the door is even halfway open. Inside is an old, foul smelling bathroom; the toilet is almost overflowing, the sink is dripping, and the black mold is twice as abundant as it was out in the hallway.";
        Entity southDoor = new Entity("SouthDoor", southDoorDesc);
        String northDoorDesc = "The handle is loose and does nothing when turned, it's completely useless.";
        Entity northDoor = new Entity("NorthDoor", northDoorDesc);
        Entity[] hallwayEntities = {southDoor, northDoor};
        Room mainHallway = new Room("Main Hallway", hallwayDesc, tempExits2, hallwayEntities);
        
        String livingRoomDesc = "A big furnished room with high ceilings. A ceiling fan sits at the top, a massive grand piano in the corner, and a reading chair with two couches in the middle.";
        String pianoDesc = "The grand piano is covered in a thick layer of dust and is cold to the touch. The keys struggle to move when pressed, it clearly hasn't been played in ages.";
        Entity piano = new Entity("Piano", pianoDesc);
        String readingChairDesc = "The reading chair is well used and oddly warm.";
        Entity readingChair = new Entity("ReadingChair", readingChairDesc);
        String couchDesc = "The couches are made of dark leather and are dusty except for one spot. Siting on the side of one of the couches, where the dust is almost non-existent, is what appears to be a man; do NOT bother him.";
        Entity couches = new Entity("Couches", couchDesc);
        Entity[] livingRoomEntities = {piano, readingChair, couches};
        Room livingRoom = new Room("Living Room", livingRoomDesc, tempExits3, livingRoomEntities);
        
        String kitchenDiningRoomDesc = "A long room, one half is a kitchen and the other is a simple dining room. The sound of roaches break the silence. Black mold covers the wall and grows on the rows of cabinets. The countertops are dusty, and have random jars and kitchenware covered in cobwebs scattered on their surface. A lone, dusty table with chairs sit in the dining half.";
        String cabinetDesc = "Unlike the rest of the room, the cabinets are completely empty. Giant cobwebs with trapped roaches line every inch of the empty space.";
        Entity cabinets = new Entity("Cabinets", cabinetDesc);
        String diningTableDesc = "The table is round and covered in piles of dirty dishes, the roaches love it here. One of the chairs is pushed further away from the table than the others.";
        Entity diningTable = new Entity("DiningTable", diningTableDesc);
        Entity[] kitchenDiningEntities = {cabinets, diningTable};
        Room kitchenDiningRoom = new Room("Kitchen and Dining Room", kitchenDiningRoomDesc, tempExits4, kitchenDiningEntities);
        
        foyer.addExit("west", mainHallway);
        foyer.addExit("south", livingRoom);
        mainHallway.addExit("west", kitchenDiningRoom);
        mainHallway.addExit("east", foyer);
        livingRoom.addExit("north", foyer);
        kitchenDiningRoom.addExit("east", mainHallway);

        currentRoom = foyer;
        inputReader();
    }

    public static void inputReader(){
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean end = false;

        System.out.println("You are in the Foyer.");
        System.out.println(currentRoom.getDescription());
        currentRoom.showEntities();

        while(!end){
            System.out.print("Enter a command: ");
            line = scanner.nextLine();
            end = interact(line);
            System.out.println();
        }
        scanner.close();
    }

    public static boolean interact(String input){
        boolean exit = false;

        String command;
        int space = input.indexOf(' ');
        boolean twoParts = true;
        input = input.toLowerCase();

        if (space > 0) {
            command = input.substring(0, space);
            input = input.substring(space+1, input.length());
        }else {
            command = input;
            twoParts = false;
        }

        switch (command) {
            case "move":
                if (twoParts == false){
                    System.out.println("'move' requires a direction. Please try again.");
                }else if(!(input.equals("north") || input.equals("south") || input.equals("east") || input.equals("west"))){
                    System.out.println("'move' requires a valid direction. Please try again.");
                }else{
                    try {
                        currentRoom = currentRoom.getExit(input);
                        System.out.println("You are in the " + currentRoom.getName() + ".");
                        System.out.println(currentRoom.getDescription());
                        currentRoom.showEntities();
                    } catch (InvalidDirectionException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case "interact":
                if (twoParts == false){
                    System.out.println("'interact' requires an entity. Please try again.");
                }else{
                    try {
                        currentRoom.interactWithEntity(input);
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case "look":
                if (twoParts == true){
                    System.out.println("'look' should be entered with no following words. Please try again.");
                }else {
                    System.out.println(currentRoom.getDescription());
                    currentRoom.showEntities();
                }
                break;
            case "exit", "quit":
                if (twoParts == true){
                    System.out.println("'exit' should be entered with no following words. Please try again.");
                }else {
                    System.out.println("It's too late, you should've never came here.");
                    exit = true;
                }
                break;
            default:
                System.out.println("Unrecognized command: '"+ command +"'");
                break;
        }
        return exit;
    }
}
