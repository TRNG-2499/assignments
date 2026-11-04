public class InsufficientFundsException extends Exception {
  public InsufficientFundsException(Money given, Money required) {
    super(String.format("Insufficient funds: %s given, %s required, %s more needed", given, required,
        required.absoluteDifference(given)));
  }
}
