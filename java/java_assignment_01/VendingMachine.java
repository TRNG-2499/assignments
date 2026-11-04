package assignments.java.java_assignment_01;
//import java.util.*;

public class VendingMachine {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the item price: ");
        double price = scanner.nextDouble();
        System.out.println();
        System.out.print("Please enter the amount inserted: ");
        double amountInserted = scanner.nextDouble();
        purchase(price, amountInserted);

        double[] prices = {3.25, 1.75, 2.50, 1.25};
        massPurchase(prices, 12);

        //change(3.67);*/
    }

    public static void purchase(double p, double amount) {
        if (p < 0) {
            System.out.println("Invalid input: price cannot be negative.");
        }else if (amount < 0) {
            System.out.println("Invalid input: amount inserted cannot be negative.");
        }else if (p > amount) {
            System.out.println("Insufficient funds. Please insert $"+(p-amount)+" more.");
        }else {
            System.out.println("Purchase successful. Change due: $"+(amount-p)+".");
        }
    }

    public static void massPurchase(double[] p, double amount) {
        double total = 0;
        for(int x = 0; x < p.length; x++) {
            total += p[x];
        }
        purchase(total, amount);
    }

    public static void change(double amountOwed) {
        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;
        int pennies = 0;

        if (amountOwed > 0) {
            if (amountOwed >= 1) {
                while (amountOwed >= 1) {
                    dollars++;
                    amountOwed = amountOwed - 1;
                }
            }
            if (amountOwed >= 0.25) {
                while (amountOwed >= 0.25) {
                    quarters++;
                    amountOwed = amountOwed - 0.25;
                }
            }
            if (amountOwed >= 0.1) {
                while (amountOwed >= 0.1) {
                    dimes++;
                    amountOwed = amountOwed - 0.1;
                }
            }
            if (amountOwed >= 0.05){
                while (amountOwed >= 0.05) {
                    nickles++;
                    amountOwed = amountOwed - 0.05;
                }
            }
            if (amountOwed > 0){
                while (amountOwed > 0) {
                    pennies++;
                    amountOwed = amountOwed - 0.01;
                }
            }
        }
        System.out.println("Amount of bills and coins used: "+dollars+" dollar bills, "+quarters+" quarters, "+dimes+" dimes, "+nickles+" nickles, and "+pennies+" pennies.");
    }
}
