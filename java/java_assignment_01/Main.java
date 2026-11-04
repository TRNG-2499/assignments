public class Main {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Invalid input: must be two amounts");
    }

    calculateChange(args[0], args[1]);
  }

  private static void calculateChange(String provided, String required) {
    try {
      Money providedMoney = new Money(provided);
      Money requiredMoney = new Money(required);

      Money change = providedMoney.take(requiredMoney);

      System.out.printf("Purchase successful. Change dispensed: %s\n", change);
    } catch (NumberFormatException e) {
      System.out.printf("Invalid format for money: %s\n", e.getMessage());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
