public class orderProcessingSystemGP {
    public static void main(String args[]) throws OutOfStockException, InvalidQuantityException, PaymentDeclinedException, PaymentExpiredException {
        //Valid
        System.out.println(processOrder("Lego brick", 10, 100, 10.0, 1.0, false));
        try{
            //PaymentDeclined
            System.out.println(processOrder("Lambo", 1, 10, 10.0, 100.0, false));
        } catch(PaymentDeclinedException e) {
            System.out.println("Order failed, payment was declined");
        }
        try {
            //InvalidQuantity
            System.out.println(processOrder("Stove", -1, 10, 1000.0, 100.0, false));
        } catch(InvalidQuantityException e) {
            System.out.println("Quantity was given as negative");
        }
        try {
            //PaymentExpired
            System.out.println(processOrder("Pizza", 1, 10, 10.0, 5.0, true));
        } catch(PaymentExpiredException e) {
            System.out.println("Payment is expired");
        }
        try {
            //OutOfStock
            System.out.println(processOrder("Labubu", 100, 2, 10.0, 2.0, false));
        } catch(OutOfStockException e) {
            System.out.println("Item does not have enough stock");
        }

    }
    public static String processOrder(String itemName, int quantity, int itemStock, double payment, double cost, boolean expired) throws OutOfStockException, InvalidQuantityException, PaymentDeclinedException, PaymentExpiredException{
        if(quantity > itemStock) {
            throw new OutOfStockException();
        }
        if (quantity <= 0) {
            throw new InvalidQuantityException();
        }
        if(expired) {
            throw new PaymentExpiredException();
        }
        if(cost > payment) {
            throw new PaymentDeclinedException();
        }
        return "Successful order, you ordered "+quantity+" many "+itemName+"(s)";
    }
}

class inventoryException extends Exception {
    public inventoryException() {}

    public inventoryException(String message) {
        super(message);
    }
}

class paymentException extends Exception {
    public paymentException() {}

    public paymentException(String message) {
        super(message);
    }
}

class OutOfStockException extends inventoryException {
    public OutOfStockException() {
        super("Order requested more of a item than is in stock");
    }

    public OutOfStockException(String message) {
        super(message);
    }
}

class InvalidQuantityException extends inventoryException {
    public InvalidQuantityException() {
        super("Order requested zero or negative value of items");
    }

    public InvalidQuantityException(String message) {
        super(message);
    }
}

class PaymentDeclinedException extends paymentException {
    public PaymentDeclinedException() {
        super("Payment declined, payment is less than amount needed");
    }

    public PaymentDeclinedException(String message) {
        super(message);
    }
}

class PaymentExpiredException extends paymentException {
    public PaymentExpiredException() {
        super("Payment is expired");
    }

    public PaymentExpiredException(String message) {
        super(message);
    }
}