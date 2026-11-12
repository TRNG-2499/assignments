import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderProcessingSystem {

    // ---------- Base activity ----------
    // Validates inventory rules first, then payment rules. Each failed rule
    // throws its own specific exception; if everything passes, the order is
    // confirmed.
    public static void processOrder(String item, int requestedQty, int availableStock,
                                    double paymentAmount, double orderCost, boolean isExpired)
            throws InventoryException, PaymentException {
        // Inventory rules
        if (requestedQty <= 0) {
            throw new InvalidQuantityException(requestedQty);
        }
        if (requestedQty > availableStock) {
            throw new OutOfStockException(item, requestedQty, availableStock);
        }

        // Payment rules
        if (isExpired) {
            throw new PaymentExpiredException();
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException(paymentAmount, orderCost);
        }

        System.out.println("Order successful! " + requestedQty + " x " + item + " confirmed.");
    }

    // ---------- Stretch 2: Batch Order Processing with a Summary Report ----------
    // Runs every order through processOrder. A failure is recorded and the loop
    // moves on to the next order instead of stopping the batch. Afterwards a
    // summary shows successes, failures, and failures grouped by exception type.
    public static void processBatch(List<Order> orders) {
        int succeeded = 0;
        int failed = 0;
        Map<String, Integer> failuresByType = new LinkedHashMap<>();

        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            System.out.print("Order #" + (i + 1) + ": ");
            try {
                processOrder(o.item(), o.requestedQty(), o.availableStock(),
                        o.paymentAmount(), o.orderCost(), o.isExpired());
                succeeded++;
            } catch (InventoryException | PaymentException e) {
                failed++;
                System.out.println("Order failed: " + e.getMessage());
                failuresByType.merge(e.getClass().getSimpleName(), 1, Integer::sum);
            }
        }

        System.out.println("\n----- Batch Summary -----");
        System.out.println("Total orders: " + orders.size());
        System.out.println("Succeeded:    " + succeeded);
        System.out.println("Failed:       " + failed);
        if (!failuresByType.isEmpty()) {
            System.out.println("Failures by type:");
            failuresByType.forEach((type, count) -> System.out.println("  " + type + ": " + count));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Base activity: catching specific subclasses ===");
        // Each specific subclass is caught before its parent type.
        Object[][] orders = {
                { "Widget", 5, 2, 50.00, 50.00, false },   // OutOfStockException
                { "Widget", -1, 10, 50.00, 50.00, false }, // InvalidQuantityException
                { "Widget", 2, 10, 10.00, 50.00, false },  // PaymentDeclinedException
                { "Widget", 2, 10, 50.00, 50.00, true },   // PaymentExpiredException
                { "Widget", 2, 10, 50.00, 50.00, false },  // success
        };
        for (Object[] o : orders) {
            try {
                processOrder((String) o[0], (int) o[1], (int) o[2],
                        (double) o[3], (double) o[4], (boolean) o[5]);
            } catch (OutOfStockException e) {
                // Specific catch. Stretch 1: message built from the exception's fields.
                System.out.println("Order failed: Out of stock. Requested " + e.getRequestedQty()
                        + ", but only " + e.getAvailableStock() + " available.");
            } catch (InvalidQuantityException e) {
                System.out.println("Order failed: " + e.getMessage());
            } catch (PaymentExpiredException e) {
                System.out.println("Order failed: " + e.getMessage());
            } catch (PaymentDeclinedException e) {
                System.out.println("Order failed: " + e.getMessage());
            } catch (InventoryException e) {
                System.out.println("Order failed (inventory problem): " + e.getMessage());
            } catch (PaymentException e) {
                System.out.println("Order failed (payment problem): " + e.getMessage());
            }
        }

        System.out.println("\n=== Base activity: catching broader parent types ===");
        // Only the parent types are caught here, so any subclass is handled generically.
        Object[][] genericOrders = {
                { "Gadget", 0, 5, 20.00, 20.00, false },   // InvalidQuantityException -> InventoryException
                { "Gadget", 9, 5, 20.00, 20.00, false },   // OutOfStockException      -> InventoryException
                { "Gadget", 1, 5, 20.00, 20.00, true },    // PaymentExpiredException  -> PaymentException
                { "Gadget", 1, 5, 5.00, 20.00, false },    // PaymentDeclinedException -> PaymentException
        };
        for (Object[] o : genericOrders) {
            try {
                processOrder((String) o[0], (int) o[1], (int) o[2],
                        (double) o[3], (double) o[4], (boolean) o[5]);
            } catch (InventoryException e) {
                System.out.println("Inventory problem (" + e.getClass().getSimpleName() + "): "
                        + e.getMessage());
            } catch (PaymentException e) {
                System.out.println("Payment problem (" + e.getClass().getSimpleName() + "): "
                        + e.getMessage());
            }
        }

        System.out.println("\n=== Stretch 1: Custom Fields on Exceptions ===");
        try {
            processOrder("Gizmo", 3, 10, 12.50, 30.00, false);
        } catch (PaymentDeclinedException e) {
            System.out.printf("Order failed: Paid $%.2f of $%.2f, short by $%.2f.%n",
                    e.getPaymentAmount(), e.getOrderCost(), e.getShortfall());
        } catch (InventoryException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        try {
            processOrder("Gizmo", 12, 4, 30.00, 30.00, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: Only " + e.getAvailableStock() + " " + e.getItem()
                    + "(s) left; " + (e.getRequestedQty() - e.getAvailableStock())
                    + " more than available were requested.");
        } catch (InventoryException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        System.out.println("\n=== Stretch 2: Batch Order Processing ===");
        processBatch(List.of(
                new Order("Widget", 2, 10, 50.00, 50.00, false),
                new Order("Widget", 5, 2, 50.00, 50.00, false),
                new Order("Gadget", 0, 10, 50.00, 50.00, false),
                new Order("Gadget", 1, 1, 15.00, 15.00, false),
                new Order("Gizmo", 2, 10, 10.00, 50.00, false),
                new Order("Gizmo", 2, 10, 50.00, 50.00, true),
                new Order("Doohickey", 7, 3, 70.00, 70.00, false)
        ));
    }
}

// A single simulated order, used by the batch processor.
record Order(String item, int requestedQty, int availableStock,
             double paymentAmount, double orderCost, boolean isExpired) {
}

// ---------- Top-level exceptions ----------
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

// ---------- Inventory subclasses ----------
// Stretch 1: carries the item, requested quantity, and available stock.
class OutOfStockException extends InventoryException {
    private final String item;
    private final int requestedQty;
    private final int availableStock;

    public OutOfStockException(String item, int requestedQty, int availableStock) {
        super("Out of stock. Requested " + requestedQty + ", but only " + availableStock + " available.");
        this.item = item;
        this.requestedQty = requestedQty;
        this.availableStock = availableStock;
    }

    public String getItem() {
        return item;
    }

    public int getRequestedQty() {
        return requestedQty;
    }

    public int getAvailableStock() {
        return availableStock;
    }
}

class InvalidQuantityException extends InventoryException {
    private final int requestedQty;

    public InvalidQuantityException(int requestedQty) {
        super("Invalid quantity. Quantity must be greater than 0.");
        this.requestedQty = requestedQty;
    }

    public int getRequestedQty() {
        return requestedQty;
    }
}

// ---------- Payment subclasses ----------
// Stretch 1: carries the payment amount and order cost.
class PaymentDeclinedException extends PaymentException {
    private final double paymentAmount;
    private final double orderCost;

    public PaymentDeclinedException(double paymentAmount, double orderCost) {
        super("Payment declined. Insufficient funds.");
        this.paymentAmount = paymentAmount;
        this.orderCost = orderCost;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public double getShortfall() {
        return orderCost - paymentAmount;
    }
}

class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException() {
        super("Payment method expired.");
    }
}
