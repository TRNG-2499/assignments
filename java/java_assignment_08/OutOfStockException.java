public class OutOfStockException extends InventoryException {
    private final int requestedQuantity;
    private final int availableStock;

    public OutOfStockException(int requested, int available) {
        super("Order failed: Out of stock. Requested " + requested + ", but only " + available + " available");
        this.requestedQuantity = requested;
        this.availableStock = available;
    }

    public int getRequestedQuantity() { return requestedQuantity; }
    public int getAvailableStock() { return availableStock; }
}
