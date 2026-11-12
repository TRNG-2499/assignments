import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Bug in ShoppingCart.getItemCount():
 * - getItemCount_oneProductWithThreeUnits_returnsThree (expected 3, got 1)
 * - getItemCount_multipleProducts_sumsQuantities (expected 5, got 2)
 * items.size() counts distinct product names. The method should add
 * the quantities on all cart lines to get the total number of units.
 */


class ShoppingCartTest {
    // Allow tiny differences when comparing double values.
    private static final double DELTA = 0.000001;
    private ShoppingCart cart;

    // Each test starts with an empty cart and no discount.
    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void addItem_newProduct_addsItToCart() {
        // Act
        cart.addItem("Pen", 2.50, 1);

        // Assert
        assertEquals(2.50, cart.getSubtotal(), DELTA);
    }

    @Test
    void addItem_sameName_increasesQuantity() {
        // Arrange
        cart.addItem("Pen", 2.50, 2);

        // Act
        cart.addItem("Pen", 2.50, 3);

        // Assert: Five pens at $2.50 each.
        assertEquals(12.50, cart.getSubtotal(), DELTA);
    }

    @Test
    void addItem_zeroQuantity_throwsException() {
        // Act and assert: The minimum allowed quantity is one.
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Pen", 2.50, 0));
    }

    @Test
    void removeItem_existingProduct_removesAllUnits() {
        // Arrange
        cart.addItem("Pen", 2.50, 3);

        // Act
        boolean removed = cart.removeItem("Pen");

        // Assert: Removing the product clears all three units.
        assertTrue(removed);
        assertEquals(0.0, cart.getSubtotal(), DELTA);
    }

    @Test
    void removeItem_emptyCart_returnsFalse() {
        // Act
        boolean removed = cart.removeItem("Pen");

        // Assert
        assertFalse(removed);
    }

    @Test
    void removeItem_missingProduct_leavesExistingProduct() {
        // Arrange
        cart.addItem("Pen", 2.50, 1);

        // Act
        boolean removed = cart.removeItem("Book");

        // Assert
        assertFalse(removed);
        assertEquals(2.50, cart.getSubtotal(), DELTA);
    }

    @Test
    void getItemCount_emptyCart_returnsZero() {
        // Act
        int count = cart.getItemCount();

        // Assert
        assertEquals(0, count);
    }

    @Test
    void getItemCount_oneProductWithThreeUnits_returnsThree() {
        // Arrange
        cart.addItem("Pen", 2.50, 3);

        // Act
        int count = cart.getItemCount();

        // Assert: One cart line contains three units.
        assertEquals(3, count);
    }

    @Test
    void getItemCount_multipleProducts_sumsQuantities() {
        // Arrange
        cart.addItem("Pen", 2.50, 2);
        cart.addItem("Book", 8.00, 3);

        // Act
        int count = cart.getItemCount();

        // Assert: Two pens and three books add up to five units.
        assertEquals(5, count);
    }

    @Test
    void getSubtotal_emptyCart_returnsZero() {
        // Act
        double subtotal = cart.getSubtotal();

        // Assert
        assertEquals(0.0, subtotal, DELTA);
    }

    @Test
    void getSubtotal_multipleProducts_sumsPriceTimesQuantity() {
        // Arrange
        cart.addItem("Pen", 2.50, 2);
        cart.addItem("Book", 8.00, 3);

        // Act
        double subtotal = cart.getSubtotal();

        // Assert: The pens cost $5 and the books cost $24.
        assertEquals(29.00, subtotal, DELTA);
    }

    @Test
    void getSubtotal_discountApplied_returnsOriginalAmount() {
        // Arrange
        cart.addItem("Book", 20.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        // Act
        double subtotal = cart.getSubtotal();

        // Assert: The subtotal is the amount before the discount.
        assertEquals(20.00, subtotal, DELTA);
    }

    @Test
    void applyDiscountCode_save10_reducesTotalByTenPercent() {
        // Arrange
        cart.addItem("Book", 100.00, 1);

        // Act
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        // Assert
        assertEquals(90.00, cart.getTotal(), DELTA);
    }

    @Test
    void applyDiscountCode_secondCode_replacesFirst() {
        // Arrange
        cart.addItem("Book", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        // Act
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        // Assert: SAVE20 applies to the original $100 subtotal.
        assertEquals(80.00, cart.getTotal(), DELTA);
    }

    @Test
    void applyDiscountCode_wrongCase_throwsException() {
        // Act and assert: Discount codes are case-sensitive.
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
    }

    @Test
    void getTotal_withoutDiscount_returnsSubtotal() {
        // Arrange
        cart.addItem("Pen", 2.50, 2);

        // Act
        double total = cart.getTotal();

        // Assert
        assertEquals(5.00, total, DELTA);
    }

    @Test
    void getTotal_halfOff_keepsFractionalCents() {
        // Arrange
        cart.addItem("Book", 19.99, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        // Act
        double total = cart.getTotal();

        // Assert: Half of $19.99 is $9.995 before any rounding.
        assertEquals(9.995, total, DELTA);
    }

    @Test
    void getTotal_emptyCartWithDiscount_returnsZero() {
        // Arrange
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        // Act
        double total = cart.getTotal();

        // Assert
        assertEquals(0.0, total, DELTA);
    }
}