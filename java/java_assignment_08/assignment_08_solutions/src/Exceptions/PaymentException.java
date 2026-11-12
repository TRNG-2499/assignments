package Exceptions;

public class PaymentException extends Exception {
    public PaymentException() {
        super("Error: Payment exception.");
    }
    public PaymentException(String message) {
        super(message);
    }
}