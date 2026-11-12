public class OutOfStockExceptionPlus extends InventoryException {
    public OutOfStockExceptionPlus(String message, int quantity, int stock) {
        super(message);
    }
}
