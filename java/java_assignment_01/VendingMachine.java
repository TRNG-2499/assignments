import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {
        System.out.println("Vending Machine Change Maker");

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("How many items are you purchasing? ");
            int count = Integer.parseInt(scanner.nextLine());

            if (count <= 0) {
                System.out.println("Please enter at least one item.");
                return;
            }

            List<Double> prices = new ArrayList<>();
            for (int i = 1; i <= count; i++) {
                System.out.print("Enter price of item " + i + " ($): ");
                prices.add(Double.parseDouble(scanner.nextLine()));
            }

            double total = calculateTotal(prices);
            if (Double.isNaN(total)) {
                System.out.println("Invalid item prices.");
                return;
            }
            System.out.printf("%nTotal amount: $%.2f%n", total);

            System.out.print("Enter amount inserted ($): ");
            double paid = Double.parseDouble(scanner.nextLine());

            System.out.println("\n" + makeChangeMultipleItems(prices, paid));

            if (isValid(paid) && paid > total) {
                System.out.println(calculateDenominations(paid - total));
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    // Single item
    public static String makeChange(double price, double paid) {
        if (!isValid(price)) {
            return "Invalid input: item price cannot be negative.";
        }
        if (!isValid(paid)) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        if (paid < price) {
            return String.format("Insufficient funds. Please insert $%.2f more.", price - paid);
        }
        return String.format("Purchase successful. Change due: $%.2f", paid - price);
    }

    // Stretch goal 1: multiple items
    public static String makeChangeMultipleItems(List<Double> prices, double paid) {
        if (prices == null || prices.isEmpty()) {
            return "Invalid input: item list cannot be empty.";
        }
        double total = calculateTotal(prices);
        if (Double.isNaN(total)) {
            return "Invalid input: item prices must be non-null and non-negative.";
        }
        return makeChange(total, paid);
    }

    // Stretch goal 2: denominations
    public static String calculateDenominations(double changeOwed) {
        if (!isValid(changeOwed)) {
            return "Invalid change amount.";
        }
        long cents = Math.round(changeOwed * 100);

        long dollars = cents / 100;  cents %= 100;
        long quarters = cents / 25;  cents %= 25;
        long dimes = cents / 10;     cents %= 10;
        long nickels = cents / 5;    cents %= 5;

        return String.format("Change breakdown: %d Dollar(s), %d Quarter(s), %d Dime(s), %d Nickel(s), %d Penny(ies)",dollars, quarters, dimes, nickels, cents);
    }

    private static double calculateTotal(List<Double> prices) {
        double total = 0;
        for (Double p : prices) {
            if (!isValid(p)) return Double.NaN;
            total += p;
        }
        return Double.isFinite(total) ? total : Double.NaN;
    }

    private static boolean isValid(Double amount) {
        return amount != null && Double.isFinite(amount) && amount >= 0;
    }
}