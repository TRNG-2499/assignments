import java.io.*;
import java.util.*;

public class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException(String itemName, int requestedQuantity, double paymentAmount, double totalOrderCost){
        super(String.format("Insufficient Funds: %d %s, payment: $%.2f, cost: $%.2f!", requestedQuantity, itemName, paymentAmount, totalOrderCost));
    }
}