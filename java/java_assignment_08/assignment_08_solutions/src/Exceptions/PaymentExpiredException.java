package Exceptions;

public class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException() {
        super("Error: Payment expired.");
    }
    public PaymentExpiredException(String message) {
        super(message);
    }
}