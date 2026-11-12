package assignments.java.java_assignment_08.exceptions;

public class PaymentDeclinedException extends PaymentException {

    public PaymentDeclinedException(float paymentAmount, float costAmount) {
        super("Declined - The payment amount is less than the order's total cost. Cost of order: $" + costAmount
                + "Payment amount: $" + paymentAmount);
        // TODO Auto-generated constructor stub
    }

}
