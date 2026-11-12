public class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException() {
        String message = "Payment has been declined!";
        super(message);
    }
}
