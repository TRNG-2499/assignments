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

    //Stretch Goal 1: Multiple Items/Running Total
    public static void multiVendingMachine(double amountInserted, double... price){

        double totalPrice = 0.00;

        if (price.length > 0){
            for(int i=0; i<price.length; i++){

                if(price[i] < 0){
                    System.out.println("Invalid Input: One price was negative; price cannot be negative.\n");
                    return;
                }

                totalPrice+=price[i];
            }
        }

        if (totalPrice < 0){
            System.out.println("Invalid Input: Price cannot be negative.\n");
        } else if (amountInserted < 0) {
            System.out.println("Invalid Input: Amount Inserted cannot be negative.\n");
        } else if (amountInserted < totalPrice){
            double priceDifference = totalPrice - amountInserted;
            System.out.println("Insufficient funds. Please insert $" + String.format("%.2f", priceDifference) + " more.\n");
        } else if (amountInserted == totalPrice){
            System.out.println("Purchase successful. Change due: $0.00\n");
        } else {
            double priceDifference = amountInserted - totalPrice;
            System.out.println("Purchase successful. Change due: $" + String.format("%.2f", priceDifference)  + "\n");
        }

    }


    //Stretch Goal 2: Making Change in Denominations
    public static void vendingMachineWithChange(double price, double amountInserted){
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
            double changeLeft = amountInserted - price;
            System.out.println("Purchase successful. Change due: $" + String.format("%.2f", changeLeft)  + "\n");

            int numDollars = 0;
            int numQuarters = 0;
            int numDimes = 0;
            int numNickels = 0;
            int numPennies = 0;

            while(changeLeft > 0){
                if(changeLeft - 1 >= 0){
                    changeLeft -= 1;
                    numDollars++;
                } else if (changeLeft - 0.25 >= 0){
                    changeLeft -= 0.25;
                    numQuarters++;
                } else if (changeLeft - 0.10 >= 0){
                    changeLeft -= 0.10;
                    numDimes++;
                } else if (changeLeft - 0.05 >= 0){
                    changeLeft -= 0.05;
                    numNickels++;
                } else {
                    changeLeft -= 0.01;
                    numPennies++;
                }
            }

            System.out.println("Change Denominations:");
            if(numDollars!=0){
                System.out.println(numDollars + " Dollars");
            }
            if(numQuarters!=0){
                System.out.println(numQuarters + " Quarters");
            }
            if(numDimes!=0){
                System.out.println(numDimes + " Dimes");
            }
            if(numNickels!=0){
                System.out.println(numNickels + " Nickels");
            }
            if(numPennies!=0){
                System.out.println(numPennies + " Pennies");
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================== Basic Tests =====================");
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

        //***************************************************************/
        //Stretch Goal 1 (Multiple Items) Tests
        System.out.println("=================== Stretch Goal 1 Tests =====================");

        //Successful Purchase
        System.out.println("amountInserted = 10, price = 1, 2, 3");
        multiVendingMachine(10, 1, 2, 3);

        //Insufficient Funds
        System.out.println("amountInserted = 10, price = 1, 2, 3, 4, 5");
        multiVendingMachine(10, 1, 2, 3, 4, 5);

        //Exact change
        System.out.println("amountInserted = 10, price = 1, 2, 3, 4");
        multiVendingMachine(10, 1, 2, 3, 4);

        //Invalid Inputs
        System.out.println("amountInserted = 10, price = 1, -2, 3");
        multiVendingMachine(10, 1, -2, 3);

        System.out.println("amountInserted = -10, price = 1, 2, 3");
        multiVendingMachine(-10, 1, 2, 3);

        //***************************************************************/
        //Stretch Goal 2 (Change owed) Tests
        System.out.println("=================== Stretch Goal 2 Tests =====================");

        //Successful Purchase
        System.out.println("price = 1.75, amountInserted = 2.40");
        vendingMachineWithChange(1.75, 2.40);

        System.out.println("price = 1.45, amountInserted = 3.64");
        vendingMachineWithChange(1.45, 3.64);






        //In case I need to test using custom inputs from console
//        System.out.println("Insert Price:");
//        double price = scanner.nextDouble();
//        System.out.println("Insert $$$ into Machine:");
//        double amountInserted = scanner.nextDouble();
//
//        vendingMachine(price, amountInserted);
    }
}