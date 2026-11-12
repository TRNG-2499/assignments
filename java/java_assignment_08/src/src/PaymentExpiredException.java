public class PaymentExpiredException extends PaymentException{
    public PaymentExpiredException() {
        super("Order failed: Payment method expired.");
    }
}
