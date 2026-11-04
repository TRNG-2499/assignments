import java.util.*;
import java.text.DecimalFormat;

public static void main(String[] args){
    //Scanner is just for testing
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the price of the product: ");
    double price = scanner.nextDouble();

    System.out.println("Enter the amount inserted: ");
    double amountInserted = scanner.nextDouble();

    purchaseChange(price, amountInserted);

    scanner.close();
}

public static void purchaseChange(double price, double amountInserted){
    DecimalFormat df = new DecimalFormat("0.00");
    
    System.out.println("Price = " + df.format(price) + " and amount inserted = " + df.format(amountInserted));
    
    if(price == amountInserted)
        System.out.println("Purchase Successful. $0.00 change due");
    else if(price > amountInserted)
        System.out.println("Purchase failed. Insert $" + df.format((price - amountInserted)) + " to complete purchase");
    else if(price < amountInserted)
        System.out.println("Purchase Successful. Change due: $" + df.format((amountInserted - price)));
}