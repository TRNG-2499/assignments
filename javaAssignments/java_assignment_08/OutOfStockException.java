package javaAssignments.java_assignment_08;
public class OutOfStockException extends inventoryException {

    public final int stock;
    public final int requested;

    public OutOfStockException(String message, int stock, int requested) {
        this.stock = stock;
        this.requested = requested;
        super("Out of stock: " + stock + " available, " + requested + " requested");
    }

    public int getStock() {
        return stock;
    }

    public int getRequested() {
        return requested;
    }
}
