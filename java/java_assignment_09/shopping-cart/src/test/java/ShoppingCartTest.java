import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.revature.ShoppingCart;

// incorrect method: getItemCount()
//
// failing tests:
//   getItemCount_oneItemQuantityThree_returnsThree
//   getItemCount_twoItemsWithQuantities2And3_returnsFive
//   getItemCount_sameItemAddedTwice_returnsCombinedQuantity
//   addAndCount_severalItems_countAndSubtotalBothCorrect (stretch goal 2)
//
// what it does wrong: it returns items.size(), which is the number of different item names
// in the cart, not the total quantity of all items, so a cart holding 3 apples reports 1
public class ShoppingCartTest {

    // doubles can be slightly off after math, so compare them within this tolerance
    private static final double DELTA = 0.0001;

    private ShoppingCart cart;

    // runs before every test, so each test starts with an empty cart and none depend on each other
    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    // normal solution

    // addItem
    @Test
    void addItem_validItem_subtotalReflectsPriceTimesQuantity() {
        cart.addItem("Apple", 1.50, 2);

        assertEquals(3.00, cart.getSubtotal(), DELTA);
    }

    @Test
    void addItem_sameNameTwice_increasesQuantity() {
        cart.addItem("Apple", 2.00, 2);

        cart.addItem("Apple", 2.00, 3);

        // checked through the subtotal instead of getItemCount, so this test doesn't rely on another method
        // 5 apples at 2.00 each
        assertEquals(10.00, cart.getSubtotal(), DELTA);
    }

    @Test
    void addItem_nullName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 1.00, 1));
    }

    @Test
    void addItem_negativePrice_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", -0.01, 1));
    }

    @Test
    void addItem_zeroQuantity_throwsIllegalArgumentException() {
        // boundary: 1 is the smallest valid quantity, so 0 should be rejected
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", 1.00, 0));
    }

    // removeItem
    @Test
    void removeItem_existingItem_returnsTrue() {
        cart.addItem("Apple", 1.00, 1);

        boolean result = cart.removeItem("Apple");

        assertTrue(result);
    }

    @Test
    void removeItem_missingItemOnEmptyCart_returnsFalse() {
        boolean result = cart.removeItem("Apple");

        assertFalse(result);
    }

    @Test
    void removeItem_existingItem_subtotalNoLongerIncludesIt() {
        cart.addItem("Apple", 1.00, 2);
        cart.addItem("Bread", 3.00, 1);

        cart.removeItem("Apple");

        assertEquals(3.00, cart.getSubtotal(), DELTA);
    }

    @Test
    void removeItem_sameItemTwice_secondCallReturnsFalse() {
        cart.addItem("Apple", 1.00, 1);
        cart.removeItem("Apple");

        boolean result = cart.removeItem("Apple");

        assertFalse(result);
    }

    @Test
    void removeItem_wrongCasing_returnsFalse() {
        cart.addItem("Apple", 1.00, 1);

        boolean result = cart.removeItem("APPLE");

        assertFalse(result);
    }

    // getItemCount
    @Test
    void getItemCount_emptyCart_returnsZero() {
        int result = cart.getItemCount();

        assertEquals(0, result);
    }

    @Test
    void getItemCount_oneItemQuantityThree_returnsThree() {
        cart.addItem("Apple", 1.00, 3);

        int result = cart.getItemCount();

        assertEquals(3, result);
    }

    @Test
    void getItemCount_twoItemsWithQuantities2And3_returnsFive() {
        cart.addItem("Apple", 1.00, 2);
        cart.addItem("Bread", 3.00, 3);

        int result = cart.getItemCount();

        assertEquals(5, result);
    }

    @Test
    void getItemCount_sameItemAddedTwice_returnsCombinedQuantity() {
        cart.addItem("Apple", 1.00, 2);
        cart.addItem("Apple", 1.00, 3);

        int result = cart.getItemCount();

        assertEquals(5, result);
    }

    // getSubtotal
    @Test
    void getSubtotal_emptyCart_returnsZero() {
        double result = cart.getSubtotal();

        assertEquals(0.0, result, DELTA);
    }

    @Test
    void getSubtotal_multipleItems_returnsSumOfPriceTimesQuantity() {
        cart.addItem("Apple", 2.50, 2);
        cart.addItem("Bread", 1.00, 3);

        double result = cart.getSubtotal();

        // (2.50 * 2) + (1.00 * 3) = 8.00
        assertEquals(8.00, result, DELTA);
    }

    @Test
    void getSubtotal_afterDiscountApplied_isUnchanged() {
        cart.addItem("Apple", 10.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        double result = cart.getSubtotal();

        // the subtotal is before any discount, so the discount shouldn't change it
        assertEquals(10.00, result, DELTA);
    }

    // applyDiscountCode
    @Test
    void applyDiscountCode_save10_totalIs90PercentOfSubtotal() {
        cart.addItem("Apple", 100.00, 1);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(90.00, cart.getTotal(), DELTA);
    }

    @Test
    void applyDiscountCode_secondCode_replacesFirstInsteadOfStacking() {
        cart.addItem("Apple", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        // stacking would give 70.00, replacing gives 80.00
        assertEquals(80.00, cart.getTotal(), DELTA);
    }

    @Test
    void applyDiscountCode_nullCode_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(null));
    }

    @Test
    void applyDiscountCode_lowercaseValidCode_throwsIllegalArgumentException() {
        // codes are case-sensitive, so "save10" is not the same as "SAVE10"
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
    }

    @Test
    void applyDiscountCode_invalidAfterValid_keepsPreviousDiscount() {
        cart.addItem("Apple", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("BAD"));

        // a rejected code shouldn't wipe out the discount that was already working
        assertEquals(90.00, cart.getTotal(), DELTA);
    }

    // getTotal
    @Test
    void getTotal_noDiscount_equalsSubtotal() {
        cart.addItem("Apple", 2.50, 4);

        double result = cart.getTotal();

        assertEquals(10.00, result, DELTA);
    }

    @Test
    void getTotal_emptyCartWithDiscount_returnsZero() {
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        double result = cart.getTotal();

        assertEquals(0.0, result, DELTA);
    }

    @Test
    void getTotal_halfOff_returnsHalfOfSubtotal() {
        cart.addItem("Apple", 30.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        double result = cart.getTotal();

        assertEquals(15.00, result, DELTA);
    }

    @Test
    void getTotal_noRounding_returnsExactValue() {
        cart.addItem("Apple", 3.33, 3);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        double result = cart.getTotal();

        // 9.99 * 0.9 = 8.991, which would be 8.99 if the method rounded to cents
        assertEquals(8.991, result, DELTA);
    }

    // stretch goal 1
    // each row of the CsvSource runs the test once, with the code and expected total filled in
    @ParameterizedTest
    @CsvSource({
        "SAVE10, 90.0",
        "SAVE20, 80.0",
        "HALFOFF, 50.0"
    })
    void applyDiscountCode_eachValidCode_producesExpectedTotal(String code, double expectedTotal) {
        cart.addItem("Apple", 100.00, 1);

        cart.applyDiscountCode(code);

        assertEquals(expectedTotal, cart.getTotal(), DELTA);
    }

    // stretch goal 1
    // wrong casing, partial codes, blanks, and a trailing space should all be rejected
    @ParameterizedTest
    @ValueSource(strings = {"save10", "Save20", "halfoff", "SAVE", "", " ", "HALF OFF", "SAVE10 "})
    void applyDiscountCode_invalidCodes_throwIllegalArgumentException(String code) {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(code));
    }

    // stretch goal 1
    // the quotes keep CsvSource from trimming the blank names down to nothing
    @ParameterizedTest
    @CsvSource({
        "'',     1.00,  1",
        "'   ',  1.00,  1",
        "Apple, -1.00,  1",
        "Apple,  1.00,  0",
        "Apple,  1.00, -5"
    })
    void addItem_invalidInputs_throwIllegalArgumentException(String name, double price, int quantity) {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(name, price, quantity));
    }

    // stretch goal 2
    // assertAll runs every check and reports all failures together, instead of stopping at the first one
    @Test
    void addAndCount_severalItems_countAndSubtotalBothCorrect() {
        cart.addItem("Apple", 1.00, 2);
        cart.addItem("Bread", 3.00, 1);
        cart.addItem("Milk", 2.50, 2);

        assertAll(
            () -> assertEquals(5, cart.getItemCount()),
            () -> assertEquals(10.00, cart.getSubtotal(), DELTA)
        );
    }

    // stretch goal 2
    @Test
    void removeItem_afterRemoval_resultSubtotalAndTotalAllCorrect() {
        cart.addItem("Apple", 10.00, 1);
        cart.addItem("Bread", 20.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        boolean removed = cart.removeItem("Apple");

        assertAll(
            () -> assertTrue(removed),
            () -> assertEquals(20.00, cart.getSubtotal(), DELTA),
            () -> assertEquals(10.00, cart.getTotal(), DELTA)
        );
    }
}
