public class solution{
    public static void main(String[] args){
        purchase(-1.50, -1.00);
        changeMaker(5.66);
    }
    public static void purchase(double price, double amountInserted){
        if(price < 0 && amountInserted < 0){
            System.out.println("Invalid input: price and amount inserted cannot be negative.");
        }
        else if(price < 0){
            System.out.println("Invalid input: price inserted cannot be negative.");
        }
        else if(amountInserted < 0){
            System.out.println("Invalid input: amount inserted cannot benegative.");
        }
        else if(amountInserted < price){
            double diff = price - amountInserted;
            System.out.println("Insufficient funds. Please insert $" + diff + " more.");
        } 
        else {
            double change = amountInserted - price;
            System.out.println("Purchase successful. Change due: $" + change);
        }
    }

    //Stretch Goal Making Change in Denominations
    public static void changeMaker(double amount){
        int ones = 0, quarts = 0, dimes = 0, nicks = 0, penns = 0;
        int intAmount = (int)(amount *100);
        ones = intAmount/100;
        int rem = intAmount % 100;
        quarts = rem/25;
        rem = rem % 25;
        dimes = rem/10;
        rem = rem % 10;
        nicks = rem/5;
        rem = rem % 5;
        penns = rem;
        System.out.printf("Your change is %d dollars, %d quarters, %d dimes, %d nickels, and %d pennies", 
        ones, quarts, dimes, nicks, penns);

    }
}