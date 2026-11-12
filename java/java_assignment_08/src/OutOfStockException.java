public class OutOfStockException extends InventoryException {
    public OutOfStockException(int requested, int available) {
        super("Requested " + requested + ", but only " + available + " available.");
    }
}
