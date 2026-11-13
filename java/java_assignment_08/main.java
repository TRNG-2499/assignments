public class Main {


    /// a simple order object to test exceptions with
    static class Order {
        private final String itemName;
        private final int requestedQty, availableQty;
        private final double paymentAmt, totalAmt;
        private final boolean isExpired;

        Order(String itemName, int requestedQty, int availableQty,
              double paymentAmt, double totalAmt, boolean isExpired) {
            this.itemName = itemName;
            this.requestedQty = requestedQty;
            this.availableQty = availableQty;
            this.paymentAmt = paymentAmt;
            this.totalAmt = totalAmt;
            this.isExpired = isExpired;
        }
    }

    public static void processOrder(String itemName, int requestedQty, int availableQty,
                                    double paymentAmt, double totalAmt, boolean isExpired)
            throws InventoryException, PaymentException {
        if (requestedQty <= 0) {
            throw new InvalidQuantityException(requestedQty);
        }
        if (requestedQty > availableQty) {
            throw new OutOfStockException(requestedQty, availableQty);
        }
        if (isExpired) {
            throw new PaymentExpiredException();
        }
        if (paymentAmt < totalAmt) {
            throw new PaymentDeclinedException(paymentAmt, totalAmt);
        }

        System.out.printf("Order successful! %d x %s confirmed.%n", requestedQty, itemName);
    }

    public static void runOrder(Order order) {
        try {
            processOrder(order.itemName, order.requestedQty, order.availableQty,
                    order.paymentAmt, order.totalAmt, order.isExpired);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: Out of stock. " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        runOrder(new Order("Widget", 5, 2, 50.00, 50.00, false));
        runOrder(new Order("Widget", -1, 10, 50.00, 50.00, false));
        runOrder(new Order("Widget", 2, 10, 10.00, 50.00, false));
        runOrder(new Order("Widget", 2, 10, 50.00, 50.00, true));
        runOrder(new Order("Widget", 2, 10, 50.00, 50.00, false));
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
    OutOfStockException(int requestedQty, int availableQty) {
        super("Requested " + requestedQty + ", but only " + availableQty + " available.");
    }
}

class InvalidQuantityException extends InventoryException {
    InvalidQuantityException(int requestedQty) {
        super("Invalid quantity. Expected a quantity greater than 0, but got "
                + requestedQty + ".");
    }
}

class PaymentDeclinedException extends PaymentException {
    PaymentDeclinedException(double paymentAmt, double totalAmt) {
        super(String.format(
                "Payment declined. Received $%.2f for a $%.2f order. Short by $%.2f.",
                paymentAmt, totalAmt, totalAmt - paymentAmt));
    }
}

class PaymentExpiredException extends PaymentException {
    PaymentExpiredException() {
        super("Payment method expired.");
    }
}