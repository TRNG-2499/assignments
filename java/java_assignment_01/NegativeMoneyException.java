public class NegativeMoneyException extends Exception {
  public NegativeMoneyException() {
    super("Money amounts should not be negative.");
  }
}
