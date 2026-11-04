package java.java_assignment_01;

public class Vending{
    public static double Machine(double price, double inserted) {
        double amount = inserted - price; 
        if(price <= 0 || inserted < 0){
            System.out.println("Invalid input");
            amount = 0;
        }else if (inserted < price){
            System.out.println("Insufficient funds");
        }
        else {
            System.out.println("Transaction successful");
        }
        return amount;
    }
    
    public static void main(String[] args) {
        double price = 10.0;
        double inserted = 5.0;
        double change = Machine(price, inserted);
        if (change > 0){
            System.out.println("You owe: " + change);
        }
        else{
           System.out.println("Change: " + Math.abs(change)); 
        }
    }
    
}
