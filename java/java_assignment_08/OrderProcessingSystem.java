public class OrderProcessingSystem {

    public static void processOrder(String item, int requestedQty, int availableStock,
                                    double paymentAmount, double orderCost, boolean isExpired)
            throws InventoryException, PaymentException {

        // Check inventory first. A failed check stops the order immediately.
        if (requestedQty <= 0) {
            throw new InvalidQuantityException();
        }

        if (requestedQty > availableStock) {
            throw new OutOfStockException(requestedQty, availableStock);
        }

        // Check whether the payment method can be used before checking the amount.
        if (isExpired) {
            throw new PaymentExpiredException();
        }

        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException();
        }

        System.out.println("Order successful! " + requestedQty + " x " + item + " confirmed.");
    }



    private static void tryOrder(String item, int requestedQty, int availableStock,
                                 double paymentAmount, double orderCost, boolean isExpired) {
        try {
            processOrder(item, requestedQty, availableStock, paymentAmount, orderCost, isExpired);
        } catch (OutOfStockException e) {
            // Catch the specific exception first so we can give stock-related advice.
            System.out.println("Order failed for " + item + ": " + e.getMessage()
                    + " Try ordering fewer.");
        } catch (InventoryException e) {
            // Handle any other inventory error here.
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            // This one catch handles both expired and declined payments.
            System.out.println("Order failed: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        // Each call handles its own error, so the next order can still run.
        tryOrder("Widget", 5, 2, 50.00, 50.00, false);   // Out of stock
        tryOrder("Widget", -1, 10, 50.00, 50.00, false); // Invalid quantity
        tryOrder("Widget", 2, 10, 10.00, 50.00, false);  // Payment declined
        tryOrder("Widget", 2, 10, 50.00, 50.00, true);   // Payment expired
        tryOrder("Widget", 2, 10, 50.00, 50.00, false);  // Success
    }
}



// Parent exception for problems with order quantity or available stock.
class InventoryException extends Exception {
    InventoryException(String message) {
        // Pass the message to Exception so a catch block can read it with getMessage().
        super(message);
    }
}

// Parent exception for problems with a payment.
class PaymentException extends Exception {
    PaymentException(String message) {
        super(message);
    }
}

// Thrown when the customer requests more items than are in stock.
class OutOfStockException extends InventoryException {
    OutOfStockException(int requestedQty, int availableStock) {
        // Include both quantities so the customer knows how many are available.
        super("Out of stock. Requested " + requestedQty
                + ", but only " + availableStock + " available.");
    }
}

// Thrown when the requested quantity is zero or negative.
class InvalidQuantityException extends InventoryException {
    InvalidQuantityException() {
        super("Invalid quantity. Quantity must be greater than 0.");
    }
}

// Thrown when the payment amount is less than the order total.
class PaymentDeclinedException extends PaymentException {
    PaymentDeclinedException() {
        super("Payment declined. Insufficient funds.");
    }
}

// Thrown when the payment method has expired.
class PaymentExpiredException extends PaymentException {
    PaymentExpiredException() {
        super("Payment method expired.");
    }
}