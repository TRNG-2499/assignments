

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import shoppingcart.ShoppingCart;

//Get itemCount() is wrong, making the test for addItem() fail that uses it to check that the item was added 
// with correct quantity. It also makes the tests for getItemCount() fail. This is because Map.size() returns
//how many unique items are in the cart, not the total quantity of all items in the cart. The method should 
//instead iterate through the map and sum the quantity of each item, to get the correct amount.

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
    }

//addItem tests//////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void addItem_nullItemName_throwsException() {
        String param1 = null;
        double param2 = 5.00;
        int param3 = 2;

        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, 
            () -> shoppingCart.addItem(param1, param2, param3) 
        );

        assertEquals("Item name must not be null or blank.", result.getMessage());
    }

    @Test
    void addItem_emptyItemName_throwsException() {
        String param1 = "";
        double param2 = 5.00;
        int param3 = 2;

        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, 
            () -> shoppingCart.addItem(param1, param2, param3) 
        );

        assertEquals("Item name must not be null or blank.", result.getMessage());
    }

    @Test
    void addItem_negativePrice_throwsException() {
        String param1 = "testItem1";
        double param2 = -5.00;
        int param3 = 2;

        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, 
            () -> shoppingCart.addItem(param1, param2, param3) 
        );

        assertEquals("Price must not be negative.", result.getMessage());
    }

    @Test
    void addItem_zeroQuantity_throwsException() {
        String param1 = "testItem1";
        double param2 = 5.00;
        int param3 = 0;

        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, 
            () -> shoppingCart.addItem(param1, param2, param3) 
        );

        assertEquals("Quantity must be at least 1.", result.getMessage());
    }

    @Test
    void addItem_itemNotInCart_addsNewItem() {
        String param1 = "testItem1";
        double param2 = 5.00;
        int param3 = 2;

        shoppingCart.addItem(param1, param2, param3);

        assertEquals(2, shoppingCart.getItemCount());
    }

    @Test
    void addItem_itemInCart_increasesQuantity() {
        shoppingCart.addItem("testItem1", 2.00, 1);
        String param1 = "testItem2";
        double param2 = 5.00;
        int param3 = 2;

        shoppingCart.addItem(param1, param2, param3);

        assertEquals(3, shoppingCart.getItemCount());
    }

//removeItems tests///////////////////////////////////////////////////////////////////////////////////////////

    @Test
    //@DisplayName("Adding two positive numbers (2, 3) returns their sum")
    void removeItem_emptyCart_returnsFalse() {
        String param = "test_item";

        boolean result = shoppingCart.removeItem(param);

        assertTrue(!result);
    }

    @Test
    void removeItem_nullItem_returnsFalse() {
        String param = null;

        boolean result = shoppingCart.removeItem(param);

        assertTrue(!result);
    }

    @Test
    void removeItem_notInCart_returnsFalse() {
        shoppingCart.addItem("testItem", 5.00, 1);
        String param = "testItem2";

        boolean result = shoppingCart.removeItem(param);

        assertTrue(!result);
    }

    @Test
    void removeItem_onlyItemInCart_returnsTrue() {
        shoppingCart.addItem("testItem", 5.00, 1);
        String param = "testItem";

        boolean result = shoppingCart.removeItem(param);

        assertTrue(result);
    }

    @Test
    void removeItem_severalItemsInCart_returnsTrue() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 1);
        shoppingCart.addItem("testItem3", 3.00, 1);
        String param = "testItem";

        boolean result = shoppingCart.removeItem(param);

        assertTrue(result);
    }

//getItemCount test///////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void getItemCount_noItemsInCart_returnsZero() {
        int result = shoppingCart.getItemCount();

        assertEquals(0, result);
    }

    @Test
    void getItemCount_oneItemInCart_returnsOne() {
        shoppingCart.addItem("testItem", 5.00, 1);
        
        int result = shoppingCart.getItemCount();

        assertEquals(1, result);
    }

    @Test
    void getItemCount_severalItemsInCart_returnsZero() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 2);
        shoppingCart.addItem("testItem3", 3.00, 1);
        
        int result = shoppingCart.getItemCount();

        assertEquals(4, result);
    }

//getSubtotal tests///////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void getSubtotal_noItemsInCart_returnsZero() {
        double result = shoppingCart.getSubtotal();

        assertEquals(0.00, result, 0.001);
    }

    @Test
    void getSubtotal_oneItemInCart() {
        shoppingCart.addItem("testItem", 5.00, 1);

        double result = shoppingCart.getSubtotal();

        assertEquals(5.00, result, 0.001);
    }

    @Test
    void getSubtotal_severalItemsInCart() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 2);
        shoppingCart.addItem("testItem3", 3.00, 1);

        double result = shoppingCart.getSubtotal();

        assertEquals(12.00, result, 0.001);
    }

//applyDiscountCode tests/////////////////////////////////////////////////////////////////////////////////////

    @Test
    void applyDiscountCode_nullCode_throwsException() {
        String param1 = null;

        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, 
            () -> shoppingCart.applyDiscountCode(param1) 
        );

        assertEquals("Discount code must not be null.", result.getMessage());
    }

    @Test
    void applyDiscountCode_invalidCode_throwsException() {
        String param1 = "INVALIDCODE";

        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, 
            () -> shoppingCart.applyDiscountCode(param1) 
        );

        assertEquals("Invalid discount code: INVALIDCODE", result.getMessage());
    }

    @Test
    void applyDiscountCode_properCode_appliesDiscount() {
        String param1 = "CODE_SAVE20";

        assertDoesNotThrow(() -> shoppingCart.applyDiscountCode(param1));
    }

//getTotal() tests////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void getTotal_emptyCart_with20PercentOff() {
        shoppingCart.applyDiscountCode("CODE_SAVE20");

        double result = shoppingCart.getSubtotal();

        assertEquals(0.00, result, 0.001);
    }

    @Test
    void getTotal_noDiscountCode() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 1);
        shoppingCart.addItem("testItem3", 3.00, 1);

        double result = shoppingCart.getTotal();

        assertEquals(10.00, result);
    }

    @Test
    void getTotal_oneItemInCart_with20PercentOff() {
        shoppingCart.addItem("testItem", 10.00, 1);
        shoppingCart.applyDiscountCode("CODE_SAVE20");

        double result = shoppingCart.getSubtotal();

        assertEquals(8.00, result);
    }

    @Test
    void getSubtotal_severalItemsInCart_with20PercentOff() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 1);
        shoppingCart.addItem("testItem3", 3.00, 1);
        shoppingCart.applyDiscountCode("CODE_SAVE20");

        double result = shoppingCart.getSubtotal();

        assertEquals(8.00, result, 0.001);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
