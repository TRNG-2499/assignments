public class PaymentException extends Exception {
  public PaymentException(String explanation) {
    super("Payment issue: " + explanation);
  }
}
