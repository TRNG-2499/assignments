public class OrderProcessor {
    public static void main(String[] args) {
        try {
            //processOrder("Widget", 5, 2, 50.00, 50.00, false);
            processOrder("Widget", -1, 10, 50.00, 50.00, false);
            processOrder("Widget", 2, 10, 10.00, 50.00, false);
            processOrder("Widget", 2, 10, 50.00, 50.00, true);
            processOrder("Widget", 2, 10, 50.00, 50.00, false);
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order violated inventory. (" + e.getMessage() + ")");
        } catch (PaymentExpiredException e) {
            System.out.println(e.getMessage());
        } catch (PaymentDeclinedException e) {
            System.out.println(e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment failed. (" + e.getMessage() + ")");
        }
    }

    private static void processOrder(
            String item, int requested, int available,
            double payment, double totalCost, boolean expired) throws InventoryException, PaymentException {

        if (requested <= 0) throw new InvalidQuantityException();
        if (requested > available) throw new OutOfStockException(requested, available);
        if (expired) throw new PaymentExpiredException();
        if (payment < totalCost) throw new PaymentDeclinedException();

        System.out.println("Order confirmed successfully: " + requested + "x " + item + ".");
    }
}
