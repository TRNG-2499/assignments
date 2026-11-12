package java.java_assignment_08;

public class PaymentdeclineException extends PaymentException{
    public PaymentdeclineException(double paymentAmount, double totalCost){
        super(String.format("Payment declined: paid $%.2f, but the order total is $%.2f " + "(short by $%.2f).", paymentAmount, totalCost, totalCost - paymentAmount));
    }
}
