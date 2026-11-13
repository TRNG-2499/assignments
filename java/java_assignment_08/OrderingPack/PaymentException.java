package OrderingPack;

public class PaymentException extends Exception{
    public PaymentException(String message) {
        super(message);
    }
}
class PaymentDeclinedException extends PaymentException{

    public PaymentDeclinedException(String message) {
        super(message);
    }
}
class PaymentExpiredException extends PaymentException{

    public PaymentExpiredException(String message) {
        super(message);
    }
}
