package payment;

import payment.PaymentException;

public class PaymentDeclinedException extends PaymentException {

    public PaymentDeclinedException (String message){
        super(message);
    }
}
