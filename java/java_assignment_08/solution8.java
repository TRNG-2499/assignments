public class solution8{
    public static void main(String[] args) {
        try{
            confirmOrder("Widget", 5,2, 50, 50, false);
        }
        catch(OutOfStockException | InvalidQuantityException | PaymentDeclinedException | PaymentExpiredException e){
            System.out.println("Order failed: Not enough available stock for the requested item");
        }

        try{
            confirmOrder("Widget", -5,2, 50, 50, false);
        }
        catch(OutOfStockException | InvalidQuantityException | PaymentDeclinedException | PaymentExpiredException e){
            System.out.println("Order failed: The quantity can't be 0 or less");
        }

        try{
            confirmOrder("Widget", 5,2, 30, 50, false);
        }
        catch(OutOfStockException | InvalidQuantityException | PaymentDeclinedException | PaymentExpiredException e){
            System.out.println("Order failed: Payment declined. Insufficient funds.");
        }

        try{
            confirmOrder("Widget", 5,5, 50, 50, true);
        }
        catch(OutOfStockException | InvalidQuantityException | PaymentDeclinedException | PaymentExpiredException e){
            System.out.println("Order failed: Payment method expired.");
        }

        try{
            confirmOrder("Widget", 5,5, 50, 50, false);
        }
        catch(InventoryException | PaymentException e){
            System.out.println("an error occured");
        }


    }
    
    public static void confirmOrder(String item, int requestedQty, int availableStock, double paymentAmount, double orderCost, 
        boolean isExpired) throws InvalidQuantityException, OutOfStockException, PaymentExpiredException, PaymentDeclinedException{
        if(requestedQty <= 0)
            throw new InvalidQuantityException();
        else if(requestedQty > availableStock)
            throw new OutOfStockException();
        else if(isExpired)
            throw new PaymentExpiredException();
        else if(paymentAmount < orderCost)
            throw new PaymentDeclinedException();
        else
            System.out.println("Order successful! " + requestedQty + " x " + item + " confirmed.");
    }
}