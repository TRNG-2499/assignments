public class Payment {
    
    public void checkPayment(int req_quantity, int pay_amount, int cost, boolean expired) throws PaymentException{
        if(expired == false){
            throw new PaymentExpiredException("Payment method expired.");
        }
        if(pay_amount < (req_quantity * cost)){
            throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
        }
    }
}
