/**
     * @param args the command line arguments
     * Java assignment 08 - Order Processing System
     * Objective: Practice designing a custom exception hierarchy — two top-level custom exceptions, each with more specific subclasses beneath them — and using that hierarchy to catch errors at different levels of specificity: catching a specific subtype versus catching its broader parent type.
     * 1. Define two top-level custom exception classes, both extending Exception: InventoryException and PaymentException. Define the following subclasses:
     * Extending InventoryException:
     * OutOfStockException — thrown when an order requests more of an item than is currently available in stock
     * InvalidQuantityException — thrown when an order requests a zero or negative quantity of an item
     * 
     * Extending PaymentException:
     * PaymentDeclinedException — thrown when a simulated payment amount is less than the order's total cost
     * PaymentExpiredException — thrown when a simulated payment method is marked as expired
     * 
     * 2. Each custom exception should provide a clear, descriptive message explaining what went wrong. Write a method that processes a single simulated order. It should accept an item name, a requested quantity, the available stock for that item, a payment amount, the order's total cost, and whether the payment method is expired. 
     *      Validate inventory-related rules first: If the requested quantity is zero or negative, throw InvalidQuantityException
            If the requested quantity exceeds the available stock, throw OutOfStockException

            Then validate payment-related rules:
            If the payment method is expired, throw PaymentExpiredException
            If the payment amount is less than the order's total cost, throw PaymentDeclinedException
            If all validations pass, report a successful order confirmation, including the item name and quantity ordered.
     * 3. In your driving code (e.g., main), call this method with several different simulated orders, each designed to trigger a different outcome (each type of exception, as well as at least one successful order). Demonstrate catching these exceptions at both levels of specificity across your driving code: 
            At least one catch block that catches a specific subclass (for example, OutOfStockException) and handles it with a tailored message. 
            At least one catch block that catches the broader parent type (for example, PaymentException) and handles any of its subclasses more generically.
            In Java, a catch block for a subclass must appear before a catch block for its parent class in the same try statement, or the code will not compile. Keep this in mind when deciding which exceptions you catch specifically versus generically within the same try block.
*/
public class OrderProcessingSystem {
    public static void main(String[] args) throws PaymentException, InventoryException {
        //out of stock test
        try {
            OrderProcessor.processOrder(
                "Widget", 5, 2, 50.00, 50.00, false
            );
        }catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        }catch (InventoryException e) {
            System.out.println("Inventory error: " + e.getMessage());
        }

        //invalid quantity test
        try {
            OrderProcessor.processOrder(
                "Widget", -1, 10, 50.00, 50.00, false
            );
        }catch (InvalidQuantityException e) {
            System.out.println("Order failed: " + e.getMessage());
        }catch (InventoryException e) {
            System.out.println("Inventory error: " + e.getMessage());
        }

        //payment declined test
        try {
            OrderProcessor.processOrder(
                "Widget", 2, 10, 10.00, 50.00, false
            );
        }catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        //payment expired test
        try {
            OrderProcessor.processOrder(
                "Widget", 2, 10, 50.00, 50.00, true
            );
        }catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        //successful order test
        try {
            OrderProcessor.processOrder(
                "Widget", 2, 10, 50.00, 50.00, false
            );
        }catch (InventoryException e) {
            System.out.println("Inventory error: " + e.getMessage());

        }catch (PaymentException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }
}
