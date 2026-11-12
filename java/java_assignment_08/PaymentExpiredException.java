public class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException() {
        String message = "Payment method has expired!";
        super(message);
    }
}
