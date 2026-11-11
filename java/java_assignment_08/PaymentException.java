public class PaymentException extends Exception{
    public PaymentException(){
        super("There is something wrong with the payment");
    }
    public PaymentException(String msg){
        super(msg);
    }
}

class PaymentDeclinedException extends PaymentException{
    public PaymentDeclinedException(){
        super("Payment declined due to payment amount being less than total");
    }
    public PaymentDeclinedException(String msg){
        super(msg);
    }
}

class PaymentExpiredException extends PaymentException{
    public PaymentExpiredException(){
        super("The payment method is expired");
    }
    public PaymentExpiredException(String msg){
        super(msg);
    }
}
