public class OrderSystem {

    public static void processOrder(String item, int quantity, int stock,
                                    double payment, double cost, boolean isExpired)
            throws InventoryException, PaymentException {

        if (quantity <= 0) {
            throw new InvalidQuantityException();
        }
        if (quantity > stock) {
            throw new OutOfStockException(quantity, stock);
        }

        if (isExpired) {
            throw new PaymentExpiredException();
        }
        if (payment < cost) {
            throw new PaymentDeclinedException();
        }

        System.out.println("Order successful: " + quantity + " x " + item);
    }

    public static void tryOrder(String item, int quantity, int stock,double payment, double cost, boolean isExpired) {
        try {
            processOrder(item, quantity, stock, payment, cost, isExpired);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: Out of stock. Requested " + e.getRequested()+ ", but only " + e.getAvailable() + " available.");
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        tryOrder("Widget", 5, 2, 50.00, 50.00, false);
        tryOrder("Widget", -1, 10, 50.00, 50.00, false);
        tryOrder("Widget", 2, 10, 10.00, 50.00, false);
        tryOrder("Widget", 2, 10, 50.00, 50.00, true);
        tryOrder("Widget", 2, 10, 50.00, 50.00, false);
    }
}