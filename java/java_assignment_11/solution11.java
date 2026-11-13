import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.Map;
public class solution11 {
    public static void main(String[] args) {
        Entity book = new Entity("Book", "This is a book", "You read a page of the book.");
        Entity apple = new Entity("Apple", "This is an apple", "You took a bite of the apple.");
        Entity waterBottle = new Entity("Water Bottle", "This is a water bottle", "You took a sip from the water bottle.");
        Entity bed = new Entity("Bed", "A comfy bed", "You took a nap on the bed.");

        Room r1 = new Room("r1", "There is an exit north and east", new ArrayList<Entity>(List.of(book)));
        Room r2 = new Room("r2", "There is an exit east and south", new ArrayList<Entity>(List.of(apple)));
        Room r3 = new Room("r3", "There is an exit south and west", new ArrayList<Entity>(List.of(waterBottle)));
        Room r4 = new Room("r4", "There is an exit west and north", new ArrayList<Entity>(List.of(bed)));

        r1.addExit("north", r2);
        r1.addExit("east", r4);
        r2.addExit("east", r3);
        r2.addExit("south", r1);
        r3.addExit("south", r4);
        r3.addExit("west", r2);
        r4.addExit("west", r1);
        r4.addExit("north", r3);

        Room currRoom = r1;
        Scanner input = new Scanner(System.in);
        printAllDescription(currRoom);
        while(true){
            System.out.print("Enter a command: ");
            String command = input.nextLine().toLowerCase();
            String [] commandWords = command.split(" ");

            switch(commandWords[0]){
                case("look"):
                    printAllDescription(currRoom);
                    break;
                case("interact"):
                    if(commandWords.length == 2){
                        try{
                            interact(currRoom.getEntities(), commandWords[1]);
                        }
                        catch(EntityNotFoundException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                        System.out.println("Invalid command");
                    break;
                case("move"):
                    if(commandWords.length == 2){
                        try{
                            currRoom = move(currRoom.getExits(), commandWords[1]);
                            printAllDescription(currRoom);
                        }
                        catch(InvalidDirectionException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                        System.out.println("Invalid command");
                    break;
                case("exit"):
                    System.out.println("Thanks for visiting! Goodbye.");
                    return;
                case("quit"):
                    System.out.println("Thanks for visiting! Goodbye.");
                    return;
                default:
                    System.out.println("Invalid Command");
            }
        }
    }

    public static void interact(List <Entity> entities, String name) throws EntityNotFoundException{
        for(Entity e : entities){
            if(e.getName().toLowerCase().equals(name)){
                System.out.println(e.interact());
                return;
            }
        }
        throw new EntityNotFoundException("There is no " + name + " here to interact with.");
    }
    public static Room move(Map<String, Room> exits, String direction) throws InvalidDirectionException{
        if(exits.containsKey(direction))
            return exits.get(direction);
        else
            throw new InvalidDirectionException("There is no exit to the " + direction + " here.");
    }
    public static void printAllDescription(Room r){
        List <Entity> currEntities = r.getEntities();
        StringJoiner entityListStr = new StringJoiner(", ");
        for(Entity e : currEntities)
            entityListStr.add(e.getName());

        System.out.printf("You are in %s.\n%s\nInteractable entities: %s\n", r.getName(), r.getDescription(), entityListStr.toString());
    }
}   
