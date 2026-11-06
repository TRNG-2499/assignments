import java.util.Scanner;
public class solution6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = "";
        int total = 0;
        while(!command.equals("exit")){
            System.out.print("Enter a command: ");
            command = input.nextLine();
            String [] comWord = command.split(" ");
            if(!validateInputLength(comWord)){
                System.out.println("Invalid Command. Please try again");
                continue;
            }
            switch(comWord[0]){
                case "add":
                    try {
                        int inputNum = Integer.parseInt(comWord[1]);
                        total += inputNum;
                        System.out.println("Added " + inputNum +". Running total: " + total);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("'add' requires a valid number. Please try again");
                    }
                    break;
                case "subtract":
                    try {
                        int inputNum = Integer.parseInt(comWord[1]);
                        total -= inputNum;
                        System.out.println("Subtracted " + inputNum +". Running total: " + total);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("'subtract' requires a valid number. Please try again");
                    }
                    break;
                case "reset":
                    total = 0;
                    System.out.println("Running total has been reset to 0.");
                    break;
                case "total":
                    System.out.println("Current total: " + total);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Unrecognized command: '" + comWord[0] + "'");
                    break;
            }
        }
        System.out.println("Goodbye! Final total: " + total);
        input.close();
    }
    public static boolean validateInputLength(String [] input){
        if((input[0].equals("add") || input[0].equals("subtract")) && input.length != 2)
            return false;
        if((input[0].equals("reset") || input[0].equals("total") || input[0].equals("exit")) && input.length != 1)
            return false;
        return true;
    }

}
