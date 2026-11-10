package java_assignment_06;

import java.util.Scanner;

public class JA06 {

    private static final Scanner scanner = new Scanner(System.in);
    public static int total = 0;

    public static void parseCommand(String command){
        String[] words = command.split(" ");

        if (words.length == 1){
            switch(words[0]){
            case("total"):
                System.out.printf("Current total: %d\n", total);
                break;
            case("reset"):
                total = 0;
                System.out.println("Running total has been reset to 0.\n");
                break;
            default:
                System.out.printf("Unrecognized command: %s\n", words[0]); 
                break;
            }
        } else if (words.length == 2){
            if (words[1].matches("[+-]?\\d+")){
                int val = Integer.parseInt(words[1]);
                switch(words[0]){
                    case("add"):
                        total += val;
                        System.out.printf("Added %d. Running total: %d\n", val, total);
                        break;
                    case("subtract"):
                        total -= val;
                        System.out.printf("Subtracted %d. Running total: %d\n", val, total);
                        break;
                }
            } else {
                System.out.printf("'%s' requires a valid number. Please try again.\n", words[0]);
            }
            
        }
    }

    public static void receiveCommand(String[] args){
        while(true){
            System.out.println("Enter a command:");
            String command = scanner.nextLine();

            if (command.equals("exit")){
                System.out.printf("Goodbye! Final total: %d\n", total);
                scanner.close();
                break;
            } else {
                parseCommand(command);
            }
        }
    }

    public static void main(String[] args){
        receiveCommand(args);
    }
}
