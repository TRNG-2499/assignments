import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String... args){
        Scanner user = new Scanner(System.in);

        Room currentRoom = new LivingRoom(null, "down");
        printRoomDescription(currentRoom);
        while(true){
            System.out.println();
            System.out.print("Enter a command: ");
            String input = user.next();

            if(input.equals("move")){
                try {
                    currentRoom = currentRoom.enter(user.next());
                    printRoomDescription(currentRoom);
                } catch(InvalidDirectionException e){
                    System.out.println(e.getMessage());
                }
            } else if(input.equals("look")){
                printRoomDescription(currentRoom);
            } else if(input.equals("interact")){
                try {
                    currentRoom.getEntity(user.next()).interact();
                } catch(EntityNotFoundException e){
                    System.out.println(e.getMessage());
                }
            } else if(input.equals("exit")){
                System.out.println("Thanks for visiting! Goodbye!");
                break;
            } else {
                System.out.println("%s is not a valid command");
            }
        }

        user.close();
    }

    private static void printRoomDescription(Room room){
        System.out.printf("You are in the %s\n", room.name());
        System.out.println(room.description());
        System.out.print("Interactable entities: ");
        for(Entity e : room.getEntities()){
            System.out.printf("%s, ");
        }
        System.out.println();
    }
}