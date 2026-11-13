import java.util.Scanner;

public class homeTour {
    
    public static void main(String[] args) {
        //initalizing starter rooms, they make a 3x2 grid.
        room foyer = new room("Foyer", "The entrance to the house.");
        room livingRoom = new room("Living Room", "The main area for relaxation.");
        room office = new room("Office", "The workspace for work and study.");
        room kitchen = new room("Kitchen", "The area for cooking.");
        room bedroom = new room("Bedroom", "The private area for sleeping.");
        room bathroom = new room("Bathroom", "The area for personal hygiene.");
        foyer.setNorth(livingRoom);
        foyer.setWest(office);
        foyer.setEast(bathroom);
        livingRoom.setSouth(foyer);
        livingRoom.setWest(bedroom);
        livingRoom.setEast(kitchen);
        office.setEast(foyer);  
        office.setNorth(bedroom);
        bedroom.setSouth(office);
        bedroom.setEast(livingRoom);
        kitchen.setWest(livingRoom);
        kitchen.setSouth(bathroom);
        bathroom.setNorth(kitchen);
        bathroom.setWest(foyer);

        //creating starter entities and assigning them to rooms.
        entity coat = new entity("Coat", "A piece of outerwear.", "You put on the coat");
        foyer.setEntity(coat);

        entity laptop = new entity("Laptop", "A portable computer.", "You take the laptop with you.");
        office.setEntity(laptop);

        entity book = new entity("Book", "A reading material.", "You read the book.");
        bedroom.setEntity(book);

        entity toothbrush = new entity("Toothbrush", "A tool for cleaning teeth.", "You use the toothbrush.");
        bathroom.setEntity(toothbrush);

        entity plate = new entity("Plate", "A dish for serving food.", "You use the plate.");
        kitchen.setEntity(plate);

        entity couch = new entity("Couch", "A piece of furniture for sitting.", "You sit on the couch.");
        livingRoom.setEntity(couch);

        //initializing the house tour, starting in the foyer
        room currentRoom = foyer;

        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running){
            displayMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    System.out.println("You are in the " + currentRoom.getName() + ": " + currentRoom.getDescription() + " You can interact with the following entities: " + currentRoom.getEntity().getName());
                    break;
                case 2:
                    if(currentRoom.getNorth() != null){
                        currentRoom = currentRoom.getNorth();
                        System.out.println("You moved to the " + currentRoom.getName() + ": " + currentRoom.getDescription() + " You can interact with the following entities: " + currentRoom.getEntity().getName());
                    } else {
                        System.out.println("You cannot move north.");
                    }
                    break;
                case 3:
                    if(currentRoom.getSouth() != null){
                        currentRoom = currentRoom.getSouth();
                        System.out.println("You moved to the " + currentRoom.getName() + ": " + currentRoom.getDescription() + " You can interact with the following entities: " + currentRoom.getEntity().getName());
                    } else {
                        System.out.println("You cannot move south.");
                    }
                    break;
                case 4:
                    if(currentRoom.getEast() != null){
                        currentRoom = currentRoom.getEast();
                        System.out.println("You moved to the " + currentRoom.getName() + ": " + currentRoom.getDescription() + " You can interact with the following entities: " + currentRoom.getEntity().getName());
                    } else {
                        System.out.println("You cannot move east.");
                    }
                    break;
                case 5:
                    if(currentRoom.getWest() != null){
                        currentRoom = currentRoom.getWest();
                        System.out.println("You moved to the " + currentRoom.getName() + ": " + currentRoom.getDescription() + " You can interact with the following entities: " + currentRoom.getEntity().getName());
                    } else {
                        System.out.println("You cannot move west.");
                    }
                    break;
                case 6:
                    System.out.println("Interact with an entity: " + currentRoom.getEntity().getInteractionResponse());
                    break;
                case 7:
                    System.out.println("Exiting the house tour.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                }
            }
        }


    public static void displayMenu(){
        System.out.println("""
               [1] Look around
               [2] Move North
               [3] Move South
               [4] Move East
               [5] Move West
               [6] Interact with an entity
               [7] Exit
               """);
    }
}
