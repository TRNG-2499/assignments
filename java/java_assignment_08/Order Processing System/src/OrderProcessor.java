public class OrderProcessor {
  public static void processOrder(
    String itemName,
    int requestedQty,
    int availableStock,
    double paymentAmount,
    double orderCost,
    boolean isExpired)
    throws InventoryException, PaymentException {
      //check inventory
      if (requestedQty <= 0) {
        throw new InvalidQuantityException(
          "Invalid quantity. Quantity must be greater than 0."
          );
        }
      if (requestedQty > availableStock) {
        throw new OutOfStockException(
        "Out of stock. Requested " + requestedQty +
        ", but only " + availableStock + " available."
        );
        }

      //check payment
      if (isExpired) {
        throw new PaymentExpiredException(
        "Payment method expired."
        );
        }
      if (paymentAmount < orderCost) {
        throw new PaymentDeclinedException(
        "Payment declined. Insufficient funds."
        );
        }

      //successful order
      System.out.println(
        "Order successful! " + requestedQty +
        " x " + itemName + " confirmed."
      );
    }
}
