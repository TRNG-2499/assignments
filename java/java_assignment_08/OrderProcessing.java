package assignments.java.java_assignment_08;

public class OrderProcessing {
    public static void main(String[] args) {
        try {
            takeOrder("Widget", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException | InvalidQuantityException | PaymentDeclinedException | PaymentExpiredException e) {
            System.err.println(e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.err.println(e.getMessage());
        }
        try {
            takeOrder("Widget", -1, 10, 50.00, 50.00, false);
        } catch (OutOfStockException | InvalidQuantityException | PaymentDeclinedException | PaymentExpiredException e) {
            System.err.println(e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.err.println(e.getMessage());
        }
        try {
            takeOrder("Widget", 2, 10, 10.00, 50.00, false);
        } catch (OutOfStockException | InvalidQuantityException | PaymentDeclinedException | PaymentExpiredException e) {
            System.err.println(e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.err.println(e.getMessage());
        }
        try {
            takeOrder("Widget", 2, 10, 50.00, 50.00, true);
        } catch (OutOfStockException | InvalidQuantityException | PaymentDeclinedException | PaymentExpiredException e) {
            System.err.println(e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.err.println(e.getMessage());
        }
        try {
            takeOrder("Widget", 2, 10, 50.00, 50.00, false);
        } catch (OutOfStockException | InvalidQuantityException | PaymentDeclinedException | PaymentExpiredException e) {
            System.err.println(e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void takeOrder(String item, int request, int stock, double payment, double cost, boolean expired) throws InventoryException, PaymentException {
        
        if (item == null || item.equals("")){
                throw new InventoryException("Order failed: Item name cannot be empty.");
        }
        if (request <= 0){
            throw new InvalidQuantityException(" Quantity must be greater than 0.");
        }else if (request > stock){
            throw new OutOfStockException(" Requested "+ request +", but only "+ stock +" available.");
        }
        if (payment < cost){
            throw new PaymentDeclinedException(" Insufficient funds.");
        }else if (expired){
            throw new PaymentExpiredException();
        }
        
        System.out.println("Order successful! "+ request +" x "+ item +" confirmed.");
    }
}