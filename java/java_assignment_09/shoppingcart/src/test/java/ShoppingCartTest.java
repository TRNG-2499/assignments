/*

ShoppingCart.getItemCount() should returns the TOTAL QUANTITY of all items in
the cart, but it returns items.size(), i.e. the number of distinct items.
For example, adding 15 potatoes reports 1 instead of 15.
Failing tests:
    addItemTests.addItemToEmptyCart
    addItemTests.addManyItemsToCart
    addItemTests.addFreeItemsToCart
    addItemTests.addSeveralItemsGroupedAssertions
    getItemCountTests.singleItemWithLargeQuantityCountsFullQuantity
    getItemCountTests.multipleDistinctItemsCountsSumOfQuantities
    getItemCountTests.sameItemAddedTwiceCountsCombinedQuantity
    getItemCountTests.countAfterRemovingOneItemExcludesRemovedQuantity
    getItemCountTests.countAndSubtotalAfterSeveralAddsGroupedAssertions
 
  (getItemCount tests with an empty cart or a single item of quantity 1 will
  pass since size() and total quantity coincide in those cases.)

*/

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ShoppingCartTest {
    @Nested
    @DisplayName("addItem tests")
    class addItemTests {
        @Test
        @DisplayName("Adding an Item to an empty cart gives a cart with as many items as were added.")
        void addItemToEmptyCart() {
            ShoppingCart cart = new ShoppingCart();
            boolean emptyCart = cart.isEmpty();
            cart.addItem("potatoes",4.50 ,15);
            assertAll(
                () -> assertTrue(emptyCart, "cart was initially empty"),
                () -> assertEquals(15, cart.getItemCount(), "item count accurate"),
                () -> assertEquals(67.5, cart.getSubtotal(), 0.01, "subtotal accurate")
            );

        }

        @Test
        @DisplayName("Adding same item twice behaves as expected")
        void addManyItemsToCart() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes",4.50 ,2);
            cart.addItem("potatoes",4.50 ,3);
            assertAll(
                () -> assertEquals(5, cart.getItemCount(), "item count accurate"),
                () -> assertEquals(22.5, cart.getSubtotal(), 0.01, "subtotal accurate")
            );

        }

        @Test
        @DisplayName("Adding an Item with a quantity of 0 throws IllegalArgumentException.")
        void addZeroItemsToCart() {
            ShoppingCart cart = new ShoppingCart();
            

            String message = assertThrows(IllegalArgumentException.class, () -> {
                cart.addItem("potatoes",4.50 ,0);
            }).getMessage();

            assertEquals("Quantity must be at least 1.", message);
        }

        @Test
        @DisplayName("Adding items with a price of 0 correctly adds to cart.")
        void addFreeItemsToCart() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("banana",0.0 ,30);

            assertAll(
                () -> assertEquals(30, cart.getItemCount(), "item count accurate"),
                () -> assertEquals(0.0, cart.getSubtotal(), 0.01, "subtotal accurate")
            );

        }

        @Test
        @DisplayName("Adding null item to cart throws correct IllegalArgumentException.")
        void addNullToCart() {
            ShoppingCart cart = new ShoppingCart();

            String message = assertThrows(IllegalArgumentException.class, () -> {
                cart.addItem(null,4.50 ,5);
            }).getMessage();

            assertEquals("Item name must not be null or blank.", message);

        }

        @Test
        @DisplayName("Adding an item with a negative price throws correct IllegalArgumentException.")
        void addNegativePriceToCart() {
            ShoppingCart cart = new ShoppingCart();

            String message = assertThrows(IllegalArgumentException.class, () -> {
                cart.addItem("potatoes", -0.01, 5);
            }).getMessage();

            assertEquals("Price must not be negative.", message);
        }

        @Test
        @DisplayName("Adding several different items reports count, subtotal and emptiness together.")
        void addSeveralItemsGroupedAssertions() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("apples", 1.25, 4);   // 5.00
            cart.addItem("bread", 3.00, 2);    // 6.00
            cart.addItem("milk", 2.50, 1);     // 2.50

            assertAll(
                () -> assertFalse(cart.isEmpty(), "cart is not empty"),
                () -> assertEquals(7, cart.getItemCount(), "total quantity is 4 + 2 + 1"),
                () -> assertEquals(13.5, cart.getSubtotal(), 0.01, "subtotal is 5.00 + 6.00 + 2.50")
            );
        }

        @ParameterizedTest(name = "addItem(\"{0}\", {1}, {2}) throws IllegalArgumentException")
        @CsvSource({
            ",         4.50,  1", 
            "'',       4.50,  1", 
            "'   ',    4.50,  1", 
            "potatoes, -1.0,  1", 
            "potatoes, 4.50,  0", 
            "potatoes, 4.50, -1", 
            "potatoes, 4.50, -100"
        })
        
        void addInvalidArgumentsThrows(String name, double price, int quantity) {
            ShoppingCart cart = new ShoppingCart();

            assertThrows(IllegalArgumentException.class, () -> cart.addItem(name, price, quantity));
        }
    }
    
    @Nested
    @DisplayName("removeItem tests")
    class removeItemTests {
        @Test
        @DisplayName("Removing an item from a cart removes that whole line, leaving a non-empty cart.")
        void removeItemFromCart() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 4);
            cart.addItem("apples", 1.00, 3);

            boolean removed = cart.removeItem("potatoes");

            assertAll(
                () -> assertTrue(removed, "removeItem returns true for an item in the cart"),
                () -> assertFalse(cart.isEmpty(), "cart still holds apples"),
                () -> assertEquals(3.0, cart.getSubtotal(), 0.01, "only apples remain in subtotal")
            );
        }

        @Test
        @DisplayName("Removing all items from cart correctly empties cart.")
        void removeAllItemsFromCart() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 4);
            cart.addItem("apples", 1.00, 3);

            boolean removedPotatoes = cart.removeItem("potatoes");
            boolean removedApples = cart.removeItem("apples");

            assertAll(
                () -> assertTrue(removedPotatoes, "potatoes removed"),
                () -> assertTrue(removedApples, "apples removed"),
                () -> assertTrue(cart.isEmpty(), "cart is empty"),
                () -> assertEquals(0.0, cart.getSubtotal(), 0.01, "subtotal is 0 for empty cart")
            );
        }

        @Test
        @DisplayName("Removing items not in cart returns false.")
        void removeItemNotInCart() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 4);

            boolean removed = cart.removeItem("carrots");

            assertAll(
                () -> assertFalse(removed, "carrots was never in the cart"),
                () -> assertEquals(18.0, cart.getSubtotal(), 0.01, "cart is unchanged")
            );
        }

        @Test
        @DisplayName("Removing null from a cart returns false and leaves the cart unchanged.")
        void removeNullFromCart() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 4);

            boolean removed = cart.removeItem(null);

            assertAll(
                () -> assertFalse(removed, "null is never in the cart"),
                () -> assertEquals(18.0, cart.getSubtotal(), 0.01, "cart is unchanged")
            );
        }

        @Test
        @DisplayName("Removing the same item twice returns true then false.")
        void removeSameItemTwice() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 4);

            boolean first = cart.removeItem("potatoes");
            boolean second = cart.removeItem("potatoes");

            assertAll(
                () -> assertTrue(first, "first removal finds the item"),
                () -> assertFalse(second, "second removal finds nothing"),
                () -> assertTrue(cart.isEmpty(), "cart is empty")
            );
        }

        @Test
        @DisplayName("Removing an item with different casing returns false (names are case-sensitive).")
        void removeItemWithDifferentCasing() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 4);

            boolean removed = cart.removeItem("POTATOES");

            assertAll(
                () -> assertFalse(removed, "POTATOES does not match potatoes"),
                () -> assertFalse(cart.isEmpty(), "potatoes is still in the cart")
            );
        }
    }

    @Nested
    @DisplayName("getItemCount tests")
    class getItemCountTests {
        @Test
        @DisplayName("An empty cart has an item count of 0.")
        void emptyCartHasCountZero() {
            ShoppingCart cart = new ShoppingCart();

            int count = cart.getItemCount();

            assertEquals(0, count);
        }

        @Test
        @DisplayName("A single item with quantity 1 gives a count of 1.")
        void singleItemWithQuantityOneCountsOne() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 1);

            int count = cart.getItemCount();

            assertEquals(1, count);
        }

        @Test
        @DisplayName("A single item with a large quantity counts the full quantity.")
        void singleItemWithLargeQuantityCountsFullQuantity() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 25);

            int count = cart.getItemCount();

            assertEquals(25, count);
        }

        @Test
        @DisplayName("Several distinct items count the sum of their quantities.")
        void multipleDistinctItemsCountsSumOfQuantities() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 3);
            cart.addItem("apples", 1.00, 5);
            cart.addItem("bread", 3.00, 2);

            int count = cart.getItemCount();

            assertEquals(10, count);
        }

        @Test
        @DisplayName("Adding the same item twice counts the combined quantity.")
        void sameItemAddedTwiceCountsCombinedQuantity() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 2);
            cart.addItem("potatoes", 4.50, 6);

            int count = cart.getItemCount();

            assertEquals(8, count);
        }

        @Test
        @DisplayName("After removing one item, the count excludes that item's full quantity.")
        void countAfterRemovingOneItemExcludesRemovedQuantity() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 3);
            cart.addItem("apples", 1.00, 7);
            cart.removeItem("potatoes");

            int count = cart.getItemCount();

            assertEquals(7, count);
        }

        @Test
        @DisplayName("Count, subtotal and emptiness are all consistent after several adds.")
        void countAndSubtotalAfterSeveralAddsGroupedAssertions() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 2.00, 3);   // 6.00
            cart.addItem("apples", 0.50, 4);     // 2.00
            cart.addItem("potatoes", 2.00, 2);   // +4.00, same line as above

            assertAll(
                () -> assertFalse(cart.isEmpty(), "cart is not empty"),
                () -> assertEquals(9, cart.getItemCount(), "3 + 2 potatoes + 4 apples"),
                () -> assertEquals(12.0, cart.getSubtotal(), 0.01, "5 * 2.00 + 4 * 0.50")
            );
        }
    }

    @Nested
    @DisplayName("getSubtotal tests")
    class getSubtotalTests {
        @Test
        @DisplayName("An empty cart has a subtotal of 0.")
        void emptyCartHasSubtotalZero() {
            ShoppingCart cart = new ShoppingCart();

            double subtotal = cart.getSubtotal();

            assertEquals(0.0, subtotal, 0.01);
        }

        @Test
        @DisplayName("A single item's subtotal is price times quantity.")
        void singleItemSubtotalIsPriceTimesQuantity() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 3);

            double subtotal = cart.getSubtotal();

            assertEquals(13.5, subtotal, 0.01);
        }

        @Test
        @DisplayName("Several different items have a subtotal equal to the sum of their line totals.")
        void multipleItemsSubtotalIsSumOfLines() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 2);   // 9.00
            cart.addItem("apples", 1.25, 4);     // 5.00
            cart.addItem("bread", 3.00, 1);      // 3.00

            double subtotal = cart.getSubtotal();

            assertEquals(17.0, subtotal, 0.01);
        }

        @Test
        @DisplayName("Free items contribute 0 to the subtotal.")
        void freeItemsContributeNothingToSubtotal() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("banana", 0.0, 30);
            cart.addItem("potatoes", 4.50, 2);

            double subtotal = cart.getSubtotal();

            assertEquals(9.0, subtotal, 0.01);
        }

        @Test
        @DisplayName("Removing an item lowers the subtotal by that item's line total.")
        void subtotalAfterRemovingItemExcludesIt() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 2);
            cart.addItem("apples", 1.25, 4);
            cart.removeItem("potatoes");

            double subtotal = cart.getSubtotal();

            assertEquals(5.0, subtotal, 0.01);
        }

        @Test
        @DisplayName("Subtotal ignores any applied discount.")
        void subtotalIsNotAffectedByDiscount() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 10.00, 10);
            cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

            double subtotal = cart.getSubtotal();

            assertEquals(100.0, subtotal, 0.01);
        }


        @Test
        @DisplayName("Subtotal after adding several items is accurate and the cart is not empty.")
        void subtotalAfterSeveralAddsGroupedAssertions() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 2);
            cart.addItem("apples", 1.25, 4);

            assertAll(
                () -> assertFalse(cart.isEmpty(), "cart is not empty"),
                () -> assertEquals(14.0, cart.getSubtotal(), 0.01, "subtotal is 9.00 + 5.00"),
                () -> assertEquals(14.0, cart.getTotal(), 0.01, "no discount, so total equals subtotal")
            );
        }
    }

    @Nested
    @DisplayName("applyDiscountCode tests")
    class applyDiscountCodeTests {
        @Test
        @DisplayName("Applying SAVE10 takes 10% off the total.")
        void applySave10TakesTenPercentOff() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 10.00, 10);

            cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

            assertEquals(90.0, cart.getTotal(), 0.01);
        }

        @Test
        @DisplayName("Applying a new valid code replaces the previously applied code.")
        void applyingSecondCodeReplacesFirst() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 10.00, 10);

            cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

            assertEquals(90.0, cart.getTotal(), 0.01, "SAVE10 replaces HALFOFF; discounts do not stack");
        }

        @Test
        @DisplayName("Applying a null code throws correct IllegalArgumentException.")
        void applyNullCodeThrows() {
            ShoppingCart cart = new ShoppingCart();

            String message = assertThrows(IllegalArgumentException.class, () -> {
                cart.applyDiscountCode(null);
            }).getMessage();

            assertEquals("Discount code must not be null.", message);
        }

        @Test
        @DisplayName("Applying an unknown code throws correct IllegalArgumentException.")
        void applyUnknownCodeThrows() {
            ShoppingCart cart = new ShoppingCart();

            String message = assertThrows(IllegalArgumentException.class, () -> {
                cart.applyDiscountCode("BOGUS");
            }).getMessage();

            assertEquals("Invalid discount code: BOGUS", message);
        }

        @Test
        @DisplayName("Codes are case-sensitive, so a lowercase valid code throws.")
        void applyLowercaseCodeThrows() {
            ShoppingCart cart = new ShoppingCart();

            assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
        }

        @Test
        @DisplayName("A rejected code leaves a previously applied discount in place.")
        void invalidCodeDoesNotClearExistingDiscount() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 10.00, 10);
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

            assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("BOGUS"));

            assertEquals(80.0, cart.getTotal(), 0.01, "SAVE20 is still applied");
        }

        
        @ParameterizedTest(name = "code {0} gives a total of {1}")
        @CsvSource({
            "SAVE10, 90.0",
            "SAVE20, 80.0",
            "HALFOFF, 50.0"
        })
        void validCodesProduceExpectedTotal(String code, double expectedTotal) {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 10.00, 10);

            cart.applyDiscountCode(code);

            assertEquals(expectedTotal, cart.getTotal(), 0.01);
        }

        @ParameterizedTest(name = "invalid code [{0}] throws IllegalArgumentException")
        @NullAndEmptySource
        @ValueSource(strings = {
            " ", "INVALID", "SAVE30", "Save10", "SAVE20 ", " SAVE20", "halfoff", "HALF_OFF", "50"
        })
        void invalidCodesThrow(String code) {
            ShoppingCart cart = new ShoppingCart();

            assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(code));
        }
    }

    @Nested 
    @DisplayName("getTotal tests")
    class getTotalTests{
        @Test
        @DisplayName("An empty cart has a total of 0.")
        void emptyCartHasTotalZero() {
            ShoppingCart cart = new ShoppingCart();

            double total = cart.getTotal();

            assertEquals(0.0, total, 0.01);
        }

        @Test
        @DisplayName("With no discount applied, the total equals the subtotal.")
        void totalWithoutDiscountEqualsSubtotal() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 4.50, 2);
            cart.addItem("apples", 1.25, 4);

            double total = cart.getTotal();

            assertEquals(14.0, total, 0.01);
        }

        @Test
        @DisplayName("With SAVE10 applied, the total is 90% of the subtotal.")
        void totalWithSave10IsNinetyPercentOfSubtotal() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 20.00, 5);
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

            double total = cart.getTotal();

            assertEquals(90.0, total, 0.01);
        }

        @Test
        @DisplayName("With HALFOFF applied, the total is half of the subtotal.")
        void totalWithHalfOffIsHalfOfSubtotal() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 20.00, 5);
            cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

            double total = cart.getTotal();

            assertEquals(50.0, total, 0.01);
        }

        @Test
        @DisplayName("Total reflects items added after the discount was applied.")
        void totalReflectsItemsAddedAfterDiscount() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 10.00, 1);
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
            cart.addItem("apples", 10.00, 4);

            double total = cart.getTotal();

            assertEquals(40.0, total, 0.01, "50.00 subtotal minus 20%");
        }

        @Test
        @DisplayName("Total reflects items removed after the discount was applied.")
        void totalReflectsItemsRemovedAfterDiscount() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 10.00, 5);
            cart.addItem("apples", 10.00, 5);
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
            cart.removeItem("apples");

            double total = cart.getTotal();

            assertEquals(45.0, total, 0.01, "50.00 subtotal minus 10%");
        }

        // ---- Stretch goals ----

        @Test
        @DisplayName("Subtotal and discounted total are both correct for a mixed cart.")
        void mixedCartSubtotalAndTotalGroupedAssertions() {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("potatoes", 10.00, 2);   // 20.00
            cart.addItem("apples", 20.00, 3);     // 60.00
            cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

            assertAll(
                () -> assertEquals(80.0, cart.getSubtotal(), 0.01, "subtotal is undiscounted"),
                () -> assertEquals(64.0, cart.getTotal(), 0.01, "total has 20% off")
            );
        }

        // Totals across several prices, quantities and codes.
        @ParameterizedTest(name = "price {0} x {1} with {2} gives a total of {3}")
        @CsvSource({
            "10.00, 1,  SAVE10,  9.00",
            "10.00, 1,  SAVE20,  8.00",
            "10.00, 1,  HALFOFF, 5.00",
            "2.50,  4,  SAVE10,  9.00",
            "0.00,  10, SAVE20,  0.00",
            "19.99, 3,  HALFOFF, 29.985"
        })
        void totalAcrossPricesAndCodes(double price, int quantity, String code, double expectedTotal) {
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("item", price, quantity);
            cart.applyDiscountCode(code);

            assertEquals(expectedTotal, cart.getTotal(), 0.001);
        }
    }
}