package assignments.java.java_assignment_08;

public class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException() {
		super("Order failed: Not enough funds.");
	}
}
