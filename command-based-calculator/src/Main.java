import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int runningTotal = 0;

        while(true){
            System.out.println("Please enter a command: ");
            String input = scanner.nextLine().trim(); //we are removing leading and tailing spaces

            //let's split the input into command and argument
            String [] parts = input.split("\\s+");

            //Let's get the first part, which is command and change all that to lowercase
            String command = parts[0].toLowerCase();

            //have something to exit the program
            if(command.equals("exit")){
                System.out.println("Goodbye! final total is: " + runningTotal);
                break;
            }

            runningTotal = calculation(command, parts, runningTotal);

        }


    }

    public static int calculation (String command, String [] parts, int runningTotal ){

        switch (command){
            case  "add":
                if(parts.length < 2){
                    System.out.println("'add' requires a valid input, please try again: ");
                } else {
                    int number = Integer.parseInt(parts[1]);

                runningTotal = runningTotal + number;

                    System.out.println("Added" + number + " . Running total: " + runningTotal);
                }
                break;
            case "subtract":
                if(parts.length < 2){
                    System.out.println("subtract requires a valid input, please try again: ");
                } else {
                    int number = Integer.parseInt(parts[1]);

                runningTotal = runningTotal - number;

                    System.out.println("Subtracted " + number + " . Running total: " + runningTotal);
                }
            break;
            case "reset":
                runningTotal = 0;
                System.out.println("Running total has been reset to 0.");
              break;
            case "total":
                System.out.println("The final total is: " + runningTotal);
                break;
            default:
                System.out.println("Unrecognized input. ");
                break;
        }
        return runningTotal;
    }
}