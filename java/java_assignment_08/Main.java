public class Main {

    public static void processOrder(String itemName, int requestedQty, int availableStock,
                                    double paymentAmount, double orderCost, boolean isExpired){

        try{
            validateInventory(requestedQty, availableStock);
            validatePayment(paymentAmount, orderCost, isExpired);
            System.out.println("Order Confirmed! " + itemName + " x " + requestedQty + " confirmed.");
        } catch (Exception e) {
            System.out.println("Order Failed: " + e.getMessage());
        }

    }

    public static void validateInventory(int requestedQty, int availableStock) throws Exception{
        if(requestedQty <= 0){
            throw new InvalidQuantityException("Invalid Quantity. Quantity must be greater than 0.");
        } else if (requestedQty > availableStock){
            throw new OutOfStockException("Out of stock. Requested " + requestedQty + " but only " + availableStock + " available.");
        }
    }

    public static void validatePayment(double paymentAmount, double orderCost, boolean isExpired) throws Exception{
        if(isExpired){
            throw new PaymentExpiredException("Payment method expired.");
        } else if (paymentAmount < orderCost){
            throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
        }
    }

    public static void main(String[] args){

        processOrder("Widget", 5, 2, 50.00, 50.00, false);

        processOrder("Widget", -1, 10, 50.00, 50.00, false);

        processOrder("Widget", 2, 10, 10.00, 50.00, false);

        processOrder("Widget", 2, 10, 50.00, 50.00, true);

        processOrder("Widget", 2, 10, 50.00, 50.00, false);

    }
}
