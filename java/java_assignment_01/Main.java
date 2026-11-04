import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void vendingMachine(double price, double amountInserted){

        if (price < 0){
            System.out.println("Invalid Input: Price cannot be negative.\n");
        } else if (amountInserted < 0) {
            System.out.println("Invalid Input: Amount Inserted cannot be negative.\n");
        } else if (amountInserted < price){
            double priceDifference = price - amountInserted;
            System.out.println("Insufficient funds. Please insert $" + String.format("%.2f", priceDifference) + " more.\n");
        } else if (amountInserted == price){
            System.out.println("Purchase successful. Change due: $0.00\n");
        } else {
            double priceDifference = amountInserted - price;
            System.out.println("Purchase successful. Change due: $" + String.format("%.2f", priceDifference)  + "\n");
        }

    }

    //
    public static void vendingMachineWithChange(){

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Basic Vending Machine tests
        //Successful Purchase
        System.out.println("price = 1.50, amountInserted = 2.00");
        vendingMachine(1.50, 2.00);

        //Insufficient Funds
        System.out.println("price = 1.50, amountInserted = 1.00");
        vendingMachine(1.50, 1.00);

        //Exact change
        System.out.println("price = 1.50, amountInserted = 1.50");
        vendingMachine(1.50, 1.50);

        //Invalid Inputs
        System.out.println("price = 1.50, amountInserted = -1.00");
        vendingMachine(1.50, -1.00);

        System.out.println("price = -1.50, amountInserted = 1.00");
        vendingMachine(-1.50, 1.00);

        //Custom Inputs
        System.out.println("Insert Price:");
        double price = scanner.nextDouble();
        System.out.println("Insert $$$ into Machine:");
        double amountInserted = scanner.nextDouble();

        vendingMachine(price, amountInserted);
    }
}