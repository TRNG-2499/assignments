package assignments.java.java_assignment_08;

import java.util.ArrayList;

import assignments.java.java_assignment_08.exceptions.InvalidQuantityException;
import assignments.java.java_assignment_08.exceptions.InventoryException;
import assignments.java.java_assignment_08.exceptions.OutOfStockException;
import assignments.java.java_assignment_08.exceptions.PaymentException;

public class EntryPoint08 {

    private static OrderProcessor processor = new OrderProcessor();

    public static void main(String[] args) throws InventoryException, PaymentException {

        // Create test orders
        ArrayList<Order> orders = new ArrayList<>();

        orders.add(new Order("Widget", 5, 2, 50, 50, false));  // Stock check
        orders.add(new Order("Widget", -1, 10, 50, 50, false)); // Invalid quantity
        orders.add(new Order("Widget", 2, 10, 10, 50, false));  // Payment declined
        orders.add(new Order("Widget", 2, 10, 50, 50, true));   // Payment expired
        orders.add(new Order("Widget", 2, 10, 50, 50, false));  // Successful order

        // Original assignment tests
        for (Order order : orders) {
            testOrder(order);
        }

        // Stretch goal 1: Custom exception fields
        // Handled in testOrder()

        // Stretch goal 2: Batch processing
        processor.processBatch(orders);
    }

    private static void testOrder(Order order) {

        try {
            processor.processOrder(order);

        } catch (OutOfStockException e) {
            System.out.println(
                    "Out of stock - Requested " + e.getQuantity()
                            + " but only " + e.getStock() + " available.");

        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());

        } catch (InventoryException e) {
            System.out.println(e.getMessage());

        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        }
    }
}