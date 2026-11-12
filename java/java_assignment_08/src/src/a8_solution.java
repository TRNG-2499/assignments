import java.util.ArrayList;
import java.util.List;

public class a8_solution {
    public void solution(String item, int quantity, int stock, double payment, double total, boolean isExpired) throws InventoryException, PaymentException{
        if(quantity <= 0){
            throw new InvalidQuantityException();
        }
        if(quantity > stock){
            throw new OutOfStockException(quantity, stock);
        }
        if(isExpired){
            throw new PaymentExpiredException();
        }
        if(total > payment){
            throw new PaymentDeclinedException();
        }
        System.out.println("Order successful! " + quantity + " x " + item + " confirmed.");
    }

    public void batchSummary(List<Order> orders){
        int success = 0;
        int failure = 0;
        int outOfStock = 0;
        int invalid = 0;
        int declined = 0;
        int expired = 0;
        for(Order order : orders){
            try{
                solution(order.getItem(), order.getQuantity(), order.getStock(), order.getPayment(), order.getTotal(), order.isExpired());
                success++;
            }catch(PaymentException | InventoryException e){
                failure++;
                if(e instanceof OutOfStockException){
                    outOfStock++;
                }else if(e instanceof InvalidQuantityException){
                    invalid++;
                }else if(e instanceof PaymentDeclinedException){
                    declined++;
                }else{
                    expired++;
                }
            }
        }
        System.out.println("Batch Summary: " + success + " orders successfully confirmed, " +  failure + " orders failed.");
        System.out.println("Failures by exception type:");
        System.out.println("OutOfStockException: " + outOfStock + "\nInvalidQuantityException: " + invalid
        + "\nPaymentDeclinedException: " + declined + "\nPaymentExpiredException: " + expired);
    }
    public static void main(String[] args) {
        a8_solution a8 = new a8_solution();
        try {
            a8.solution("apple",5,10,100.00,25.00,false); // works
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            a8.solution("orange",15,10,100.00,25.00,false); // not in stock
        } catch(OutOfStockException e){
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println("basic exception");
        }
        try{
            a8.solution("computer",1,5,10.00,150.00,false); // not enough funds
        } catch(PaymentException | InventoryException e){
            System.out.println(e.getMessage());
        }
        try{
            a8.solution("ramen",11,25,25.00,14.99,true); // expired payment
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            a8.solution("???", -55, 0, 0.00, 0.00, false); // negative quantity
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            a8.solution("orange",15,10,100.00,25.00,false); // not in stock, but using getters
        } catch(OutOfStockException e){
            System.out.println("Order failed: Requested: " + e.getQuantity() + ", Available: " + e.getStock());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("---------- Stretch Goals ----------");
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("apple",5,10,100.00,25.00,false));
        orderList.add(new Order("orange",15,10,100.00,25.00,false));
        orderList.add(new Order("computer",1,5,10.00,150.00,false));
        orderList.add(new Order("ramen",11,25,25.00,14.99,true));
        orderList.add(new Order("???", -55, 0, 0.00, 0.00, false));
        a8.batchSummary(orderList);
        System.out.println("----- Batch Number 2 -----");
        orderList.remove(new Order("orange",15,10,100.00,25.00,false));
        orderList.add(new Order("banana",0,10,100.00,25.00,false));
        a8.batchSummary(orderList);
    }
}
