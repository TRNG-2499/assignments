package javaAssignments.java_assignment_01;

public class vendingmachineChange {
    public static void main(String[] args) {
        /* //TEST STATEMENTS

        //normal purchase
        System.out.println(calculateChange(10.0, 4.75));

        //negative vals
        System.out.println(calculateChange(-10.0, 4.7));

        //insufficient funds
        System.out.println(calculateChange(3.0, 4.0));
        */
    }
        public static String calculateChange(double amountReceived, double itemPrice) {

            //input validation
            if (amountReceived < 0 || itemPrice < 0) {
                return "Invalid input. Please enter non-negative values.";
            }

            //offering return values based on the amount received and item price
            if (amountReceived >= itemPrice) {
                return "Purchase Successful. Change: $" + (amountReceived - itemPrice);
            } else {
                return "Insufficient funds. Please insert $" + (itemPrice - amountReceived) + " more";
            }
    }
}