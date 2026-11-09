import java.util.Scanner;
public class calc { 

    public static int add(int total, int number) {
        System.out.println("Added " + number +".");
        return total + number;
    }
    public static int subtract(int total, int number) {
        System.out.println("Added " + number +".");
        return total - number;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = 0;

        while (true) {
            System.out.println("Enter a command:");
            String line = scan.nextLine();
            String[] como = line.split(" ");
            
            String command = como[0];

            if (command.equals("exit")) {
                System.out.println("Goodbye Final Total: " + total);
                break;
            }

            switch (command) {
                case "add":
                    if (como.length > 1) {
                        int num = Integer.parseInt(como[1]);
                        total = add(total, num);
                        System.out.println("Total: " + total);
                    } else {
                        System.out.println("Error: Please provide a number.");
                    }
                    break;
                    
                case "subtract":
                    if (como.length > 1) {
                        int num = Integer.parseInt(como[1]);
                        total = subtract(total, num);
                        System.out.println("Total: " + total);
                    } else {
                        System.out.println("Error: Please provide a number.");
                    }
                    break;
                    
                case "reset":
                    total = 0;
                    System.out.println("Total reset to 0.");
                    break;
                    
                case "total": 
                    System.out.println("Current Total: " + total);
                    break;
                    
                default:
                    System.out.println("Unrecognized command: " + command);
                    break;
            }
        }
        scan.close();
    }


}