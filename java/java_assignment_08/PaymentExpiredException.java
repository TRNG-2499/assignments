import java.io.*;
import java.util.*;

public class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException(){
        super("The payment has been expired!");
    }
}