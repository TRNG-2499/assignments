package java_assignment_08.OrderSystem;

public class OrderProcessingSystem {

    public static void processOrder(
        String productName,
        int requestedQuantity,
        int availableQuantity,
        double paymentAmount,
        double totalCost,
        boolean paymentExpired)
        throws InventoryException, PaymentException {

            //Validate inventory
            if (requestedQuantity <= 0) {
                throw new InvalidQuantityException(
                    "order quantity must be greater than zero.");

            }

            if (requestedQuantity > availableQuantity) {
                throw new OutOfStockException(
                    "Not enough " + productName + " available.");

            }

            //Validate payment
            if (paymentExpired) {
                throw new PaymentExpiredException(
                    "The payment method has expired.");

            }

            if (paymentAmount < totalCost) {
                throw new PaymentDeclinedException (
                    "Payment amount is insufficient");

            }

            //Successful Order
            System.out.println("Order Successful!");
            System.out.println("Product: " + productName);
            System.out.println("Quantity: " + requestedQuantity);
        }

        public static void main(String[] args) {

            //Test 1: Successful order
            try {
                processOrder("hat", 1, 5, 34.99, 34.99, false);
            }
            catch (OutOfStockException e) {
                System.out.println("Specific inventory error: " + e.getMessage());
            }
            catch (InventoryException e) {
                System.out.println("General inventory error: " + e.getMessage());
            }
            catch (PaymentDeclinedException e) {
                System.out.println("Specific payment error: " + e.getMessage());
            }
            catch (PaymentException e) {
                System.out.println("General payment error: " + e.getMessage());
            }

            //Test 2: product unavailable
            try {
                processOrder("Sun glass", 20, 19, 30, 30, false);
            }
            catch (OutOfStockException e) {
                System.out.println("Specific inventory error: " + e.getMessage());
            }
            catch (InventoryException e) {
                System.out.println("General inventory error: " + e.getMessage());
            }
            catch (PaymentDeclinedException e) {
                System.out.println("Specific Payment error: " + e.getMessage());
            }
            catch (PaymentException e) {
                System.out.println("General payment error: " + e.getMessage());
            }

            //Test 3: Invalid Quantity
            try{
                processOrder("mirror", 0, 5, 60, 60, false);
            }
            catch (OutOfStockException e) {
                System.out.println("Specific inventory error: " + e.getMessage());
            }
            catch (InventoryException e) {
                System.out.println("General inventory error: " + e.getMessage());
            }
            catch (PaymentDeclinedException e) {
                System.out.println("Specific payment error: " + e.getMessage());
            }
            catch (PaymentException e) {
                System.out.println("General payment error: " + e.getMessage());
            }

            // Test 4: Insufficient payment
            try {
                processOrder("thawb", 1, 1, 45, 46, false);
            }
            catch (OutOfStockException e) {
                System.out.println("Specific inventory error: " + e.getMessage());
            }
            catch (InventoryException e) {
                System.out.println("General inventory error: " + e.getMessage());
            }
            catch (PaymentDeclinedException e) {
                System.out.println("Specific payment error: " + e.getMessage());
            }
            catch (PaymentException e) {
                System.out.println("General payment error: " + e.getMessage());
            }

            // Test 5: Expired payment
            try {
                processOrder("Bread", 30, 1000, 3, 3, true);
            }
            catch (OutOfStockException e) {
                System.out.println("Specific inventory error: " + e.getMessage());
            }
            catch (InventoryException e) {
                System.out.println("General inventory error: " + e.getMessage());
            }
            catch (PaymentDeclinedException e) {
                System.out.println("Specific Payment error: " + e.getMessage());
            }
            catch (PaymentException e) {
                System.out.println("General payment error: " + e.getMessage());
            }
        }
    
    
}
