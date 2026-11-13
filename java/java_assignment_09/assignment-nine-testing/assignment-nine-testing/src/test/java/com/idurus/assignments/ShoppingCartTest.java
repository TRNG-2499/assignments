package com.idurus.assignments;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


/*
 * Suspected bug: getItemCount()
 *
 * The method uses items.size(), which counts the number
 * of distinct item names instead of total quantity.
 * Tests involving multiple quantities fail because the
 * returned count does not match the expected total quantity.
 */


public class ShoppingCartTest {
    
    private ShoppingCart cart;

    @BeforeEach 
    public void setUp() {
        cart = new ShoppingCart();
    }

    // 1. Testing addItem()
    
    @Test
    public void addingShoppingUpdatesCount() {

        //Arrange
        //Fresh cart created by @BeforeEach

        //Act
        cart.addItem("T-shirt", 19.99, 3);

        //Assert
        assertEquals(3, cart.getItemCount());
    }

    @Test
    public void addingSameItemIncreasesQuantity() {

        // Arrange
        cart.addItem("shoelaces", 5, 4);

        // Act
        cart.addItem("shoelaces", 5, 8);

        // Assert
        assertEquals(12, cart.getItemCount());

    }

    @Test
    public void addingItemWithNegativePriceThrowsException() {


        // Act and Assert
        assertThrows(
            IllegalArgumentException.class, () -> cart.addItem("Tie", -6, 1) 
            );
        

    }

    @Test
    public void addingItemWithBlankNameThrowsException() {

        assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem(" ", 2.50, 1)
        );
    }

    @Test
    public void addingItemWithInvalidQuantityThrowsException() {

        assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("Chapati", 7.50, 0)
        );
    }



    // 2. Testing removeItem()
    
    @Test
    public void removeExistingItemReturnsTrue() {

        //Arrange
        cart.addItem("cup", 6, 2);

        //Act
        boolean result = cart.removeItem("cup");

        //Assert
        assertTrue(result);

    }

    @Test
    public void removingNonexistentItemReturnsFalse() {

        // Act
        boolean result = cart.removeItem("Desk");

        // Assert
        assertFalse(result);
    }

    @Test
    public void removingItemRemovesItsEntireQuantity() {

        // Arrange
        cart.addItem("Chapati", 11.90, 3);

        // Act
        cart.removeItem("Chapati");

        // Assert
        assertEquals(0, cart.getItemCount());
    }

    // 3. TESTING getItemCount()
    

    @Test
    public void emptyCartHasZeroItems() {

        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void countIncludesMultipleItemTypes() {

        cart.addItem("Biriyani", 17.50, 1);
        cart.addItem("Chapati", 17.00, 8);

        assertEquals(9, cart.getItemCount());
    }

    @Test
    public void countIncludesUpdatedQuantities() {

        cart.addItem("Chai", 2.50, 1);
        cart.addItem("Chapati", 17.50, 8);

        assertEquals(9, cart.getItemCount());
    }

    
    // 4. TESTING getSubtotal()
    

    @Test
    public void emptyCartHasZeroSubtotal() {

        assertEquals(0.0, cart.getSubtotal(), 0.001);
    }

    @Test
    public void subtotalCalculatesPriceTimesQuantity() {

        cart.addItem("Chai", 2.50, 2);

        assertEquals(5.00, cart.getSubtotal(), 0.001);
    }

    @Test
    public void subtotalCombinesMultipleSnackTypes() {

        cart.addItem("Chai", 2.50, 2);
        cart.addItem("Chapati", 4.00, 3);

        assertEquals(17.00, cart.getSubtotal(), 0.001);
    }



    // 5. TESTING applyCoupon()
    

    @Test
    public void item10CouponAppliesTenPercentDiscount() {

        cart.addItem("Chapati", 10.00, 1);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(9.00, cart.getTotal(), 0.001);
    }

    @Test
    public void item20CouponAppliesTwentyPercentDiscount() {

        cart.addItem("Chapati", 10.00, 1);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        assertEquals(8.00, cart.getTotal(), 0.001);
    }

    @Test
    public void halfItemCouponAppliesFiftyPercentDiscount() {

        cart.addItem("Chapati", 10.00, 1);

        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        assertEquals(5.00, cart.getTotal(), 0.001);
    }

    @Test
    public void invalidCouponThrowsException() {

        assertThrows(
            IllegalArgumentException.class,
            () -> cart.applyDiscountCode("INVALID")
        );
    }

    @Test
    public void newCouponReplacesPreviousCoupon() {

        cart.addItem("Chai", 2.50, 4);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        assertEquals(8.00, cart.getTotal(), 0.001);
    }


    
    // 6. TESTING getTotal()
  

    @Test
    public void totalWithoutDiscountEqualsSubtotal() {

        cart.addItem("Chapati", 10.00, 2);

        assertEquals(20.00, cart.getTotal(), 0.001);
    }

    @Test
    public void totalWithTenPercentDiscountIsCorrect() {

        cart.addItem("Chapati", 20.00, 1);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(18.00, cart.getTotal(), 0.001);
    }

    @Test
    public void totalWithFiftyPercentDiscountIsCorrect() {

        cart.addItem("Chapati", 40.00, 1);

        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        assertEquals(20.00, cart.getTotal(), 0.001);
    }

    @Test
    public void totalForEmptyCartIsZero() {

        assertEquals(0.0, cart.getTotal(), 0.001);
    }


}
