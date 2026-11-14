import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//removeMultipleItemTest(), addMultipleOfTheSameItemWithDifferentPriceTest(), removeMissingItemTest() fails.
class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
    }
    @Test
    void addItemTest() {
        shoppingCart.addItem("cookie",4.00,5);
        double result = shoppingCart.getTotal();
        Assertions.assertEquals(20.00, result);
    }
    @Test
    void addItemNegativePriceThrowsTest() {
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.addItem("cookie", -4.00, 1));
    }
    @Test //failed because I expected $25 and the output was $24 but there can be many cookies with different prices.
    void addMultipleOfTheSameItemWithDifferentPriceTest(){
        shoppingCart.addItem("cookie",4.00,5);
        shoppingCart.addItem("cookie",5.00,1);
        double result = shoppingCart.getTotal();
        Assertions.assertEquals(25.00, result);
    }
    @Test
    void addItemNoQuantityTest(){
        boolean exceptionThrown = false;
        try {
            shoppingCart.addItem("cookie", 4.00, 0);
        }catch (IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
    @Test
    void removeItemTest() {
        shoppingCart.addItem("cookie", 4.00, 1);
        shoppingCart.removeItem("cookie");
        assertEquals(0, shoppingCart.getItemCount());
    }
    @Test //failed because I expected 2 cookies left and instead I actually got zero back
    void removeMultipleItemTest() {
        shoppingCart.addItem("cookie", 4.00, 5);
        shoppingCart.removeItem("cookie");
        shoppingCart.removeItem("cookie");
        shoppingCart.removeItem("cookie");
        assertEquals(2, shoppingCart.getItemCount());
    }

    @Test //failed because removing the wrong item did not throw an IllegalArgumentException, leaving exceptionThrown false.
    void removeMissingItemTest() {
        shoppingCart.addItem("cookie", 4.00, 1);
        boolean exceptionThrown = false;

        try {
            shoppingCart.removeItem("coke");
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
        assertEquals(1, shoppingCart.getItemCount());
    }
    @Test
    void getItemCountTest() {
        shoppingCart.addItem("cookie", 4.00, 1);
        shoppingCart.addItem("milk", 3.50, 1);
        assertEquals(2, shoppingCart.getItemCount());
    }
    @Test
    void getItemCountAfterRemoveTest() {
        shoppingCart.addItem("cookie", 4.00, 2);
        shoppingCart.addItem("milk", 3.50, 1);
        shoppingCart.removeItem("cookie");
        assertEquals(1, shoppingCart.getItemCount());
    }
    @Test
    void getItemCountWhenEmptyTest() {
        assertEquals(0, shoppingCart.getItemCount());
    }
    @Test
    void getSubtotalTest() {
        shoppingCart.addItem("cookie", 4.00, 1);
        shoppingCart.addItem("milk", 3.50, 1);
        assertEquals(7.50, shoppingCart.getSubtotal());
    }
    @Test
    void getSubtotalForMultipleItemsAndQuantitiesTest() {
        shoppingCart.addItem("cookie", 4.00, 2);
        shoppingCart.addItem("milk", 3.50, 3);
        assertEquals(18.50, shoppingCart.getSubtotal());
    }
    @Test
    void getSubtotalAfterDupeTest() {
        shoppingCart.addItem("cookie", 4.00, 2);
        shoppingCart.addItem("cookie", 4.00, 1);
        assertEquals(12.00, shoppingCart.getSubtotal());
    }
    @Test
    void applyDiscountCodeTest() {
        shoppingCart.addItem("bag", 20.00, 1);
        shoppingCart.applyDiscountCode("SAVE10");
        assertEquals(18.00, shoppingCart.getTotal());
    }
    @Test
    void applyInvalidDiscountCodeThrowsTest() {
        shoppingCart.addItem("cookie", 5.00, 1);
        boolean exceptionThrown = false;

        try {
            shoppingCart.applyDiscountCode("SAVE100");
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
    @Test
    void applyEmptyDiscountCodeTest() {
        shoppingCart.addItem("cookie", 10.00, 1);
        boolean exceptionThrown = false;

        try {
            shoppingCart.applyDiscountCode(null);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
    @Test
    void getTotalTest() {
            shoppingCart.addItem("cookie", 4.00, 1);
            shoppingCart.addItem("milk", 3.50, 1);
            shoppingCart.addItem("cheese", 3.50, 1);
            assertEquals(11.00, shoppingCart.getTotal());
    }
    @Test
    void getTotalMultipleQuantitiesTest() {
        shoppingCart.addItem("cookie", 4.00, 2);
        shoppingCart.addItem("milk", 3.50, 3);
        shoppingCart.addItem("cheese", 3.50, 2);
        assertEquals(25.50, shoppingCart.getTotal());
    }
    @Test
    void getTotalAfterRemovingItemTest() {
        shoppingCart.addItem("cookie", 4.00, 2); // 8.00
        shoppingCart.addItem("milk", 3.50, 1);   // 3.50
        shoppingCart.removeItem("cookie");
        assertEquals(3.50, shoppingCart.getTotal());
    }
}