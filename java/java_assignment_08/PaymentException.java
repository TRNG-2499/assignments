public class PaymentException extends Exception {

    public PaymentException() {
        super("Payment Exception");
    }

    public PaymentException(String s) {
        super(s);
    }
}
