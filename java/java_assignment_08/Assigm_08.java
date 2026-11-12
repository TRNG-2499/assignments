public class Assigm_08 {
    

    public static void main(String[] args) {
        
        Object[] [] testCases = {
            // Item, RequestedQty, Stock, PayAmount, Cost, IsExpired, Label
            {"Widget", 5, 2, 50.0, 50.0, false, "Out of Stock"},
            {"Gadget", -1, 10, 50.0, 50.0, false, "Invalid Quantity"},
            {"Tool", 2, 10, 10.0, 50.0, false, "Payment Declined"},
            {"Gear", 2, 10, 50.0, 50.0, true, "Expired Payment"},
            {"Widget", 2, 10, 50.0, 50.0, false, "Successful Order"}
        };

        for (Object[] test : testCases) {
            String name = (String) test[0];
            int reqQty = (int) test[1];
            int stock = (int) test[2];
            double payAmt = (double) test[3];
            double cost = (double) test[4];
            boolean expired = (boolean) test[5];
            String label = (String) test[6];

            System.out.println("--- Testing: \" + label + \" ---");
            try {
                processOrder(name, reqQty, stock, payAmt, cost, expired);
            }
            catch (OutOfStockException e) {
                System.out.println("Specific Catch: " + e.getMessage());
            }
            catch (InvalidQuantityException e) {
                System.out.println("Catching Invalid Quantity: " + e.getMessage());
            }
            catch (PaymentException e) {
                System.out.println("Generic Payment Catch: " + e.getMessage());
            }
            catch (InventoryException e) {
                System.out.println("Generic Inventory Catch: " + e.getMessage());
            }
            System.out.println();
        }
    }

    public static void processOrder(String itemName, int requestedQty, int availableStock, double paymentAmount, double orderCost, boolean isExpired) throws InventoryException, PaymentException {

        if (requestedQty <= 0) {
            throw new InvalidQuantityException();
        }
        if (requestedQty > availableStock) {
            throw new OutOfStockException(requestedQty, availableStock);
        }
        if (isExpired) {
            throw new PaymentExpiredException();
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException();
        }

        System.out.println("Order sucessfull!" + requestedQty + " x " + itemName + "confirmed");
    }


}
