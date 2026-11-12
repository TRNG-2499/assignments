import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void addsNewItemCorrectly() {
        cart.addItem("Apple", 1.50, 1);
        assertEquals(1, cart.getItemCount());
        assertEquals(1.50, cart.getSubtotal(), 0.001);
    }

    @Test
    void addsDuplicateItemCorrectly() {
        cart.addItem("Apple", 1.50, 1);
        cart.addItem("Apple", 1.50, 1);
        assertEquals(2, cart.getItemCount());
        assertEquals(3.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void addsItemWithDifferentCasingCorrectly() {
        cart.addItem("Apple", 1.50, 1);
        cart.addItem("apple", 2.50, 1);
        assertEquals(2, cart.getItemCount());
        assertEquals(4.00,  cart.getSubtotal(), 0.001);
    }

    @Test
    void addsInvalidNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 1.50, 1));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("", 1.50, 1));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("   ", 1.50, 1));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("\t", 1.50, 1));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t"})
    void addsInvalidNameThrowsException(String name) {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(name, 1.50, 1));
    }

    @Test
    void addsNegativePriceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", -1.50, 1));
    }

    @Test
    void addsInvalidQuantityThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", 1.50, 0));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", 1.50, -5));
    }

    @Test
    void removesItemSuccessfully() {
        cart.addItem("Apple", 1.50, 1);
        assertTrue(cart.removeItem("Apple"));
        assertTrue(cart.isEmpty());
    }

    @Test
    void removesItemNotInCartReturnsFalse() {
        cart.addItem("Apple", 1.50, 1);
        assertFalse(cart.removeItem("Banana"));
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void removesDoesntRemoveDifferentCasingName() {
        cart.addItem("Apple", 1.50, 1);
        assertFalse(cart.removeItem("apple"));
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void getItemOnEmptyCartIsZero() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void getItemCountsCorrectly() {
        cart.addItem("Apple", 1.50,  100);
        cart.addItem("Banana",  2.50, 101);
        assertEquals(201, cart.getItemCount());
    }

    @Test
    void getItemCountCorrectAfterRemoval() {
        cart.addItem("Apple", 1.50,  100);
        cart.addItem("Banana", 2.50, 101);
        cart.removeItem("Apple");
        assertEquals(101, cart.getItemCount());
    }

    @Test
    void getSubtotalCountsCorrectly() {
        cart.addItem("Apple", 1.50,  100);
        cart.addItem("Banana",  2.50, 100);
        assertEquals(400, cart.getSubtotal(), 0.001);
    }

    @Test
    void getSubtotalEmptyCartIsZero() {
        assertEquals(0, cart.getSubtotal(), 0.001);
    }

    @Test
    void getSubtotalCorrectAfterRemoval() {
        cart.addItem("Apple", 1.50,  100);
        cart.addItem("Banana", 2.50, 100);
        cart.removeItem("Apple");
        assertEquals(250, cart.getSubtotal(), 0.001);
    }

    @Test
    void applyDiscountAcceptsCode() {
        assertDoesNotThrow(() -> cart.applyDiscountCode(ShoppingCart.CODE_SAVE10));
        assertDoesNotThrow(() -> cart.applyDiscountCode(ShoppingCart.CODE_SAVE20));
        assertDoesNotThrow(() -> cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF));
    }

    @Test
    void applyDiscountWithInvalidCodeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(null));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(""));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("MYCODE"));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE100"));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("  SAVE10  "));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"MYCODE", "save10", "SAVE100", "  SAVE10  "})
    void applyDiscountWithInvalidCodeThrowsException(String code) {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(code));
    }

    @Test
    void applyDiscountSave10ReturnsCorrectTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        assertEquals(90.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountSave20ReturnsCorrectTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        assertEquals(80.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountHalfOffReturnsCorrectTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        assertEquals(50.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountSetsDiscountCorrectlyAssertAllVersion() {
        ShoppingCart save10 = new ShoppingCart();
        save10.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        save10.addItem("Apple", 100.00, 1);

        ShoppingCart save20 = new ShoppingCart();
        save20.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        save20.addItem("Apple", 100.00, 1);

        ShoppingCart saveHalf = new ShoppingCart();
        saveHalf.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        saveHalf.addItem("Apple", 100.00, 1);

        assertAll("All discount code applied correctly",
            () -> assertEquals(90.00, save10.getTotal(), 0.001),
            () -> assertEquals(80.00, save20.getTotal(), 0.001),
            () -> assertEquals(50.00, saveHalf.getTotal(), 0.001)
        );
    }

    @Test
    void getTotalOnEmptyCartIsZero() {
        assertEquals(0, cart.getTotal(), 0.001);
    }

    @Test
    void getTotalWithoutDiscount() {
        cart.addItem("Apple", 1.50, 1);
        cart.addItem("Banana", 2.50, 1);
        cart.addItem("apple", 1.00, 1);
        assertEquals(5, cart.getTotal(), 0.001);
    }

    @Test
    void getTotalWithDiscount() {
        cart.addItem("Apple", 10.0, 10);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        assertEquals(50, cart.getTotal(), 0.001);
    }

    @Test
    void combinedTest() {
        cart.addItem("Apple", 10.0, 10);
        cart.addItem("Banana", 20.0, 124);
        cart.removeItem("Banana");
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertAll("Result: ",
            () -> assertEquals(10, cart.getItemCount()),
            () -> assertEquals(100, cart.getSubtotal(), 0.001),
            () -> assertEquals(90, cart.getTotal(), 0.001)
        );
    }
}