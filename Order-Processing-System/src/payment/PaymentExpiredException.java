package payment;

import payment.PaymentException;

public class PaymentExpiredException extends PaymentException {

    public PaymentExpiredException(String message) {
        super(message);
    }
}
