import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Checkout {

    public static void main(String... args) {
        try {
            checkout("test", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: Out of stock. " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed: Inventory problem. " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: Payment problem. " + e.getMessage());
        }

        try {
            checkout("test", -1, 10, 50.00, 50.00, false);
        } catch (InvalidQuantityException e) {
            System.out.println("Order failed: Invalid quantity. " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed (payment): " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed (inventory): " + e.getMessage());
        }

        try {
            checkout("test", 2, 10, 10.00, 50.00, false);
        } catch (PaymentException e) {
            System.out.println("Order failed: Payment problem. " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed: Inventory problem. " + e.getMessage());
        }

        try {
            checkout("test", 2, 10, 50.00, 50.00, true);
        } catch (PaymentExpiredException e) {
            System.out.println("Order failed: Payment method expired. " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: Payment problem. " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed: Inventory problem. " + e.getMessage());
        }

        try {
            checkout("test", 2, 10, 50.00, 50.00, false);
        } catch (InventoryException | PaymentException e) {
            System.out.println("Unexpected failure: " + e.getMessage());
        }

        try {
            checkoutWithDetails("test", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException e) {
            // Built from the fields, not the message string
            System.out.println("Order failed: Out of stock. You asked for " + e.getRequested()
                    + " but we only have " + e.getAvailable()
                    + " (short by " + e.getShortfall() + ").");
        } catch (InventoryException e) {
            System.out.println("Order failed: Inventory problem. " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: Payment problem. " + e.getMessage());
        }

        System.out.println("\n--- Batch demo ---");
        List<Order> batch = new ArrayList<>();
        batch.add(new Order("test", 2, 10, 50.00, 50.00, false));   // success
        batch.add(new Order("test", 5, 2, 50.00, 50.00, false));    // out of stock
        batch.add(new Order("test", -1, 10, 50.00, 50.00, false));  // invalid quantity
        batch.add(new Order("test", 2, 10, 10.00, 50.00, false));   // declined
        batch.add(new Order("test", 2, 10, 50.00, 50.00, true));    // expired
        batch.add(new Order("test", 3, 10, 75.00, 75.00, false));   // success
        batch.add(new Order("test", 9, 4, 50.00, 50.00, false));    // out of stock
        processBatch(batch);
    }

    public static void checkout(String item, int quantity, int availableStock, 
                    double paymentAmount, double totalCost, boolean isExpired)
                    throws InventoryException, PaymentException{
        
        //Inventory rules
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than 0.");
        }
        if (quantity > availableStock) {
            throw new OutOfStockException("Requested " + quantity + ", but only " + availableStock + " available.");
        }

        //Payment rules
        if (isExpired) {
            throw new PaymentExpiredException("Payment method is expired.");
        }
        if (paymentAmount < totalCost) {
            throw new PaymentDeclinedException("Insufficient funds. Payment of $"
                    + String.format("%.2f", paymentAmount) + " is less than total of $"
                    + String.format("%.2f", totalCost) + ".");
        }

        System.out.println("Order successful! " + quantity + " x " + item + " confirmed.");
    }
    public static void checkoutWithDetails(String item, int quantity, int availableStock,
                    double paymentAmount, double totalCost, boolean isExpired)
                    throws InventoryException, PaymentException {

    if (quantity > 0 && quantity > availableStock) {
        throw new OutOfStockException(quantity, availableStock);
    }
    checkout(item, quantity, availableStock, paymentAmount, totalCost, isExpired);
    }

    public static void processBatch(List<Order> orders) {
        int successes = 0;
        int failures = 0;
        Map<String, Integer> failuresByType = new LinkedHashMap<>();

        for (Order o : orders) {
            try {
                checkout(o.item, o.quantity, o.availableStock,
                        o.paymentAmount, o.totalCost, o.isExpired);
                successes++;
            } catch (InventoryException | PaymentException e) {
                failures++;
                System.out.println("Order failed (" + e.getClass().getSimpleName() + "): " + e.getMessage());
                failuresByType.merge(e.getClass().getSimpleName(), 1, Integer::sum);
            }
        }

        System.out.println("\n===== Batch Summary =====");
        System.out.println("Total orders: " + orders.size());
        System.out.println("Succeeded:    " + successes);
        System.out.println("Failed:       " + failures);
        if (!failuresByType.isEmpty()) {
            System.out.println("Failures by type:");
            for (Map.Entry<String, Integer> entry : failuresByType.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    public static class InventoryException extends Exception {
        public InventoryException() { super(); }
        public InventoryException(String message) {super(message); }
    }
    public static class PaymentException extends Exception {
        public PaymentException() { super(); }
        public PaymentException(String message) { super(message); }
    }
    public static class OutOfStockException extends InventoryException {
        private final int requested;
        private final int available;

        public OutOfStockException() { super(); requested = 0; available = 0; }
        public OutOfStockException(String message) { super(message); requested = 0; available = 0; }

        public OutOfStockException(int requested, int available) {
            super("Requested " + requested + ", but only " + available + " available.");
            this.requested = requested;
            this.available = available;
        }

        public int getRequested() { return requested; }
        public int getAvailable() { return available; }
        public int getShortfall() { return requested - available; }
    }
    public static class InvalidQuantityException extends InventoryException {
        public InvalidQuantityException() { super(); }
        public InvalidQuantityException(String message) { super(message); }
    }
    public static class PaymentDeclinedException extends PaymentException {
        public PaymentDeclinedException() { super(); }
        public PaymentDeclinedException(String message) { super(message); }
    }
    public static class PaymentExpiredException extends PaymentException {
        public PaymentExpiredException() { super(); }
        public PaymentExpiredException(String message) { super(message); }
    }

    public static class Order {
        final String item;
        final int quantity;
        final int availableStock;
        final double paymentAmount;
        final double totalCost;
        final boolean isExpired;

        Order(String item, int quantity, int availableStock,
            double paymentAmount, double totalCost, boolean isExpired) {
            this.item = item;
            this.quantity = quantity;
            this.availableStock = availableStock;
            this.paymentAmount = paymentAmount;
            this.totalCost = totalCost;
            this.isExpired = isExpired;
        }
    }
}