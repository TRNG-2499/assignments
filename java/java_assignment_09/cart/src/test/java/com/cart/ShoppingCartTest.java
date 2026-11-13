package com.cart;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Incorrect method: (fill in after running the tests)
 * Failing test(s): (list the names of the tests that failed)
 * Explanation: (one or two sentences on what the method does wrong)
 */
public class ShoppingCartTest {

    private ShoppingCart cart;
    private static final double DELTA = 0.0001;

    @BeforeEach
    void setup() {
        cart = new ShoppingCart();
    }

    //addItem 

    @Test
    void addItem_sameNameTwice_combinesQuantity() {
        cart.addItem("Fish", 5.50, 2);
        cart.addItem("Fish", 5.50, 6);
        assertEquals(8, cart.getItemCount());
    }

    @Test
    void addItem_zeroPrice_isAllowed() {
        cart.addItem("Free Sample", 0.0, 1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void addItem_blankName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("", 3.50, 2));
    }

    @Test
    void addItem_negativePrice_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Pie", -0.01, 1));
    }


    //removeItem 

    @Test
    void removeItem_existingItem_returnsTrue() {
        cart.addItem("Pie", 3.50, 1);
        boolean result = cart.removeItem("Pie");
        assertTrue(result);
    }

    @Test
    void removeItem_itemNotInCart_returnsFalse() {
        cart.addItem("Pie", 3.50, 1);
        boolean result = cart.removeItem("Cake");
        assertFalse(result);
    }

    @Test
    void removeItem_calledTwice_secondCallReturnsFalse() {
        cart.addItem("Pie", 3.50, 1);
        cart.removeItem("Pie");
        boolean result = cart.removeItem("Pie");
        assertFalse(result);
    }

    //getItemCount

    @Test
    void getItemCount_emptyCart_returnsZero() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void getItemCount_multipleItems_returnsSumOfQuantities() {
        cart.addItem("Pie", 3.50, 2);
        cart.addItem("Cake", 10.00, 3);
        int count = cart.getItemCount();
        assertEquals(5, count);
    }

    @Test
    void getItemCount_afterRemovingOneItem() {
        cart.addItem("Pie", 3.50, 2);
        cart.addItem("Cake", 10.00, 3);
        cart.removeItem("Pie");
        int count = cart.getItemCount();
        assertEquals(3, count);
    }

    // getSubtotal 

    @Test
    void getSubtotal_emptyCart_returnsZero() {
        assertEquals(0.0, cart.getSubtotal(), DELTA);
    }

    @Test
    void getSubtotal_singleItem_returnsPriceTimesQuantity() {
        cart.addItem("Pie", 3.50, 3);
        double subtotal = cart.getSubtotal();
        assertEquals(10.50, subtotal, DELTA);
    }

    @Test
    void getSubtotal_multipleItems_returnsSumOfAllItems() {
        cart.addItem("Pie", 3.50, 2);
        cart.addItem("Cake", 10.00, 1);
        double subtotal = cart.getSubtotal();
        assertEquals(17.00, subtotal, DELTA);
    }

    @Test
    void getSubtotal_withDiscountApplied_isNotDiscounted() {
        cart.addItem("Cake", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        double subtotal = cart.getSubtotal();
        assertEquals(100.00, subtotal, DELTA);
    }

    // applyDiscountCode 

    @Test
    void applyDiscountCode_validCode_doesNotThrow() {
        assertDoesNotThrow(() -> cart.applyDiscountCode(ShoppingCart.CODE_SAVE10));
    }

    @Test
    void applyDiscountCode_nullCode_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.applyDiscountCode(null));
    }

    @Test
    void applyDiscountCode_unknownCode_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.applyDiscountCode("FREE"));
    }

    // getTotal 

    @Test
    void getTotal_noDiscount_equalsSubtotal() {
        cart.addItem("Cake", 10.00, 2);
        double total = cart.getTotal();
        assertEquals(20.00, total, DELTA);
    }

    @Test
    void getTotal_takesTenPercentOff() {
        cart.addItem("Cake", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        double total = cart.getTotal();
        assertEquals(90.00, total, DELTA);
    }


    @Test
    void getTotal_sameCodeAppliedTwice_appliesDiscountOnce() {
        cart.addItem("Cake", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        double total = cart.getTotal();
        assertEquals(90.00, total, DELTA);
    }

    @Test
    void getTotal_emptyCartWithDiscount_returnsZero() {
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        double total = cart.getTotal();
        assertEquals(0.0, total, DELTA);
    }

}