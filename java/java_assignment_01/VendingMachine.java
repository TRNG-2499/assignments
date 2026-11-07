

import java.util.Scanner;

public class VendingMachine {

    public static void change(double price, double amountInserted) {
        if (price < 0 || amountInserted < 0) {
            System.out.println("Price and amount inserted cannot be negative.");
            return;
        }
        if (amountInserted < price) {
            System.out.println("Insufficient amount inserted. Please insert $" + (price - amountInserted) + " more.");
            return;
        }
        
        System.out.println("Purchase successful. Change to be due: $" + (amountInserted - price));
    }
        



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the price of the item: ");
        double price = scanner.nextDouble();
        System.out.print("Enter the amount inserted: ");
        double amountInserted = scanner.nextDouble();
        change(price, amountInserted);
    }
}

