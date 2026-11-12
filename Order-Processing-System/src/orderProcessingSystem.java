import Inventory.InvalidQuantityException;
import Inventory.InventoryException;
import Inventory.OutOfStockException;
import payment.PaymentDeclinedException;
import payment.PaymentException;
import payment.PaymentExpiredException;

public class orderProcessingSystem {


    public static void main(String[] args) {

        //order 1. Out of stock
        try {
            processOrder("Widget", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException e){
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e){
            System.out.println("Invalid Quantity: " + e.getMessage());
        } catch (PaymentException e){
            System.out.println("Qunatity must be greater than 0" + e.getMessage());
        }

        //order 2. Invalid Quantity
        try{
            processOrder("widget", -1, 10, 50.00, 50.00, false);
        } catch (InvalidQuantityException e){
            System.out.println("Order failed: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error: " + e.getMessage());
        }

        //order 3. Payment declined
        try{
            processOrder("widget", 2, 10, 10.00, 50.00, false);
        } catch (PaymentDeclinedException e){
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e){
            System.out.println("Payment Declined. " + e.getMessage());
        } catch(PaymentException e){
            System.out.println("Insufficient funds. " + e.getMessage());
        }

        //order 4. Payment Expired
         try{
            processOrder("Widget", 2, 10, 50.00, 50.00, true);
         } catch (PaymentExpiredException e){
             System.out.println("Order failed:" + e.getMessage());
         } catch (InventoryException e){
             System.out.println("");
         } catch (PaymentException e){
             System.out.println("Payment method expired");
         }

         //Order 5. Successful order
        try{
            processOrder("Widget,", 2, 10, 50.00, 50.00, false);
        } catch (Exception e){
            System.out.println("Order failed: " + e.getMessage());
        }
    }

public static void processOrder ( String itemName,
                                  int requestedQuantity,
                                  int availableStock,
                                  double paymentAmount,
                                  double orderTotal,
                                  boolean paymentExpired) throws InventoryException, PaymentException {

        if(requestedQuantity <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0");
        }

        if(requestedQuantity > availableStock){
            throw new OutOfStockException("Requested Quantity exceeds the stock. Our available stock is: " + availableStock);
        }

        if(paymentExpired){
            throw new PaymentExpiredException("Payment method has been expired. Please update. ");

        }

        if(paymentAmount < orderTotal){
            throw new PaymentDeclinedException("Payment amount is less than the order's total cost. " +
                    "Item is  " + itemName + ", and quantity  ordered are: " + requestedQuantity);
        }
    System.out.println("Order Successful! " + requestedQuantity + " x " + itemName + " Confirmed.");
}


}
