


public class VendingMachine {

    public void makePurchase( double itemPrice, double amountPaid) {
        if (itemPrice < 0) {
            System.out.println("Invalid Input: Item price cannot be negative");
            return;
            
        } 
        if (amountPaid < 0) {
            System.out.println("Invalid Input: Amount cannot be negative");
            return;
        }

        if (amountPaid < itemPrice) {
            double missingAmount = itemPrice - amountPaid;
            System.out.println("Insufficient funds, please Insert $" +missingAmount + " more.");
            return;
        }

        else {
            double change = amountPaid - itemPrice;
            System.out.println("Purchase successful. Change due: $" + change);
            return;
        }
    }

    public void buyMultipleItems(double[] itemPrices, double amountPaid) {
        double totalPrice = 0;
        for (double elem : itemPrices) {
            totalPrice += elem; 
        }

        makePurchase(totalPrice, amountPaid);
    }

    

    public static void main(String[] args) {
        VendingMachine myVendingMachine = new VendingMachine();

        myVendingMachine.makePurchase(-1.5, 2.6);
        myVendingMachine.makePurchase(1.5, -2.6);
        myVendingMachine.makePurchase(-1.5, -2.6);
        myVendingMachine.makePurchase(2.6, 1.5);
        myVendingMachine.makePurchase(1.5, 1.5);
        myVendingMachine.makePurchase(1.5, 2.6);

        double[] multipleItemPrices = {1,2,3,4};
        myVendingMachine.buyMultipleItems(multipleItemPrices, 5);
        myVendingMachine.buyMultipleItems(multipleItemPrices, 10);
    }
}