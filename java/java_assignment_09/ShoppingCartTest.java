/*
 * Bug: getItemCount() returns items.size(), which counts how many different items
 * are in the cart instead of their total quantity. 2 Bells plus 3 Bells returns 1, not 5
 *
 * These tests fail because of the getItemCount() issue above:
 * addItem_sameItemTwice_addsQuantity, getItemCount_quantityThree_returnsThree,
 * getItemCount_twoItems_returnsTotal
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    public void addItem_newItem_updatesSubtotal() {
        cart.addItem("Bell", 13, 2);

        assertEquals(26.0, cart.getSubtotal(), 0.01);
    }

    @Test
    public void addItem_sameItemTwice_addsQuantity() {
        cart.addItem("Bell", 13, 2);
        cart.addItem("Bell", 13, 3);

        assertEquals(5, cart.getItemCount());
    }

    @Test
    public void addItem_negativePrice_throws() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Bell", -13, 2));
    }

    @Test
    public void removeItem_itemInCart_returnsTrue() {
        cart.addItem("Bell", 13, 2);

        boolean removed = cart.removeItem("Bell");

        assertTrue(removed);
    }

    @Test
    public void removeItem_emptyCart_returnsFalse() {
        boolean removed = cart.removeItem("Bell");

        assertFalse(removed);
    }

    @Test
    public void removeItem_itemInCart_lowersSubtotal() {
        cart.addItem("Bell", 13, 2);
        cart.addItem("Pen", 2, 1);

        cart.removeItem("Bell");

        assertEquals(2.0, cart.getSubtotal(), 0.01);
    }

    @Test
    public void getItemCount_emptyCart_returnsZero() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void getItemCount_quantityThree_returnsThree() {
        cart.addItem("Bell", 13, 3);

        assertEquals(3, cart.getItemCount());
    }

    @Test
    public void getItemCount_twoItems_returnsTotal() {
        cart.addItem("Bell", 13, 2);
        cart.addItem("Pen", 2, 3);

        assertEquals(5, cart.getItemCount());
    }

    @Test
    public void getSubtotal_emptyCart_returnsZero() {
        assertEquals(0.0, cart.getSubtotal(), 0.01);
    }

    @Test
    public void getSubtotal_twoItems_returnsSum() {
        cart.addItem("Bell", 13, 2);
        cart.addItem("Pen", 1.5, 4);

        assertEquals(32.0, cart.getSubtotal(), 0.01);
    }

    @Test
    public void getSubtotal_withDiscount_staysSame() {
        cart.addItem("Bell", 10, 2);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(20.0, cart.getSubtotal(), 0.01);
    }

    @Test
    public void applyDiscountCode_save20_takes20PercentOff() {
        cart.addItem("Bell", 50, 2);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        assertEquals(80.0, cart.getTotal(), 0.01);
    }

    @Test
    public void applyDiscountCode_newCode_replacesOld() {
        cart.addItem("Bell", 50, 2);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        assertEquals(50.0, cart.getTotal(), 0.01);
    }

    @Test
    public void applyDiscountCode_lowercaseCode_throws() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
    }

    @Test
    public void getTotal_noDiscount_equalsSubtotal() {
        cart.addItem("Bell", 13, 2);

        assertEquals(26.0, cart.getTotal(), 0.01);
    }

    @Test
    public void getTotal_halfOff_returnsHalf() {
        cart.addItem("Bell", 25, 2);
        cart.addItem("Pen", 5, 2);

        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        assertEquals(30.0, cart.getTotal(), 0.01);
    }

    @Test
    public void getTotal_emptyCartWithDiscount_returnsZero() {
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(0.0, cart.getTotal(), 0.01);
    }
}