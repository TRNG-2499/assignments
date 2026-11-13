import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private static final double DELTA = 1e-9;

    private ShoppingCart cart;

    @BeforeEach
    void setUp(){
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test adding a new item, (Apple, 1.50, x2)")
    void testAddItem_01(){
        String name = "Apple";
        double price = 1.50;
        int quantity = 2;
        double expectedSubtotal = 3.00;

        cart.addItem(name, price, quantity);
        assertEquals(expectedSubtotal, cart.getSubtotal(), DELTA);
        assertTrue(cart.removeItem(name));
    }

    @Test
    @DisplayName("Adding the same  name twice increases its quantity instead of a second line")
    void testAddItem_02(){
        cart.addItem("Apple", 1.00, 2);
        cart.addItem("Apple", 1.00, 3);

        assertEquals(5.00, cart.getSubtotal(), DELTA);
        assertTrue(cart.removeItem("Apple"));
        assertEquals(0.0, cart.getSubtotal(), DELTA);
    }

    @Test 
    @DisplayName("Adding an item with a null name thows an IllegalArgumentException")
    void testAdditem_03(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 1.00, 1));
        assertEquals("Item name must not be null or blank.",  exception.getMessage());
    }

    // remove item 
    @Test 
    @DisplayName("Removing an item that is in the cart return true and removes it ")
    void testRemoveItem_01(){
        cart.addItem("Apple", 1.00, 1);
        cart.addItem("Bread", 3.00, 1);

        boolean result = cart.removeItem("Apple");
        assertTrue(result);
        assertEquals(3.00, cart.getSubtotal(), DELTA);

    }

    @Test
    @DisplayName("Removing from an empty cart returns false")
    void testRemoveItem_02(){
        assertFalse(cart.removeItem("Apple"));
    }

    @Test 
    @DisplayName("Removing an item that is not in the cart returns fasle and changes nothing")
    void testRemoveItem_03(){
        cart.addItem("Apple", 1.00, 1);

        assertFalse(cart.removeItem("Bread"));
        assertEquals(1.00, cart.getSubtotal(), DELTA);
    }

    //get item count 
    @Test 
    @DisplayName("One item with quantity 3 gives an item count of 3")
    void testGetItemCount_01(){
        cart.addItem("Apple",1.00, 3);
        int expectedCount = 3;

        int result = cart.getItemCount();
        assertEquals(expectedCount, result);
    }

    @Test 
    @DisplayName("An empty cart has an item count of 0")
    void testGetItemCount_02(){
        assertEquals(0, cart.getItemCount());
    }

    @Test 
    @DisplayName("A rejected addItem call does not chnage the item count")
    void testGetItemCount_03(){
        cart.addItem("Apple",1.00,1);
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Bread", -1.00, 1));

        assertEquals(1, cart.getItemCount());
    }

    //get subtotal
    @Test
    @DisplayName("One item (1.25 x 4) gives a subtotal of 5.00")
    void testGetSubtotal_01() {
        cart.addItem("Apple", 1.25, 4);
        double expectedSubtotal = 5.00;

        double result = cart.getSubtotal();
        assertEquals(expectedSubtotal, result, DELTA);
    }

    @Test
    @DisplayName("An empty cart has a subtotal of 0.0")
    void testGetSubtotal_02() {
        assertEquals(0.0, cart.getSubtotal(), DELTA);
    }

    @Test
    @DisplayName("The subtotal is NOT reduced when a discount code is applied")
    void testGetSubtotal_03() {
        cart.addItem("Apple", 10.00, 2);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        assertEquals(20.00, cart.getSubtotal(), DELTA);
    }


    //apply discount code
    @Test
    @DisplayName("SAVE10 takes 10% off: a 100.00 cart totals 90.00")
    void testApplyDiscountCode_01() {
        cart.addItem("Jacket", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        assertEquals(90.00, cart.getTotal(), DELTA);
    }

    @Test
    @DisplayName("A new code replaces the old one instead of stacking (SAVE20 then SAVE10 = 90.00, not 72.00)")
    void testApplyDiscountCode_02() {
        cart.addItem("Jacket", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(90.00, cart.getTotal(), DELTA);
    }

    @Test
    @DisplayName("A null discount code throws an IllegalArgumentException")
    void testApplyDiscountCode_03() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> cart.applyDiscountCode(null)
        );

        assertEquals("Discount code must not be null.", exception.getMessage());
    }

    // get total 
    @Test
    @DisplayName("With SAVE10, the total uses every item's quantity (20.00 subtotal totals 18.00)")
    void testGetTotal_01() {
        cart.addItem("Apple", 2.00, 5);   // 10.00
        cart.addItem("Bread", 5.00, 2);   // 10.00

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        assertEquals(18.00, cart.getTotal(), DELTA);
    }

    @Test
    @DisplayName("An empty cart has a total of 0.0")
    void testGetTotal_02() {
        assertEquals(0.0, cart.getTotal(), DELTA);
    }

    @Test
    @DisplayName("With no discount, the total equals the subtotal (12.00)")
    void testGetTotal_03() {
        cart.addItem("Apple", 1.25, 4);
        cart.addItem("Bread", 3.50, 2);

        assertEquals(12.00, cart.getTotal(), DELTA);
        assertEquals(cart.getSubtotal(), cart.getTotal(), DELTA);
    }
}