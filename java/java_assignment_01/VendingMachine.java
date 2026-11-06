public class VendingMachine {

    public static void main(String[] args) {
        
        System.out.println(makeChange(1.50, 2.00));
        System.out.println(makeChange(1.50, 1.00));
        System.out.println(makeChange(1.50, 1.50));
        System.out.println(makeChange(1.50, -1.00));
        System.out.println(makeChange(-1.00, 2.00));

        double[] items = {1.25, 0.75, 2.00};
        
        System.out.println(makeChangeForItems(items, 5.00));
        System.out.println(makeChangeForItems(items, 3.00));
    }

    public static String makeChange(double price, double money) {
        if (price < 0) 
            {
            return "Invalid input: item price cannot be negative.";
        }
        if (money < 0) 
            {
            return "Invalid input: amount inserted cannot be negative.";
        }
        if (money < price) {
            double needed = price - money;
            return String.format("Insufficient funds. Please insert $%.2f more.", needed);
        }
        double change = money - price;
        
        return String.format("Purchase successful. Change due: $%.2f", change);
    }

    public static String makeChangeForItems(double[] prices, double money) {
        double total = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < 0) {
                return "Invalid input: item price cannot be negative.";
            }
            total = total + prices[i];
        }
        
        return makeChange(total, money);
    }
}
