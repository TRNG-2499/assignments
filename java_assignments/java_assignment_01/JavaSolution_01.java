package java_assignments.java_assignment_01;
import java.util.ArrayList;
import java.util.Arrays;
public class JavaSolution_01{
    public static void main(String [] args){
        //changeMaker(1.50, -1.00);

        ArrayList<Double> prices = new ArrayList<>(Arrays.asList(4.0, 2.0, 3.0));

        changeMakerStretch(prices, 9);
    }

    public static void changeMaker(double itemPrice, double moneyIn){
        if(itemPrice < 0.0 || moneyIn < 0){
            System.out.println("Invalid input.");
        } else if(moneyIn < itemPrice){
            System.out.println("Insufficient funds. Please add $" + Math.abs((moneyIn-itemPrice)));
        } else {
            System.out.println("Purchase successful. Change due: $" + (moneyIn-itemPrice));
        }
    }

    public static void changeMakerStretch(ArrayList<Double> itemPrices, double moneyIn){
        double totalPrice = 0;
        for(Double item : itemPrices){
            if(item < 0.0 ){
                System.out.println("Invalid item!");
                return;
            }

            totalPrice += item;
        }
        if(moneyIn < 0){
            System.out.println("Invalid amount inserted!");
        } else if(moneyIn < totalPrice){
            System.out.println("Insufficient funds. Please add $" + Math.abs((moneyIn-totalPrice)));
        } else {
            System.out.println("Purchase successful. Change due: $" + (moneyIn-totalPrice));
        }
    }
}