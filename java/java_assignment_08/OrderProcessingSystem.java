
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

public class OrderProcessingSystem {
    
    public void processOrder(String item, int requestedQuantity, int availableStock, double paymentAmount, double orderCost, boolean isExpired) {
        try {
            if (requestedQuantity <= 0) {
                throw new InvalidQuantityException("Order failed: Invalid quantity. Quantity must be greater than 0.");
            }
            if (requestedQuantity > availableStock) {
                throw new OutOfStockException("Order failed: Out of stock. Requested 5, but only 2 available.");
            }
            if (paymentAmount < orderCost) {
                throw new PaymentDeclinedException("Order failed: Payment declined. Insufficient funds.");
            }
            if (isExpired) {
                throw new PaymentExpiredException("Order failed: Payment method expired.");
            }
            
            System.out.println("Order successful!" + requestedQuantity + "X " + item + " confirmed.");
        } catch (InventoryException | PaymentException e) {
            System.err.println("Error processing order: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        OrderProcessingSystem ops = new OrderProcessingSystem();
        
        ops.processOrder("Widget", 5, 2, 100.0, 50.0, false); 
        ops.processOrder("Widget", -1, 10, 100.0, 50.0, false); 
        ops.processOrder("Widget", 3, 5, 30.0, 50.0, false);
        ops.processOrder("Widget", 2, 5, 100.0, 50.0, true); 
        ops.processOrder("Widget", 2, 5, 100.0, 50.0, false);
    }
}
        