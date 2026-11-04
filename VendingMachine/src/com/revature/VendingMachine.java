package com.revature;

public class VendingMachine {
    public static void main(String[] args) {
    System.out.println(processPurchase(1.50, 2.00)); //should be successful with $0.50 change
    System.out.println(processPurchase(1.50, 1.00)); //Insufficient, $0.50 more needed
    System.out.println(processPurchase(1.50, 1.50)); //should be successful, $0.00 change
    System.out.println(processPurchase(1.50, -1.00)); //should be Invalid since negative
    System.out.println(processPurchase(-1.50, 2.00)); //should be Invalid since negative
    }

    public static String processPurchase (double price, double amountInserted){
        /*if(price < 0 || amountInserted < 0){
            return "Invalid Input: item price or amount inserted can not be negative";
        } */
        if(price < 0){
            return "Invalid Input: Item price can not be negative";
        }
        if(amountInserted < 0){
            return "Invalid Input: Amount Inserted can not be negative";
        }

        if(amountInserted < price){
            double moneyNeeded = price - amountInserted;
            return String.format("Insufficient funds. Please insert $%.2f more.", moneyNeeded);
        }
        double change = amountInserted - price;
        return String.format("Purchase is successful: Your change is : $%.2f", change);
    }
}