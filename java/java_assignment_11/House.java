import java.util.*;

public class House {
    private Room currentRoom;
    private Scanner sc;
    public House(Room startingRoom){
        this.currentRoom = startingRoom;
        this.sc = new Scanner(System.in);
    }
    public void explore(){
        displayCurrentRoom();
        boolean finished = false;
        while(!finished){
            System.out.print("\nEnter a command: ");
            String command = sc.nextLine().toLowerCase();
            String[] commandLine = command.trim().split(" ");
            System.out.println(Arrays.toString(commandLine));
            switch(commandLine[0]){
                case "move":
                    if(commandLine.length == 2){
                        try{
                            if(!currentRoom.getDirections().containsKey(commandLine[1])){
                                throw new InvalidDirectionException(commandLine[1]);
                            }else{
                                currentRoom = currentRoom.getDirections().get(commandLine[1]);
                                displayCurrentRoom();
                            }
                        }catch(InvalidDirectionException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    }else{
                        System.out.println("State a direction to move to.");
                    }
                    break;
                case "interact":
                    if(commandLine.length == 2){
                        try{
                            Optional<Entity> entity = currentRoom.getObjectsInRoom().stream().filter(
                                    e -> e.getName().equalsIgnoreCase(commandLine[1])).findFirst();
                            if(entity.isPresent()){
                                Entity e = entity.get();
                                System.out.println("You check the " + commandLine[1] + ". " + e.interact());
                            }else{
                                throw new EntityNotFoundException(commandLine[1]);
                            }
                        }catch(EntityNotFoundException e){
                            System.out.println(e.getMessage());
                        }
                    }else{
                        System.out.println("State an entity to interact with.");
                    }
                    break;
                case "look":
                    displayCurrentRoom();
                    break;
                case "quit", "exit":
                    System.out.println("Thanks for visiting! Goodbye.");
                    sc.close();
                    finished = true;
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
                    break;
            }
        }

    }

    public void displayCurrentRoom(){
        System.out.println("You are in the " + currentRoom.getName() + ".");
        System.out.println(currentRoom.getDescription());
        System.out.println("Interactable Entities: " + currentRoom.getObjectNames());
    }

    public static void main(){
        String foyerDesc = "A small entryway with a coat rack and a stairway leading up, and a kitchen to the east.";
        String kitchenDesc = "A bright kitchen with the smell of fresh coffee. The foyer is to the west.";
        String upstairsDesc = "A hallway upstairs. There is a stairway leading down, and a room to the north.";
        String bedroomDesc = "A small bedroom, with a desk and a bed. The hallway remains to the south.";
        // entities list
        List<Entity> foyerEntities = new ArrayList<>();
        List<Entity> kitchenEntities = new ArrayList<>();
        List<Entity> upstairsEntities = new ArrayList<>();
        List<Entity> bedroomEntities = new ArrayList<>();
        // foyer entities
        Entity CoatRack = new Entity("CoatRack", "There's an old raincoat hanging on it.");
        foyerEntities.add(CoatRack);
        // kitchen entities
        Entity CoffeeMaker = new Entity("CoffeeMaker", "Still contains lukewarm coffee.");
        Entity Refrigerator = new Entity("Refrigerator", "Cold air keeps the meat and veggies fresh.");
        kitchenEntities.add(Refrigerator);
        kitchenEntities.add(CoffeeMaker);
        // upstairs entities
        Entity Lamp = new Entity("Lamp","The lamp flickers its light ever so slightly.");
        upstairsEntities.add(Lamp);
        // bedroom entities
        Entity Bed = new Entity("Bed","The blankets and sheets are strewn across the bed.");
        Entity Desk = new Entity("Desk", "A desk containing a stationary and some pens.");
        bedroomEntities.add(Desk);
        bedroomEntities.add(Bed);

        Map<String, Room> foyerDirections = new HashMap<>();
        Map<String, Room> kitchenDirections = new HashMap<>();
        Map<String, Room> upstairsDirections = new HashMap<>();
        Map<String, Room> bedroomDirections = new HashMap<>();

        Room foyer = new Room("Foyer", foyerDesc, foyerDirections,foyerEntities);
        Room kitchen = new Room("Kitchen", kitchenDesc, kitchenDirections,kitchenEntities);
        Room upstairs = new Room("Hallway", upstairsDesc, upstairsDirections,upstairsEntities);
        Room bedroom = new Room("BedRoom", bedroomDesc, bedroomDirections,bedroomEntities);
        foyerDirections.put("east",kitchen); // in foyer, the east contains the kitchen
        foyerDirections.put("up",upstairs);
        kitchenDirections.put("west",foyer); // in kitchen, the west contains the foyer
        upstairsDirections.put("down",foyer);
        upstairsDirections.put("north",bedroom);
        bedroomDirections.put("south",upstairs);

        House house = new House(foyer);
        house.explore();
    }
}
