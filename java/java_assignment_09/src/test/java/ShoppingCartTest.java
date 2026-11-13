import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void freshShoppingCart() {
        cart = new ShoppingCart();
    }

    @Test
    void addToEmptyCart_doesNotThrow() {
        assertDoesNotThrow(() -> cart.addItem("Eggs", 6.99, 1));
    }

    @Test
    void addItems_hasCorrectTotal() {
        assertTrue(cart.isEmpty());
        cart.addItem("Eggs", 6.99, 2);
        cart.addItem("Milk", 2.99, 1);
        assertEquals(16.97, cart.getTotal(), 0.01);
    }

    @Test
    void addNegativePrice_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Eggs", -0.99, 1));
    }

    @Test
    void removeItem_removesAll() {
        cart.addItem("Eggs", 6.99, 1);
        cart.addItem("Eggs", 6.99, 1);
        assertTrue(cart.removeItem("Eggs"));
        assertTrue(cart.isEmpty());
    }

    @Test
    void removeItemOnEmpty_returnsFalse() {
        assertTrue(cart.isEmpty());
        assertFalse(cart.removeItem("Eggs"));
    }

    @Test
    void removeItemWithSlightlyDifferentName_returnsFalse() {
        cart.addItem("Eggs", 6.99, 1);
        assertFalse(cart.removeItem("eggs"));
    }

    @Test
    void getItemCountOnEmpty_returnsZero() {
        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void getItemCountWithSameItemAddedTwice_sumsQuantities() {
        cart.addItem("Eggs", 6.99, 2);
        cart.addItem("Eggs", 6.99, 3);
        cart.addItem("Milk", 2.99, 1);
        assertEquals(6, cart.getItemCount());
    }

    @Test
    void getItemCountAfterZeroQuantityAdd_throwsAndCountUnchanged() {
        cart.addItem("Eggs", 6.99, 1);
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Milk", 2.99, 0));
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void getSubtotalOnEmpty_returnsZero() {
        assertTrue(cart.isEmpty());
        assertEquals(0.0, cart.getSubtotal(), 0.01);
    }

    @Test
    void getSubtotalWithMultipleItems_returnsPriceTimesQuantitySum() {
        cart.addItem("Eggs", 6.99, 2);
        cart.addItem("Milk", 2.99, 1);
        assertEquals(16.97, cart.getSubtotal(), 0.01);
    }

    @Test
    void getSubtotalAfterDiscount_ignoresDiscount() {
        cart.addItem("Eggs", 10.00, 2);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        assertEquals(20.00, cart.getSubtotal(), 0.01);
    }

    @Test
    void applySave10_reducesTotalByTenPercent() {
        cart.addItem("Eggs", 25.00, 2);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        assertEquals(45.00, cart.getTotal(), 0.01);
    }

    @Test
    void applyNullCode_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(null));
    }

    @Test
    void applyCodeWithWrongCasing_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
    }

    @Test
    void getTotalWithNoDiscount_equalsSubtotal() {
        cart.addItem("Eggs", 6.99, 2);
        cart.addItem("Milk", 2.99, 1);
        assertEquals(cart.getSubtotal(), cart.getTotal(), 0.01);
    }

    @Test
    void getTotalOnEmptyWithDiscount_returnsZero() {
        assertTrue(cart.isEmpty());
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        assertEquals(0.0, cart.getTotal(), 0.01);
    }

    @Test
    void getTotalAfterApplyingTwoCodes_usesOnlyLastCode() {
        cart.addItem("Big Whoppin' Bag Of Chicken", 50.00, 2);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        assertEquals(80.00, cart.getTotal(), 0.01);
    }
}
