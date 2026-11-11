import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class solution {
    public static void main(String[] args) {

        try {
            newOrder("Widget", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: (stock issue) " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        try {
            newOrder("Widget", -1, 10, 50.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        try {
            newOrder("Widget", 2, 10, 10.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        try {
            newOrder("Widget", 5, 10, 50.00, 50.00, true);
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        try {
            newOrder("Widget", 2, 10, 50.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // stretch goal: custom fields
        try {
            newOrderWithDetails("Widget", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException e) {
            int shortBy = e.getRequested() - e.getAvailable();
            System.out.println("Order failed: You're short by " + shortBy
                    + ". Try ordering " + e.getAvailable() + " instead.");
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // stretch goal: batch processing
        List<Order> batch = List.of(
                new Order("Widget", 2, 10, 50.00, 50.00, false),
                new Order("Gadget", 0, 5, 20.00, 20.00, false),
                new Order("Gizmo", 8, 3, 80.00, 80.00, false),
                new Order("Widget", 1, 10, 25.00, 25.00, true),
                new Order("Gadget", 3, 5, 10.00, 60.00, false),
                new Order("Gizmo", 1, 3, 15.00, 15.00, false),
                new Order("Widget", 20, 10, 200.00, 200.00, false)
        );
        processBatch(batch);
    }

    public static void newOrder(String itemName, int quantityRequested,
                                int stockAvailable, double paymentAmount,
                                double totalCost, boolean cardExpired)
            throws InventoryException, PaymentException {

        if (quantityRequested <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0.");
        }
        if (quantityRequested > stockAvailable) {
            throw new OutOfStockException("Out of stock. Requested " + quantityRequested + ", but only " + stockAvailable + " available.");
        }
        if (cardExpired) {
            throw new PaymentExpiredException("Payment method expired.");
        }
        if (paymentAmount < totalCost) {
            throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
        }

        // no need for an else since any other if branches would throw an exception and break
        System.out.println("Order successful! " + quantityRequested + " x " + itemName + " confirmed.");
    }

    // same as newOrder but throws OutOfStockException with the actual numbers
    public static void newOrderWithDetails(String itemName, int quantityRequested,
                                           int stockAvailable, double paymentAmount,
                                           double totalCost, boolean cardExpired)
            throws InventoryException, PaymentException {

        if (quantityRequested <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0.");
        }
        if (quantityRequested > stockAvailable) {
            throw new OutOfStockException(quantityRequested, stockAvailable);
        }
        if (cardExpired) {
            throw new PaymentExpiredException("Payment method expired.");
        }
        if (paymentAmount < totalCost) {
            throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
        }

        System.out.println("Order successful! " + quantityRequested + " x " + itemName + " confirmed.");
    }

    // runs every order even if some fail, then prints a summary
    public static void processBatch(List<Order> orders) {
        int succeeded = 0;
        int failed = 0;
        Map<String, Integer> failuresByType = new LinkedHashMap<>();

        System.out.println();
        System.out.println("--- Batch Processing ---");

        for (Order order : orders) {
            // try is inside the loop so one failure doesn't stop the rest
            try {
                newOrder(order.getItemName(), order.getQuantityRequested(),
                        order.getStockAvailable(), order.getPaymentAmount(),
                        order.getTotalCost(), order.isCardExpired());
                succeeded++;
            } catch (InventoryException | PaymentException e) {
                System.out.println("Order failed: " + e.getMessage());
                failed++;
                // count by the actual class name, like OutOfStockException
                String type = e.getClass().getSimpleName();
                failuresByType.put(type, failuresByType.getOrDefault(type, 0) + 1);
            }
        }

        System.out.println();
        System.out.println("--- Batch Summary ---");
        System.out.println("Total orders: " + orders.size());
        System.out.println("Succeeded: " + succeeded);
        System.out.println("Failed: " + failed);
        System.out.println("Failures by type:");
        for (Map.Entry<String, Integer> entry : failuresByType.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
}