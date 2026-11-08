package assignments.java.java_assignment_06;

import java.util.*;

public class CommandCalculator {
    private static int total = 0;
    public static void main(String[] args) {
        inputReader();
    }

    public static void inputReader(){
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean end = false;

        while(!end){
            System.out.print("Enter a command: ");
            line = scanner.nextLine();
            end = calculator(line);
            System.out.println();
        }
        scanner.close();
    }

    public static boolean calculator(String commandLine) {
        boolean exit = false;

        String command;
        int num = 0;
        int space = commandLine.indexOf(' ');
        boolean twoParts = true;
        boolean validNum = true;

        if (space > 0) { //2 parts
            command = commandLine.substring(0, space);
            //stringNum = commandLine.substring(space+1, commandLine.length());
            try {
                num = Integer.parseInt(commandLine.substring(space+1, commandLine.length()));
            } catch (NumberFormatException e) {
                validNum = false;
            }
            //num = Integer.parseInt(commandLine.substring(space+1, commandLine.length()));
        }else {//1 word
            command = commandLine;
            twoParts = false;
        }

        switch (command) {
            case "add":
                if (twoParts == false || validNum == false){
                    System.out.println("'add' requires a valid number. Please try again.");
                }else {
                    total += num;
                    System.out.println("Added "+ num +". Running total: "+ total);
                }
                break;
            case "subtract":
                if (twoParts == false || validNum == false){
                    System.out.println("'subtract' requires a valid number. Please try again.");
                }else {
                    total -= num;
                    System.out.println("Subtracted "+ num +". Running total: "+ total);
                }
                break;
            case "reset":
                if (twoParts == true){
                    System.out.println("'reset' should be entered with no following words or numbers. Please try again.");
                }else {
                    total = 0;
                    System.out.println("Running total has been reset to 0.");
                }
                break;
            case "total":
                if (twoParts == true){
                    System.out.println("'total' should be entered with no following words or numbers. Please try again.");
                }else {
                    System.out.println("Current total: "+ total);
                }
                break;
            case "exit":
                if (twoParts == true){
                    System.out.println("'exit' should be entered with no following words or numbers. Please try again.");
                }else {
                    System.out.println("Goodbye! Final total: "+ total);
                    exit = true;
                }
                break;
            default:
                System.out.println("Unrecognized command: '"+ command +"'");
                break;
        }
        return exit;
    }

}
