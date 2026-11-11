package com.revature;

public class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException() {
        super("Payment declined. Insufficient funds.");
    }
}
