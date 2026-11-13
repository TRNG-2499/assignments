import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    /*
     * Bug found: getItemCount()
     *
     * The following tests will fail:
     * 1. getItemCount_singleItem_returnsItsQuantity()
     * 2. getItemCount_multipleItems_returnsTotalQuantity()
     *
     * the method currently uses items.size(), which counts distinct item names instead of adding together their quantities.
     */
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    // ==========================================
    // add item tests
    // ==========================================

    @Test
    void addItem_validItem_addsItemToCart() {
        //arrange
        String name = "Apple";
        double price = 2.00;
        int quantity = 3;

        //act
        cart.addItem(name, price, quantity);

        //assert
        assertEquals(6.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItem_duplicateName_increasesQuantity() {
        //arrange
        cart.addItem("Apple", 2.00, 2);

        //act
        cart.addItem("Apple", 2.00, 3);

        //assert
        assertEquals(10.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItem_differentCasing_addsSeparateItems() {
        //arrange
        cart.addItem("Apple", 2.00, 1);

        //act
        cart.addItem("apple", 3.00, 1);

        //assert
        assertEquals(5.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItem_nullName_throwsException() {
        //act & assert
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem(null, 2.00, 1));
    }

    @Test
    void addItem_blankName_throwsException() {
        //act & assert
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("   ", 2.00, 1));
    }

    @Test
    void addItem_negativePrice_throwsException() {
        //act & assert
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Apple", -2.00, 1));
    }

    @Test
    void addItem_zeroQuantity_throwsException() {
        //act & assert
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Apple", 2.00, 0));
    }


    // ==========================================
    // remove test items
    // ==========================================

    @Test
    void removeItem_existingItem_returnsTrue() {
        //arrange
        cart.addItem("Apple", 2.00, 2);

        //act
        boolean result = cart.removeItem("Apple");

        //assert
        assertTrue(result);
    }

    @Test
    void removeItem_nonExistingItem_returnsFalse() {
        //act
        boolean result = cart.removeItem("Apple");

        //assert
        assertFalse(result);
    }

    @Test
    void removeItem_existingItem_removesEntireItem() {
        //arrange
        cart.addItem("Apple", 2.00, 3);

        //act
        cart.removeItem("Apple");

        //assert
        assertEquals(0.0, cart.getSubtotal(), 0.001);
    }


    // ==========================================
    // get item count tests
    // ==========================================

    @Test
    void getItemCount_emptyCart_returnsZero() {
        //act
        int result = cart.getItemCount();

        //assert
        assertEquals(0, result);
    }

    @Test
    void getItemCount_singleItem_returnsItsQuantity() {
        //arrange
        cart.addItem("Apple", 2.00, 3);

        //act
        int result = cart.getItemCount();

        //assert
        assertEquals(3, result);
    }

    @Test
    void getItemCount_multipleItems_returnsTotalQuantity() {
        //arrange
        cart.addItem("Apple", 2.00, 3);
        cart.addItem("Banana", 1.00, 2);

        //act
        int result = cart.getItemCount();

        //assert
        assertEquals(5, result);
    }


    // ==========================================
    // get subtotal tests
    // ==========================================

    @Test
    void getSubtotal_emptyCart_returnsZero() {
        //act
        double result = cart.getSubtotal();

        //assert
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void getSubtotal_singleItem_returnsCorrectSubtotal() {
        //arrange
        cart.addItem("Apple", 2.50, 4);

        //act
        double result = cart.getSubtotal();

        //assert
        assertEquals(10.00, result, 0.001);
    }

    @Test
    void getSubtotal_multipleItems_returnsCombinedSubtotal() {
        //arrange
        cart.addItem("Apple", 2.00, 3);
        cart.addItem("Banana", 1.50, 2);

        //act
        double result = cart.getSubtotal();

        //assert
        assertEquals(9.00, result, 0.001);
    }


    // ==========================================
    // apply discount codes tests
    // ==========================================

    @Test
    void applyDiscountCode_save10_acceptsValidCode() {
        //act & assert
        assertDoesNotThrow(
                () -> cart.applyDiscountCode(ShoppingCart.CODE_SAVE10));
    }

    @Test
    void applyDiscountCode_newCode_replacesPreviousDiscount() {
        //arrange
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        //act
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        //assert
        cart.addItem("Apple", 100.00, 1);
        assertEquals(80.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCode_halfOff_acceptsValidCode() {
        //act & assert
        assertDoesNotThrow(
                () -> cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF));
    }

    @Test
    void applyDiscountCode_nullCode_throwsException() {
        //act & assert
        assertThrows(IllegalArgumentException.class,
                () -> cart.applyDiscountCode(null));
    }

    @Test
    void applyDiscountCode_invalidCasing_throwsException() {
        //act & assert
        assertThrows(IllegalArgumentException.class,
                () -> cart.applyDiscountCode("save10"));
    }


    // ==========================================
    // get total tests
    // ==========================================

    @Test
    void getTotal_noDiscount_returnsSubtotal() {
        //arrange
        cart.addItem("Apple", 10.00, 2);

        //act
        double result = cart.getTotal();

        //assert
        assertEquals(20.00, result, 0.001);
    }

    @Test
    void getTotal_save10_returnsDiscountedTotal() {
        //arrange
        cart.addItem("Apple", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        //act
        double result = cart.getTotal();

        //assert
        assertEquals(90.00, result, 0.001);
    }

    @Test
    void getTotal_halfOff_returnsHalfSubtotal() {
        //arrange
        cart.addItem("Apple", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        //act
        double result = cart.getTotal();

        //assert
        assertEquals(50.00, result, 0.001);
    }

}
