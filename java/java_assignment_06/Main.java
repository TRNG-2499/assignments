import java.util.Scanner;

public class Main {

    public static final String validCommands[] = {"add", "subtract", "reset", "total", "exit"};

    //handles parsing the command
    public static void readInput() {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        String input="";
        int runningTotal = 0;

        while(true){
            System.out.print("Enter a command: ");
            command = scanner.nextLine();

            //parse command
            String[] parsedCommand = command.split(" ");

            //parse exit, otherwise pass info to readCommand
            if(parsedCommand[0].equals("exit")){
                scanner.close();
                System.out.print("Goodbye! Final total: " + runningTotal);
                break;
            } else {
                input = parsedCommand.length >= 2 ? parsedCommand[1] : ""; //jank way to handle varying levels of inputs but hey it works
                runningTotal = readCommand(parsedCommand[0], input, runningTotal);
            }


        }
    }

    //handles command validation and execution
    public static int readCommand(String command, String input, int runningTotal){
        switch(command){
            case "add":
                try {
                    runningTotal+=Integer.parseInt(input);
                    System.out.print("Added " + input + ". Running total: " + runningTotal + "\n");
                    break;
                }
                catch (Exception e){
                    System.out.print("'add' requires a valid number. Please try again.\n");
                    break;
                 }
            case "subtract":
                try {
                    runningTotal-=Integer.parseInt(input);
                    System.out.print("Subtracted " + input + ". Running total: " + runningTotal + "\n");
                    break;
                }
                catch (Exception e){
                    System.out.print("'subtract' requires a valid number. Please try again.\n");
                    break;
                }
            case "reset":
                runningTotal = 0;
                System.out.print("Running total has been reset to 0.\n");
                break;
            case "total":
                System.out.print("Current total: " + runningTotal + ".\n");
                break;
            default:
                System.out.print("Unrecognized command: " + command + "\n");
        }
        return runningTotal;
    }



    public static void main(String[] args) {
        readInput();
    }
}
