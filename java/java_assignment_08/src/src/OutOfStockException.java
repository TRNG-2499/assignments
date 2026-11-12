public class OutOfStockException extends InventoryException {
    int quantity;
    int stock;
    public OutOfStockException(int quantity, int stock) {
        super("Order failed: Out of stock. Requested " + quantity + ", but only " + stock + " available.");
        this.quantity = quantity;
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }
    public int getStock() {
        return stock;
    }
}
