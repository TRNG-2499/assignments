import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

//BUG: getItemCount() is returning distinct item count instead of the total quantity. It failed the sameItemCount and MultiItemCount tests
public class ShoppingCartTest{
    private ShoppingCart cart;
    @BeforeEach 
    void setup(){
        cart = new ShoppingCart();
    }

    @Test 
    void testAddNullItem(){
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> {
                cart.addItem(null, 10, 1); // This line is expected to throw the exception
            }
        );
        assertEquals("Item name must not be null or blank.", exception.getMessage());
    }

    @Test 
    void testAddNegPrice(){
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> {
                cart.addItem("Book", -10, 1); // This line is expected to throw the exception
            }
        );
        assertEquals("Price must not be negative.", exception.getMessage());
    }

    @Test 
    void testAddNegQuant(){
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> {
                cart.addItem("Book", 10, 0); 
            }
        );
        assertEquals("Quantity must be at least 1.", exception.getMessage());
    }

    @Test 
    void removeFromEmptyCart(){
        boolean res = cart.removeItem("Book");
        assertFalse(res);
    }

    @Test 
    void removeExistingItem(){
        cart.addItem("Book", 10, 1);
        boolean res = cart.removeItem("Book");
        assertTrue(res);
    }

    @Test 
    void removeFakeItem(){
        cart.addItem("Book", 10, 1);
        boolean res = cart.removeItem("B");
        assertFalse(res);
    }

    @Test 
    void itemCountEmpty(){
        int res = cart.getItemCount();
        assertEquals(0, res);
    }

    @Test 
    void sameItemCount(){
        cart.addItem("Book", 10, 10);
        int res = cart.getItemCount();
        assertEquals(10, res);
    }

    @Test 
    void multiItemCount(){
        cart.addItem("Book", 10, 10);
        cart.addItem("Clothes", 10, 10);
        int res = cart.getItemCount();
        assertEquals(20, res);
    }

    @Test 
    void emptySubtotal(){
        double res = cart.getSubtotal();
        assertEquals(0, res, 0.01);
    }

    @Test
    void subtotalWithNoDiscount(){
        cart.addItem("Book", 10, 10);
        double res = cart.getSubtotal();
        assertEquals(100, res, 0.01);
    }

    @Test
    void subtotalWithDiscount(){
        cart.addItem("Book", 10, 10);
        cart.applyDiscountCode("SAVE10");
        double res = cart.getSubtotal();
        assertEquals(100, res, 0.01);
    }

    @Test 
    void applyNullDiscount(){
        cart.addItem("Book", 10, 10);
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> {
                cart.applyDiscountCode(null);
            }
        );
        assertEquals("Discount code must not be null.", exception.getMessage());
    }

    @Test 
    void applyInvalidDiscount(){
        cart.addItem("Book", 10, 10);
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> {
                cart.applyDiscountCode("TEST");
            }
        );
        assertEquals("Invalid discount code: TEST", exception.getMessage());
    }

    @Test 
    void applyMultiDiscount(){
        cart.addItem("Book", 10, 10);
        cart.applyDiscountCode("SAVE20");
        cart.applyDiscountCode("SAVE10");
        double res = cart.getTotal();
        assertEquals(90, res, 0.01);
    }

    @Test 
    void totalNoDiscount(){
        cart.addItem("Book", 10, 10);
        double res = cart.getTotal();
        assertEquals(100, res, 0.01);
    }

    @Test 
    void totalWithDiscount(){
        cart.addItem("Book", 10, 10);
        cart.applyDiscountCode("SAVE10");
        double res = cart.getTotal();
        assertEquals(90, res, 0.01);
    }

    @Test 
    void totalNoRounding(){
        cart.addItem("Book", 13.25, 1);
        cart.applyDiscountCode("HALFOFF");
        double res = cart.getTotal();
        assertEquals(6.625, res, 0.01);
    }

}
