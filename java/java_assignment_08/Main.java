package assignments.java.java_assignment_08;

public class Main {
    
    public static void main(String[] args){


/*
**Example 1 — Out of stock**
```
Input: item = "Widget", requestedQty = 5, availableStock = 2, paymentAmount = 50.00, orderCost = 50.00, isExpired = false
Output: "Order failed: Out of stock. Requested 5, but only 2 available."
```*/

try {
        processOrder("Widget", 5, 2, 50.00, 50.00, false);
    }
    catch (OutOfStockException e) {
        System.out.println(e.getMessage());
    }
    catch (InventoryException e) {
        System.out.println(e.getMessage());
    }
    catch (PaymentException e) {
        System.out.println(e.getMessage());
    }

/**Example 2 — Invalid quantity**
```
Input: item = "Widget", requestedQty = -1, availableStock = 10, paymentAmount = 50.00, orderCost = 50.00, isExpired = false
Output: "Order failed: Invalid quantity. Quantity must be greater than 0."*/
try {
        processOrder("Widget", -1, 10, 50.00, 50.00, false);
    }
    catch (OutOfStockException e) {
        System.out.println(e.getMessage());
    }
    catch (InventoryException e) {
        System.out.println(e.getMessage());
    }
    catch (PaymentException e) {
        System.out.println(e.getMessage());
    }


/***Example 3 — Payment declined**
```
Input: item = "Widget", requestedQty = 2, availableStock = 10, paymentAmount = 10.00, orderCost = 50.00, isExpired = false
Output: "Order failed: Payment declined. Insufficient funds."*/

try {
        processOrder("Widget", 2, 10, 10.00, 50.00, false);
    }
    catch (OutOfStockException e) {
        System.out.println(e.getMessage());
    }
    catch (InventoryException e) {
        System.out.println(e.getMessage());
    }
    catch (PaymentDeclinedException e) {
        System.out.println(e.getMessage());
    }
    catch (PaymentException e) {
        System.out.println(e.getMessage());
    }

/***Example 4 — Payment expired**
```
Input: item = "Widget", requestedQty = 2, availableStock = 10, paymentAmount = 50.00, orderCost = 50.00, isExpired = true
Output: "Order failed: Payment method expired."*/
try {
        processOrder("Widget", 2, 10, 50.00, 50.00, true);
    }
    catch (OutOfStockException e) {
        System.out.println(e.getMessage());
    }
    catch (InventoryException e) {
        System.out.println(e.getMessage());
    }
    catch (PaymentException e) {
        System.out.println(e.getMessage());
    }


/**Example 5 — Successful order**
```
Input: item = "Widget", requestedQty = 2, availableStock = 10, paymentAmount = 50.00, orderCost = 50.00, isExpired = false
Output: "Order successful! 2 x Widget confirmed." */

 try {
        processOrder("Widget", 2, 10, 50.00, 50.00, false);
    }
    catch (OutOfStockException e) {
        System.out.println(e.getMessage());
    }
    catch (InventoryException e) {
        System.out.println(e.getMessage());
    }
    catch (PaymentException e) {
        System.out.println(e.getMessage());
    }

    }

    /*
    
    Write a method that processes a single simulated order. It should accept an item name, a requested quantity, 
    the available stock for that item, a payment amount, the order's total cost, and whether the payment method is expired.
  - Validate inventory-related rules first:
    - If the requested quantity is zero or negative, throw `InvalidQuantityException`
    - If the requested quantity exceeds the available stock, throw `OutOfStockException`
  - Then validate payment-related rules:
    - If the payment method is expired, throw `PaymentExpiredException`
    - If the payment amount is less than the order's total cost, throw `PaymentDeclinedException`
  - If all validations pass, report a successful order confirmation, including the item name and quantity ordered.
- In your driving code (e.g., `main`), call this method with several different simulated orders, each designed to trigger 
a different outcome (each type of exception, as well as at least one successful order).
    
    */
    public static void processOrder(String item, int quantity, int stock, double payment, double total, boolean is_expired) throws InventoryException, PaymentException{
        
        if(quantity <= 0){
            throw new InvalidQuantityException("Order failed: Quantity cannot be zero or negative.");
        }

        if(quantity > stock){
            throw new OutOfStockException(String.format("Order failed: Quantity exceeds current stock. Requested %d, but only %d in inventory", quantity, stock));
        }
        
        
        if(is_expired){
            throw new PaymentExpiredException("Order failed: Payment method is expired.");
        }

        if(payment < total){
            throw new PaymentDeclinedException("Order failed: Insufficient funds.");
        }

        String s = String.format("Transaction completed successfully. %d x %s confirmed.", quantity, item);
        System.out.println(s);

    }



}
