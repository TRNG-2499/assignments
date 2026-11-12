package assignments.java.java_assignment_08;

import java.util.ArrayList;

import assignments.java.java_assignment_08.exceptions.InvalidQuantityException;
import assignments.java.java_assignment_08.exceptions.InventoryException;
import assignments.java.java_assignment_08.exceptions.OutOfStockException;
import assignments.java.java_assignment_08.exceptions.PaymentDeclinedException;
import assignments.java.java_assignment_08.exceptions.PaymentException;
import assignments.java.java_assignment_08.exceptions.PaymentExpiredException;

public class OrderProcessor {

    public void processOrder(Order order) throws InventoryException, PaymentException {

        if (validateInventory(order.getQuantity(), order.getStock())
                && validatePayment(order.getPaymentAmount(), order.getCostAmount(), order.isExpired())) {

            System.out.println("Success, " + order.getQuantity()
                    + " - " + order.getItemName() + " have been ordered");
        }
    }

    private boolean validateInventory(int quantity,
            int stock) throws InventoryException {
        if (quantity <= 0) {
            throw new InvalidQuantityException(quantity);
        }
        if (quantity > stock) {
            throw new OutOfStockException(quantity, stock);
        }
        return true;
    }

    private boolean validatePayment(float paymentAmount, float costAmount, boolean isExpired) throws PaymentException {
        if (isExpired) {
            throw new PaymentExpiredException();
        }
        if (paymentAmount < costAmount) {
            throw new PaymentDeclinedException(paymentAmount, costAmount);
        }
        return true;
    }

    public void processBatch(ArrayList<Order> orders) throws InventoryException, PaymentException {

        int successful = 0;
        int failed = 0;

        int outOfStock = 0;
        int invalidQuantity = 0;
        int paymentDeclined = 0;
        int paymentExpired = 0;

        for (Order order : orders) {

            try {
                processOrder(order);
                successful++;

            } catch (OutOfStockException e) {
                outOfStock++;
                failed++;
                System.out.println(e.getMessage());

            } catch (InvalidQuantityException e) {
                invalidQuantity++;
                failed++;
                System.out.println(e.getMessage());

            } catch (PaymentDeclinedException e) {
                paymentDeclined++;
                failed++;
                System.out.println(e.getMessage());

            } catch (PaymentExpiredException e) {
                paymentExpired++;
                failed++;
                System.out.println(e.getMessage());
            }
        }

        System.out.printf("""
                ***** Batch *****
                Total Orders: %d
                Successful: %d
                Failed: %d

                ***** Failures *****
                Out of Stock: %d
                Invalid Quantity: %d
                Payment Declined: %d
                Payment Expired: %d
                """,
                orders.size(),
                successful,
                failed,
                outOfStock,
                invalidQuantity,
                paymentDeclined,
                paymentExpired);
    }
}