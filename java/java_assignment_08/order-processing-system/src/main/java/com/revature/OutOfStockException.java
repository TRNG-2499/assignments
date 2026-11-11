package com.revature;

public class OutOfStockException extends InventoryException {
    // stretch goal 1
    // kept as fields so a catch block can use the numbers directly instead of reading them out of the message
    private final int requestedQuantity;
    private final int availableStock;

    public OutOfStockException(int requestedQuantity, int availableStock) {
        super("Out of stock. Requested " + requestedQuantity + ", but only " + availableStock + " available.");
        this.requestedQuantity = requestedQuantity;
        this.availableStock = availableStock;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public int getAvailableStock() {
        return availableStock;
    }
}
