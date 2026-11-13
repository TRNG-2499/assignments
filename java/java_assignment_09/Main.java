package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private ShoppingCart myCart;

    @BeforeEach
    void setUp() {
        myCart = new ShoppingCart();
    }

    @Test
    @DisplayName("Testing adding items: ")
    void testAddItem_01() {
        String param1 = "Legos";
        int param2 = 100;
        int param3 = 5;
        int result = myCart.getItemCount() + 1;


        myCart.addItem(param1,param2,param3);

        assertFalse(myCart.isEmpty());

    }

    @Test
    @DisplayName("Testing adding items with negative count: ")
    void testAddItem_02() {
        String param1 = "Pizza";
        int param2 = -1;
        int param3 = 5;
        int result = myCart.getItemCount() + 1;


        assertThrows(IllegalArgumentException.class, () -> {
            myCart.addItem(param1,param2,param3);
        });

    }

    @Test
    @DisplayName("Test adding a bunch of items: ")
    void testAddItem_03() {
        String param1 = "Dr.Pepper";
        int param2 = 30;
        int param3 = 1;

        myCart.addItem(param1,param2,param3);
        myCart.addItem("cheese",2,3);
        myCart.addItem("Burger",10,1);
        myCart.addItem("Milk",6,10);
        myCart.addItem("Burger2",11,1);

        assertEquals(5, myCart.getItemCount());

    }

    @Test
    @DisplayName("Testing removing an item: ")
    void testRemoveItem_01() {
        myCart.addItem("Coffee",2,3);
        myCart.removeItem("Coffee");

        assertTrue(myCart.isEmpty());

    }

    @Test
    @DisplayName("Test trying to remove an item that does not exist: ")
    void testRemoveItem_02() {

        assertFalse(myCart.removeItem("Cheetos"));

    }

    @Test
    @DisplayName("Testing removing an item returns true: ")
    void testRemoveItem_03() {
        myCart.addItem("Coffee",2,3);

        assertTrue(myCart.removeItem("Coffee"));

    }

    @Test
    @DisplayName("Testing item count is true: ")
    void testGetItemCount_01() {
        myCart.addItem("cheese",2,3);
        myCart.addItem("Burger",10,1);
        myCart.addItem("Milk",6,10);
        myCart.addItem("Burger2",11,1);

        assertEquals(4, myCart.getItemCount());

    }

    @Test
    @DisplayName("Test item count when cart is empty: ")
    void testGetItemCount_02() {
        assertEquals(0, myCart.getItemCount());

    }

    @Test
    @DisplayName("Test item count updates according to add: ")
    void testGetItemCount_03() {
        int[] myArr = {0,1};
        int[] myArr2 = {0,0};
        myArr2[0] = myCart.getItemCount();
        myCart.addItem("itemName", 2,1);
        myArr2[1] = myCart.getItemCount();

        assertArrayEquals(myArr, myArr2);

    }
    @Test
    @DisplayName("Test subtotal when cart is empty: ")
    void testGetSubTotal_01() {
        assertEquals(0, myCart.getSubtotal());

    }

    @Test
    @DisplayName("Test subtotal when cart is full: ")
    void testGetSubTotal_02() {
        myCart.addItem("Pillow", 2, 10);

        assertEquals(20, myCart.getSubtotal());
    }

    @Test
    @DisplayName("Test subtotal with multiple items at once: ")
    void testGetSubTotal_03() {
        myCart.addItem("Pillow", 2, 10);
        myCart.addItem("Blanket", 3, 5);
        myCart.addItem("Bed", 100, 1);

        assertEquals(20+15+100, myCart.getSubtotal());
    }

    @Test
    @DisplayName("Test discount code when code is null: ")
    void testApplyDiscountCode_01() {
        assertThrows(IllegalArgumentException.class, () -> {
            myCart.applyDiscountCode(null);
        });
    }

    @Test
    @DisplayName("Test discount code when code is invalid: ")
    void testApplyDiscountCode_02() {
        assertThrows(IllegalArgumentException.class, () -> {
            myCart.applyDiscountCode("This code is very real to me!");
        });
    }

    @Test
    @DisplayName("Test discount code works as expected: ")
    void testApplyDiscountCode_03() {
        myCart.addItem("Chicken Wings", 100, 1);
        myCart.applyDiscountCode("HALFOFF");
        assertEquals(50, myCart.getTotal());
    }

    @Test
    @DisplayName("Test getting total: ")
    void testGetTotal_01() {
        myCart.addItem("Chicken Wings", 100, 1);

        assertEquals(100, myCart.getTotal());
    }

    @Test
    @DisplayName("Test getting total when cart is empty: ")
    void testGetTotal_02() {
        assertEquals(0, myCart.getTotal());
    }

    @Test
    @DisplayName("Test getting total from a big order: ")
    void testGetTotal_03() {
        myCart.addItem("Pillow", 2, 10);
        myCart.addItem("Blanket", 3, 5);
        myCart.addItem("Bed", 100, 1);
        assertEquals(20+15+100, myCart.getTotal());
    }

}