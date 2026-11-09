import java.util.Scanner;
public class scannerCalc {
    public static void main(String args[]) {
        int number = 0;
        Boolean leave = false;
        Scanner myScan = new Scanner(System.in);
        while(leave != true) {
            System.out.println("Commands: add, subtract, reset, total, exit");
            String input = myScan.nextLine();
            String[] splited = new String[2];
            splited = input.split(" ");
            switch(splited[0]){
                case "add":
                    try {
                        number += Integer.parseInt(splited[1]);
                        System.out.println("Your number is now: "+number);
                        break;
                    } catch(NumberFormatException nfe) {
                        System.out.println("please add numbers!");
                        break;
                    }

                case "subtract":
                    try {
                        number -= Integer.parseInt(splited[1]);
                        System.out.println("Your number is now: "+number);
                        break;
                    } catch(NumberFormatException nfe) {
                        System.out.println("please subtract numbers!");
                        break;
                    }
                case "reset":
                    number = 0;
                    System.out.println("Your number is now: "+number);
                    break;
                case "total":
                    System.out.println("Your total is: "+number);
                    break;
                case "exit":
                    leave = true;
                    break;
                default:
                    System.out.println("Unrecognized command, please try again");
                    break;
            }

        }
        myScan.close();

    }

}
