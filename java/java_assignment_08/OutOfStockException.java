public class OutOfStockException extends InventoryException {
    private int requested;
    private int available;

    // original constructor, still used by newOrder
    public OutOfStockException(String message) {
        super(message);
    }

    // stretch goal: stores the numbers so the catch block can use them
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