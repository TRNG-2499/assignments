class InventoryException extends Exception {
    public InventoryException(String message) {
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

class PaymentException extends Exception {
    public PaymentException(String message) {
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

public class OrderProcessor {

    public static String processOrder(String item, int quantity, int stock,
                                      double payment, double cost, boolean isExpired)
            throws InventoryException, PaymentException {

        if (quantity < 1) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0.");
        }

        if (stock < quantity) {
            throw new OutOfStockException("Out of stock. Requested " + quantity + ", but only " + stock + " available.");
        }

        if (isExpired) {
            throw new PaymentExpiredException("Payment method expired.");
        }

        if (payment < cost) {
            throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
        }

        return "Order successful! " + quantity + " x " + item + " confirmed.";
    }

    public static void main(String[] args) {
        try {
            System.out.println(processOrder("Widget", 5, 2, 50.00, 50.00, false));
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage() + " Please order fewer items.");
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        try {
            System.out.println(processOrder("Widget", -1, 10, 50.00, 50.00, false));
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        try {
            System.out.println(processOrder("Widget", 2, 10, 10.00, 50.00, false));
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        try {
            System.out.println(processOrder("Widget", 2, 10, 50.00, 50.00, true));
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        try {
            System.out.println(processOrder("Widget", 2, 10, 50.00, 50.00, false));
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }
}
