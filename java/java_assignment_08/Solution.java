import java.io.*;
import java.util.*;

public class Solution {

    public static void processOrder(String itemName, int requestedQuantity, int availableStock, double paymentAmount, double totalOrderCost, boolean expired) throws InvalidQuantityException, OutOfStockException, PaymentDeclinedException, PaymentExpiredException {
        if(requestedQuantity < 1){
            throw new InvalidQuantityException(requestedQuantity);
        }

        if(requestedQuantity > availableStock){
            throw new OutOfStockException(itemName, requestedQuantity, availableStock);
        }

        if(expired){
            throw new PaymentExpiredException();
        }

        if(paymentAmount < totalOrderCost){
            throw new PaymentDeclinedException(itemName, requestedQuantity, paymentAmount, totalOrderCost);
        }

        System.out.printf("Payment Successful: %d %s, payment: %.2f, change: %.2f\n", requestedQuantity, itemName, paymentAmount, paymentAmount - totalOrderCost);
    }

    public static void main(String... args){
        try {
            processOrder("Apple", -9, 10, 4, 5, false);
        } catch (InvalidQuantityException e){
            System.out.println(e.getMessage());
        } catch (InventoryException e){
            System.out.println(e.getMessage());
        } catch (PaymentException e){
            System.out.println(e.getMessage());
        }
        
        try {
            processOrder("Orange", 12, 10, 10.0, 9.0, false);
        } catch (OutOfStockException e){
            System.out.println(e.getMessage());
        } catch (InventoryException e){
            System.out.println(e.getMessage());
        } catch (PaymentException e){
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Banana", 5, 6, 5, 6.0, true);
        } catch (PaymentExpiredException e){
            System.out.println(e.getMessage());
        } catch (InventoryException e){
            System.out.println(e.getMessage());
        } catch (PaymentException e){
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Kiwi", 10, 20, 1.5, 2.5, false);
        } catch (PaymentDeclinedException e){
            System.out.println(e.getMessage());
        } catch (InventoryException e){
            System.out.println(e.getMessage());
        } catch (PaymentException e){
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Peach", 20, 50, 10, 9, false);
        } catch (PaymentDeclinedException e) {
            System.out.println(e.getMessage());
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        }
    }
}