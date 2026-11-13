package OrderingPack;

public class OrderProcessingSystem {

    public static void main(String[] args) {
        try {
            orderProcessingSystem("candles", 3, 4, 30,30,false );
        } catch (Exception e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }

    public static void orderProcessingSystem(String item, int requestedQuantity, int stock, int payment, int cost, boolean expired) throws InventoryException, PaymentException {
        if (requestedQuantity <= 0){
            throw new InvalidQuantityException("zero or negative quantity of an item");
        }
        else if (requestedQuantity > stock) {
            throw new OutOfStockException("the requested quantity exceeds the available stock");
        }
        else if (expired) {
            throw new PaymentExpiredException("the payment method is expired");
        }
        else if (payment < cost) {
            throw new PaymentDeclinedException("the payment amount is less than the order's total cost");
        }
        else {
            System.out.println("successful order! " + item + " was purchased");
        }
    }
}
