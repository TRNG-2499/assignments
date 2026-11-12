public class OutOfStockException extends InventoryException {

    private String item;
    private int requestedQty;
    private int availableStock;

    public OutOfStockException(String message) {
        super(message);
    }

    public OutOfStockException(String message, String item, int requestedQty, int availableStock) {
        super(
            message + " (Item: " + item + ", Requested Quantity: " + requestedQty + ", Available Stock: " + availableStock + ")"
        );
        this.item = item;
        this.requestedQty = requestedQty;
        this.availableStock = availableStock;
    }

    public String getItem() {
        return item;
    }

    public int getRequestedQty() {
        return requestedQty;
    }
    
    public int getAvailableStock() {
        return availableStock;
    }
}
