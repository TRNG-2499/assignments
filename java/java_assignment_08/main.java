import java.lang.Exception;

class Main {
    public class InventoryException extends Exception {
        public class OutOfStockException extends InventoryException {

        }
        public class InvalidQuantityException extends InventoryException {

        }
    }

    public class PaymentException extends Exception {
        public class ExceptionPaymentDeclinedException extends PaymentException {

        }
        public class PaymentExpiredException extends PaymentException {

        }
    }

    public static void main(String[] args) {
        System.out.println("hi mom");
    }
}