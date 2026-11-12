import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUP() {
        cart = new ShoppingCart();
    }

    // Test normal condition
    @Test
    void addItemValid() {
        cart.addItem("Apple", 1.0, 2);
        assertEquals(2, cart.getSubtotal(), 0.001);
    }

    // Test add same item
    @Test
    void addItemSameItem() {
        cart.addItem("Banana", 1.0, 2);
        cart.addItem("Banana", 1.0, 3);
        assertEquals(5, cart.getSubtotal(), 0.001);
    }

    // Test invalid item quantity
    @Test
    void addItemInvalid() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Carrot", 1.0, 0));
    }

    // Remove successful
    @Test
    void removeItemValid() {

        cart.addItem("Apple", 1.0, 2);
        assertTrue(cart.removeItem("Apple"));
        assertEquals(0, cart.getSubtotal(), 0.001);

    }

    // Remove empty cart
    @Test
    void removeItemInvalid() {
        assertFalse(cart.removeItem("Banana"));
    }

    // Remove item twice
    @Test
    void removeItemTwice() {
        cart.addItem("Apple", 1.0, 2);
        assertTrue(cart.removeItem("Apple"));
        assertFalse(cart.removeItem("Apple"));
    }

    // Get valid item count
    @Test
    void getItemCountValid() {
        cart.addItem("Apple", 1.0, 2);
        cart.addItem("Banana", 1.0, 3);
        cart.addItem("Carrot", 1.0, 4);
        assertEquals(3, cart.getItemCount());
    }

    // Get item count for same item added twice
    @Test
    void getItemCountSameItem() {
        cart.addItem("Apple", 1.0, 2);
        cart.addItem("Apple", 1.0, 3);
        assertEquals(1, cart.getItemCount());
    }

    // Get item count with different casing for same item
    @Test
    void getItemCountCasing() {
        cart.addItem("Apple", 1.0, 2);
        cart.addItem("apple", 1.0, 3);

        assertEquals(2, cart.getItemCount());

    }

    // Get subtotal for valid items
    @Test
    void getSubtotalValid() {
        cart.addItem("Apple", 1.0, 2);
        cart.addItem("Banana", 2.5, 3);
        assertEquals(9.5, cart.getSubtotal(), 0.001);
    }

    // Get subtotal for empty cart
    @Test
    void getSubtotalEdgeCase() {
        assertEquals(0, cart.getSubtotal(), 0.001);
    }

    // Get subtotal after discount(price unchanged)
    @Test
    void getSubtotalAfterRemove() {
        cart.addItem("Apple", 1.0, 1);
        cart.addItem("Banana", 3, 3);
        cart.applyDiscountCode("SAVE10");

        assertEquals(10.0, cart.getSubtotal(), 0.001);
    }

    // Apply discount
    @Test
    void applyDiscountCodeValid() {
        cart.addItem("Apple", 2.0, 5);
        cart.applyDiscountCode("SAVE10");
        assertEquals(9.0, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCodeReplace() {
        cart.addItem("Apple", 2.0, 5);
        cart.applyDiscountCode("SAVE10");
        cart.applyDiscountCode("SAVE20");
        assertEquals(8.0, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCodeReplaceHalf() {
        cart.addItem("Apple", 2.0, 5);
        cart.applyDiscountCode("SAVE10");
        cart.applyDiscountCode("SAVE20");
        cart.applyDiscountCode("HALFOFF");
        assertEquals(5.0, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCodeInvalid() {
        cart.addItem("Apple", 2.0, 5);
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(null));
    }

    @Test
    void getTotal_emptyCart_returnsZero() {
        assertEquals(0.0, cart.getTotal(), 0.001);
    }

    // Check add discount before adding item
    @Test
    void getTotal_discountAppliedBeforeAddingItem_discountsNewItem() {
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        cart.addItem("Book", 10.00, 2);

        assertEquals(16.00, cart.getTotal(), 0.001);
    }

    // Check no rounding
    @Test
    void getTotal_fractionalResult_isNotRounded() {
        cart.addItem("Candy", 0.99, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(0.891, cart.getTotal(), 0.000001);
    }
}
