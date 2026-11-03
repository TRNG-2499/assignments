public class VendingMachineChangeMaker {
    public static String makeTransation(double itemPrice, double moneyInserted){
        if(itemPrice < 0){
            return "Invalid Input: item price cannot be negative.";
        } else if(moneyInserted < 0){
            return "Invalid Input: amount inserted cannot be negative.";
        } else if(moneyInserted < itemPrice){
            return "Insufficient funds. Please insert at least $" + (itemPrice - moneyInserted) + " more.";
        } else {
            return "Purchase successful. Change due: $" + (moneyInserted - itemPrice);
        }
    }
}