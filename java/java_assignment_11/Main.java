import java.util.Scanner;

public class Main {

    public static void homeTour(Room currentRoom){

        boolean continueReading = true;
        String userInput = "";
        Scanner scanner = new Scanner(System.in);

        currentRoom.look();

        while(continueReading){
            try{
                System.out.print("Enter a command: ");
                userInput = scanner.nextLine();
                userInput = userInput.toLowerCase();
                String[] processedInput = userInput.split(" ");

                switch(processedInput[0]){
                    case "exit":
                        continueReading = false;
                        break;
                    case "move":
                        switch(processedInput[1]){
                            case "north":
                                if(currentRoom.getNorth() != null){
                                    currentRoom = currentRoom.getNorth();
                                    currentRoom.look();
                                } else { throw new InvalidDirectionException("Error: There is no exit to the north from here.");}
                                break;
                            case "south":
                                if(currentRoom.getSouth() != null){
                                    currentRoom = currentRoom.getSouth();
                                    currentRoom.look();
                                } else { throw new InvalidDirectionException("Error: There is no exit to the south from here.");}
                                break;
                            case "east":
                                if(currentRoom.getEast() != null){
                                    currentRoom = currentRoom.getEast();
                                    currentRoom.look();
                                } else { throw new InvalidDirectionException("Error: There is no exit to the east from here."); }
                                break;
                            case "west":
                                if(currentRoom.getWest() != null){
                                    currentRoom = currentRoom.getWest();
                                    currentRoom.look();
                                } else { throw new InvalidDirectionException("Error: There is no exit to the west from here."); }
                                break;
                            default:
                                throw new InvalidDirectionException("Error: Not Valid Direction");
                        }
                        break;
                    case "look":
                        currentRoom.look();
                        break;
                    case "interact":
                        Entity[] entityList = currentRoom.getEntities();
                        boolean interacted = false;

                        for(int i=0; i < entityList.length; i++){
                            Entity object = entityList[i];
                            String objectName = object.getName();

                            if(processedInput[1].equals(objectName.toLowerCase())){
                                object.interact();
                                interacted = true;
                            }
                        }

                        if(!interacted){
                            throw new EntityNotFoundException("There is no " + processedInput[1] + " to interact with.");
                        }

                        break;
                    default:
                        System.out.println("Error: Invalid Command.");

                }


            } catch(InvalidDirectionException | EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Thanks for visiting, goodbye!");
        scanner.close();

    }

    public static void main(String[] args){
        //Set Up script for room layout, then call homeTour
        Room foyer = new Foyer();
        Room kitchen = new Kitchen();
        Room livingRoom = new LivingRoom();
        Room bathRoom = new BathRoom();
        Room diningRoom = new DiningRoom();

        foyer.setNorth(kitchen);
        livingRoom.setEast(kitchen);
        diningRoom.setSouth(kitchen);
        bathRoom.setWest(kitchen);

        kitchen.setNorth(diningRoom);
        kitchen.setEast(bathRoom);
        kitchen.setSouth(foyer);
        kitchen.setWest(livingRoom);

        homeTour(foyer);
    }
}
