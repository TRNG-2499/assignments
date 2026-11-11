package com.revature;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    // stretch goal 2
    // a record is a short way to write a class that just holds values; Java creates the
    // constructor and getters (order.item(), order.quantity(), ...) automatically
    public record Order(String item, int quantity, int availableStock, double paymentAmount, double orderCost,
            boolean isExpired) {
    }

    public static void main(String[] args) {

        // one order for each outcome, in the same order as the assignment's examples
        placeOrder("Widget", 5, 2, 50.00, 50.00, false);   // out of stock
        placeOrder("Widget", -1, 10, 50.00, 50.00, false); // invalid quantity
        placeOrder("Widget", 2, 10, 10.00, 50.00, false);  // payment declined
        placeOrder("Widget", 2, 10, 50.00, 50.00, true);   // payment expired
        placeOrder("Widget", 2, 10, 50.00, 50.00, false);  // successful

        System.out.println();
        System.out.println("-----Stretch Goal 2-----");
        // stretch goal 2
        List<Order> orders = List.of(
                new Order("Widget", 2, 10, 50.00, 50.00, false),
                new Order("Gadget", 8, 3, 80.00, 80.00, false),
                new Order("Gizmo", 0, 5, 20.00, 20.00, false),
                new Order("Widget", 1, 10, 5.00, 25.00, false),
                new Order("Gadget", 1, 3, 10.00, 10.00, true),
                new Order("Gizmo", 3, 5, 60.00, 60.00, false),
                new Order("Widget", 20, 10, 100.00, 100.00, false));
        processBatch(orders);
    }

    // normal solution
    public static void processOrder(String item, int quantity, int availableStock, double paymentAmount,
            double orderCost, boolean isExpired) throws InventoryException, PaymentException {
        // inventory is checked first, so an order with both problems reports the stock problem
        if (quantity <= 0) {
            throw new InvalidQuantityException();
        }
        if (quantity > availableStock) {
            throw new OutOfStockException(quantity, availableStock);
        }

        if (isExpired) {
            throw new PaymentExpiredException();
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException();
        }

        System.out.println("Order successful! " + quantity + " x " + item + " confirmed.");
    }

    public static void placeOrder(String item, int quantity, int availableStock, double paymentAmount,
            double orderCost, boolean isExpired) {
        try {
            processOrder(item, quantity, availableStock, paymentAmount, orderCost, isExpired);
        } catch (OutOfStockException e) {
            // specific catch: tailored message
            // stretch goal 1: built from the exception's fields instead of its message
            int shortBy = e.getRequestedQuantity() - e.getAvailableStock();
            System.out.println("Order failed: Out of stock. Requested " + e.getRequestedQuantity() + ", but only "
                    + e.getAvailableStock() + " available (short by " + shortBy + ").");
        } catch (InventoryException e) {
            // parent catch: handles any other inventory problem generically
            // must come after OutOfStockException, or Java won't compile because the subclass catch could never run
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            // parent catch: handles both payment problems the same way
            System.out.println("Order failed: " + e.getMessage());
        }
    }

    // stretch goal 2
    public static void processBatch(List<Order> orders) {
        int succeeded = 0;
        int failed = 0;

        Map<String, Integer> failuresByType = new LinkedHashMap<>();

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.print("Order " + (i + 1) + ": ");
            // the try is inside the loop, so a failed order only ends that order, not the whole batch
            try {
                processOrder(order.item(), order.quantity(), order.availableStock(), order.paymentAmount(),
                        order.orderCost(), order.isExpired());
                succeeded++;
            } catch (InventoryException | PaymentException e) {
                System.out.println("Order failed: " + e.getMessage());
                failed++;
                // getSimpleName gives the exception's class name, like "OutOfStockException"
                String type = e.getClass().getSimpleName();
                failuresByType.put(type, failuresByType.getOrDefault(type, 0) + 1);
            }
        }

        System.out.println();
        System.out.println("Summary: " + succeeded + " succeeded, " + failed + " failed");
        for (String type : failuresByType.keySet()) {
            System.out.println("  " + type + ": " + failuresByType.get(type));
        }
    }
}
