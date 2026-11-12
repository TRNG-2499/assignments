package Exceptions;

public class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException() {
        super("Error: Payment declined.");
    }
    public PaymentDeclinedException(String message) {
        super(message);
    }
}