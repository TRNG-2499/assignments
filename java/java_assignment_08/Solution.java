package java_assignment_08;

public class Solution {
    public static void main(String[] args) {
        runOrder("RAM", 5, 2, 2500, 25000, false);
        runOrder("RAM", -1, 10, 500, 500, false);
        runOrder("RAM", 2, 10, 200, 1000, false);
        runOrder("RAM", 2, 10, 1000, 1000, true);
        runOrder("RAM", 2, 10, 1000, 1000, false);
    }

    private static void runOrder(String itemName, int requestedQuantity, int availableStock,
            double paymentAmount, double orderTotalCost, boolean paymentExpired) {
        try {
            processOrder(itemName, requestedQuantity, availableStock, paymentAmount,
                    orderTotalCost, paymentExpired);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }

    private static void processOrder(String itemName, int requestedQuantity, int availableStock,
            double paymentAmount, double orderTotalCost, boolean paymentExpired)
            throws InventoryException, PaymentException {
        if (requestedQuantity <= 0) {
            throw new InvalidQuantityException();
        }
        if (requestedQuantity > availableStock) {
            throw new OutOfStockException(requestedQuantity, availableStock);
        }
        if (paymentExpired) {
            throw new PaymentExpiredException();
        }
        if (paymentAmount < orderTotalCost) {
            throw new PaymentDeclinedException();
        }

        System.out.println("Order successful! " + requestedQuantity + " x " + itemName + " confirmed.");
    }
}

class InventoryException extends Exception {
    InventoryException(String message) {
        super(message);
    }
}

class PaymentException extends Exception {
    PaymentException(String message) {
        super(message);
    }
}

class OutOfStockException extends InventoryException {
    OutOfStockException(int requestedQuantity, int availableStock) {
        super("Out of stock. Requested " + requestedQuantity + ", but only "
                + availableStock + " available.");
    }
}

class InvalidQuantityException extends InventoryException {
    InvalidQuantityException() {
        super("Invalid quantity. Quantity must be greater than 0.");
    }
}

class PaymentDeclinedException extends PaymentException {
    PaymentDeclinedException() {
        super("Payment declined. Insufficient funds.");
    }
}

class PaymentExpiredException extends PaymentException {
    PaymentExpiredException() {
        super("Payment method expired.");
    }
}
