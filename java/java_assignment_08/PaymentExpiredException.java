package assignments.java.java_assignment_08;

public class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException() {
		super("Order failed: Payment method is expired");
	}
}
