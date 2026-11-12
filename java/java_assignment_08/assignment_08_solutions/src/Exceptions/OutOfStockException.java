package Exceptions;

public class OutOfStockException extends InventoryException {
    private int requested;
    private int available;

    public OutOfStockException() {
        super("Error: Inventory is out of stock.");
    }
    public OutOfStockException(String message) {
        super(message);
    }
    public OutOfStockException(int requested, int available) {
        this.requested = requested;
        this.available = available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
    public int getAvailable() {
        return this.available;
    }
    public void setRequested(int requested) {
        this.requested = requested;
    }
    public int getRequested() {
        return this.requested;
    }
}