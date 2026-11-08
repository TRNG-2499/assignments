package assignment02.part06;
import java.util.Scanner;
public class Solution {

    public static int handleCommands(String command1, String command2,int total){
        if (command1.equals("add") || command1.equals("subtract")) {
            try {
                int num = Integer.parseInt(command2);
                if (command1.equals("add")) {
                    total += num;
                    System.out.println("Added " + num + ". Running total: " + total);
                } else {
                    total -= num;
                    System.out.println("Subtracted " + num + ". Running total: " + total);
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("'" + command1 + "' requires a valid number. Please try again.");
            }
        } else if (command1.equals("total")) {
            System.out.println("Current total: " + total);
        } else if (command1.equals("reset")) {
            total = 0;
            System.out.println("Running total has been reset to 0.");
        } else {
            System.out.println("Unrecognized command: '" + command1 + "'");
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isExit = true;
        int total = 0;
        while(isExit){
            String userInput = sc.nextLine();
            String [] command = userInput.split(" ");
            if ("exit".equals(userInput)){
                isExit=false;
            }
            else{
                total = handleCommands(command[0], command[1], total);
            }
        }
        sc.close();
    }
}