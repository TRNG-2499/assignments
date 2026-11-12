
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Incorrect method: getItemCount().
 * The tests getItemCount_singleItem_returnsItsQuantity,
 * getItemCount_multipleItems_returnsSumOfQuantities, and
 * getItemCount_repeatedName_returnsCombinedQuantity fail because the method
 * returns the number of different items, not the amount of items.
 */
public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void addItem_validItem_updatesSubtotal() {
        cart.addItem("Item", 5.00, 2);

        assertEquals(10.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItem_existingExactName_increasesQuantity() {
        cart.addItem("Item", 5.00, 2);
        cart.addItem("Item", 5.00, 3);

        assertEquals(25.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItem_nameDifferentByCase_createsSeparateItems() {
        cart.addItem("Item", 10.00, 1);
        cart.addItem("item", 4.00, 1);

        assertEquals(2, cart.getItemCount());
    }

    @Test
    void addItem_BlankName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("   ", 1.00, 1));
    }

    @Test
    void addItem_negativePrice_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Item", -0.01, 1));
    }

    @Test
    void addItem_zeroQuantity_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Item", 1.00, 0));
    }

    @Test
    void removeItem_existingName_removesItem() {
        cart.addItem("Item", 10.00, 2);

        assertAll(
                () -> assertTrue(cart.removeItem("Item")),
                () -> assertEquals(0.00, cart.getSubtotal(), 0.001)
            );
    }

    @Test
    void removeItem_missingName_returnsFalse() {
        cart.addItem("Item", 10.00, 1);

        assertFalse(cart.removeItem("Thing"));
        assertEquals(10.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void removeItem_nameMatchingIsCaseSensitive() {
        cart.addItem("item", 4.00, 1);

        assertFalse(cart.removeItem("Item"));
        assertEquals(4.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void getItemCount_singleItem_returnsItsQuantity() {
        cart.addItem("Item", 5.00, 4);

        assertEquals(4, cart.getItemCount());
    }

    @Test
    void getItemCount_multipleItems_returnsSumOfQuantities() {
        cart.addItem("Item1", 5.00, 2);
        cart.addItem("Item2", 1.00, 3);

        assertEquals(5, cart.getItemCount());
    }

    @Test
    void getItemCount_repeatedName_returnsCombinedQuantity() {
        cart.addItem("Item", 5.00, 2);
        cart.addItem("Item", 5.00, 3);

        assertEquals(5, cart.getItemCount());
    }

    @Test
    void getSubtotal_singleItem_returnsPriceTimesQuantity() {
        cart.addItem("Item", 3.25, 4);

        assertEquals(13.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void getSubtotal_sameNameDifferentPrice_returnsCorrectTotal() {
        cart.addItem("Item", 2.00, 3);
        cart.addItem("Item", 3.00, 3);

        assertEquals(12.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void getSubtotal_multipleItems_returnsSumOfTotals() {
        cart.addItem("Item1", 2.00, 3);
        cart.addItem("Item2", 3.00, 2);

        assertEquals(12.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void applyDiscountCode_save10_appliesTenPercentDiscount() {
        cart.addItem("Item", 100.00, 1);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(90.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCode_save20_appliesTwentyPercentDiscount() {
        cart.addItem("Item", 100.00, 1);

        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        assertEquals(80.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCode_halfOff_appliesFiftyPercentDiscount() {
        cart.addItem("Item", 100.00, 1);

        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        assertEquals(50.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCode_invalidCode_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("INVALID"));
    }

    @Test
    void applyDiscountCode_wrongCase_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
    }

    @Test
    void getTotal_withoutDiscount_returnsSubtotal() {
        cart.addItem("Item", 20.00, 2);

        assertEquals(40.00, cart.getTotal(), 0.001);
    }

    @Test
    void getTotal_withDiscount_returnsDiscountedSubtotal() {
        cart.addItem("Item", 25.00, 2);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(45.00, cart.getTotal(), 0.001);
    }

    @Test
    void getTotal_emptyCartWithDiscount_returnsZero() {
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);

        assertEquals(0.00, cart.getTotal(), 0.001);
    }
}
