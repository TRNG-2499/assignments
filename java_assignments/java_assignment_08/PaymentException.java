package java_assignments.java_assignment_08;

public class PaymentException extends Exception {
    public PaymentException(){
        super("Inventory error.");
    }

    public PaymentException(String message){
        super(message);
    }
}
