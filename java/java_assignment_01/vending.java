public class vending {
    
    public String transactions(double price, double asserted) {
        if (asserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        if (asserted >= price) {
            double change = asserted - price;
            return "Purchase successful. Change due: $" + String.format("%.2f", change);
        }
        else {
            double needed = price - asserted;
            return "Insufficient funds. Please insert $" + String.format("%.2f", needed) + " more.";
        }
    }
    public String transactions2(double[] prices, double asserted) {
        double totalPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            totalPrice += prices[i];
        }
        if (totalPrice > asserted) {
            return "Not enough money inserted. Please insert $" + String.format("%.2f", totalPrice - asserted) + " more.";
        }
        else {
            double change = Math.abs(asserted - totalPrice);
            return "Purchase successful. Change due: $" + String.format("%.2f", change);
        }
    }
    /* - **Multiple Items / Running Total** — Accept a list of item prices being purchased together, 
    along with a single amount inserted, and determine whether the total was fully covered. 
    Report either the change owed or how much more is needed, based on the sum of all item prices. */
public static void main(String[] args) {
    System.out.println("Welcome to the Vending Machine!");
    vending vm = new vending();
    System.out.println(vm.transactions(3.0, 3.0));
    System.out.println(vm.transactions(1.0, 2.0));
    System.out.println(vm.transactions(2.5, 2.0));
    System.out.println(vm.transactions(3.25, 5.25));
    System.out.println(vm.transactions(3.25, -1.25));
    System.out.println(vm.transactions2(new double[]{5.0, 5.0, 2.0}, 10.0));

}
}