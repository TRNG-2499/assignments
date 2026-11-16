
public class OrderProcessingSystem {
    public static String processOrder(String item, int quantity, int stock, int paymentAmount, int totalCost, boolean isExpired)
            throws InvalidQuantityException, OutOfStockException, PaymentExpiredException, PaymentDeclinedException
    {
        if (quantity <= 0)
        {
            throw new InvalidQuantityException();
        }

        if(quantity > stock)
        {
            throw new OutOfStockException("Requested " + quantity + ", but only have " + stock + " available.");
        }

        if(isExpired)
        {
            throw new PaymentExpiredException();
        }

        if(paymentAmount < totalCost)
        {
            throw new PaymentDeclinedException();
        }

        System.out.println("Order sucessful! " + quantity + " x " + "item" + " confirmed.");
        return "Order sucessful! " + quantity + " x " + "item" + " confirmed.";
    }

    public static void main(String[] args) {
        // Out of stock
        try {
            processOrder("Bread", 0, 1, 10, 10, false);
        } catch (InvalidQuantityException e) { 
            e.printStackTrace();
        } catch (InventoryException e ) {
            e.printStackTrace();
        } catch (PaymentException e) {

        }

        // Payment declined
        try {
            processOrder("Bread", 1, 1, 9, 10, false);
        } catch (PaymentDeclinedException e) { 
            e.printStackTrace();
        } catch (InventoryException e ) {
            e.printStackTrace();
        } catch (PaymentException e) {

        }

        // Payment expired (general exceptions)
        try {
            processOrder("Bread", 1, 1, 10, 10, true);
        } catch (PaymentException e) { 
            e.printStackTrace();
        } catch (InventoryException e ) {
            e.printStackTrace();
        }

        // Out of Stock (general exception)
        try {
            processOrder("Bread", 5, 2, 10, 10, false);
        } catch (PaymentException e) { 
            e.printStackTrace();
        } catch (InventoryException e ) {
            e.printStackTrace();
        }

        // Succesful transaction
        try {
            processOrder("Bread", 1, 1, 10, 10, false);
        } catch (PaymentException e) { 
            e.printStackTrace();
        } catch (InventoryException e ) {
            e.printStackTrace();
        }


    }
}
