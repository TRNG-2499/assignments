//two doubles to be received via input
public class solution {
    public static void main(String[] args) {
        System.out.println(fundCheck(1.10, 1));
    }
    public static String fundCheck(double input, double price) {
        double payBack;
        double insertMore;

        if (price < 0) {
            return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Invalid input: Price cannot be negative.";
        } else {
            if (input < 0) {
                return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Invalid input: amount inserted cannot be negative.";
            } else if (input == price) {
                return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Purchase successful. Change due: $0.00";
            } else if (input > price){
                payBack = input - price;
                return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Purchase successful. Change due: $" + String.format("%.2f", payBack);
            } else {
                insertMore = price - input;
                return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Insufficient funds. Please insert $" + String.format("%.2f", insertMore) + " more.";
            }
        }
    }
}