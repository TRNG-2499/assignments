package javaAssignments.java_assignment_08;

public class order_processing {


    public static void main(String[] args) {
        // Negative quantity requested, and we don't take returns ;)
        try {
            System.out.println(processOrder("banana", -1, 10, 5.0, 5.0, true));
        } catch (invalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (inventoryException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Requested quantity exceeds available stock
        try {
            System.out.println(processOrder("apple", 5, 4, 5.0, 5.0, true));
        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (inventoryException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        //payment less than cost
        try {
            System.out.println(processOrder("lime", 5, 10, 5.0, 4.9, true));
        } catch (PaymentDeclinedException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (paymentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        //card expired
        try{
            System.out.println(processOrder("lemon", 5, 10, 5.0, 5.0, false));
        } catch (PaymentExpiredException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (paymentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Successful order
        try {
            System.out.println(processOrder("orange", 5, 10, 5.0, 5.0, true));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String processOrder(String item, int quantity, int itemStock, double totalCost, double totalPayment, Boolean paymentExpiry) throws Exception {
        if (quantity <= 0){ //fairly standard stuff here, check condition, throw exception w/ message about condition
            throw new invalidQuantityException("Quantity must be greater than 0");
        }                   //inventory errors first
        if (quantity > itemStock) { //stretch goal 1 is to update this exception
            throw new OutOfStockException("Not enough stock for " + item, itemStock, quantity);
        }
        if (totalPayment < totalCost) {
            throw new PaymentDeclinedException("Payment declined due to insufficient funds");
        }
        if (paymentExpiry == null || !paymentExpiry) {
            throw new PaymentExpiredException("Payment has expired");
        }
        return "Order processed successfully, purchased " + quantity + " of " + item;
    }

    //stretch goal 2 is to process a set of orders at a time
    //gonna set stretch goal 2 down for the day I was just creating a huge mess and I'd like to look at this with fresh eyes later
}
