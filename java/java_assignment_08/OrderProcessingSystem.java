public class OrderProcessingSystem {

    public static void processOrder(String item, int quantity, int stock, double paymentAmount, double totalCost, boolean isExpired) throws InventoryException, PaymentException {
        if (quantity <= 0) {
            System.out.println("Order failed: Invalid quantity. Quantity must be greater than 0.");
            throw new InvalidQuantityException();
        }

        if (quantity > stock) {
            System.out.printf("Order failed: Out of stock. Requested %d, but only %d available%n", quantity, stock);
            throw new OutOfStockException();
        }

        if (isExpired == true) {
            System.out.println("Order failed: Payment method expired.");
            throw new PaymentExpiredException();
        }

        if (paymentAmount < totalCost) {
            System.out.println("Order failed: Payment declined. Insufficient funds.");
            throw new PaymentDeclinedException();
        }

        System.out.printf("Order successful! %d x %s confirmed.%n", quantity, item);
    }


    public static void driver(String item, int quantity, int stock, double paymentAmount, double totalCost, boolean isExpired) {
        try {
            processOrder(item, quantity, stock, paymentAmount, totalCost, isExpired);

        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());

        } catch (InvalidQuantityException e)  {
            System.out.println(e.getMessage());

        } catch (InventoryException e) {
            System.out.println("Inventory issue");

        } catch (PaymentExpiredException e) {
            System.out.println(e.getMessage());

        } catch (PaymentDeclinedException e) {
            System.out.println(e.getMessage());

        } catch (PaymentException e) {
            System.out.println("Payment issue");
        }
    }


    public static void main(String[] args) {
        driver("computer", 2, 1, 2000, 2000, false);

        System.out.println("");

        driver("computer", 1, 2, 2000, 2000, true);

        System.out.println("");

        driver("computer", -1, 10, 2000, 2000, false);

        System.out.println("");

        driver("computer", 2, 10, 1000, 2000, false);

        System.out.println("");

        driver("computer", 2, 10, 2000, 2000, false);
    }
}
