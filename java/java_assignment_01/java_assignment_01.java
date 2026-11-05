package assignments.java.java_assignment_01;
import java.util.Scanner;

public class java_assignment_01 {
    public static void makeChange(double price, double paid){
        if (paid < 0) {
            System.out.println("Invalid input: amount inserted cannot be negative.");
        } else if (price < 0) {
            System.out.println("Invalid input: price cannot be negative.");
        } else if (paid < price) {
            double difference = price - paid;
            System.out.printf("Insufficient funds. Please insert $%.2f more.", difference);
        } else if (paid >= price) {
            double change = paid - price;
            System.out.printf("Purchase successful. Change due: $%.2f", change);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter item price: ");
        double price = scanner.nextDouble();
        
        System.out.println("Enter amount inserted: ");
        double paid = scanner.nextDouble();

        scanner.close();

        makeChange(price, paid);
    }
}