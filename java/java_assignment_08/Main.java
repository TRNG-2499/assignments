
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Scanner implemented for testing purposes

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the product you would like.");
        String name = scan.nextLine();

        System.out.println("How many would you like?");
        int req_quantity = scan.nextInt();

        System.out.println("Each " + name + " is $6. How much are you paying for it?");
        int pay_amount = scan.nextInt();

        System.out.println("Set the payment expiration to true or false");
        boolean expired = scan.nextBoolean();

        int stock = 4;
        int cost = 6;

        //This sample code should run fine if not using scanner
        // String name = "Pillows";
        // int req_quantity = 2;
        // int pay_amount = 12;
        // boolean expired = true;


        PaymentProcessor(name, req_quantity, stock, pay_amount, cost, expired);

        //If using sample code, comment out scan.close()
        scan.close();
    }

    public static void PaymentProcessor(String name, int req_quantity, int stock, int pay_amount, int cost, boolean expired){
        Inventory inventory = new Inventory();
        Payment payment = new Payment();

        try{
            inventory.checkInventory(req_quantity, stock);
            payment.checkPayment(req_quantity, pay_amount, cost, expired);
            System.out.println("Order Successful.");
        }
        catch (InventoryException e){
            System.out.println("Order Failed: " + e.getMessage());
        }
        catch (PaymentException e){
            System.out.println("Order Failed: " + e.getMessage());
        }
    }
}
