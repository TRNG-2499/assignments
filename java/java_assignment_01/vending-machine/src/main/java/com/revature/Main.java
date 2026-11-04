package com.revature;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double price = readDouble(scanner, "Enter item price: ");
        double amount = readDouble(scanner, "Enter amount inserted: ");

        System.out.println(vendingMachineSolution(price, amount));

        // stretch goal 1
        int itemCount = readItemCount(scanner, "\nHow many items? ");
        double[] prices = new double[itemCount];
        for (int i = 0; i < itemCount; i++) {
            prices[i] = readDouble(scanner, "Enter price of item " + (i + 1) + ": ");
        }

        double listAmount = readDouble(scanner, "Enter amount inserted: ");

        System.out.println(vendingMachineList(prices, listAmount));

        // stretch goal 2
        double changeAmount = readDouble(scanner, "\nEnter change amount to break down: ");

        System.out.println(makeChange(changeAmount));

        scanner.close();
    }

    public static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next(); // Throw away the bad token.
            System.out.print("Please enter a number: ");
        }
        return scanner.nextDouble();
    }

    public static int readItemCount(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (true) {
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                if (count >= 1) {
                    return count;
                }
            } else {
                scanner.next();
            }
            System.out.print("Please enter a whole number of 1 or more: ");
        }
    }

    // normal solution
    public static String vendingMachineSolution(double price, double amount) {
        String output;
        double neededChange = price - amount;
        double change = amount - price;

        if (price < 0) {
            output = "Invalid input: price cannot be negative";
        } else if (amount < 0) {
            output = "Invalid input: amount inserted cannot be negative";
        } else if (amount < price) {
            output = String.format("Insufficient funds, please insert $%.2f more", neededChange);
        } else {        
            output = String.format("Purchase successful, change due: $%.2f", change);
        }
        return output;
    }

    // strech goal 1
    public static String vendingMachineList(double[] prices, double amount) {
        double total = 0;

        for (double p : prices) {
            if (p < 0) {
                return "Invalid input: item price cannot be negative";
            }
            total += p;
        }

        return vendingMachineSolution(total, amount);
    }

    // strech goal 2
    public static String makeChange(double change) {
        if (change < 0) {
            return "invalid input, change cannot be negative.";
        }

        int cents = (int) Math.round(change * 100);

        int[] values = {100, 25, 10, 5, 1};
        String[] names = {"$1.00", "$0.25", "$0.10", "$0.05", "$0.01"};

        String output = String.format("Change for $%.2f:", change);
        for (int i = 0; i < values.length; i++) {
            int count = cents / values[i];
            cents %= values[i];
            output += "\n  " + names[i] + " x " + count;
        }
        return output;
    }
}