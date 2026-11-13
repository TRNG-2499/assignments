/*
 * ============================================================================
 *  BUG REPORT  (fill this in after running the tests)
 * ============================================================================
 *  Method with incorrect logic: TODO  (e.g. "getSomething()")
 *
 *  Failing test(s):
 *    - TODO
 *    - TODO
 *
 *  What it does wrong:
 *    TODO - one or two sentences describing the expected vs. actual behavior.
 *
 *  NOTE: ShoppingCart has NOT been modified or fixed - only identified.
 * ============================================================================
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    /** Tolerance used for every double comparison. */
    private static final double DELTA = 0.0001;

    /**
     * A brand-new cart is created before EVERY test, so tests never share state.
     */
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    // ========================================================================
    // addItem(String name, double price, int quantity)
    // ========================================================================
    @Nested
    @DisplayName("addItem")
    class AddItemTests {

        @Test
        void addItem_validItem_increasesItemCount() {
            // Arrange: can stay empty

            // Act
            cart.addItem("Cherry", 20.01, 10);

            int result = cart.getItemCount();

            // Assert
            assertEquals(10, result);
        }

        @Test
        void addItem_sameNameTwice_combinesQuantities() {
            // Arrange: add "Apple" once
            cart.addItem("Apple", 10, 15);

            // Act: add "Apple" again
            cart.addItem("Apple", 10, 7);

            int result = cart.getItemCount();

            // Assert: item count is the sum of both quantities
            assertEquals(22, result);
        }

        @Test
        void addItem_sameNameDifferentCase_treatedAsSeparateItems() {
            // Arrange / Act: add "Apple" and "apple"
            cart.addItem("Apple", 10, 15);
            cart.addItem("apple", 10, 7);
            cart.removeItem("apple");

            // Assert: both are kept (e.g. removing one leaves the other)
            int result = cart.getItemCount();
            assertEquals(15, result);
        }

        @Test
        void addItem_zeroPrice_isAllowed() {
            // Boundary: price of 0.0 is NOT negative, so it should be accepted
            // Act
            cart.addItem("Peach", 0.0, 3);

            // Assert
            double result = cart.getTotal();
            assertEquals(0, result, DELTA);
            int count = cart.getItemCount();
            assertEquals(3, count);
        }

        @Test
        void addItem_quantityOfOne_isAllowed() {
            // Boundary: quantity 1 is the smallest valid value
            // Act
            cart.addItem("Ackee", 10, 1);

            // Assert
            int result = cart.getItemCount();
            assertEquals(1, result);
        }

        @Test
        void addItem_nullName_throwsIllegalArgumentException() {
            // Act/Assert
            assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 10, 10));

        }

        @Test
        void addItem_blankName_throwsIllegalArgumentException() {
            // Act/Assert
            assertThrows(IllegalArgumentException.class, () -> cart.addItem("", 10, 10));
        }

        @Test
        void addItem_negativePrice_throwsIllegalArgumentException() {
            // Act/Assert
            assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", -10, 10));
        }

        @Test
        void addItem_zeroQuantity_throwsIllegalArgumentException() {
            // Act/Assert
            assertThrows(IllegalArgumentException.class, () -> cart.addItem("apple", 10, 0));
        }
    }

    // ========================================================================
    // removeItem(String name)
    // ========================================================================
    @Nested
    @DisplayName("removeItem")
    class RemoveItemTests {

        @Test
        void removeItem_existingItem_returnsTrue() {
            // Arrange: add 1 item
            cart.addItem("Peach", 11, 1);

            // Act
            boolean result = cart.removeItem("Peach");

            // Assert
            assertTrue(result);

        }

        @Test
        void removeItem_existingItem_removesEntireQuantity() {
            // Arrange: add an item with quantity > 1
            cart.addItem("Peach", 11, 2);

            // Act: remove it
            cart.removeItem("Peach");

            // Assert: item count drops by the full quantity, not by 1
            int result = cart.getItemCount();
            assertEquals(0, result);
        }

        @Test
        void removeItem_itemNotInCart_returnsFalse() {
            // Arrange: add an item with quantity > 1 that isn't apple
            cart.addItem("Peach", 11, 2);
            // Act: remove wrong item and Assert: check what happened to Apple

            boolean result = cart.removeItem("Apple");

            // Assert
            assertFalse(result);
            // shows peaches wasn't touched
            assertEquals(2, cart.getItemCount());

        }

        @Test
        void removeItem_emptyCart_returnsFalse() {
            // Cart start empty

            // Act
            boolean result = cart.removeItem("tree");

            // Assert
            assertFalse(result);
        }

        @Test
        void removeItem_calledTwiceOnSameItem_secondCallReturnsFalse() {
            // Arrange: add 1 item to cart
            cart.addItem("Apple", 10, 1);

            // Act: remove apple twice
            boolean first = cart.removeItem("Apple");
            boolean second = cart.removeItem("Apple");

            // Assert
            assertTrue(first);
            assertFalse(second);

        }

        @Test
        void removeItem_differentCase_returnsFalse() {
            // Arrange: add 1 item to cart
            cart.addItem("Apple", 10, 1);

            // Act: remove apple incorrectly
            boolean result = cart.removeItem("apple");

            assertFalse(result);

        }
    }

    // ========================================================================
    // getItemCount()
    // ========================================================================
    @Nested
    @DisplayName("getItemCount")
    class GetItemCountTests {

        @Test
        void getItemCount_emptyCart_returnsZero() {
            // Arrange: cart is empty

            // Act
            int result = cart.getItemCount();

            // Assert
            assertEquals(0, result);

        }

        @Test
        void getItemCount_multipleItems_returnsTotalQuantity() {
            // Total QUANTITY, not number of distinct items

            // Arrange
            cart.addItem("Apple", 10, 1);
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 3);

            // Act
            int result = cart.getItemCount();

            // Assert
            assertEquals(9, result);
        }

        @Test
        void getItemCount_afterRemovingItem_excludesRemovedQuantity() {
            // Arrange
            cart.addItem("Apple", 10, 1);
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 3);

            // Act: remove Apple
            cart.removeItem("Apple");
            int result = cart.getItemCount();

            // Assert
            assertEquals(8, result);
        }

        @Test
        void getItemCount_afterInvalidAdd_isUnchanged() {
            // A rejected addItem call should not change the count

            // Arrange: incorrectly adding item
            assertThrows(IllegalArgumentException.class, () -> cart.addItem("Peach", 10, -5));
            int result = cart.getItemCount();

            // Assert
            assertEquals(0, result);
        }
    }

    // ========================================================================
    // getSubtotal()
    // ========================================================================
    @Nested
    @DisplayName("getSubtotal")
    class GetSubtotalTests {

        @Test
        void getSubtotal_emptyCart_returnsZero() {
            // cart is empty

            double result = cart.getSubtotal();
            assertEquals(0.0, result);
        }

        @Test
        void getSubtotal_singleItemWithQuantity_returnsPriceTimesQuantity() {
            // Arrange
            cart.addItem("Peach", 10, 5);

            // Act
            double result = cart.getSubtotal();

            // Assert
            assertEquals(50.0, result);
        }

        @Test
        void getSubtotal_multipleItems_returnsSumOfAllLines() {
            // Arrange
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 4);
            cart.addItem("Apple", 10, 9);

            // Act
            double result = cart.getSubtotal();

            // Assert
            assertEquals(180, result);
        }

        @Test
        void getSubtotal_withDiscountApplied_ignoresDiscount() {
            // ignores discounts

            // Arrange
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 4);
            cart.addItem("Apple", 10, 9);

            // Act
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
            double result = cart.getSubtotal();

            // Assert
            assertEquals(180, result);

        }

        @Test
        void getSubtotal_afterRemovingItem_excludesRemovedItem() {
            // Arrange:
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 4);
            cart.addItem("Apple", 10, 9);

            // Act
            cart.removeItem("Apple"); // removing apple changes subtotal
            double result = cart.getSubtotal();

            // Assert
            assertEquals(90, result);
        }
    }

    // ========================================================================
    // applyDiscountCode(String code)
    // ========================================================================
    @Nested
    @DisplayName("applyDiscountCode")
    class ApplyDiscountCodeTests {

        @Test
        void applyDiscountCode_validCode_doesNotThrow() {

            assertDoesNotThrow(() -> cart.applyDiscountCode(ShoppingCart.CODE_SAVE10));

        }

        @Test
        void applyDiscountCode_newValidCode_replacesPreviousCode() {
            // Apply SAVE10, then SAVE20 -> total reflects ONLY 20% off

            // Arrange
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 4);
            cart.addItem("Apple", 10, 9);

            // Act
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
            double result = cart.getTotal();

            assertEquals(144, result);

        }

        @Test
        void applyDiscountCode_nullCode_throwsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(null));
        }

        @Test
        void applyDiscountCode_unknownCode_throwsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE100"));
        }

        @Test
        void applyDiscountCode_wrongCase_throwsIllegalArgumentException() {
            // e.g. "save10"
            assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
        }

        @Test
        void applyDiscountCode_onEmptyCart_doesNotThrow() {
            // cart is just empty, no error should be thrown in this case

            assertDoesNotThrow(() -> cart.applyDiscountCode(ShoppingCart.CODE_SAVE10));

        }
    }

    // ========================================================================
    // getTotal()
    // ========================================================================
    @Nested
    @DisplayName("getTotal")
    class GetTotalTests {

        @Test
        void getTotal_noDiscount_equalsSubtotal() {
            // Arrange: adding in one item
            cart.addItem("Apple", 1, 1);

            // Act
            double total = cart.getTotal();
            double subtotal = cart.getSubtotal();

            // Assert total and subtotal should be the same considering no discount
            assertEquals(total, subtotal);
        }

        @Test
        void getTotal_save10_returnsNinetyPercentOfSubtotal() {
            // Arrange
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 4);
            cart.addItem("Apple", 10, 9);

            // Act
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
            double result = cart.getTotal();

            // assert
            assertEquals(162, result);

        }

        @Test
        void getTotal_save20_returnsEightyPercentOfSubtotal() {
            // Arrange
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 4);
            cart.addItem("Apple", 10, 9);

            // Act
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
            double result = cart.getTotal();

            // assert
            assertEquals(144, result);
        }

        @Test
        void getTotal_halfOff_returnsHalfOfSubtotal() {
            // Arrange
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 4);
            cart.addItem("Apple", 10, 9);

            // Act
            cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
            double result = cart.getTotal();

            // assert
            assertEquals(90, result);

        }

        @Test
        void getTotal_emptyCart_returnsZero() {
            // cart is empty

            // act
            double result = cart.getTotal();

            // assert
            assertEquals(0, result);

        }

        @Test
        void getTotal_itemAddedAfterDiscount_discountAppliesToNewItemToo() {
            // Arrange
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 4);
            cart.addItem("Apple", 10, 9);

            // Act
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
            cart.addItem("Pear", 10, 1);
            double result = cart.getTotal();

            // assert
            assertEquals(171, result);

        }

        @Test
        void getTotal_invalidCodeAfterValidCode_keepsOriginalDiscount() {
            // Apply SAVE10, then try an invalid code (expect exception),
            // total should still be 10% off

            // Arrange
            cart.addItem("Peach", 10, 5);
            cart.addItem("Orange", 10, 4);
            cart.addItem("Apple", 10, 9);

            // Act: invalid discount
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
            assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE80"));
            double result = cart.getTotal();

            assertEquals(162, result);
        }
    }

    // ========================================================================
    // STRETCH GOAL 1: Parameterized Tests
    // ========================================================================
    @Nested
    @DisplayName("Stretch: parameterized")
    class ParameterizedTests {

        @ParameterizedTest(name = "code {0} on subtotal 100.0 -> total {1}")
        @CsvSource({
                "SAVE10,  90.0",
                "SAVE20,  80.0",
                "HALFOFF, 50.0"
        })
        void getTotal_eachValidCode_producesExpectedTotal(String code, double expectedTotal) {
            // Arrange: add items totalling 100.0
            // Act: apply code, read total
            // Assert: assertEquals(expectedTotal, actual, DELTA)
            fail("Not implemented yet");
        }

        @ParameterizedTest(name = "invalid code \"{0}\" throws")
        @NullAndEmptySource
        @ValueSource(strings = { "save10", "Save20", "halfoff", "SAVE30", " SAVE10", "SAVE10 ", "BOGUS" })
        void applyDiscountCode_invalidCodes_throwIllegalArgumentException(String code) {
            fail("Not implemented yet");
        }

        @ParameterizedTest(name = "addItem(\"{0}\", {1}, {2}) throws")
        @CsvSource(value = {
                // name, price, quantity
                "NULL,    1.00,  1", // null name
                "'',      1.00,  1", // empty name
                "'   ',   1.00,  1", // blank name
                "Apple,  -0.01,  1", // negative price
                "Apple,   1.00,  0", // zero quantity
                "Apple,   1.00, -5" // negative quantity
        }, nullValues = "NULL")
        void addItem_invalidInputs_throwIllegalArgumentException(String name, double price, int quantity) {
            fail("Not implemented yet");
        }

        @ParameterizedTest(name = "quantity {0} is accepted")
        @ValueSource(ints = { 1, 2, 10, 1000 })
        void addItem_validQuantities_areReflectedInItemCount(int quantity) {
            fail("Not implemented yet");
        }
    }

    // ========================================================================
    // STRETCH GOAL 2: Grouped Assertions (assertAll)
    // ========================================================================
    @Nested
    @DisplayName("Stretch: grouped assertions")
    class GroupedAssertionTests {

        @Test
        void addSeveralItems_countAndSubtotalBothCorrect() {
            // Arrange / Act: add several items

            // Assert:
            // assertAll("cart after adding items",
            // () -> assertEquals(expectedCount, cart.getItemCount()),
            // () -> assertEquals(expectedSubtotal, cart.getSubtotal(), DELTA),
            // () -> assertFalse(cart.isEmpty())
            // );
            fail("Not implemented yet");
        }

        @Test
        void applyDiscount_subtotalUnchangedAndTotalReduced() {
            // assertAll: subtotal stays the same, total is discounted
            fail("Not implemented yet");
        }

        @Test
        void removeItem_countSubtotalAndTotalAllUpdated() {
            // assertAll: return value, item count, subtotal, total after removal
            fail("Not implemented yet");
        }
    }
}
