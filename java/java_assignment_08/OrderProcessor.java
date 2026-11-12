package java.java_assignment_08;

public class OrderProcessor {
    public static void processOrder(String itemName, int quantity, int avaliableStock, double paymentAmount, double totalCost, boolean paymentExpired) throws Inventoryexception, PaymentException {
        if (quantity <= 0){
            throw new InvalidQuantityException(itemName, quantity);
        }
        if (quantity > avaliableStock){
            throw new OutofStockException(itemName, quantity, avaliableStock);
        }

        if (paymentExpired){
            throw new PaymentExpiredException();
        }
        if(paymentAmount < totalCost){
            throw new PaymentdeclineException(paymentAmount, totalCost);
        }
        System.out.printf("Order confirmed for %d x %s (total $%.2f). %n", quantity, itemName, totalCost);
    }
    
}
