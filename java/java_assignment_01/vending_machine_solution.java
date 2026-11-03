/*
Write a method that accepts two parameters: the price of an item and the amount of money inserted by the customer.
Your method should evaluate the inputs and determine one of the following outcomes:
Invalid input — if the item price is negative, or the amount inserted is negative, the inputs are invalid. Your method should return a clear string message describing the problem rather than attempting to calculate a result.
Insufficient funds — if the amount inserted is less than the item price, the method should return a clear string message reporting that more money is needed, along with how much additional money is required.
Successful purchase — if the amount inserted meets or exceeds the item price, return a message reporting that the purchase was successful and calculate the change owed (amount inserted minus price). An amount inserted that exactly matches the price is a successful purchase with $0.00 in change.
You may use double values to represent money for this activity. Be aware that floating-point arithmetic can introduce small rounding errors (for example, 0.1 + 0.2 does not always equal exactly 0.3 in Java) — this is a known limitation you should be aware of, but resolving it is not a requirement for the base activity.
Your method should clearly communicate which of the three outcomes occurred, along with the relevant number (amount still needed, or change owed) where applicable.
*/

public class vending_machine_solution {
    public static String vendingMachine(double price, double inserted) {
        if (inserted < 0) {
            return "Invalid input: inserted amount must be non-negative.";
        }
        if (price < 0) {
            return "Invalid input: price must be non-negative.";
        }
        if (inserted < price) {
            return String.format("Insufficient funds. Please insert $%.2f more.", (price - inserted));
        }
        return String.format("Purchase successful. Change due: $%.2f.", (inserted - price));
    }

    public static void main(String[] args) {
        System.out.println(vendingMachine(2.5, 3.0));
        System.out.println(vendingMachine(2.5, 2.0));
        System.out.println(vendingMachine(2.5, -2.0));
        System.out.println(vendingMachine(-1.0, 2.0));
        System.out.println(vendingMachine(2.5, 2.5));
    }
}
