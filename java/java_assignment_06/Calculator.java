package java.java_assignment_06;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int total = 0;
        boolean running = true;

        System.out.println("Welcome to the Calculator!");
        System.out.println("Here are the following commands: ");
        System.out.print("add [number] \n subtract [number] \n reset \n total \n exit \n");

        while (running){
            System.out.println("Enter a command: ");
            if (!scan.hasNextLine()){
                break;
            }

            String line = scan.nextLine().trim();
            String[] parts = line.split("\\s+");
            String command = parts[0].toLowerCase();

            switch(command) {
                case "add":
                case "subtract":
                    if (parts.length < 2){
                        System.out.println("Error: '" + command + "' needs a number, ex: "+ command + "5");
                        break;
                    }
                    int number;
                    try{
                        number = Integer.parseInt(parts[1]);
                    } catch (NumberFormatException e){
                        System.out.println("Error: " + parts[1]+ "is not a valid integer.");
                        break;
                    }
                    if(command.equals("add")) {
                        total += number;
                        System.out.println("Added " + number + ". Running total: "+ total);
                    }else {
                        total -= number;
                        System.out.println("Subtracted " + number + ". Running total: "+ total);
                    }
                    break;
                case "reset":
                    total = 0;
                    System.out.println("Total reset. Running total: "+ total);
                    break;
                case "total":
                    System.out.println("Current total: "+total);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Error: '" + line + "' is not a recognized command.");
                    break;
            }
        }
        System.out.println("Thank you for using the Calculator!");
        System.out.println("Final total: "+total);
        scan.close();
    }
}
