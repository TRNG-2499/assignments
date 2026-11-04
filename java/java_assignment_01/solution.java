public class solution{
    public void vending(double price, double money){
        // Invalid input clause, if money or price is negative
        if(price<0.00 || money <0.00){
            System.out.println("Invalid input: amount inserted cannot be negative.");
            return;
        }
        // Insufficient funds clause, if money is less than price
        if(money<price){
            double missing = price - money;
            String result = String.format("%.2f", missing);
            System.out.println("Insufficient funds. Please insert $" + result + " more.");
            return;
        }
        // Successful purchase
        if(money >= price){
            double extra = money - price;
            String result = String.format("%.2f", extra);
            System.out.println("Purchase successful. Change due: $" + result + ".");
            return;
        }
    }

    public static void main(String[] args) {
        solution s = new solution();
        s.vending(-7.00, 10.00); // Negative Price
        s.vending(3.00, -12.00); // Negative Money
        s.vending(5.00, 1.00); // Money < Price
        s.vending(50.35, 145.02); // Correct
        s.vending(123.45, 123.45); // Exact change
    }
}