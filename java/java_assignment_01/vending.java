import java.util.*;
import java.lang.Math;

public class vending {
    public static void main(String[] args) {

        // Console description
        System.out.println("Select your purchase mode: ");
        System.out.println("1 for default ");
        System.out.println("2 for multiple items ");
        System.out.println("3 for change breakdown ");

        // intiate scanner
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        // default mode
        if (input == 1) {

            System.out.print("Please enter the item price: ");
            double price = scanner.nextDouble();

            if (price < 0) {
                System.out.println("Invalid input: price cannot be negative.");
                scanner.close();
                return;
            }

            System.out.print("Please enter your cash: ");
            double cash = scanner.nextDouble();

            if (cash < 0) {
                System.out.println("Invalid input: amount inserted cannot be negative.");
                scanner.close();
                return;
            }
            vendingMachine(price, cash);

            // multiple item mode
        } else if (input == 2) {

            System.out.print("Please enter the number of items you want to purchase: ");
            int itemCount = scanner.nextInt();
            List<Double> prices = new ArrayList<>();

            for (int i = 0; i < itemCount; i++) {
                System.out.print("Please enter the price for item " + (i + 1) + ": ");
                double price = scanner.nextDouble();
                if (price < 0) {
                    System.out.println("Invalid input: price cannot be negative.");
                    scanner.close();
                    return;
                }
                prices.add(price);
            }

            System.out.print("Please enter your cash: ");
            double cash = scanner.nextDouble();
            if (cash < 0) {
                System.out.println("Invalid input: amount inserted cannot be negative.");
                scanner.close();
                return;
            }
            multipleItems(prices, cash);

            // change breakdown mode
        } else if (input == 3) {
            System.out.print("Please enter the item price: ");
            double price = scanner.nextDouble();

            if (price < 0) {
                System.out.println("Invalid input: price cannot be negative.");
                scanner.close();
                return;
            }

            System.out.print("Please enter your cash: ");
            double cash = scanner.nextDouble();

            if (cash < 0) {
                System.out.println("Invalid input: amount inserted cannot be negative.");
                scanner.close();
                return;
            }

            Denominations(price, cash);

        } else {
            System.out.println("Invalid input: please enter a valid option.");
        }

        scanner.close();

    }

    public static void vendingMachine(double price, double cash) {

        Scanner scanner = new Scanner(System.in);

        if (cash < price) {
            System.out.printf(Locale.US, "Insufficient funds. Please insert $%.2f more%n", Math.abs(cash - price));
        } else if (cash == price) {
            System.out.printf(Locale.US, "Purchase successful. Change due: $%.2f%n", Math.abs(cash - price));
        } else {
            System.out.printf(Locale.US, "Purchase successful. Change due: $%.2f%n", Math.abs(cash - price));
        }

        scanner.close();
    }

    public static void multipleItems(List<Double> prices, double cash) {

        double totalPrice = 0;
        for (double price : prices) {
            totalPrice += price;
        }

        if (cash < totalPrice) {
            System.out.printf(Locale.US, "Insufficient funds. Please insert $%.2f more%n", Math.abs(cash - totalPrice));
        } else if (cash == totalPrice) {
            System.out.printf(Locale.US, "Purchase successful. Change due: $%.2f%n", Math.abs(cash - totalPrice));
        } else {

            double change = Math.abs(cash - totalPrice);
            System.out.printf(Locale.US, "Purchase successful. Change due: $%.2f%n", change);

        }

    }

    public static void Denominations(Double price, double cash) {

        List<Double> deno = new ArrayList<>();
        deno = Arrays.asList(1.00, 0.25, 0.10, 0.05, 0.01);

        double change = Math.abs(cash - price);

        if (cash < price) {
            System.out.printf(Locale.US, "Insufficient funds. Please insert $%.2f more%n", Math.abs(cash - price));
        } else if (cash == price) {
            System.out.printf(Locale.US, "Purchase successful. Change due: $%.2f%n", Math.abs(cash - price));
        } else {
            System.out.printf(Locale.US, "Purchase successful. Change due: $%.2f%n", change);
        }

        System.out.println("Change breakdown: ");

        for (double d : deno) {
            int count = (int) (change / d);
            change = change - (count * d);
            if (count > 0) {
                System.out.printf(Locale.US, "%d x $%.2f%n", count, d);
            }
        }

    }
}
