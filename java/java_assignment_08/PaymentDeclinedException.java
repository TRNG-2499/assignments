public class PaymentDeclinedException extends PaymentException {
  public PaymentDeclinedException(String explanation) {
    super("Declined: " + explanation);
  }
}
