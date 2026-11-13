// Incorrect method: getItemCount()

// Failing tests:
// - getItemCount_singleItemWithQuantityFive_returnsFive
// - getItemCount_multipleItems_returnsSumOfQuantities
// - getItemCount_sameItemAddedTwice_returnsCombinedQuantity
// - getItemCount_afterRemovingItem_returnsRemainingQuantity

// What it does wrong: it returns the number of distinct items in the cart (items.size()) instead of the total quantity of all items.


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

    private static final double DELTA = 0.001;

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    // ---------- addItem ----------

    @Test
    void addItem_validItem_updatesSubtotal() {
        cart.addItem("Apple", 2.0, 3);

        double subtotal = cart.getSubtotal();

        assertEquals(6.0, subtotal, DELTA);
    }

    @Test
    void addItem_sameNameTwice_combinesQuantityIntoOneLine() {
        cart.addItem("Apple", 2.0, 1);
        cart.addItem("Apple", 2.0, 2);

        double subtotal = cart.getSubtotal();

        assertEquals(6.0, subtotal, DELTA);
    }

    @Test
    void addItem_differentCasing_treatedAsSeparateItems() {
        cart.addItem("apple", 1.0, 1);
        cart.addItem("Apple", 3.0, 1);

        double subtotal = cart.getSubtotal();

        assertEquals(4.0, subtotal, DELTA);
    }

    @Test
    void addItem_zeroPrice_isAllowed() {
        assertDoesNotThrow(() -> cart.addItem("Freebie", 0.0, 1));

        assertEquals(0.0, cart.getSubtotal(), DELTA);
    }

    @Test
    void addItem_nullName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 1.0, 1));
    }

    @Test
    void addItem_blankName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("   ", 1.0, 1));
    }

    @Test
    void addItem_negativePrice_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", -0.01, 1));
    }

    @Test
    void addItem_zeroQuantity_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", 1.0, 0));
    }


    @Test
    void removeItem_existingItem_returnsTrue() {
        cart.addItem("Apple", 1.0, 1);

        boolean result = cart.removeItem("Apple");

        assertTrue(result);
    }

    @Test
    void removeItem_itemNotInCart_returnsFalse() {
        cart.addItem("Apple", 1.0, 1);

        boolean result = cart.removeItem("Banana");

        assertFalse(result);
    }

    @Test
    void removeItem_emptyCart_returnsFalse() {
        boolean result = cart.removeItem("Apple");

        assertFalse(result);
    }

    @Test
    void removeItem_sameItemTwice_secondCallReturnsFalse() {
        cart.addItem("Apple", 1.0, 4);
        cart.removeItem("Apple");

        boolean result = cart.removeItem("Apple");

        assertFalse(result);
    }

    @Test
    void removeItem_differentCasing_returnsFalse() {
        cart.addItem("Apple", 1.0, 1);

        boolean result = cart.removeItem("apple");

        assertFalse(result);
    }

    @Test
    void removeItem_existingItem_removesWholeLineFromSubtotal() {
        cart.addItem("Apple", 2.0, 5);
        cart.addItem("Bread", 3.0, 1);

        cart.removeItem("Apple");

        assertEquals(3.0, cart.getSubtotal(), DELTA);
    }


    @Test
    void getItemCount_emptyCart_returnsZero() {
        int count = cart.getItemCount();

        assertEquals(0, count);
    }

    @Test
    void getItemCount_singleItemWithQuantityFive_returnsFive() {
        cart.addItem("Apple", 1.0, 5);

        int count = cart.getItemCount();

        assertEquals(5, count);
    }

    @Test
    void getItemCount_multipleItems_returnsSumOfQuantities() {
        cart.addItem("Apple", 1.0, 2);
        cart.addItem("Bread", 3.0, 3);

        int count = cart.getItemCount();

        assertEquals(5, count);
    }

    @Test
    void getItemCount_sameItemAddedTwice_returnsCombinedQuantity() {
        cart.addItem("Apple", 1.0, 2);
        cart.addItem("Apple", 1.0, 4);

        int count = cart.getItemCount();

        assertEquals(6, count);
    }

    @Test
    void getItemCount_afterRemovingItem_returnsRemainingQuantity() {
        cart.addItem("Apple", 1.0, 2);
        cart.addItem("Bread", 3.0, 3);
        cart.removeItem("Apple");

        int count = cart.getItemCount();

        assertEquals(3, count);
    }


    @Test
    void getSubtotal_emptyCart_returnsZero() {
        double subtotal = cart.getSubtotal();

        assertEquals(0.0, subtotal, DELTA);
    }

    @Test
    void getSubtotal_multipleItems_returnsSumOfPriceTimesQuantity() {
        cart.addItem("Apple", 2.50, 2);
        cart.addItem("Bread", 1.25, 4);

        double subtotal = cart.getSubtotal();

        assertEquals(10.0, subtotal, DELTA);
    }

    @Test
    void getSubtotal_afterRemovingItem_excludesRemovedItem() {
        cart.addItem("Apple", 2.0, 3);
        cart.addItem("Bread", 4.0, 1);
        cart.removeItem("Bread");

        double subtotal = cart.getSubtotal();

        assertEquals(6.0, subtotal, DELTA);
    }

    @Test
    void getSubtotal_withDiscountApplied_isNotReduced() {
        cart.addItem("Laptop", 100.0, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        double subtotal = cart.getSubtotal();

        assertEquals(100.0, subtotal, DELTA);
    }


    @Test
    void applyDiscountCode_validCode_doesNotThrow() {
        assertDoesNotThrow(() -> cart.applyDiscountCode(ShoppingCart.CODE_SAVE10));
    }

    @Test
    void applyDiscountCode_nullCode_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(null));
    }

    @Test
    void applyDiscountCode_unknownCode_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("BOGUS"));
    }

    @Test
    void applyDiscountCode_wrongCasing_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
    }

    @Test
    void applyDiscountCode_secondValidCode_replacesFirstCode() {
        cart.addItem("Laptop", 100.0, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        assertEquals(80.0, cart.getTotal(), DELTA);
    }

    @Test
    void applyDiscountCode_invalidCodeAfterValidOne_keepsPreviousDiscount() {
        cart.addItem("Laptop", 100.0, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("BOGUS"));

        assertEquals(90.0, cart.getTotal(), DELTA);
    }

    // ---------- getTotal ----------

    @Test
    void getTotal_noDiscount_equalsSubtotal() {
        cart.addItem("Apple", 2.5, 4);

        double total = cart.getTotal();

        assertEquals(10.0, total, DELTA);
    }

    @Test
    void getTotal_withSave10_takesTenPercentOff() {
        cart.addItem("Laptop", 100.0, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        double total = cart.getTotal();

        assertEquals(90.0, total, DELTA);
    }

    @Test
    void getTotal_withHalfOff_takesFiftyPercentOff() {
        cart.addItem("Laptop", 100.0, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        double total = cart.getTotal();

        assertEquals(50.0, total, DELTA);
    }

    @Test
    void getTotal_emptyCartWithDiscount_returnsZero() {
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        double total = cart.getTotal();

        assertEquals(0.0, total, DELTA);
    }

    @Test
    void getTotal_discountAppliedBeforeAddingItems_stillAppliesToNewItems() {
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        cart.addItem("Chair", 50.0, 2);

        double total = cart.getTotal();

        assertEquals(80.0, total, DELTA);
    }
}