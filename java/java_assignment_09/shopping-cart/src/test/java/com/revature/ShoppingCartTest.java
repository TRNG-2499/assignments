package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Incorrect Method: getItemCount()

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setup() {
        cart = new ShoppingCart();
    }

    // ************************************************************
    // addItem(String name, double price, int quantity)
    // ************************************************************

    // adds a new item to the cart
    @Test
    void addItem_validItem_increasesItemCount() {
        cart.addItem("Raspberry Pi", 49.99, 1);
        assertEquals(1, cart.getItemCount());
    }

    // same name exactly - quantity increases instead of adding another item
    @Test
    void addItem_duplicateName_increasesQuantity() {
        cart.addItem("Raspberry Pi", 49.99, 1);
        cart.addItem("Raspberry Pi", 49.99, 1);
        assertEquals(2, cart.getItemCount());
    }

    // throws IllegalArgumentException if name is null
    @Test
    void addItem_nullName_throwsIllegalArgumentException() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> cart.addItem(null, 49.99, 1));
        assertEquals("Item name must not be null or blank.", exception.getMessage());
    }

    // throws IllegalArgumentException if quantity is less than 1
    @Test
    void addItem_zeroQuantity_throwsIllegalArgumentException() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> cart.addItem("Raspberry Pi", 49.99, 0));
        assertEquals("Quantity must be at least 1.", exception.getMessage());

    }

    // ************************************************************
    // removeItem(String name)
    // ************************************************************

    // removes an existing item entirely and returns true
    @Test
    void removeItem_existingItem_returnsTrue() {
        cart.addItem("Raspberry Pi", 49.99, 1);
        assertTrue(cart.removeItem("Raspberry Pi"));
    }

    // returns false if the item does not exist
    @Test
    void removeItem_nonexistentItem_returnsFalse() {
        cart.addItem("Raspberry Pi Zero", 19.99, 1);
        assertTrue(!cart.removeItem("Raspberry Pi"));
    }

    // returns false if the cart is empty
    @Test
    void removeItem_emptyCart_returnsFalse() {
        assertTrue(!cart.removeItem("Raspberry Pi"));
    }

    // ************************************************************
    // getItemCount()
    // ************************************************************

    // returns 0 if the cart is empty
    @Test
    void getItemCount_emptyCart_returnsZero() {
        assertEquals(0, cart.getItemCount());
    }

    // returns quantity of a single item
    @Test
    void getItemCount_singleItem_returnsQuantity() {
        cart.addItem("Raspberry Pi", 49.99, 2);
        assertEquals(2, cart.getItemCount());
    }

    // returns combined quantities of different items
    @Test
    void getItemCount_multipleItems_returnsTotalQuantity() {
        cart.addItem("Raspberry Pi", 49.99, 4);
        cart.addItem("Raspberry Pi Zero", 19.99, 1);
        assertEquals(5, cart.getItemCount());
    }

    // returns updated count after removing an item
    @Test
    void getItemCount_afterRemoval_returnsUpdatedCount() {
        cart.addItem("Raspberry Pi", 49.99, 2);
        cart.addItem("Raspberry Pi Zero", 19.99, 2);
        cart.removeItem("Raspberry Pi");
        assertEquals(2, cart.getItemCount());
    }

    // ************************************************************
    // getSubtotal()
    // ************************************************************

    // returns 0.0 if the cart is empty
    @Test
    void getSubtotal_emptyCart_returnsZero() {
        assertEquals(0, cart.getSubtotal(), 0.001);
    }

    // returns price multiplied by quantity
    @Test
    void getSubtotal_singleItem_returnsPriceTimesQuantity() {
        cart.addItem("Raspberry Pi", 49.99, 2);
        assertEquals(99.98, cart.getSubtotal(), 0.001);
    }

    // returns sum of all item prices multiplied by quantities
    @Test
    void getSubtotal_multipleItems_returnsSum() {
        cart.addItem("Raspberry Pi", 49.99, 2);
        cart.addItem("Raspberry Pi Zero", 19.99, 2);
        assertEquals(139.96, cart.getSubtotal(), 0.001);
    }

    // subtotal is not affected by applied discounts
    @Test
    void getSubtotal_withDiscount_returnsOriginalSubtotal() {
        cart.addItem("Raspberry Pi Zero", 19.99, 1);
        cart.applyDiscountCode("SAVE10");
        assertEquals(19.99, cart.getSubtotal(), 0.001);
    }

    // ************************************************************
    // applyDiscountCode(String code)
    // ************************************************************

    // applies a valid 10% discount
    @Test
    void applyDiscountCode_save10_appliesTenPercentDiscount() {
        cart.addItem("Raspberry Pi Zero", 19.99, 1);
        cart.applyDiscountCode("SAVE10");
        assertEquals(19.99 * .9, cart.getTotal(), 0.001);
    }

    // applies a valid 50% discount
    @Test
    void applyDiscountCode_halfOff_appliesFiftyPercentDiscount() {
        cart.addItem("Raspberry Pi Zero", 19.99, 1);
        cart.applyDiscountCode("HALFOFF");
        assertEquals(19.99 * .5, cart.getTotal(), 0.001);
    }

    // new valid discount replaces previous discount
    @Test
    void applyDiscountCode_newValidCode_replacesPreviousDiscount() {
        cart.addItem("Raspberry Pi Zero", 19.99, 1);
        cart.applyDiscountCode("SAVE10");
        cart.applyDiscountCode("HALFOFF");
        assertEquals(19.99 * .5, cart.getTotal(), 0.001);
    }

    // throws IllegalArgumentException for invalid code
    @Test
    void applyDiscountCode_invalidCode_throwsIllegalArgumentException() {
        cart.addItem("Raspberry Pi Zero", 19.99, 1);
        String code = "SAVENOTHING";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> cart.applyDiscountCode(code));
        assertEquals("Invalid discount code: " + code, exception.getMessage());
    }

    // ************************************************************
    // getTotal()
    // ************************************************************

    // returns 0.0 if the cart is empty
    @Test
    void getTotal_emptyCart_returnsZero() {
        assertEquals(0, cart.getTotal(), 0.001);
    }

    // returns subtotal when no discount is applied
    @Test
    void getTotal_noDiscount_returnsSubtotal() {
        cart.addItem("Raspberry Pi Zero", 19.99, 1);
        assertEquals(cart.getSubtotal(), cart.getTotal(), 0.001);

    }

    // returns subtotal with 20% discount applied
    @Test
    void getTotal_save20_returnsEightyPercent() {
        cart.addItem("Raspberry Pi Zero", 19.99, 1);
        cart.applyDiscountCode("SAVE20");
        assertEquals(19.99 * .8, cart.getTotal(), 0.001);
    }
}
