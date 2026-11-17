import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String... args){
        Scanner user = new Scanner(System.in);

        Room currentRoom = new LivingRoom();
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
                    System.out.println(currentRoom.getEntity(user.next()).interact());
                } catch(EntityNotFoundException e){
                    System.out.println(e.getMessage());
                }
            } else if(input.equals("exit")){
                System.out.println("Thanks for visiting! Goodbye!");
                break;
            } else {
                System.out.printf("%s is not a valid command\n", input);
            }
        }

        user.close();
    }

    private static void printRoomDescription(Room room){
        System.out.printf("You are in the %s\n", room.name());
        System.out.println(room.description());
        System.out.print("Interactable entities: ");
        if(room.getEntityCount() <= 0){
            System.out.print("None");
        } else {
            int i = 0;
            for(Entity e : room.getEntities()){
                if(i >= (room.getEntityCount() - 1)){
                    System.out.print(e.getName());
                } else {
                    System.out.printf("%s, ", e.getName());
                }
                i++;
            }
        }
        System.out.println();
    }
}