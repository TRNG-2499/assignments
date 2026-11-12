/*
*BUG REPORT
* Method with incorrect logic: addItem
* Failing tests: 2 - addItem_itemInCart_increasesItemCount, getItemCount_itemInCart_returnsCorrectCount
* What it does wrong: 
* - getItemCount uses items.size() which is not reflecting the actual number of 
* items in the cart and only account for how many entries are in the map
*/


import static org.junit.jupiter.api.Assertions.assertEquals;
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

    //Add Item
    @Test
    @DisplayName("Test adding an item to the shopping cart")
    void addItem_itemInCart_increasesItemCount() {
        cart.addItem("Apple", 2.0, 2);
        assertEquals(1, cart.getItemCount());
        assertEquals(4.0, cart.getTotal(), DELTA);
    }

    //Remove Item
    @Test 
    @DisplayName("Test removing an item from the shopping cart")
    void removeItem_itemInCart_returnsTrue() {
        cart.addItem("Apple", 1.50, 2);
        boolean result = cart.removeItem("Apple");
        assertTrue(result);
    }

    //getItemCount
    @Test
    @DisplayName("Test getting the item count from the shopping cart")
    void getItemCount_itemInCart_returnsCorrectCount() {
        cart.addItem("Apple", 1.0, 1);
        cart.addItem("Banana", 2.0, 3);
        cart.addItem("Orange", 3.0, 5);
        assertEquals(9, cart.getItemCount());
    }

    //getSubtotal
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

    //applyDiscountedCode
    @Test 
    @DisplayName("Test applying a discount code to the shopping cart")
    void applyDiscountCode_validCode_appliesDiscount() {
        cart.addItem("Apple", 1.0, 1);
        cart.applyDiscountCode("SAVE10");
        assertEquals(0.9, cart.getTotal(), DELTA);
    }

    //getTotal
    @Test 
    @DisplayName("Test getting the total from the shopping cart")
    void getTotal_itemsInCart_returnsCorrectTotal() {
        cart.addItem("Apple", 1.0, 1);
        cart.addItem("Banana", 2.0, 1);
        assertEquals(3.0, cart.getTotal(), DELTA);
    }

    
}
