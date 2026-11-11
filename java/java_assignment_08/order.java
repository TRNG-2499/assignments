package java_assignment_08;

import java.util.*;

class InventoryException extends Exception {
    InventoryException(String message) {
        super(message);
    }
}

class OutOfStockException extends InventoryException {
    OutOfStockException(int requestedQty, int availableStock) {
        super("Order failed: Out of stock. Requested " + requestedQty + ", but only " + availableStock + " available.");
    }
}

class InvalidQuantityException extends InventoryException {
    InvalidQuantityException() {
        super("Order failed: Invalid quantity. Quantity must be greater than 0.");
    }

}

class PaymentException extends Exception {
    PaymentException(String message) {
        super(message);
    }
}

class PaymentDeclinedException extends PaymentException {
    PaymentDeclinedException(double payment, double cost) {
        super("Order failed: Payment declined. Insufficient funds. Please insert $"
                + Math.abs((cost - payment)) + " more.");
    }
}

class PaymentExpiredException extends PaymentException {
    PaymentExpiredException() {
        super("Order failed: Payment method expired.");
    }

}

public class order {

    public static void main(String[] args) {
        System.out.println("Order processing program running.....");
        Scanner scanner = new Scanner(System.in);

        // Below is the code to take user input for order details
        // System.out.print("Enter item name: ");
        // String item = scanner.nextLine();
        // System.out.print("Enter requested quantity: ");
        // int requestedQty = scanner.nextInt();
        // System.out.print("Enter available stock: ");
        // int availableStock = scanner.nextInt();
        // System.out.print("Enter payment amount: ");
        // double paymentAmount = scanner.nextDouble();
        // System.out.print("Enter order cost: ");
        // double orderCost = scanner.nextDouble();
        // System.out.print("Is payment expired (true/false): ");
        // boolean isExpired = scanner.nextBoolean();
        // processOrder(item, requestedQty, availableStock, paymentAmount, orderCost,
        // isExpired);

        // // this is manual input for testing
        processOrder("Widget", 5, 2, 50.00, 50.00, false); // out of stock
        processOrder("Widget", -1, 10, 50.00, 50.00, false); // invalid quantity
        processOrder("Widget", 2, 10, 10.00, 50.00, false); // invalid payment
        processOrder("Widget", 2, 10, 50.00, 50.00, true); // expired payment
        processOrder("Widget", 2, 10, 50.00, 50.00, false); // success

        // This is batch processing
        // String[][] orders = {
        // { "Widget", "5", "2", "50.00", "50.00", "false" },
        // { "Widget", "-1", "10", "50.00", "50.00", "false" },
        // { "Widget", "2", "10", "10.00", "50.00", "false" },
        // { "Widget", "2", "10", "50.00", "50.00", "true" },
        // { "Widget", "2", "10", "50.00", "50.00", "false" }
        // };
        // batchProcess(orders);

        scanner.close();
    }

    public static void processOrder(String item, int requestedQty, int availableStock, double paymentAmount,
            double orderCost,
            boolean isExpired) {

        try {
            check(item, requestedQty, availableStock, paymentAmount, orderCost, isExpired);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        } catch (PaymentDeclinedException e) {
            System.out.println(e.getMessage());
        } catch (PaymentExpiredException e) {
            System.out.println(e.getMessage());
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void check(String item, int requestedQty, int availableStock, double paymentAmount, double orderCost,
            boolean isExpired) throws InventoryException, PaymentException {
        if (requestedQty > availableStock) {
            throw new OutOfStockException(requestedQty, availableStock);
        }
        if (requestedQty <= 0) {
            throw new InvalidQuantityException();
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException(paymentAmount, orderCost);
        }
        if (isExpired) {
            throw new PaymentExpiredException();
        }
        System.out.println("Order processed successfully");

    }

    public static int batchProcessOrder(String item, int requestedQty, int availableStock, double paymentAmount,
            double orderCost,
            boolean isExpired) {

        try {
            return batchCheck(item, requestedQty, availableStock, paymentAmount, orderCost, isExpired);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        } catch (PaymentDeclinedException e) {
            System.out.println(e.getMessage());
        } catch (PaymentExpiredException e) {
            System.out.println(e.getMessage());
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        }
        return 0;

    }

    public static int batchCheck(String item, int requestedQty, int availableStock, double paymentAmount,
            double orderCost,
            boolean isExpired) throws InventoryException, PaymentException {
        if (requestedQty > availableStock) {
            throw new OutOfStockException(requestedQty, availableStock);
        }
        if (requestedQty <= 0) {
            throw new InvalidQuantityException();
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException(paymentAmount, orderCost);
        }
        if (isExpired) {
            throw new PaymentExpiredException();
        }
        System.out.println("Order processed successfully");
        return 1;

    }

    public static void batchProcess(String[][] orders) {
        int count = 0;
        for (String[] order : orders) {
            String item = order[0];
            int requestedQty = Integer.parseInt(order[1]);
            int availableStock = Integer.parseInt(order[2]);
            double paymentAmount = Double.parseDouble(order[3]);
            double orderCost = Double.parseDouble(order[4]);
            boolean isExpired = Boolean.parseBoolean(order[5]);
            count += batchProcessOrder(item, requestedQty, availableStock, paymentAmount, orderCost, isExpired);
        }
        System.out.println("Total successful orders: " + count);
        System.out.println("Total failed orders: " + (orders.length - count));
    }

}
