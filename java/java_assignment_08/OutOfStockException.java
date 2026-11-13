public class OutOfStockException extends InventoryException {
    private int requested;
    private int available;

    public OutOfStockException(int requested, int available) {
        super("Out of stock. Requested " + requested + ", but only " + available + " available.");
        this.requested = requested;
        this.available = available;
    }

    public int getRequested() {
        return requested;
    }

    public int getAvailable() {
        return available;
    }
}