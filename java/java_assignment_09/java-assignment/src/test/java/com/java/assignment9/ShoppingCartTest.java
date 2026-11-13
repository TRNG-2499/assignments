package com.java.assignment9;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    ShoppingCart cart;

    @BeforeEach
    void newCart() {
        cart = new ShoppingCart();
    }

    @Test
    void addItemHappyPath() {
        cart.addItem("tomato", 2.50, 2);
        assertEquals(5.00, cart.getSubtotal(), 0.00001);
    }

    @Test 
    @DisplayName("Add same item but different casing")
    void addItemEdgeCase() {
        cart.addItem("tomato", 1.25, 1);
        cart.addItem("TOMATO", 1.25, 1);
        assertEquals(2, cart.getItemCount());
    }

    @Test
    void addItemInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 1.00, 1));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("potato", -1, 1));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("potato", 1.00, -2));
    }

    @Test
    @DisplayName ("Remove item that exists in the cart")
    void removeItemHappyPath1() {
        cart.addItem("tomato", 1.25, 1);
        boolean result = cart.removeItem("tomato");
        assertTrue(result);
    }

    @Test
    @DisplayName ("Remove item that doesn't exist in the cart")
    void removeItemEdgeCase() {
        boolean result = cart.removeItem("tomato");
        assertFalse(result);
    }

    @Test 
    void removeItemSlightlyDifferenNames() {
        cart.addItem("tomato", 1.25, 1);
        cart.addItem("TOMATO", 1.25, 1);
        boolean result = cart.removeItem("tomato");
        assertTrue(result);
        assertEquals(1.25, cart.getSubtotal());
    }

    @Test 
    void getItemCountHappyPath() {
        cart.addItem("tomato", 1.25, 1);
        cart.addItem("potato", 2.25, 2);
        cart.addItem("banana", 1.00, 3);
        assertEquals(6, cart.getItemCount());
    }

    @Test 
    void getItemCountEmptyCart() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void getItemCountAfterRemove() {
        cart.addItem("tomato", 1.25, 1);
        cart.removeItem("tomato");
        assertEquals(0, cart.getItemCount());
    }

    @Test 
    void getSubTotalEmptyCart() {
        assertEquals(0.0, cart.getSubtotal(), 0.00001);
    }

    @Test
    void getSubTotalHappyPath() {
        cart.addItem("tomato", 1.25, 1);
        cart.addItem("potato", 2.25, 2);
        assertEquals(5.75, cart.getSubtotal(), 0.00001);
    }

    @Test
    @DisplayName ("Same items added multiple times")
    void getSubTotalEdgeCase() {
        cart.addItem("tomato", 1.25, 1);
        cart.addItem("tomato", 1.25, 2);
        assertEquals(3.75, cart.getSubtotal(), 0.00001);  
    }

    @Test
    @DisplayName ("Add and remove items, then calculate subtotal")
    void getSubTotalEdgeCase2() {
        cart.addItem("tomato", 1.25, 1);
        cart.addItem("potato", 1.00, 2);
        cart.removeItem("tomato");
        assertEquals(2.00, cart.getSubtotal(), 0.00001);  
    }

    @Test
    void applyDiscountCodeInvalidInput() {
        cart.addItem("cheese", 3, 1);
        cart.addItem("chicken", 5, 2);
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVENOTHING"));
    }

    @Test
    void discountCodeNoStack() {
        cart.addItem("cheese", 3, 1);
        cart.addItem("chicken", 5, 2);
        cart.applyDiscountCode("SAVE10");
        cart.applyDiscountCode("HALFOFF");
        assertEquals(6.5, cart.getTotal(), 0.00001);
    }

    @Test 
    void getTotalHappyPath() {
        cart.addItem("cheese", 3, 1);
        cart.addItem("chicken", 5, 2);
        cart.applyDiscountCode("SAVE10");
        assertEquals(11.7, cart.getTotal(), 0.00001);
    }

    @Test
    void getTotalHappyPath2() {
        cart.addItem("cheese", 3, 1);
        cart.addItem("chicken", 5, 2);
        cart.applyDiscountCode("SAVE20");
        assertEquals(10.4, cart.getTotal(), 0.00001);
    }

    @Test
    void emptyCartDiscount() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(0.0, cart.getTotal(), 0.00001);
    }
}
