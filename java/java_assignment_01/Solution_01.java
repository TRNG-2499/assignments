public class Solution_01 {

  public static void main(String[] args) {
    System.out.println(transaction(-1.5, 2.0));
    System.out.println(transaction(1.5, -2.0));
    System.out.println(transaction(1.5, 1.0));
    System.out.println(transaction(1.5, 1.5));
    System.out.println(transaction(1.5, 2.0));

    System.out.println(multiTransaction(10.0, 2.0, 3.0, 1.0));
    System.out.println(multiTransaction(5.0, 2.0, 3.0));
    System.out.println(multiTransaction(5.0, 2.0, 3.0, 1.0));

    System.out.println(makeChange(0.00));
    System.out.println(makeChange(0.01));
    System.out.println(makeChange(0.05));
    System.out.println(makeChange(0.10));
    System.out.println(makeChange(0.25));
    System.out.println(makeChange(1.00));
    System.out.println(makeChange(1.41));
    System.out.println(makeChange(5.99));
  }

  public static String transaction(double cost, double availMoney) {
    if (cost < 0) {
      return "Invalid input - Cost cannot be negitive";
    }
    if (availMoney < 0) {
      return "Invalid input - Availible funds, cannot be negitive";
    }

    if (cost > availMoney) {
      double amountNeeded = cost - availMoney;
      return String.format(
        "Insufficient funds - You need another $%.2f to make this purchase",
        amountNeeded
      );
    }

    double change = availMoney - cost;
    return String.format(
      "Purchase was successful! Your change is $%.2f",
      change
    );
  }

  public static String multiTransaction(double availMoney, double... items) {
    double itemTotals = 0;
    for (int i = 0; i < items.length; i++) {
      itemTotals = itemTotals + items[i];
    }
    return transaction(itemTotals, availMoney);
  }

  // without changing my transaction method i did not know how to impliment this
  public static String makeChange(double changeToGive) {
    int dollar = 0;
    int quarter = 0;
    int dime = 0;
    int nickel = 0;
    int penny = 0;
    int change = (int) Math.round(changeToGive * 100);

    while (change >= 100) {
      dollar++;
      change = change - 100;
    }
    while (change >= 25) {
      quarter++;
      change = change - 25;
    }
    while (change >= 10) {
      dime++;
      change = change - 10;
    }
    while (change >= 5) {
      nickel++;
      change = change - 5;
    }
    while (change >= 1) {
      penny++;
      change = change - 1;
    }
    return String.format(
      "Dollars: %d, Quarters: %d, Dimes: %d, Nickels: %d, Pennies: %d",
      dollar,
      quarter,
      dime,
      nickel,
      penny
    );
  }
}
