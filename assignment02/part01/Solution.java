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
    public static String testing(double payment){
        double total = 0;
        Scanner sc = new Scanner(System.in);
        while(true){ 
            System.out.println("Enter item amount: ");
            double amount = sc.nextDouble();
            total+=amount;

            if (amount <= 0){
                if (total > payment){
                    double amountOwe = total - payment;
                    return String.format("Insufficient funds! You still owe $%.2f%n", amountOwe);
                }
                else{
                    double change = payment - total;
                    return String.format("Purchase successful. Change due: $%.2f%n", change);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        double userPrice = sc.nextDouble();
        System.out.println("Amount Inserted: ");
        double userAmount = sc.nextDouble();
        System.out.println(testing(100));
        System.out.println(calculateChange(userPrice, userAmount));
        sc.close();
    }
}
