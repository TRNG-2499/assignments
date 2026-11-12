package java.java_assignment_08;

public class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException(){
        super("Payment failed: the payment method has expired. " + "Please update your card details.");
    }
}
