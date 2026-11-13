import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class ShoppingCartTest {
    ShoppingCart shoppingCart;
    @BeforeEach
    void initObject() {
        shoppingCart = new ShoppingCart();
    }

    /*
    Testing addItem
     */
    @Test
    @DisplayName("addItem(): Negative price test")
    void testNegativePrice() {
        String name = "carrot";
        Double price = -10.0;
        int quantity = 1;

        assertThrows(
                IllegalArgumentException.class, () -> {
                shoppingCart.addItem(name, price, quantity);
                }
        );
    }

    @Test
    @DisplayName("addItem(): Invalid name test")
    public void testInvalidName() {
        String name = "";
        Double price = 10.0;
        int quantity = 1;

        assertThrows(
                IllegalArgumentException.class, () ->
                    shoppingCart.addItem(name, price, quantity)
        );
    }

    @Test
    @DisplayName("addItem(): Zero quantity test")
    void testZeroQuantityAdded() {
        String name = "carrot";
        Double price = 10.0;
        int quantity = 0;

        assertThrows(
                IllegalArgumentException.class, () -> {
                    shoppingCart.addItem(name, price, quantity);
                }
        );
    }

    @Test
    @DisplayName("addItem(): Test if item added gets properly added")
    void testItemAdded() {
        String name = "carrot";
        Double price = 10.0;
        int quantity = 10;

        shoppingCart.addItem(name, price, quantity);
        assertEquals(shoppingCart.getItemCount(), 1);
    }

    /*
    Testing removeItem
     */
    @Test
    @DisplayName("removeItem(): Test if item is removed")
    void testItemRemoved() {
        String name = "carrot";
        Double price = 10.0;
        int quantity = 10;

        shoppingCart.addItem(name, price, quantity);

        assertEquals(shoppingCart.removeItem(name), true);

        assertEquals(shoppingCart.getItemCount(), 0);

    }
    @Test
    @DisplayName("removeItem(): Test if invalid item is handled properly")
    void testInvalidItemRemoved() {
        String name = "carrot";
        Double price = 10.0;
        int quantity = 10;

        shoppingCart.addItem(name, price, quantity);

        assertEquals(shoppingCart.removeItem("blah"), false);

        assertEquals(shoppingCart.getItemCount(), 1);

    }
    @Test
    @DisplayName("removeItem(): Test if null item is handled properly")
    void testNullItemRemoved() {
        String name = "carrot";
        Double price = 10.0;
        int quantity = 10;

        shoppingCart.addItem(name, price, quantity);

        assertEquals(shoppingCart.removeItem(""), false);

        assertEquals(shoppingCart.getItemCount(), 1);
    }

    /*
    Testing getItemCount
     */
    @Test
    @DisplayName("getItemCount(): Test if no items returns 0")
    void testNoItems() {
        assertEquals(shoppingCart.getItemCount(), 0);
    }
    @Test
    @DisplayName("getItemCount(): Test if one item returns 1")
    void testOneItem() {
        shoppingCart.addItem("carrot", 10.0, 1);
        assertEquals(shoppingCart.getItemCount(), 1);
    }
    @Test
    @DisplayName("getItemCount(): Test if multiple items returns correct count")
    void testMultipleItems() {
        shoppingCart.addItem("carrot", 10.0, 1);
        shoppingCart.addItem("apple", 5.0, 2);
        assertEquals(shoppingCart.getItemCount(), 2);
    }

    /*
    Testing getSubtotal
     */
    @Test
    @DisplayName("getSubtotal(): Test if empty cart returns 0")
    void testEmptyCart() {
        assertEquals(shoppingCart.getSubtotal(), 0.0, 0.0001);
    }
    @Test
    @DisplayName("getSubtotal(): Test if single item in cart returns correct subtotal")
    void testSingleItemInCart() {
        shoppingCart.addItem("carrot", 10.0, 1);
        assertEquals(shoppingCart.getSubtotal(), 10.0, 0.0001);
    }
    @Test
    @DisplayName("getSubtotal(): Test if multiple items in cart returns correct subtotal")
    void testMultipleItemsInCart() {
        shoppingCart.addItem("carrot", 10.0, 1);
        shoppingCart.addItem("apple", 5.0, 2);
        assertEquals(shoppingCart.getSubtotal(), 20.0, 0.0001);
    }

    /*
    Testing applyDiscountCode
     */
    String[] validDiscountCodes = {"SAVE10", "SAVE20", "HALFOFF"};
    @Test
    @DisplayName("applyDiscountCode(): Test if valid discount code is applied correctly")
    void testValidDiscountCode() {
        shoppingCart.addItem("carrot", 10.0, 1);
        List<Double> discountPercents = Arrays.asList(10.0, 20.0, 50.0);
        for (String code : validDiscountCodes) {
            shoppingCart.applyDiscountCode(code);
            assertEquals(
                shoppingCart.getTotal(),
                shoppingCart.getSubtotal() * (1 - discountPercents.get(Arrays.asList(validDiscountCodes).indexOf(code)) / 100.0),
                0.0001
            );
        }
    }
    @Test
    @DisplayName("applyDiscountCode(): Test if invalid discount code is handled properly")
    void testInvalidDiscountCode() {
        shoppingCart.addItem("carrot", 10.0, 1);
        String invalidCode = "INVALIDCODE";
        assertThrows(
                IllegalArgumentException.class, () -> {
                    shoppingCart.applyDiscountCode(invalidCode);
                }
        );
        assertEquals(shoppingCart.getTotal(), shoppingCart.getSubtotal(), 0.0001);
    }
    @Test
    @DisplayName("applyDiscountCode(): Test if null discount code is handled properly")
    void testNullDiscountCode() {
        shoppingCart.addItem("carrot", 10.0, 1);
        assertThrows(
                IllegalArgumentException.class, () -> {
                    shoppingCart.applyDiscountCode(null);
                }
        );
        assertEquals(shoppingCart.getTotal(), shoppingCart.getSubtotal(), 0.0001);
    }

    /*
    Testing getTotal
     */
    @Test
    @DisplayName("getTotal(): Test if total is correct when no discount is applied")
    void testTotalNoDiscount() {
        shoppingCart.addItem("carrot", 10.0, 1);
        assertEquals(shoppingCart.getTotal(), 10.0, 0.0001);
    }
    @Test
    @DisplayName("getTotal(): Test if total is correct when discount is applied")
    void testTotalWithDiscount() {
        shoppingCart.addItem("carrot", 10.0, 1);
        shoppingCart.applyDiscountCode("SAVE10");
        assertEquals(shoppingCart.getTotal(), 10.0 * 0.9, 0.0001);
    }
    @Test
    @DisplayName("getTotal(): Test if total is correct when multiple items and discount is applied")
    void testTotalWithMultipleItemsAndDiscount() {
        shoppingCart.addItem("carrot", 10.0, 1);
        shoppingCart.addItem("apple", 5.0, 2);
        shoppingCart.applyDiscountCode("SAVE20");
        assertEquals(shoppingCart.getTotal(), 15.0 * 0.8, 0.0001);
    }

    @Test
    @DisplayName("getTotal(): Test if total is correct when no items and discount is applied")
    void testTotalWithNoItemsAndDiscount() {
        shoppingCart.applyDiscountCode("SAVE10");
        assertEquals(shoppingCart.getTotal(), 0);
    }
}
