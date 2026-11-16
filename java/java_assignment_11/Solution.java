import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String... args){
        Scanner user = new Scanner(System.in);

        Room currentRoom = new LivingRoom(null, "down");
        while(true){
            System.out.printf("You are in the %s\n", currentRoom.name());
            System.out.println(currentRoom.description());

            String input = user.next();

            if(input.equals("move")){
                
            } else if(input.equals("look")){

            } else if(input.equals("interact")){

            } else if(input.equals("exit")){

            }
        }
    }
}