public class Main {
  public static void main(String[] args) {
    try {
      int requested = Integer.parseInt(args[1]);
      int available = Integer.parseInt(args[2]);
      float payment_amount = Float.parseFloat(args[3]);
      float payment_required = Float.parseFloat(args[4]);
      boolean payment_expired = Boolean.parseBoolean(args[5]);

      order(args[0], requested, available, payment_amount, payment_required, payment_expired);
    } catch (PaymentException e) {
      System.err.println(e.getMessage());
    } catch (InventoryException e) {
      System.err.println(e.getMessage());
    } catch (Exception e) {
      System.err.println("Invalid input");
    }
  }

  public static void order(String item_name, int requested, int available, float payment_amount,
      float payment_required, boolean payment_expired) throws InventoryException, PaymentException {
    if (requested < 0) {
      throw new InvalidQuantityException(item_name);
    }

    if (requested > available) {
      throw new OutOfStockException(String.format("%s (%d of %d available)", item_name, available, requested));
    }

    if (payment_expired) {
      throw new PaymentExpiredException();
    }

    if (payment_amount < payment_required) {
      throw new PaymentDeclinedException(
          String.format("Insufficient payment (%.2f short)", payment_amount - payment_required));
    }

    System.out.printf("Order for %dx %s processed...%n", requested, item_name);
  }
}
