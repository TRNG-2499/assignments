import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Room foyer = new Room("Foyer", "The front door closes behind you. One staircase climbs into the house. Another drops toward the basement.");
        Room upstairs = new Room("Upstairs", "The top of the stairs. The kitchen is to the north. The living room is to the east.");
        Room kitchen = new Room("Kitchen", "A working kitchen. The office is north, the bathroom is east, and the stairs are back south.");
        Room livingRoom = new Room("Living Room", "The living room. A couch faces the television, and the stairs are back to the west.");
        Room office = new Room("Office", "A small office. The bedroom is north, the master bedroom is east, and the kitchen is back south.");
        Room bedroom = new Room("Bedroom", "Your bedroom. The office is back to the south.");
        Room masterBedroom = new Room("Master Bedroom", "The master bedroom. The office is back to the west.");
        Room bathroom = new Room("Bathroom", "A small bathroom. The kitchen is back to the west.");
        Room basement = new Room("Basement", "A dim basement. The garage is east, the boiler room is west, and a locked door blocks the north. The stairs lead back up.");
        Room garage = new Room("Garage", "The garage. The basement door is to the west.");
        Room boilerRoom = new Room("Boiler Room", "A tight boiler room. The basement is back to the east.");

        Entity coatRack = new Entity("CoatRack", "A rack of jackets by the front door.", "You check the coats. Nothing in the pockets but an old receipt.");
        Entity shoeRack = new Entity("ShoeRack", "A shoe rack right next to you.", "You place your shoes in the shoe rack.");
        Entity coffeeMaker = new Entity("CoffeeMaker", "A coffee maker on the counter.", "The pot is half full. The coffee looks used.");
        Entity fridge = new Entity("Fridge", "A full-size fridge.", "You open the fridge. Cold air and leftovers.");
        Entity couch = new Entity("Couch", "A couch facing the television.", "You sit down. It is too comfortable to get back up immediately.");
        Entity television = new Entity("Television", "A television against the wall.", "You turn it on. It is already on the last thing someone was watching.");
        Entity computer = new Entity("Computer", "A computer on the office desk.", "The screen wakes up and asks for a password.");
        Entity bed = new Entity("Bed", "An unmade bed.", "The blankets are still warm.");
        Entity dresser = new Entity("Dresser", "A dresser against the wall.", "The drawers are full of folded clothes. You leave them alone.");
        Entity mirror = new Entity("Mirror", "A mirror above the sink.", "You look in the mirror. You look like someone giving a house tour.");
        Entity lockedDoor = new Entity("LockedDoor", "A heavy door on the north wall. It is locked.", "You try the handle. It does not move.");
        Entity car = new Entity("Car", "A car parked in the garage.", "You look through the window. The keys are not in it.");
        Entity furnace = new Entity("Furnace", "The house furnace.", "It kicks on with a low rumble, then settles.");

        foyer.addEntity(coatRack);
        upstairs.addEntity(shoeRack);
        kitchen.addEntity(coffeeMaker);
        kitchen.addEntity(fridge);
        livingRoom.addEntity(couch);
        livingRoom.addEntity(television);
        office.addEntity(computer);
        bedroom.addEntity(bed);
        masterBedroom.addEntity(dresser);
        bathroom.addEntity(mirror);
        basement.addEntity(lockedDoor);
        garage.addEntity(car);
        boilerRoom.addEntity(furnace);

        foyer.addExit("up", upstairs);
        upstairs.addExit("down", foyer);
        foyer.addExit("down", basement);
        basement.addExit("up", foyer);
        upstairs.addExit("north", kitchen);
        kitchen.addExit("south", upstairs);
        upstairs.addExit("east", livingRoom);
        livingRoom.addExit("west", upstairs);
        kitchen.addExit("north", office);
        office.addExit("south", kitchen);
        kitchen.addExit("east", bathroom);
        bathroom.addExit("west", kitchen);
        office.addExit("north", bedroom);
        bedroom.addExit("south", office);
        office.addExit("east", masterBedroom);
        masterBedroom.addExit("west", office);
        basement.addExit("east", garage);
        garage.addExit("west", basement);
        basement.addExit("west", boilerRoom);
        boilerRoom.addExit("east", basement);

        Room currentRoom = foyer;

        System.out.println("You are in the " + currentRoom.getName());
        System.out.println(currentRoom.getDescription());
        System.out.print("Interactable entities: ");
        currentRoom.getEntities();
        while(true){
            System.out.print("Enter a command: ");
            String userInput = sc.nextLine().trim().toLowerCase();
            String [] command = userInput.trim().split("\\s+");
            try{
                if (command[0].equals("move")) {
                    if (command.length < 2) {
                        System.out.println("Move where? Try: move north");
                    } else {
                        System.out.println();
                        currentRoom = currentRoom.getExit(command[1]);
                        System.out.println("You are in the " + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());
                        System.out.println();
                        if (currentRoom.hasEntities()) {
                            System.out.print("Interactable entities: ");
                            currentRoom.getEntities();
                            System.out.println();
                        }
                    }
                } else if (command[0].equals("interact")) {
                    if (command.length < 2) {
                        System.out.println("Interact with what?");
                    } else {
                        Entity interact = currentRoom.getEntity(command[1]);
                        System.out.println(interact.getInteract());
                    }
                } else if(command[0].equals("look") && command.length == 1){ 
                    System.out.println("You are in the " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                    if(currentRoom.hasEntities()){
                        System.out.print("Interactable entities: ");
                        currentRoom.getEntities();
                    }
                } else if ((command[0].equals("exit") || command[0].equals("quit")) && command.length == 1){
                    System.out.println("Thanks for visiting! Goodbye!");
                    break;
                } else {
                    System.out.println("Error: " + "'" + userInput + "'" + " is not a valid input");
                }
            } catch (InvalidDirectionException | EntityNotFoundException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
