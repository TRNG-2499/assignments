import Exceptions.*;

public class ProcessOrder {
    static void main() {
        ProcessOrder instance = new ProcessOrder();

        /*
        Core test
         */
        System.out.println("Core Test\n-------------");
        // Invalid Quantity
        try {
            System.out.println(instance.processSingleOrder("carrot", 0, 10, 10, 10, false));
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Out of stock
        try {
            System.out.println(instance.processSingleOrder("carrot", 11, 10, 10, 10, false));
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Payment expired
        try {
            System.out.println(instance.processSingleOrder("carrot", 1, 10, 10, 10, true));
        } catch (PaymentExpiredException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Payment declined
        try {
            System.out.println(instance.processSingleOrder("carrot", 10, 10, 10, 100, false));
        } catch (PaymentDeclinedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Successful order
        try {
            System.out.println(instance.processSingleOrder("carrot", 10, 10, 10, 10, false));
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
        Stretch Test
         */
        System.out.println("\nStretch Test\n----------------");
        // Out of stock exception with custom field
        try {
            System.out.println(instance.processSingleOrderCustomField("carrot", 11, 10, 10, 10, false));
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
            System.out.println("Requested quantity: " + e.getRequested() + " Available quantity: " + e.getAvailable());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String processSingleOrder(
            String itemName, int quantity,
            int availableStock, int paymentAmount,
            int totalCost, boolean paymentExpired
    ) throws PaymentException, InventoryException {
        if (quantity <= 0) {
            throw new InvalidQuantityException();
        } else if (quantity > availableStock) {
            throw new OutOfStockException();
        } else if (paymentExpired) {
            throw new PaymentExpiredException();
        } else if (paymentAmount < totalCost) {
            throw new PaymentDeclinedException();
        }
        return "Successful Order! Item name: " + itemName + " Quantity ordered: " + quantity;
    }

    public String processSingleOrderCustomField(
            String itemName, int quantity,
            int availableStock, int paymentAmount,
            int totalCost, boolean paymentExpired
    ) throws PaymentException, InventoryException {
        if (quantity <= 0) {
            throw new InvalidQuantityException();
        } else if (quantity > availableStock) {
            throw new OutOfStockException(quantity, availableStock);
        } else if (paymentExpired) {
            throw new PaymentExpiredException();
        } else if (paymentAmount < totalCost) {
            throw new PaymentDeclinedException();
        }
        return "Successful Order! Item name: " + itemName + " Quantity ordered: " + quantity;
    }
}
