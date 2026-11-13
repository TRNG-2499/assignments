package java_assignment_08;

public class JA08 {
    
    public static void order(String name, int qty, int stock, double paid, double cost, boolean payExpired){
        try{
            if(qty < 1){
                throw new InvalidQuantityException(
                    "Order failed: Invalid quantity. Quantity must be greater than 0."
                );
            } else if(qty > stock){
                throw new OutOfStockException(
                    "Order failed: Out of stock. Requested " + qty + " but only " + stock + " available."
                );
            }
        } catch (OutOfStockException e) {
            System.out.println("Out of Stock Exception Error: " + e.getMessage());
            return;
        } catch (InventoryException e){
            System.out.println("Inventory Exception Error: " + e.getMessage());
            return;
        }

        try{
            if (payExpired){
                throw new PaymentExpiredException(
                    "Order failed: Payment method expired."
                );
            } else if (paid < cost) {
                throw new PaymentDeclinedException(
                    "Order failed: Payment declined. Insufficient funds."
                );
            } 
        } catch (PaymentException e) {
            System.out.println("Payment Exception Error: " + e.getMessage());
            return;
        }

        System.out.printf("Order successful! %d x %s confirmed.", qty, name);
    }

    public static void main(String[] args){
        order("Widget", 5, 2, 50.00, 50.00, false);
        order("Widget", -1, 10, 50.00, 50.00, false);
        order("Widget", 2, 10, 10.00, 50.00, false);
        order("Widget", 2, 10, 50.00, 50.00, true);
        order("Widget", 2, 10, 50.00, 50.00, false);
        order("Widget", 2, 0, 50.00, 50.00, false);
    }
}
