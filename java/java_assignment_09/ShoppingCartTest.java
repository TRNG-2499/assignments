package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


// Overall, out of the 23 tests run (without stretch goals), *getItemCount()* is the only failing method as its method does not account for the proper data.
// getItemCount() is only counting for the amount of entries rather than the quantity. Adding 5 apples is one entry, however
// it cannot see the 5 total apple qty.
// The test that failed during the test was **getItemCountTest()**

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach // Before each allows new cart to be initialized before each test
    public void setUp() {
        cart = new ShoppingCart();
    }



    // --------------- ADD ITEMS TESTS ---------------

    @Test // Test passed.
    public void addItemTest() {
        cart.addItem("Apple", 2.00, 3);
        double result = cart.getTotal();
        Assertions.assertEquals(6.0, result, 0.001);
    }
    @Test // Test passed.
    public void addMultipleItemTest() {
        cart.addItem("Apple", 2.00, 1);
        cart.addItem("Banana", 2.00, 1);
        double result = cart.getTotal();
        Assertions.assertEquals(4, result, 0.001);
    }
    @Test // Test passed.
    public void addNullItemTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 2.00, 1));
    }
    @Test // Test passed.
    public void addEmptyStringItemTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cart.addItem("", 2.00, 1));
    }
    @Test // Test passed.
    public void addNegativePricedItemTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", -1.00, 1));
    }
    @Test // Test passed.
    public void addQuantityZeroTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cart.addItem("Apple", 1.00, 0));
    }



    // --------------- REMOVE ITEMS TESTS ---------------

    @Test // Test passed.
    public void removeItemTest() {
        cart.addItem("Apple", 5.00, 1);
        boolean removeItemResult = cart.removeItem("Apple");
        Assertions.assertTrue(removeItemResult);
        boolean cartIsEmpty = cart.isEmpty();
        Assertions.assertTrue(cartIsEmpty);
    }
    @Test // Test passed.
    public void removeItemNeverAddedTest() {
        cart.addItem("Apple", 5.00, 1);
        boolean removeItemResult = cart.removeItem("Banana");
        Assertions.assertFalse(removeItemResult);
    }
    @Test // Test passed.
    public void removeItemTwiceTest() {
        cart.addItem("Apple", 5.00, 1);
        boolean removeItemResult = cart.removeItem("Apple");
        Assertions.assertTrue(removeItemResult);
        boolean removeSecondItemResult = cart.removeItem("Apple");
        Assertions.assertFalse(removeSecondItemResult);
    }



    // --------------- GET ITEM COUNT TESTS ---------------

    // **TEST FAILED**
    // Expected result is 5. getItemCount method returns the item.size which
    // will return the entries of the collection. Our test was 5 apples. The result was 1
    // as it only saw one apple, it did not account for the quantity
    @Test
    public void getItemCountTest() {
        cart.addItem("Apple", 2.00, 5);
        int result = cart.getItemCount();
        Assertions.assertEquals(5, result);
    }
    @Test // Test passed. getItemCount() returns # of entries, not total qty.
    public void getItemCountAddThenRemoveTest() {
        cart.addItem("Apple", 2.00, 5);
        cart.removeItem("Apple");
        int result = cart.getItemCount();
        Assertions.assertEquals(0, result);
    }
    @Test // Test passed. getItemCount() returns # of entries, not total qty.
    public void getItemCountEmptyTest() {
        int result = cart.getItemCount();
        Assertions.assertEquals(0, result);
    }



    // --------------- GET SUBTOTAL TESTS ---------------

    @Test // Test passed.
    public void getSubtotalTest() {
        cart.addItem("Apple", 2.00, 1);
        cart.addItem("Banana", 3.00, 1);
        cart.addItem("Orange", 4.00, 1);
        double result = cart.getSubtotal();
        Assertions.assertEquals(9, result, 0.001);
    }
    @Test // Test passed. Subtotal after both adding and removing items
    public void getSubtotalAfterRemovalOfItemTest() {
        cart.addItem("Apple", 2.00, 1);
        cart.addItem("Banana", 3.00, 1);
        cart.addItem("Orange", 4.00, 1);
        cart.removeItem("Apple");
        double result = cart.getSubtotal();
        Assertions.assertEquals(7, result, 0.001);
    }
    @Test // Test passed. Empty cart
    public void getSubtotalEmptyCartTest() {
        double result = cart.getSubtotal();
        Assertions.assertEquals(0, result, 0.001);
    }



    // --------------- DISCOUNT CODE TESTS ---------------

    @Test //  Test passed. 10% off
    public void applyTenPercentDiscountCodeTest() {
        cart.addItem("Sneakers", 100.00, 1);
        cart.applyDiscountCode("SAVE10");
        double result = cart.getTotal();
        Assertions.assertEquals(90, result, 0.001);
    }
    @Test // Test passed. 20% off
    public void applyTwentyPercentDiscountCodeTest() {
        cart.addItem("Sneakers", 100.00, 1);
        cart.applyDiscountCode("SAVE20");
        double result = cart.getTotal();
        Assertions.assertEquals(80, result, 0.001);
    }
    @Test // Test passed. 50% off
    public void applyFiftyPercentDiscountCodeTest() {
        cart.addItem("Sneakers", 100.00, 1);
        cart.applyDiscountCode("HALFOFF");
        double result = cart.getTotal();
        Assertions.assertEquals(50, result, 0.001);
    }
    @Test // Test passed. Invalid discount code
    public void applyInvalidDiscountCodeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("FREE"));
    }
    @Test // Test passed. Newest applied discount code overrides previous
    public void applyMultipleDiscountCodesTest() {
        cart.addItem("Sneakers", 100.00, 1);
        cart.applyDiscountCode("HALFOFF");
        cart.applyDiscountCode("SAVE10");
        double result = cart.getTotal();
        Assertions.assertEquals(90, result, 0.001);
    }



    // --------------- GET TOTAL TESTS ---------------

    @Test
    public void getTotalNoDiscountTest() {
        cart.addItem("Apple", 2.00, 5);
        double result = cart.getTotal();
        Assertions.assertEquals(10, result, 0.001);
    }
    @Test
    public void getTotalWithDiscountTest() {
        cart.addItem("Apple", 2.00, 5);
        cart.applyDiscountCode("HALFOFF");
        double result = cart.getTotal();
        Assertions.assertEquals(5, result, 0.001);
    }
    @Test
    public void getTotalWithEmptyCartTest() {
        double result = cart.getTotal();
        Assertions.assertEquals(0, result, 0.001);
    }



    // --------------- STRETCH GOALS ---------------

    // Parameterized test. Runs once for each invalid code
    @ParameterizedTest
    @ValueSource(strings = {"FREE", "save10", "Save20", "halfoff", "SAVE_10", ""})
    public void applyInvalidDiscountCodesTest(String code) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(code));
    }

    // Parameterized test. Each row is a discount code and the total it should give
    @ParameterizedTest
    @CsvSource({
            "SAVE10, 90",
            "SAVE20, 80",
            "HALFOFF, 50"
    })
    public void applyValidDiscountCodesTest(String code, double expected) {
        cart.addItem("Sneakers", 100.00, 1);
        cart.applyDiscountCode(code);
        double result = cart.getTotal();
        Assertions.assertEquals(expected, result, 0.001);
    }

    // Grouped assertions. Checks item count and subtotal together
    @Test
    public void addItemsGroupedTest() {
        cart.addItem("Apple", 2.00, 3);
        cart.addItem("Banana", 1.00, 2);
        int count = cart.getItemCount();
        double subtotal = cart.getSubtotal();
        Assertions.assertAll(
                () -> Assertions.assertEquals(5, count),
                () -> Assertions.assertEquals(8, subtotal, 0.001)
        );
    }

    // Grouped assertions. Checks everything after removing the only item
    @Test
    public void removeItemGroupedTest() {
        cart.addItem("Apple", 5.00, 1);
        boolean removeItemResult = cart.removeItem("Apple");
        boolean cartIsEmpty = cart.isEmpty();
        double subtotal = cart.getSubtotal();
        Assertions.assertAll(
                () -> Assertions.assertTrue(removeItemResult),
                () -> Assertions.assertTrue(cartIsEmpty),
                () -> Assertions.assertEquals(0, subtotal, 0.001)
        );
    }
}
