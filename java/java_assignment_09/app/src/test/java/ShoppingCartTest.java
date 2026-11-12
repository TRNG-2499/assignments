import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/*
 * ShoppingCart::getItemCount returns the number of unique items
 * and not the total number of items as described
 *
 * As such, getItemCountSingularItemTest and getItemCountManyItemsTest
 * both fail.
 */

public class ShoppingCartTest {
  private final ShoppingCart cart = new ShoppingCart();

  @Test
  void addItemNullTest() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      cart.addItem(null, 1, 10);
    });
    assertEquals("Item name must not be null or blank.", e.getMessage());
  }

  @Test
  void addItemNegativePriceTest() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      cart.addItem("asdf", -2.0, 10);
    });
    assertEquals("Price must not be negative.", e.getMessage());
  }

  @Test
  void addItemInvalidQuantityTest() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      cart.addItem("asdf", 3, 0);
    });
    assertEquals("Quantity must be at least 1.", e.getMessage());
  }

  @Test
  void removeItemInCartTest() {
    cart.addItem("asdf", 2, 3);
    assertEquals(true, cart.removeItem("asdf"));
  }

  @Test
  void removeItemNotEmptyButDoesntContainTheRemovedItemTest() {
    cart.addItem("asdf 2", 2, 3);
    assertEquals(false, cart.removeItem("asdf"));
  }

  @Test
  void removeItemEmptyCartTest() {
    assertEquals(false, cart.removeItem("asdf"));
  }

  @Test
  void getItemCountEmptyTest() {
    assertEquals(0, cart.getItemCount());
  }

  @Test
  void getItemCountSingularItemTest() {
    cart.addItem("asdf", 4, 2);
    assertEquals(2, cart.getItemCount());
  }

  @Test
  void getItemCountManyItemsTest() {
    cart.addItem("asdf", 4, 3);
    cart.addItem("asdf 2", 4, 7);
    assertEquals(10, cart.getItemCount());
  }

  @Test
  void getSubtotalEmptyCartTest() {
    assertEquals(0, cart.getSubtotal(), 0.01);
  }

  @Test
  void getSubtotalOneSingularItemTest() {
    cart.addItem("asdf", 4.5, 1);
    assertEquals(4.5, cart.getSubtotal(), 0.01);
  }

  @Test
  void getSubtotalManyItemsTest() {
    cart.addItem("asdf", 4.5, 4);
    assertEquals(4.5 * 4, cart.getSubtotal(), 0.01);
  }

  @Test
  void applyDiscountCodeNullTest() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      cart.applyDiscountCode(null);
    });
    assertEquals("Discount code must not be null.", e.getMessage());
  }

  @Test
  void applyDiscountCodeInvalidCodeTest() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      cart.applyDiscountCode("asdf");
    });
    assertEquals("Invalid discount code: asdf", e.getMessage());
  }

  @Test
  void applyDiscountCodeSave10Test() {
    assertDoesNotThrow(() -> {
      cart.applyDiscountCode("SAVE10");
    });
  }

  @Test
  void getTotalEmptyCartTest() {
    assertEquals(0, cart.getTotal(), 0.01);
  }

  @Test
  void getTotalNoDiscountTest() {
    cart.addItem("asdf", 4.5, 4);
    assertEquals(4.5 * 4, cart.getTotal(), 0.01);
  }

  @Test
  void getTotalSave10Test() {
    cart.addItem("asdf", 4.5, 4);
    cart.applyDiscountCode("SAVE10");
    assertEquals(4.5 * 4 * 0.9, cart.getTotal(), 0.01);
  }
}
