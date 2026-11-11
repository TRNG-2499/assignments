public class OutOfStockException extends InventoryException {

    public OutOfStockException(int quant, int avail) {
        super(String.format(
            "Order failed: Out of stock. Requested %d, but only %d available.",
            quant,
            avail
        ));
    }
}
