package com.assignment9;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidAlgorithmParameterException;

/* getItemCount() is implemented wrong and only returns total count 
 * of DIFFERENT items not total counts for example adding 5 apples and 2 chicken
 * would return 2 not 7
 */


public class ShoppingCartTest {
    ShoppingCart cart;

    @BeforeEach
    public void setUp()
    {
        cart = new ShoppingCart();
    }

    // addItem() Tests
    @Test
    @DisplayName("Should add one item")
    public void addItem_addingOneItem_VaildTest()
    {
        cart.addItem("Bread", 1, 1);

        assertEquals(1, cart.getItemCount());
    }

    @Test
    @DisplayName("Increases item that already exists")
    public void addItem_increaseItemCount()
    {
        cart.addItem("Bread", 2, 2);
        cart.addItem("Bread", 2, 3);

        assertEquals(5, cart.getItemCount());
    }

    @Test 
    @DisplayName("Add negative price")
    public void addItem_negativePrice()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Bread", -1.50, 1);
        });
    }


    // removeItem() Tests
    @Test
    @DisplayName("Removing item that exist")
    public void removeItem_existingItem()
    {
        cart.addItem("Bread", 2, 3);

        assertTrue(cart.removeItem("Bread"));
        assertEquals(0, cart.getItemCount());
    }

    @Test
    @DisplayName("Removing item that doesn't exist")
    public void removeItem_nonexistingItem()
    {
        assertFalse(cart.removeItem("Bread"));
    }

    @Test
    @DisplayName("Remove item using different casing")
    public void removeItem_caseInsensitive()
    {
        cart.addItem("Bread", 2, 3);

        assertTrue(cart.removeItem("bread"));
    }


    // getItemCount() Tests
    @Test
    @DisplayName("Get item count of one item")
    public void getItemCount_oneItem()
    {
        cart.addItem("Bread", 2.50, 1);

        assertEquals(1, cart.getItemCount());
    }

    @Test
    @DisplayName("Get item count of multiple different items")
    public void getItemCount_differentItems()
    {
        cart.addItem("Bread", 2.50, 1);
        cart.addItem("Apple", 2.00, 1);


        assertEquals(2, cart.getItemCount());
    }

    @Test
    @DisplayName("Get item count of multiple of the same item")
    public void getItemCount_sameItems()
    {
        cart.addItem("Apple", 2.00, 1);
        cart.addItem("Apple", 2.00, 1);


        assertEquals(2, cart.getItemCount());
    }

    // getSubtotal() tests

    @Test
    @DisplayName("Get subtotal of 2 items priced at 2.50 and 3.00")
    public void getSubtotal_2ItemsDifferentPrice()
    {
        cart.addItem("Bread", 2.50, 1);
        cart.addItem("Apple", 3.00, 1);


        assertEquals(5.50, cart.getSubtotal());
    }

    @Test
    @DisplayName("Get subtotal of empty cart")
    public void getSubtotal_emptyCart()
    {
        assertEquals(0.0, cart.getSubtotal());
    }

    @Test 
    @DisplayName("Get Subtotal before and after adding items")
    public void getSubtotal_beforeAndAfter_addingItems()
    {
        cart.addItem("Bread", 2.50, 1);
        cart.addItem("Apple", 3.00, 1);


        assertEquals(5.50, cart.getSubtotal());

        cart.addItem("Chicken", 8.00, 2);

        assertEquals(5.50 + (8.00 * 2), cart.getSubtotal());
    }

    @Test
    @DisplayName("Get subtotal after applying discount")
    public void getSubtotal_afterDiscount()
    {
        cart.addItem("Bread", 2.50, 2);
        cart.addItem("Apple", 3.00, 1);

        cart.applyDiscountCode("SAVE10");

        assertEquals(8.00, cart.getSubtotal());
    }

    // applyDiscountCode() tests

    @Test
    @DisplayName("Apply discount code and check total")
    public void applyDiscountCode_10PrecentDiscount()
    {

        cart.addItem("Bread", 2.50, 2);
        cart.addItem("Apple", 3.00, 1);

        cart.applyDiscountCode("SAVE10");

        assertEquals(7.20, cart.getTotal());

    }

    @Test
    @DisplayName("Apply discount on empty cart")
    public void applyDiscountCode_emptyCart()
    {
        cart.applyDiscountCode("SAVE10");

        assertEquals(0.0, cart.getTotal());

    }

    @Test
    @DisplayName("Apply invalid discount code")
    public void applyDiscountCode_invalidDiscountCode()
    {
        cart.addItem("Bread", 2.50, 2);
        cart.addItem("Apple", 3.00, 1);

        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE25");
        });
    }


    // getTotal() Tests

    @Test
    @DisplayName("Calculate total without any discounts")
    public void getTotal_noDiscounts()
    {
        cart.addItem("Bread", 2.50, 2);
        cart.addItem("Apple", 3.00, 1);

        assertEquals(8.00, cart.getTotal());
    }


    @Test
    @DisplayName("Get total of empty cart")
    public void getTotal_emptyCart()
    {
        assertEquals(0.0, cart.getTotal());

    }

    @Test
    @DisplayName("Get total of discounted cart with 50% off")
    public void getTotal_50PercentOff()
    {
        cart.addItem("Bread", 2.50, 2);
        cart.addItem("Apple", 3.00, 1);

        cart.applyDiscountCode("HALFOFF");

        assertEquals(4.00, cart.getTotal());

    }

}
