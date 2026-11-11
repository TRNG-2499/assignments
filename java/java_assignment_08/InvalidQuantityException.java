public class InvalidQuantityException extends InventoryException {
  public InvalidQuantityException(String explanation) {
    super("Invalid quantity: " + explanation);
  }
}
