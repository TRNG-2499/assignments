package assignment02.part01;
import java.util.Scanner;
public class Solution {

    public static String calculateChange(double price, double amountInserted){
        double total = amountInserted - price;
        double insufficientFunds = price - amountInserted; 
        if(price < 0 || amountInserted < 0){
           return "Invalid input: amount inserted cannot be negative.";
        }
        else if(amountInserted < price){
            return String.format("Insufficient funds. Please insert $%.2f more.%n", insufficientFunds);
        }
        else{
            return String.format("Purchase successful. Change due: $%.2f%n", total);
        }
    }

    public static double multiItems(){
        double total = 0;
        Scanner sc = new Scanner(System.in);
        while(true){ 
            System.out.println("Enter item amount: ");
            double amount = sc.nextDouble();
            total+=amount;

            //Input 0 to exit the loop
            if (amount <= 0){
                return total;
            }
        }
    }

    public static String makeChange(double change){
        int num = (int) Math.round(change * 100); //241
        int dollars = num/100; //2
        int remainder = num%100; //41
        int quarters = remainder/25; // 1
        remainder %= 25; // 16
        int dimes = remainder/10; //1
        remainder %= 10; //6
        int nickels = remainder/5; //1
        remainder %= 5; // 1

        return String.format("Purchase successful. Change due: %d Dollars %d Quarters %d Dimes %d Nickels, %d Pennys", dollars, quarters, dimes, nickels, remainder);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        double userPrice = sc.nextDouble();
        System.out.println("Amount Inserted: ");
        double userAmount = sc.nextDouble();
        System.out.println(calculateChange(userPrice, userAmount));

        double totalAmount = multiItems();
        System.out.println(makeChange(totalAmount));
        sc.close();
    }
}
