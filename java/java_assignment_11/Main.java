import java.util.Scanner;
import java.util.ArrayList;

public class Main {




    public static void main(String[] args){
    //rooms
    Room hallway = new Room("hallway", "Spacious hallway. East: A bedroom. North: Another bedroom. West: A closet.");
    Entity coatrack = new Entity("coatrack", "A coatrack with some coats.", "You inspect the coats, not your taste.");

    hallway.addEntity(coatrack);

    Room bedroom1 = new Room("bedroom1", "Messy, decorated with lots of items. West: The hallway.");
    Entity computer = new Entity("computer", "Gaming PC", "Currently downloading something.");
    Entity chips = new Entity("chips","A half-empty bag of chips.","You take a bite. Yum!");

    bedroom1.addEntity(computer);
    bedroom1.addEntity(chips);


    Room bedroom2 = new Room("bedroom2", "Super clean, seems to be a workspace. South: The hallway.");
    Entity documents = new Entity("documents", "A pile of papers", "You take a look, but you decide you'll work at it later.");
    Entity calculator = new Entity("calculator","A graphing calculator.","It's out of batteries!");
    
    bedroom2.addEntity(documents);
    bedroom2.addEntity(calculator);


    Room closet = new Room("closet", "Cleaning supplies. East: The hallway");
    Entity mop = new Entity("mop","A dusty old mop.","You should really use this more.");
    Entity monster = new Entity("monster", "It's not doing anything.", "Let's leave it alone.");
    
    closet.addEntity(mop);
    closet.addEntity(monster);

    //connections
    hallway.addExit("east", bedroom1);
    bedroom1.addExit("west", hallway);

    hallway.addExit("north", bedroom2);
    bedroom2.addExit("south", hallway);

    hallway.addExit("west", closet);
    closet.addExit("east", hallway);

    Scanner myObj = new Scanner(System.in);
    String input = "";
    
    boolean run = true;

    Room current_room = hallway; //Current room

    while(run){

        System.out.println("You are currently in: " + current_room.getName());

        input = myObj.nextLine();
        input = input.toLowerCase();

        if(input.equals("quit") || input.equals("exit")){
            break;
        }

        else if(input.equals("look")){

            System.out.println(current_room.getName());
            System.out.println(current_room.getDescription());
            
            System.out.println("In here there are...");

            for (Entity entity : current_room.getEntities()) {
                System.out.print(entity.getName() + " ");
            }

            System.out.println();
        }
        else if(input.split(" ").length == 2){

            String cmd  = input.split(" ")[0].toLowerCase();
            String var = input.split(" ")[1].toLowerCase();

            try{
                switch(cmd){
                    case("move"):
                        current_room = current_room.getExit(var);
                        System.out.println(String.format("Current room: %s", current_room.getName()));
                        System.out.println(current_room.getDescription());

                        System.out.println("In here there are...");
                        for (Entity entity : current_room.getEntities()) {
                            System.out.print(entity.getName() + " ");
                        }

                        System.out.println();

                        break;
                    case("interact"):
                        System.out.println(current_room.getEntity(var).interact());
                        break;

                    default:
                        System.out.println("Invalid command");
                        break;
                }
                
            }
            catch (InvalidDirectionException e){
                System.out.println("Error: " + e.getMessage());
            }
            catch (EntityNotFoundException e){
                System.out.println("Error: " + e.getMessage());
            }
   
        }       
        else{
            System.out.println("Invalid command");
        }

    }


    myObj.close();
    
}
}