public class OrderProcessing {

    public static void processOrder(String item, int requestedQty, int availableStock,
                                    double paymentAmount, double orderCost, boolean isExpired)
            throws InventoryException, PaymentException {

        if (requestedQty <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0.");
        }
        if (requestedQty > availableStock) {
            throw new OutOfStockException("Requested quantity exceeds available stock.");
        }

        // Then payment checks
        if (isExpired) {
            throw new PaymentExpiredException("Payment method expired.");
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException("Insufficient funds.");
        }

        // Every check passed
        System.out.println("Order successful: " + requestedQty + " x " + item + " confirmed ");
        System.out.println("Total cost: $" + orderCost);
    }

    // THE WAITER (original): calls the cook and CATCHES any problem.
    public static void tryProcessOrder(String item, int requestedQty, int availableStock,
                                       double paymentAmount, double orderCost, boolean isExpired) {
        try {
            processOrder(item, requestedQty, availableStock, paymentAmount, orderCost, isExpired);
        } catch (OutOfStockException e) {          // specific (must come before its parent)
            System.out.println("Try a different quantity: " + e.getMessage());
        } catch (InventoryException e) {           // generic: catches InvalidQuantityException
            System.out.println("Inventory error: " + e.getMessage());
        } catch (PaymentException e) {             // generic: catches both payment exceptions
            System.out.println("Payment error: " + e.getMessage());
        }
    }

    // STRETCH GOAL 1: Custom fields on exceptions=
    public static void processOrderWithDetails(String item, int requestedQty, int availableStock,
                                               double paymentAmount, double orderCost, boolean isExpired)
            throws InventoryException, PaymentException {

        if (requestedQty <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0.");
        }
        if (requestedQty > availableStock) {
            throw new OutOfStockException("Out of stock.", item, requestedQty, availableStock);  // <-- the only difference
        }
        if (isExpired) {
            throw new PaymentExpiredException("Payment method expired.");
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException("Insufficient funds.");
        }

        System.out.println("Order successful: " + requestedQty + " x " + item + " confirmed ");
        System.out.println("Total cost: $" + orderCost);
    }

    public static void tryProcessOrderWithDetails(String item, int requestedQty, int availableStock,
                                                  double paymentAmount, double orderCost, boolean isExpired) {
        try {
            processOrderWithDetails(item, requestedQty, availableStock, paymentAmount, orderCost, isExpired);
        } catch (OutOfStockException e) {
            System.out.println("You asked for " + e.getRequestedQty() + " x " + e.getItem()
                    + ", but only " + e.getAvailableStock() + " are available. "
                    + "Try ordering " + e.getAvailableStock() + " or fewer.");
        } catch (InventoryException e) {
            System.out.println("Inventory error: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Basic requirements ---");
        tryProcessOrder("Laptop", 2, 5, 1000.0, 900.0, false);  
        tryProcessOrder("Tv", 1, 0, 500.0, 500.0, false);      
        tryProcessOrder("Phone", -1, 10, 300.0, 300.0, false);  
        tryProcessOrder("Tablet", 1, 5, 200.0, 250.0, false);    
        tryProcessOrder("Monitor", 1, 5, 400.0, 400.0, true);    

        System.out.println();
        System.out.println("--- Stretch goal 1: custom fields ---");
        tryProcessOrderWithDetails("Charger", 3, 2, 50.0, 150.0, false); 
    }
}