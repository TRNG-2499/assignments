package com.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Method: getItemCount()
 * Failing Tests: getItemCount_multipleDistinctItems_returnsTotalQuantity, 
 *                getItemCount_itemWithQuantityGreaterThanOne_returnsCorrectQuantity
 * Explanation: getItemCount() returns items.size() (the number of unique item entries in the map) 
 * instead of summing the quantities of all items in the cart. When multiple distinct 
 * items or items with quantities greater than 1 are added, the item count reflects the number of 
 * distinct keys rather than the total aggregate quantity.
 * 
 */
class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void addItem_validItem_addsSuccessfully() {
        cart.addItem("Apple", 1.5, 3);
        assertFalse(cart.isEmpty());
    }

    @Test
    void addItem_existingItem_increasesQuantity() {
        cart.addItem("Apple", 1.5, 2);
        cart.addItem("Apple", 1.5, 3);
        assertEquals(7.5, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItem_nullOrBlankName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 1.0, 1));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("", 1.0, 1));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("   ", 1.0, 1));
    }

    @Test
    void addItem_negativePrice_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", -0.01, 1));
    }

    @Test
    void addItem_invalidQuantity_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", 1.0, 0));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", 1.0, -3));
    }

    @Test
    void removeItem_existingItem_returnsTrueAndRemoves() {
        cart.addItem("Banana", 0.5, 4);
        boolean removed = cart.removeItem("Banana");
        assertTrue(removed);
        assertTrue(cart.isEmpty());
    }

    @Test
    void removeItem_nonExistentItem_returnsFalse() {
        boolean removed = cart.removeItem("NonExistent");
        assertFalse(removed);
    }

    @Test
    void removeItem_nullOrBlankName_returnsFalse() {
        cart.addItem("Banana", 0.5, 2);
        assertFalse(cart.removeItem(null));
        assertFalse(cart.removeItem(""));
    }

    @Test
    void getItemCount_emptyCart_returnsZero() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void getItemCount_multipleDistinctItems_returnsTotalQuantity() {
        cart.addItem("Apple", 1.0, 2);
        cart.addItem("Banana", 0.5, 3);
        assertEquals(5, cart.getItemCount());
    }

    @Test
    void getItemCount_itemWithQuantityGreaterThanOne_returnsCorrectQuantity() {
        cart.addItem("Milk", 3.0, 4);
        assertEquals(4, cart.getItemCount());
    }

    @Test
    void getSubtotal_emptyCart_returnsZero() {
        assertEquals(0.0, cart.getSubtotal(), 0.001);
    }

    @Test
    void getSubtotal_singleItem_returnsCorrectSubtotal() {
        cart.addItem("Coffee", 5.50, 2);
        assertEquals(11.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void getSubtotal_multipleItems_returnsCorrectSum() {
        cart.addItem("Coffee", 5.0, 2); // 10.0
        cart.addItem("Tea", 2.0, 3);    // 6.0
        assertEquals(16.0, cart.getSubtotal(), 0.001);
    }

    @Test
    void applyDiscountCode_validSave10_appliesSuccessfully() {
        assertDoesNotThrow(() -> cart.applyDiscountCode(ShoppingCart.CODE_SAVE10));
    }

    @Test
    void applyDiscountCode_replacesExistingDiscount() {
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        cart.addItem("Item", 100.0, 1);
        assertEquals(80.0, cart.getTotal(), 0.001);

        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        assertEquals(50.0, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCode_invalidOrNullCode_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(null));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("INVALID"));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10")); // Case-sensitive check
    }

    @Test
    void getTotal_noDiscount_returnsSubtotal() {
        cart.addItem("Book", 20.0, 2);
        assertEquals(40.0, cart.getTotal(), 0.001);
    }

    @Test
    void getTotal_withSave10Discount_returnsCorrectTotal() {
        cart.addItem("Book", 100.0, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        assertEquals(90.0, cart.getTotal(), 0.001);
    }

    @Test
    void getTotal_emptyCartWithDiscount_returnsZero() {
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        assertEquals(0.0, cart.getTotal(), 0.001);
    }

    }