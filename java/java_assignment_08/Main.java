
public class Main {

    public static void processOrder(
        String itemName,
        int requestedQty,
        int availableStock,
        double paymentAmount,
        double orderCost,
        boolean isExpired
    ) throws InventoryException, PaymentException {
        if (requestedQty <= 0) {
            throw new InvalidQuantityException(
                "Invalid quantity. Quantity must be greater than 0."
            );
        }
        if (requestedQty > availableStock) {
            throw new OutOfStockException(
                "Out of stock. Requested " + requestedQty +
                ", but only " + availableStock + " available."
            );
        }
        if (isExpired) {
            throw new PaymentExpiredException(
                "Payment method expired."
            );
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException(
                "Payment declined. Insufficient funds."
            );
        }
        System.out.println(
            "Order successful! " + requestedQty +
            " x " + itemName + " confirmed."
        );
    }
    public static void main(String[] args) {

    
        try {
            processOrder("Widget", 5, 2, 50.00, 50.00, false);
        }
        catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        catch (InventoryException e) {
            System.out.println("Inventory failed: " + e.getMessage());
        }
        catch (PaymentException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
        try {
            processOrder("Widget", -1, 10, 50.00, 50.00, false);
        }
        catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        catch (PaymentException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
      
        try {
            processOrder("Widget", 2, 10, 10.00, 50.00, false);
        }
        catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        catch (InventoryException e) {
            System.out.println("Inventory failed: " + e.getMessage());
        }

        // Test 4: Expired payment
        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, true);
        }
        catch (PaymentException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
        catch (InventoryException e) {
            System.out.println("Inventory failed: " + e.getMessage());
        }

        // Test 5: Successful order
        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, false);
        }
        catch (InventoryException e) {
            System.out.println("Inventory failed: " + e.getMessage());
        }
        catch (PaymentException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }
}

class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);
    }
}

class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}



class OutOfStockException extends InventoryException {
    public OutOfStockException(String message) {
        super(message);
    }
}

class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException(String message) {
        super(message);
    }
}


class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException(String message) {
        super(message);
    }
}

class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException(String message) {
        super(message);
    }
}
