
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

class OutofStockException extends InventoryException {
    public OutofStockException(String message) {
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

public class Main {
    public static void main(String[] args) {
        try {
            processOrder("Widget", 5, 2, 50.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Widget", -1, 10, 50.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Widget", 2, 10, 10.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, true);
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processOrder(String item, int qty, int stock, double payment, double cost, boolean expiration) throws InventoryException, PaymentException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Order failed: Invalid quantity. Quantity must be greater than 0.");
        }
        if (qty > stock) {
            throw new OutofStockException("Order failed: Out of stock. Requested " + qty + ", but only " + stock + " available.");
        }

        if (expiration) {
            throw new PaymentExpiredException("Order failed: Payment method expired.");
        }
        if (payment < cost) {
            throw new PaymentDeclinedException("Order failed: Payment declined. Insufficient funds.");
        }

        System.out.println("Order successful! " + qty + " x " + item + " confirmed.");
    }
}
