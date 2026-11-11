package java_assignments.java_assignment_08;

public class PaymentDeclinedException extends PaymentException{
    public PaymentDeclinedException(){
        super("Payment declined. Insuffiecient funds.");
    }
}
