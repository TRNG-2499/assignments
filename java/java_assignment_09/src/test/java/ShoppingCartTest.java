/*
*BUG REPORT
* Method with incorrect logic: addItem
* Failing tests: 1 - getItemCount_itemInCart_returnsCorrectCount
* What it does wrong: 
* - getItemCount uses items.size() which is not reflecting the actual number of 
* items in the cart and only account for how many entries are in the map
*/


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class ShoppingCartTest {
    private static final double DELTA = 0.0001;
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    //======ADD ITEM TESTS======
    @Test
    @DisplayName("Test adding an item to the shopping cart")
    void addItem_itemInCart_increasesItemCount() {
        cart.addItem("Apple", 2.0, 2);
        assertEquals(1, cart.getItemCount());
        assertEquals(4.0, cart.getTotal(), DELTA);
    }

    @Test 
    @DisplayName("Test adding an item with null name throws IllegalArgumentException")
    void addItem_nullName_throwsIllegalArgumentException() {
        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 1.0, 1));
    }

    @Test
    @DisplayName("Test adding an item with negative price throws IllegalArgumentException")
    void addItem_negativePrice_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, 
            () -> cart.addItem("Orange", -1.0, 1)
        );
    }

    @Test 
    @DisplayName("Test adding an item with quantity less than 1 throws IllegalArgumentException")
    void addItem_quantityLessThanOne_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, 
            () -> cart.addItem("Banana", 1.0, 0)
        );
    }

    //======REMOVE ITEM TESTS======
    @Test 
    @DisplayName("Test removing an item from the shopping cart")
    void removeItem_itemInCart_returnsTrue() {
        //Arrange
        cart.addItem("Apple", 1.50, 2);
        //Act
        boolean result = cart.removeItem("Apple");
        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Test removing an item not in the shopping cart")
    void removeItem_itemNotInCart_returnsFalse() {
        //Arrange
        cart.addItem("Apple", 1.50, 2);
        //Act
        boolean result = cart.removeItem("Banana");
        //Assert
        assertFalse(result);
    }

    @Test 
    @DisplayName("Test removing the same item twice from the shopping cart")
    void removeItem_sameItemTwice_returnsFalse() {
        //Arrange
        cart.addItem("Apple", 1.50, 2);
        cart.removeItem("Apple");
        //Act
        boolean result = cart.removeItem("Apple");
        //Assert
        assertFalse(result);
    }

    //======GET ITEM COUNT TESTS======
    @Test
    @DisplayName("Test getting the item count from the shopping cart")
    void getItemCount_itemInCart_returnsCorrectCount() {
        cart.addItem("Apple", 1.0, 1);
        cart.addItem("Banana", 2.0, 3);
        cart.addItem("Orange", 3.0, 5);
        assertEquals(9, cart.getItemCount());
    }

    @Test 
    @DisplayName("Test getting the item count from an empty shopping cart")
    void getItemCount_emptyCart_returnsZero() {
        assertEquals(0, cart.getItemCount());
    }

    @Test 
    @DisplayName("Test getting the item count after adding and removing items")
    void getItemCount_afterAddingAndRemovingItems_returnsCorrectCount() {
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 2.0, 3);
        cart.addItem("Orange", 3.0, 5);
        cart.removeItem("Apple");
        assertEquals(8, cart.getItemCount());
    }

    //======GET SUBTOTAL TESTS======
    @Test 
    @DisplayName("Test getting the subtotal from the shopping cart")
    void getSubtotal_twoDifferentItems_returnsSumOfPrices() {
        //Arrange
        cart.addItem("Apple", 1.0, 1);
        cart.addItem("Banana", 2.0, 1);
        //Act
        double result = cart.getSubtotal();
        //Assert
        assertEquals(3.0, result, DELTA);
    }

    @Test 
    @DisplayName("Test getting the subtotal from an empty cart")
    void getSubtotal_emptyCart_returnsZero() {
        assertEquals(0.0, cart.getSubtotal(), DELTA);
    }

    @Test 
    @DisplayName("Test getting the subtotal after adding and removing items")
    void getSubtotal_afterAddingAndRemovingItems_returnsCorrectSubtotal() {
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 2.0, 3);
        cart.addItem("Orange", 3.0, 5);
        cart.removeItem("Apple");
        double result = cart.getSubtotal();
        assertEquals(29.0, result, DELTA);
    }

    //======APPLY DISCOUNT CODE TESTS======
    @Test 
    @DisplayName("Test applying a discount code to the shopping cart")
    void applyDiscountCode_validCode_appliesDiscount() {
        cart.addItem("Apple", 1.0, 1);
        cart.applyDiscountCode("SAVE10");
        assertEquals(0.9, cart.getTotal(), DELTA);
    }

    @Test 
    @DisplayName("Test applying an invalid discount code to the shopping cart")
    void applyDiscountCode_invalidCode_doesNotApplyDiscount() {
        cart.addItem("Apple", 1.0, 1);
        cart.applyDiscountCode("INVALID");
        assertEquals(1.0, cart.getTotal(), DELTA);
    }

    @Test 
    @DisplayName("Test applying a discount code to an empty shoppping cart")
    void applyDiscountCode_emptyCart_doesNotApplyDiscount() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(0.0, cart.getTotal(), DELTA);
    }

    //======GET TOTAL TESTS======
    @Test 
    @DisplayName("Test getting the total from the shopping cart")
    void getTotal_itemsInCart_returnsCorrectTotal() {
        cart.addItem("Apple", 1.0, 1);
        cart.addItem("Banana", 2.0, 1);
        assertEquals(3.0, cart.getTotal(), DELTA);
    }

    @Test
    @DisplayName("Test getting total from an empty shopping cart")
    void getTotal_emptyCart_returnsZero() {
        assertEquals(0.0, cart.getTotal(), DELTA);
    }

    @Test
    @DisplayName("Test getting total after applying a discount code")
    void getTotal_afterApplyingDiscountCode_returnsDiscountedTotal() {
        cart.addItem("Apple", 1.0, 1);
        cart.applyDiscountCode("SAVE10");
        assertEquals(0.9, cart.getTotal(), DELTA);
    }

}
