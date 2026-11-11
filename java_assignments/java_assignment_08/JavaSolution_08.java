package java_assignments.java_assignment_08;

public class JavaSolution_08 {
    public static void main(String[] args) {
        //Main requirements
        orderHelper("Widget", 5, 2, 50.00, 50.00, false);
        orderHelper("Widget", -1, 2, 50.00, 50.00, false);
        orderHelper("Widget", 5, 5, 50.00, 50.00, true);
        orderHelper("Widget", 5, 5, 45.00, 50.00, false);
        orderHelper("Widget", 5, 5, 50.00, 50.00, false);







        //Stretch Goal 1:
        System.out.println("\nStretch Goal 1: ");
        try {
            orderStretch("Widget", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException e){
            System.out.println("Inventory error: "+e.getMessage());
        } catch(InventoryException e){
            System.out.println("Inventory error: "+e.getMessage());
        } catch(PaymentDeclinedException e){
            System.out.println("Payment Error: "+e.getMessage());
        } catch(PaymentException e) {
            System.out.println("Payment Error: "+e.getMessage());
        }
    }

    public static void orderHelper(String itemName, int req, int avail, double payment, double cost, boolean isExpired){
        try {
            order(itemName, req, avail, payment, cost, isExpired);
        } catch (OutOfStockException e){
            System.out.println("Inventory error: "+e.getMessage());
        } catch(InventoryException e){
            System.out.println("Inventory error: "+e.getMessage());
        } catch(PaymentDeclinedException e){
            System.out.println("Payment Error: "+e.getMessage());
        } catch(PaymentException e) {
            System.out.println("Payment Error: "+e.getMessage());
        }
    }

    public static void order(String itemName, int req, int avail, double payment, double cost, boolean isExpired) throws InventoryException, PaymentException{
        //Inventory checks
        if(req <= 0){
            throw new InvalidQuantityException();
        }
        if(req>avail){
            throw new OutOfStockException();
        }

        //Payment checks
        if(isExpired){
            throw new PaymentExpiredException();
        }
        if(payment<cost){
            throw new PaymentDeclinedException();
        }

        System.out.println("Order successful! "+req+" x "+itemName+" confirmed!");
        
       
    }

    public static void orderStretch(String itemName, int req, int avail, double payment, double cost, boolean isExpired) throws InventoryException, PaymentException{
        //Inventory checks
        if(req <= 0){
            throw new InvalidQuantityException();
        }
        if(req>avail){
            throw new OutOfStockException(req, avail);
        }

        //Payment checks
        if(isExpired){
            throw new PaymentExpiredException();
        }
        if(payment<cost){
            throw new PaymentDeclinedException();
        }

        System.out.println("Order successful! "+req+" x "+itemName+" confirmed!");
        
       
    }
}
