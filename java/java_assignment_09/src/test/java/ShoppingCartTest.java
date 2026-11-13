
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
/*
Failing Tests: addItemValidItemIncreasesItemCount, addItemSameNameIncreasesExistingQuantity, getItemCountSingleItemReturnsQuantity, getItemCountMultipleItemsReturnsTotalQuantity, 
getItemCountAfterRemovingItemReturnsRemainingQuantity, and addingMultipleItemsUpdatesCountAndSubtotal

The reason for the getItemCount() method is failing due to it returning the # of different products in the shoping cart insted of the total quanitity
of all items. For example, when adding 3 apples and 2 bannanas, the result expected was an item count of 5, but it returns 2. 

I did not change ShoppingCart at all. 

 */
public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void addItemValidItemIncreasesItemCount() {
        // Arrange
        String name = "Apple";
        double price = 2.50;
        int quantity = 3;

        // Act
        cart.addItem(name, price, quantity);

        // Assert
        assertEquals(3, cart.getItemCount());
    }

    @Test
    void addItemOneItemUpdatesSubtotal() {
        // Arrange
        String name = "Apple";
        double price = 2.50;
        int quantity = 1;

        // Act
        cart.addItem(name, price, quantity);

        // Assert
        assertEquals(2.50, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItemSameNameIncreasesExistingQuantity() {
        // Arrange
        cart.addItem("Apple", 2.50, 2);

        // Act
        cart.addItem("Apple", 2.50, 3);

        // Assert
        assertEquals(5, cart.getItemCount());
        assertEquals(12.50, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItemNegativePriceThrowsException() {
        // Arrange
        double price = -2.50;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Apple", price, 3);
        });
    }

    @Test
    void addItemZeroQuantityThrowsException() {
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Apple", 2.50, 0);
        });
    }

    @Test
    void addItemBlankNameThrowsException() {
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("   ", 2.50, 1);
        });
    }

    @Test
    void addItemNullNameThrowsException() {
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem(null, 2.50, 1);
        });
    }

    @Test
    void removeItemExistingItemReturnsTrue() {
        // Arrange
        cart.addItem("Apple", 2.50, 2);

        // Act
        boolean removed = cart.removeItem("Apple");

        // Assert
        assertTrue(removed);
    }

    @Test
    void removeItemMissingItemReturnsFalse() {
        // Act
        boolean removed = cart.removeItem("Banana");

        // Assert
        assertFalse(removed);
    }

    @Test
    void removeItemRemovesEntireQuantity() {
        // Arrange
        cart.addItem("Apple", 2.50, 3);
        cart.addItem("Banana", 1.00, 2);

        // Act
        boolean removed = cart.removeItem("Apple");

        // Assert
        assertTrue(removed);
        assertEquals(2.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void removeItemTwiceReturnsFalseSecondTime() {
        // Arrange
        cart.addItem("Apple", 2.50, 1);

        // Act
        boolean firstRemoval = cart.removeItem("Apple");
        boolean secondRemoval = cart.removeItem("Apple");

        // Assert
        assertTrue(firstRemoval);
        assertFalse(secondRemoval);
    }

    @Test
    void getItemCountNewCartReturnsZero() {
        // Act
        int count = cart.getItemCount();

        // Assert
        assertEquals(0, count);
    }

    @Test
    void getItemCountSingleItemReturnsQuantity() {
        // Arrange
        cart.addItem("Apple", 2.50, 4);

        // Act
        int count = cart.getItemCount();

        // Assert
        assertEquals(4, count);
    }

    @Test
    void getItemCountMultipleItemsReturnsTotalQuantity() {
        // Arrange
        cart.addItem("Apple", 2.50, 3);
        cart.addItem("Banana", 1.00, 2);

        // Act
        int count = cart.getItemCount();

        // Assert
        assertEquals(5, count);
    }

    @Test
    void getItemCountAfterRemovingItemReturnsRemainingQuantity() {
        // Arrange
        cart.addItem("Apple", 2.50, 3);
        cart.addItem("Banana", 1.00, 2);

        // Act
        cart.removeItem("Apple");
        int count = cart.getItemCount();

        // Assert
        assertEquals(2, count);
    }

    @Test
    void getSubtotalEmptyCartReturnsZero() {
        // Act
        double subtotal = cart.getSubtotal();

        // Assert
        assertEquals(0.0, subtotal, 0.001);
    }

    @Test
    void getSubtotalSingleItemCalculatesPriceTimesQuantity() {
        // Arrange
        cart.addItem("Apple", 2.50, 3);

        // Act
        double subtotal = cart.getSubtotal();

        // Assert
        assertEquals(7.50, subtotal, 0.001);
    }

    @Test
    void getSubtotalMultipleItemsReturnsCorrectSum() {
        // Arrange
        cart.addItem("Apple", 2.50, 3);
        cart.addItem("Banana", 1.00, 2);

        // Act
        double subtotal = cart.getSubtotal();

        // Assert
        assertEquals(9.50, subtotal, 0.001);
    }

    @Test
    void getSubtotalAfterDiscountRemainsUnchanged() {
        // Arrange
        cart.addItem("Apple", 10.00, 2);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        // Act
        double subtotal = cart.getSubtotal();

        // Assert
        assertEquals(20.00, subtotal, 0.001);
    }

    @Test
    void applyDiscountCodeSave10ReducesTotalByTenPercent() {
        // Arrange
        cart.addItem("Apple", 100.00, 1);

        // Act
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        // Assert
        assertEquals(90.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCodeSave20ReducesTotalByTwentyPercent() {
        // Arrange
        cart.addItem("Apple", 100.00, 1);

        // Act
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        // Assert
        assertEquals(80.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCodeHalfOffReducesTotalByFiftyPercent() {
        // Arrange
        cart.addItem("Apple", 100.00, 1);

        // Act
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        // Assert
        assertEquals(50.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCodeInvalidCodeThrowsException() {
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("INVALID");
        });
    }

    @Test
    void applyDiscountCodeNullThrowsException() {
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode(null);
        });
    }

    @Test
    void applyDiscountCodeReplacesPreviousDiscount() {
        // Arrange
        cart.addItem("Apple", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        // Act
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        // Assert
        assertEquals(80.00, cart.getTotal(), 0.001);
    }

    @Test
    void getTotalEmptyCartReturnsZero() {
        // Act
        double total = cart.getTotal();

        // Assert
        assertEquals(0.0, total, 0.001);
    }

    @Test
    void getTotalWithoutDiscountEqualsSubtotal() {
        // Arrange
        cart.addItem("Apple", 10.00, 3);

        // Act
        double total = cart.getTotal();

        // Assert
        assertEquals(30.00, total, 0.001);
    }

    @Test
    void getTotalWithDiscountCalculatesCorrectAmount() {
        // Arrange
        cart.addItem("Apple", 20.00, 2);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        // Act
        double total = cart.getTotal();

        // Assert
        assertEquals(36.00, total, 0.001);
    }

    @Test
    void getTotalAfterRemovingItemRecalculatesDiscount() {
        // Arrange
        cart.addItem("Apple", 20.00, 2);
        cart.addItem("Banana", 10.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        cart.removeItem("Banana");

        // Act
        double total = cart.getTotal();

        // Assert
        assertEquals(32.00, total, 0.001);
    }

    // Goal 1

    @ParameterizedTest
    @CsvSource({
        "SAVE10, 90.0",
        "SAVE20, 80.0",
        "HALFOFF, 50.0"
    })
    void validDiscountCodesProduceCorrectTotal(
            String code, double expectedTotal) {

        // Arrange
        cart.addItem("Apple", 100.00, 1);

        // Act
        cart.applyDiscountCode(code);

        // Assert
        assertEquals(expectedTotal, cart.getTotal(), 0.001);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "save10",
        "SAVE30",
        "HALF",
        "",
        "SAVE20 "
    })
    void invalidDiscountCodesThrowException(String code) {
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode(code);
        });
    }

    // Goal 2

    @Test
    void addingMultipleItemsUpdatesCountAndSubtotal() {
        // Arrange
        cart.addItem("Apple", 2.00, 2);
        cart.addItem("Banana", 3.00, 3);

        // Act
        int count = cart.getItemCount();
        double subtotal = cart.getSubtotal();

        // Assert
        assertAll(
            () -> assertEquals(5, count),
            () -> assertEquals(13.00, subtotal, 0.001)
        );
    }

    @Test
    void applyingDiscountChangesTotalButNotSubtotal() {
        // Arrange
        cart.addItem("Apple", 10.00, 2);

        // Act
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        // Assert
        assertAll(
            () -> assertEquals(20.00, cart.getSubtotal(), 0.001),
            () -> assertEquals(10.00, cart.getTotal(), 0.001)
        );
    }
}
