import java.util.Scanner;

public class JavaSolution_11 {
    public static void main(String[] args) {
        Room livingRoom = new Room("Living room", "Room with tv and couch");
        Room kitchen = new Room("Kitchen", "Room where the cooking is done");
        Room foyer = new Room("Foyer", "Small entry way with a staircase upstairs.");
        Room attic = new Room("Attic", "Large space filled with lots of dusty items!");

        Entity Oven = new Entity("Oven", "The smell of dinner cooking leaks from the oven.");
        Entity Pot = new Entity("Pot", "Water starts to bubble up out of the pot.");
        kitchen.addEntity(Oven);
        kitchen.addEntity(Pot);
        
        Entity TV = new Entity("TV", "The news is playing, spreading light across the room.");
        Entity Couch = new Entity("Couch", "You take a seat and sink into the old couch.");
        livingRoom.addEntity(TV);
        livingRoom.addEntity(Couch);

        Entity Shoes = new Entity("Shoes", "You pick up the beat up Nikes. Yuck! They stink!");
        Entity PictureFrame = new Entity("Picture Frame", "You look at the old photo.");
        foyer.addEntity(PictureFrame);
        foyer.addEntity(Shoes);

        Entity DustyMirror = new Entity("Dusty Mirror", "You observe what little you can see of yourself in the dusty mirror. Achooo!");
        Entity OldChest = new Entity("Old Chest", "You open the chest and find the Fortnite Pirate Coin!");
        attic.addEntity(OldChest);
        attic.addEntity(DustyMirror);
        
        kitchen.addExit("North", livingRoom);
        kitchen.addExit("East", foyer);

        foyer.addExit("Up", attic);
        foyer.addExit("West", livingRoom);

        homeTour(foyer);
        
    }

    public static void homeTour(Room start){
        Scanner userIn = new Scanner(System.in);

        Room current = start;
        System.out.println("You're in the "+current.getName());
        current.look();

        System.out.println("Enter a command: ");
        String input = userIn.nextLine();

        while(!userIn.equals("exit")){
            String[] inputs = input.toLowerCase().split(" ");
            switch(inputs[0]){
                case("move"):
                    try{
                        current = current.move(inputs[1]);
                        System.out.println("You're in the "+current.getName());
                        current.look();
                        break;
                    } catch(InvalidDirectionException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case("look"):
                    System.out.println("You're in the "+current.getName());
                    current.look();
                    break;
                case("interact"):
                    try{
                        current.interact(inputs[1]);
                        break;
                    } catch(EntityNotFoundException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case("exit"):
                    userIn.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid command: "+input);
                
            }
            System.out.println("Enter another command: ");
            input = userIn.nextLine();
        }
    }
}
