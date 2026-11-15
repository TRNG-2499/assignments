/*import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;*/

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
    }

//addItem tests//////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    //@DisplayName("Adding two positive numbers (2, 3) returns their sum")
    void addItem_nullItem_returnsFalse() {
        /*String param = "test_item";

        boolean result = shoppingCart.removeItem(param);

        assertTrue(!result);*/
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
        String param;

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

    /*@Test
    void removeItem_severalItemsInCart_returnsFalse() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 1);
        shoppingCart.addItem("testItem3", 3.00, 1);
        
        String param = "testItem";

        boolean result = shoppingCart.removeItem(param);

        assertTrue(result);
    }*/

//getSubtotal tests///////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void getSubtotal_noItemsInCart_returnsZero() {
        int result = shoppingCart.removeItem(param);

        assertEquals(0.00, result);
    }

    @Test
    void getSubtotal_oneItemInCart() {
        shoppingCart.addItem("testItem", 5.00, 1);

        int result = shoppingCart.getSubtotal();

        assertEquals(5.00, result);
    }

    @Test
    void getSubtotal_severalItemsInCart() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 1);
        shoppingCart.addItem("testItem3", 3.00, 1);

        int result = shoppingCart.getSubtotal();

        assertEquals(10.00, result);
    }

//applyDiscountCode tests/////////////////////////////////////////////////////////////////////////////////////

    /*@Test
    void getSubtotal_severalItemsInCart() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 1);
        shoppingCart.addItem("testItem3", 3.00, 1);

        int result = shoppingCart.getSubtotal();

        assertEquals(10.00, result);
    }*/

//getTotal() tests////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void getTotal_noDiscountCode() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 1);
        shoppingCart.addItem("testItem3", 3.00, 1);

        int result = shoppingCart.getTotal();

        assertEquals(10.00, result);
    }

    @Test
    void getTotal_oneItemInCart_with20PercentOff() {
        shoppingCart.addItem("testItem", 10.00, 1);
        shoppingCart.applyDiscountCode("SAVE20");

        int result = shoppingCart.getSubtotal();

        assertEquals(8.00, result);
    }

    @Test
    void getSubtotal_severalItemsInCart_with20PercentOff() {
        shoppingCart.addItem("testItem", 5.00, 1);
        shoppingCart.addItem("testItem2", 2.00, 1);
        shoppingCart.addItem("testItem3", 3.00, 1);
        shoppingCart.applyDiscountCode("SAVE20");

        int result = shoppingCart.getSubtotal();

        assertEquals(8.00, result);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
