import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int currentNumber = 0;

        while(true){
            System.out.print("Enter a command: ");

            String command = scanner.next();
            if(command.equals("add")){
                try {
                    int value = scanner.nextInt();
                    currentNumber += value;
                    System.out.println("Added " + value + ". Running total: " + currentNumber);
                } catch (InputMismatchException e){
                    System.out.println("\'add\' requires a valid number. Please try again.");
                }
            } else if(command.equals("subtract")){
                try {
                    int value = scanner.nextInt();
                    currentNumber -= value;
                    System.out.println("Subtracted " + value + ". Running total: " + currentNumber);
                } catch(InputMismatchException e){
                    System.out.println("\'subtract\' requires a valid number. Please try again.");
                }
            } else if(command.equals("reset")){
                currentNumber = 0;
                System.out.println("Running total has been reset to " + currentNumber);
            } else if(command.equals("total")){
                System.out.println("Current total: " + currentNumber);
            } else if(command.equals("exit")){
                System.out.println("Goodbye! Final total: 0");
                break;
            } else {
                System.out.println("Unrecognized command: \'fly\'");
            }
        }
        scanner.close();
    }
}
