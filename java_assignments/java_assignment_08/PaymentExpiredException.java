package java_assignments.java_assignment_08;

public class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException(){
        super("Payment declined. Payment method is expired.");
    }
    
}
