import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public record Transaction(String itemName, int amt) {

        @Override 
        public String toString() {
            String out = String.format(
                "%d x %s",
                amt,
                itemName()
            );

            return out;
        }
    }

    public record Order(String itemName, int quant, int avail, int pay, int cost, boolean exp) {
        public Transaction validate() throws OutOfStockException,InvalidQuantityException,PaymentDeclinedException,PaymentExpiredException {
            if (quant > avail) {
                throw new OutOfStockException(quant, avail);
            }

            if (quant <= 0) {
                throw new InvalidQuantityException();
            }

            if (pay < cost) {
                throw new PaymentDeclinedException();
            }

            if (exp) {
                throw new PaymentExpiredException();
            }

            return new Transaction(itemName, quant);
        }
    }

    public static Transaction order(String itemName, int quant, int avail, int pay, int cost, boolean exp) throws OutOfStockException,InvalidQuantityException,PaymentDeclinedException,PaymentExpiredException {
        return new Order(itemName, quant, avail, pay, cost, exp).validate();
    }

    public static Transaction order(Order order) throws OutOfStockException,InvalidQuantityException,PaymentDeclinedException,PaymentExpiredException {
        return order.validate();
    }

    public static List<Transaction> batchOrder(Order[] orders) {
        List<Transaction> txs = new ArrayList<>();
        int conf = 0;

        for (Order o : orders) {
            try {
                Transaction tx = order(o);
                conf++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(String.format(
            "Order Summary:%n\tSucceeded:%3d%n\tFailed:%3d",
            conf,
            orders.length - conf
        ));

        return txs;
    }

    public static boolean randB() {
        return Math.random() < .5;
    }

    public static Order[] genOrders(int n) {
        return 
            IntStream
                .range(0, n)
                .mapToObj(i -> new Order("Widget", 1, 1, 1, 1, randB()))
                .toArray(Order[]::new);
    }

    public static void main(String[] args) {
        try {
            Transaction tx0 = order("Widget", 5, 2, 50, 50, false);
            System.out.println(String.format(
                "Order successful! %s confirmed.",
                tx0.toString()
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Transaction tx0 = order("Widget", -1, 2, 50, 50, false);
            System.out.println(String.format(
                "Order successful! %s confirmed.",
                tx0.toString()
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Transaction tx0 = order("Widget", 5, 10, 49, 50, false);
            System.out.println(String.format(
                "Order successful! %s confirmed.",
                tx0.toString()
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Transaction tx0 = order("Widget", 5, 10, 50, 50, true);
            System.out.println(String.format(
                "Order successful! %s confirmed.",
                tx0.toString()
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Transaction tx0 = order("Widget", 5, 10, 50, 50, false);
            System.out.println(String.format(
                "Order successful! %s confirmed.",
                tx0.toString()
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Transaction tx0 = order("Widget", 5, 1, 50, 50, false);
            System.out.println(String.format(
                "Order successful! %s confirmed.",
                tx0.toString()
            ));
        } catch (InventoryException | PaymentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        Order[] orders = genOrders(100);
        batchOrder(orders);
    }
}
