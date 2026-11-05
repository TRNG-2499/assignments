public class Solution {
    public static String solutionAnswer(double price, double payment) {
    if (price < 0 || payment < 0) {
        return "Invalid. Please enter a non-negative number";
    }

    double change = payment - price;

    if (payment < price) {
        return "Insufficient Funds!! Amount needed is: " + (price - payment);
    } else {
        return "Purchase Succeeded! change is: " + change;
    }
    }
}