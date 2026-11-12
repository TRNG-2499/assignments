


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



class OutOfStockException extends InventoryException {

    private int requestedQuantity;
    private int availableQuantity;

    public OutOfStockException(int requestedQuantity, int availableQuantity) {
        super("Out of stock. Requested " + requestedQuantity + ", but only " + availableQuantity + " available.");

        this.requestedQuantity = requestedQuantity;
        this.availableQuantity = availableQuantity;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }
}

class InvalidQuantityException extends InventoryException {

    public InvalidQuantityException() {
        super("Order failed: Invalid quantity. Quantity must be greater than 0.");
    }
}


class PaymentDeclinedException extends PaymentException {

    public PaymentDeclinedException() {
        super("Order failed: Payment declined. Insufficient funds.");
    }
}

class PaymentExpiredException extends PaymentException {

    public PaymentExpiredException() {
        super("Order failed: Payment method expired.");
    }
}


public class orderProcessingSystem {

    // Original order-processing method
    public static void processOrder(
            String itemName,
            int requestedQuantity,
            int availableStock,
            double paymentAmount,
            double orderCost,
            boolean isExpired
    ) throws InventoryException, PaymentException {


        if (requestedQuantity <= 0) {
            throw new InvalidQuantityException();
        }

        if (requestedQuantity > availableStock) {
            throw new OutOfStockException(requestedQuantity, availableStock);
        }


        if (isExpired) {
            throw new PaymentExpiredException();
        }

        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException();
        }


        System.out.println("Order successful! " + requestedQuantity + " x " + itemName + " confirmed.");
    }




    public static void main(String[] args) {

        try {
            processOrder("Widget", 5, 2, 50.00, 50.00, false);

        } catch (OutOfStockException e) {

            System.out.println("Order failed: " + e.getMessage());
            System.out.println("Requested quantity: " + e.getRequestedQuantity());
            System.out.println("Available quantity: " + e.getAvailableQuantity());

        } catch (InventoryException | PaymentException e) {

            System.out.println(e.getMessage());
        }


        try {
            processOrder("Widget", -1, 10, 50.00, 50.00, false);

        } catch (InventoryException | PaymentException e) {

            System.out.println(e.getMessage());
        }


        try {
            processOrder("Widget", 2, 10, 10.00, 50.00, false);

        } catch (PaymentException e) {

            System.out.println(e.getMessage());

        } catch (InventoryException e) {

            System.out.println(e.getMessage());
        }


        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, true);

        } catch (PaymentException e) {

            System.out.println(e.getMessage());

        } catch (InventoryException e) {

            System.out.println(e.getMessage());
        }


        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, false);

        } catch (InventoryException | PaymentException e) {

            System.out.println(e.getMessage());
        }
    }

}
