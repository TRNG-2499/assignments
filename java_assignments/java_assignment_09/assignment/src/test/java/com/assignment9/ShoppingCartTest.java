package com.assignment9;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setup() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Adding an item to cart.")
    public void testAdd_01(){
        cart.addItem("Cookies", 5.00, 1);

        assertEquals(1, cart.getItemCount());
    }

    @Test 
    @DisplayName("Adding negative item quantity.")
    public void testAdd_02(){
        

        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Cookies", 5.00, -1);
        });
           
    }

    @Test 
    @DisplayName("Adding same item with different casing.")
    public void testAdd_03(){
        cart.addItem("Cookies", 5.00, 1);
        cart.addItem("cookies", 5.00, 1);

        assertEquals(2, cart.getItemCount());
    }

    @Test 
    @DisplayName("Removing item in cart.")
    public void testRemove_01(){
        cart.addItem("Cookies", 5.00, 1);

        assertTrue(cart.removeItem("Cookies"));
    }

    @Test 
    @DisplayName("Removing item in cart with multiple items.")
    public void testRemove_02(){
        cart.addItem("Cookies", 5.00, 1);
        cart.addItem("Pears", 0.50, 7);
        cart.addItem("Chicken", 7.00, 3);

        assertTrue(cart.removeItem("Chicken"));
    }

    @Test 
    @DisplayName("Removing non existent item in cart.")
    public void testRemove_03(){
        cart.addItem("Cookies", 5.00, 1);
        cart.addItem("Pears", 0.50, 7);
        cart.addItem("Chicken", 7.00, 3);

        assertFalse(cart.removeItem("Eggs"));
    }

    @Test 
    @DisplayName("Getting quantity of multiple items.")
    public void testGetItemCount_01(){
        cart.addItem("Cookies", 5.00, 1);
        cart.addItem("Salmon", 10.00, 1);
        cart.addItem("Apple", 1.00, 1);
        cart.addItem("Grapes", 3.00, 1);

        assertEquals(4, cart.getItemCount());
           
    }

    @Test 
    @DisplayName("Getting quantity of duplicate items.")
    public void testGetItemCount_02(){
        cart.addItem("Cookies", 5.00, 2);
        cart.addItem("Cookies", 5.00, 2);

        //fails because the method returns array size rather than actual item count
        assertEquals(4, cart.getItemCount());
           
    }

    @Test 
    @DisplayName("Getting quantity of multiple items with varying quantities.")
    public void testGetItemCount_03(){
        cart.addItem("Cookies", 5.00, 2);
        cart.addItem("Eggs", 2.00, 6);
        cart.addItem("Apples", 1.00, 3);
        cart.addItem("Diet Cokes", 2.00, 12);

        //fails because the method returns array size rather than actual item count
        assertEquals(23, cart.getItemCount());
           
    }

    @Test
    @DisplayName("Getting subtotal of an empty cart.")
    public void testGetSubtotal_01(){

        assertEquals(0.0, cart.getSubtotal(),0.01);

    }

    @Test
    @DisplayName("Getting subtotal of cart with multiple items.")
    public void testGetSubtotal_02(){
        cart.addItem("Cookies", 5.00, 1);
        cart.addItem("Salmon", 10.00, 1);
        cart.addItem("Apple", 1.00, 1);
        cart.addItem("Grapes", 3.00, 1);

        assertEquals(19.00, cart.getSubtotal(),0.01);

    }

    @Test
    @DisplayName("Getting subtotal of cart with multiple items with varying quantities.")
    public void testGetSubtotal_03(){
        cart.addItem("Cookies", 5.00, 2);
        cart.addItem("Eggs", 2.00, 6);
        cart.addItem("Apples", 1.00, 3);
        cart.addItem("Diet Cokes", 2.00, 12);

        assertEquals(49.00, cart.getSubtotal(),0.01);

    }

    @Test
    @DisplayName("Applying discount to cart")
    public void testApplyDiscount_01(){
        cart.addItem("Cookies", 5.00, 2);

        cart.applyDiscountCode(cart.CODE_SAVE10);

        assertEquals(9.0, cart.getTotal(),0.01);
    }

    @Test
    @DisplayName("Applying a second discount code.")
    public void testApplyDiscount_02(){
        cart.addItem("Cookies", 5.00, 4);

        cart.applyDiscountCode(cart.CODE_SAVE10);
        double firstCodeTotal = cart.getTotal();
        
        cart.applyDiscountCode(cart.CODE_HALF_OFF);

        assertAll("Two Discount Codes",
            () -> assertNotEquals(firstCodeTotal, cart.getTotal(), 0.01),
            () -> assertEquals(10.00, cart.getTotal(), 0.01)
        );
    }

    @Test
    @DisplayName("Applying an invalid code.")
    public void testApplyDiscount_03(){
        cart.addItem("Cookies", 5.00, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("FakeCode50");
        });
    }

    @Test
    @DisplayName("Getting total from cart")
    public void testGetTotal_01(){
        cart.addItem("Cookies", 5.00, 2);

        assertEquals(10.0, cart.getTotal(),0.01);
    }

    @Test
    @DisplayName("Getting total from empty cart")
    public void testGetTotal_02(){
        assertEquals(0.0, cart.getTotal(),0.01);
    }

    @Test
    @DisplayName("Getting total from cart with multiple items, quantities and promo code.")
    public void testGetTotal_03(){
        cart.addItem("Cookies", 5.00, 2);
        cart.addItem("Eggs", 2.00, 6);
        cart.addItem("Apples", 1.00, 3);
        cart.addItem("Diet Cokes", 2.00, 12);

        cart.applyDiscountCode(cart.CODE_HALF_OFF);
        
        assertEquals(24.5, cart.getTotal(),0.01);
    }

    




    
}
