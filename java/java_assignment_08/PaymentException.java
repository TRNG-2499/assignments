
public class PaymentException extends Exception{
    public PaymentException(String message)
    {
        super("Order Failed: " + message);
    }
}
