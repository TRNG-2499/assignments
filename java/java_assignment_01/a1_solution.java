public class a1_solution {
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
    public void multiple(double[] price, double money){
        double total = 0;
        if(money < 0.00){
            System.out.println("Invalid input: amount inserted cannot be negative.");
            return;
        }
        for(int i=0;i<price.length;i++){
            if(price[i]<0){
                System.out.println("Invalid input: amount inserted cannot be negative.");
                return;
            }
            total = total + price[i];
        }
        // Insufficient funds clause, if money is less than price
        if(money<total){
            double missing = total - money;
            String result = String.format("%.2f", missing);
            System.out.println("Insufficient funds. Please insert $" + result + " more.");
            return;
        }
        // Successful purchase
        if(money >= total){
            double extra = money - total;
            String result = String.format("%.2f", extra);
            System.out.println("Purchase successful. Change due: $" + result + ".");
            return;
        }
    }
    public void change(double money){
        if(money < 0.00){
            System.out.println("Invalid input: amount inserted cannot be negative.");
            return;
        }
        double current = money;
        // dollars
        int dollar = (int)(Math.floor(current));
        current -= dollar;
        // quarters
        int quarter  = (int)(Math.floor(current/.25));
        current -= quarter * .25;
        // dimes
        int dime = (int)(Math.floor(current/.1));
        current -= dime * .1;
        // nickels
        int nickel = (int)(Math.floor(current/.05));
        current -= nickel * .05;
        // pennies
        int penny = (int) Math.round(current * 100);
        String mon = String.format("%.2f", money);
        System.out.println("With $" + mon +", your change is " + dollar + " dollar(s), " + quarter + " quarter(s)," + dime + " dime(s), " + nickel + " nickel(s), " + penny + " penny(s).");
    }

    public static void main(String[] args) {
        a1_solution s = new a1_solution();
        s.vending(-7.00, 10.00); // Negative Price
        s.vending(3.00, -12.00); // Negative Money
        s.vending(5.00, 1.00); // Money < Price
        s.vending(50.35, 145.02); // Correct
        s.vending(123.45, 123.45); // Exact change
        System.out.println("Checking multiple list");
        double[] grocery = {10.00, 20.00, 30.00};
        double[] error = {10.00, 32.45, -1.00, 23.01};
        s.multiple(grocery, 10.00); // list not enough
        s.multiple(grocery, 100.00); // list enough
        s.multiple(error, 123.45);
        s.change(0.00); // expect 0
        s.change(0.01); // expect 1 penny
        s.change(1.30); // expect 1 dollar, 1 quarter, 1 nickel
        s.change(123.46);
        s.change(-2);
    }
}