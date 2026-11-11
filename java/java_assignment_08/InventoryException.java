public class InventoryException extends Exception {
  public InventoryException(String explanation) {
    super("Inventory issue: " + explanation);
  }
}
