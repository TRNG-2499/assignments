import java.util.Scanner;

public class CommBasedCalc {
    public static int total = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //looping the output so my program can keep going
        while (true) {
            System.out.println("Enter a command, options are: add, subtract, reset, total, exit.");
            System.out.println("running total = " + total);

            String command = scan.nextLine();

            if (command.equals("exit")){
                break;
            }
            //if the input is either add or subtract it asks for a number, other commands it asks for nothing
            if (command.equals("add") || command.equals("subtract")) {
                System.out.println("Enter a number:");
                int input = scan.nextInt();
                scan.nextLine();
                        //removes the additional newline form nextInt
                options(command, input);
            } else {
                options(command, 0);
            }
        }
    }
    public static void options(String command, int input) {
        switch (command){
            case "add":
                System.out.println(total += input);
                break;
            case "subtract":
                System.out.println(total -= input);
                break;
            case "reset":
                total = 0;
                System.out.println(total);
                break;
            case "total":
                System.out.println(total);
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}
