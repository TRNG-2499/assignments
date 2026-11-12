public class PaymentDeclinedException extends PaymentException{
    public PaymentDeclinedException() {
        super("Order failed: Payment declined. Insufficient funds.");
    }
}
