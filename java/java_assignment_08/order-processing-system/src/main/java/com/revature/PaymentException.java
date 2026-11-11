package com.revature;

// parent for every payment-related problem, so callers can catch them all with one catch block
public class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}
