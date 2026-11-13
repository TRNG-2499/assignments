import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.testing.ShoppingCart;

public class ShoppingCartTest {

    private ShoppingCart cart;

    private static final String nameLower = "a";
    private static final String wrongName = "b";
    private static final double price1 = 1;
    private static final int quant1 = 1;

    @BeforeEach
    void newCart() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddItem_addsToCartAndSubTotal() {
        cart.addItem(nameLower, price1, quant1);

        assertAll(
            "Addition reflected in cart and subtotal",
            () -> assertFalse(cart.isEmpty()),
            () -> assertEquals(1, cart.getSubtotal())
        );
    }

    @Test
    void testAddItem_existingItemSameCase_addsToCartAndSubtotal() {
        cart.addItem(nameLower, price1, quant1);
        cart.addItem(nameLower, price1, quant1);

        assertAll(
            "Addition reflected in cart and total",
            () -> assertEquals(2, cart.getItemCount()),
            () -> assertEquals(2, cart.getSubtotal())
        );
    }

    @Test
    void testAddItem_sameNameDifferentCase_addsToCartAndSubtotal() {
        cart.addItem(nameLower, price1, quant1);
        cart.addItem(nameLower.toUpperCase(), price1, quant1);

        assertAll(
            "Verify addition reflected in cart and total",
            () -> assertEquals(2, cart.getItemCount()),
            () -> assertEquals(2, cart.getSubtotal())
        );
    }
    
    @Test
    void testAddItemNullOrBlank_throwsIllegalArgumentException() {
        assertAll(
            "Verify null, empty, or whitespace item name throws IAE",
            () -> assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, price1, quant1)),
            () -> assertThrows(IllegalArgumentException.class, () -> cart.addItem("", price1, quant1)),
            () -> assertThrows(IllegalArgumentException.class, () -> cart.addItem(" ", price1, quant1))
        );
    }

    @Test
    void testAddItemInvalidPriceOrQuantity_throwsIllegalArgumentException() {
        assertAll(
            "Verify negative price, quantity < 1 throws IAE",
            () -> assertThrows(IllegalArgumentException.class, () -> cart.addItem(nameLower, -1.0, quant1)),
            () -> assertThrows(IllegalArgumentException.class, () -> cart.addItem(nameLower, price1, 0)),
            () -> assertThrows(IllegalArgumentException.class, () -> cart.addItem(nameLower, price1, -1))
        );
    }

    @Test
    void removeItem_existingItem_removesEntirely_returnsTrue() {
        cart.addItem(nameLower,price1, quant1);

        assertAll("Verify item is completely removed regardless of quantity",
            () -> assertTrue(cart.removeItem(nameLower)),
            () -> assertTrue(cart.isEmpty()),
            () -> assertEquals(0.0, cart.getSubtotal())
        );
    }

    @Test
    void removeItem_nonExistentItemOrEmptyCart_returnsFalse() {
        cart.addItem(nameLower,price1, quant1);

        assertFalse(cart.removeItem(wrongName));
    }

    @Test
    void removeItem_differentCasingOrNull_returnsFalse() {
        cart.addItem(nameLower,price1, quant1);

        assertAll("Verify casing mismatch or null does not remove item and returns false",
            () -> assertFalse(cart.removeItem(nameLower.toUpperCase())),
            () -> assertFalse(cart.removeItem(null)),
            () -> assertEquals(1, cart.getItemCount())
        );
    }

    @Test
    void getItemCount_emptyCart_returnsZero() {
        int count = cart.getItemCount();

        assertEquals(0, count);
    }

    @Test
    void getItemCount_singleItemMultipleQuantity_returnsTotalQuantity() {
        cart.addItem(nameLower,price1, quant1);

        int count = cart.getItemCount();

        assertEquals(quant1, count);
    }

    @Test
    void getItemCount_multipleItemsMultipleQuantities_returnsSumOfQuantities() {
        cart.addItem(nameLower,price1, quant1);
        cart.addItem(wrongName,price1, quant1 + 1);

        int count = cart.getItemCount();
        int expCount = quant1 * 2 + 1;

        assertEquals(expCount, count);
    }

    @Test
    void getSubtotal_emptyCart_returnsZero() {
        double subtotal = cart.getSubtotal();

        assertEquals(0.0, subtotal);
    }

    @Test
    void getSubtotal_multipleItemsWithQuantities_returnsSumOfPriceTimesQuantity() {
        cart.addItem(nameLower, price1, quant1);
        cart.addItem(wrongName,price1, quant1 + 1);

        double subtotal = cart.getSubtotal();
        double expSubtotal = price1 * quant1 + price1 * (quant1 + 1);

        assertEquals(expSubtotal, subtotal);
    }

    @Test
    void getSubtotal_withDiscountApplied_ignoresDiscountAndReturnsRawSubtotal() {
        cart.addItem(nameLower, price1, quant1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        double subtotal = cart.getSubtotal();

        assertEquals(price1 ,subtotal);
    }

    @Test
    void applyDiscountCode_validCode_appliesCorrectPercentageDiscount() {
        cart.addItem(nameLower, price1, quant1);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        assertEquals(price1 * .8, cart.getTotal());
    }

    @Test
    void applyDiscountCode_subsequentValidCode_replacesPreviousDiscount() {
        cart.addItem(nameLower, price1, quant1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        assertEquals(price1 * .5, cart.getTotal());
    }

    @Test
    void applyDiscountCode_nullOrInvalidOrWrongCaseCode_throwsIllegalArgumentException() {
        assertAll("Verify null, unrecognized, or wrong-case codes throw IllegalArgumentException",
            () -> assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(null)),
            () -> assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10")),
            () -> assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE30")),
            () -> assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(""))
        );
    }

    @Test
    void getTotal_noDiscountApplied_returnsSubtotal() {
        cart.addItem(nameLower, price1, quant1);

        double total = cart.getTotal();

        assertEquals(price1, total);
    }

    @Test
    void getTotal_withDiscountAndFractionalCents_returnsUnroundedTotal() {
        cart.addItem(nameLower, price1, quant1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        double total = cart.getTotal();
        double expTotal = price1 * .9;

        assertEquals(expTotal, total);
    }

    @Test
    void getTotal_emptyCartWithDiscountApplied_returnsZero() {
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        double total = cart.getTotal();

        assertEquals(0.0, total);
    }

    @ParameterizedTest
    @CsvSource({
        "'', 10.0, 1",
        "'   ', 10.0, 1",
        "a, -0.01, 1",
        "a, -100.0, 1",
        "a, 10.0, 0",
        "a, 10.0, -3"
    })
    void addItem_invalidInputs_throwsIllegalArgumentException(String name, double price, int quantity) {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(name, price, quantity));
    }
}