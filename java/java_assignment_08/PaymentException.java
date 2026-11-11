import java.io.*;
import java.util.*;

public class PaymentException extends Exception {
    public PaymentException(String message){
        super(message);
    }
}