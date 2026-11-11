public class OutOfStockException extends InventoryException {
  public OutOfStockException(String explanation) {
    super("Out of stock: " + explanation);
  }
}
