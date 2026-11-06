/**
     * @param args the command line arguments
     * Java assignment 01 - Vending Machine Change Maker
     * Objective: Practice input validation using conditional logic, basic arithmetic, and returning clear, distinct outcomes based on multiple possible conditions.
     * Steps:
     * 1. A method that accepts 2 params. Price of a item and amount of money inserted by the customer.
     * 2. Method evals the inputs and determines 3 different outcomes.
     * 3. Invalid input, insufficient funds, or successful purchase.
*/

public class VendingMachine {

    public static String calculateChange(double price, double amountInserted) {

        //invalid input checker for price and amount inserted
        if (price < 0) {
            return "Invalid input: item price cannot be negative.";
        }
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        //check to see if the customer inserted enough money
        if (amountInserted < price) {
            double amountNeeded = price - amountInserted;
            return String.format(
                "Insufficient funds. Please insert $%.2f more.",
                amountNeeded
            );
        }

        //the customer change is calculated if the purchase is successful
        double change = amountInserted - price;
        return String.format(
            "Purchase successful. Change due: $%.2f",
            change
        );
    }

    public static void main(String[] args)  {
        System.out.println(calculateChange(2.75, 3.00));
        System.out.println(calculateChange(2.25, 1.00));
        System.out.println(calculateChange(1.50, 1.50));
        System.out.println(calculateChange(1.50, -1.00));
    }
}
