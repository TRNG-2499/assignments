package assignment02.part08;

public class Solution {
    public static void OPS(String item, int requestedQty, int availableStock,
                            double paymentAmount, double orderCost, boolean isExpired)
                            throws InventoryException, PaymentException{
            if (requestedQty <= 0){
                throw new InvalidQuantityException("Invalid Quantity. Quantity must be greater than 0");
            }
            if (requestedQty > availableStock){
                throw new OutOfStockException("Out of stock. Requested " + requestedQty + ", but only " + availableStock + " available.");
            }
            if (isExpired){
                throw new PaymentExpiredException("Payment method expired.");
            } 
            if(paymentAmount < orderCost){
                throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
            }
        System.out.println("Order Successful! " + requestedQty + " x " + item + " confirmed.");
    }

    public static void main(String[] args) {
        try {
            OPS("Widget", 5, 2, 50.00, 50.00, false);
        }
          catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        try {
            OPS("Widget",-1, 10, 50.00, 50.00, false);
        }
          catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        try {
            OPS("Widget", 2,10,10.00,50.00,false);
        }
          catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        try {
            OPS("Widget", 2,10,50.00,50.00,true);
        }
          catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        try {
            OPS("Widget", 2,10,50.00,50.00,false);
        }
          catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }
}
