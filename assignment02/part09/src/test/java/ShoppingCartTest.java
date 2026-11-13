import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


/*
    The getItemCount is the method that is incorrect.
    It returns items.size(), which is how many different names are in the cart.
    It should add up each item's quantity. One "Paint" with quantity 3 comes
    back as 1. A quantity of 1 still passes, because the name count and the
    quantity are both 1.
    Failing tests:
    test_item_count_for_quantity_three_is_three,
    test_item_count_after_adding_same_item_twice_is_sum, 
    test_item_count_for_two_items_is_sum_of_quantities
 */

class ShoppingCartTest {

    private static final double DELTA = 0.001;
    
    private ShoppingCart cart;

    // Runs before each test, so every test starts with its own empty cart.
    @BeforeEach
    void setUp(){
        cart = new ShoppingCart();
    }

    @Test
    void test_new_cart_is_empty() {
        assertTrue(cart.isEmpty());
    }

    // addItem
    @Test
    void test_add_item_subtotal_is_price_times_quantity() {
        cart.addItem("Paint", 20.00, 2);
        assertEquals(40.00, cart.getSubtotal(), DELTA);
    }
    @Test
    void test_add_same_name_twice_quantity_is_combined() {
        cart.addItem("Paint", 20.00, 2);
        cart.addItem("Paint", 20.00, 3);
        assertEquals(100.0, cart.getSubtotal(), DELTA);
    }
    @Test
    void test_add_different_casing_counts_as_two_items() {
        cart.addItem("Paint", 10.0, 1);
        cart.addItem("paint", 5.0, 1);
        assertEquals(15.0, cart.getSubtotal(), DELTA);
    }
    @Test
    void test_add_null_name_throws() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 10.0, 1));
    }
    @Test
    void test_add_blank_name_throws() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("   ", 10.0, 1));
    }
    @Test
    void test_add_negative_price_throws() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Paint", -5.0, 1));
    }
    @Test
    void test_add_quantity_below_one_throws() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Paint", 10.0, 0));
    }

    // removeItem
    @Test
    void test_remove_existing_item_returns_true_and_clears_it() {
        cart.addItem("Paint", 20.00, 1);
        boolean removed = cart.removeItem("Paint");
        assertTrue(removed);
        assertEquals(0.0, cart.getSubtotal(), DELTA);
        assertTrue(cart.isEmpty());
    }
    @Test
    void test_remove_missing_item_returns_false() {
        boolean removed = cart.removeItem("Paint");
        assertFalse(removed);
    }
    @Test
    void test_remove_wrong_casing_returns_false_and_keeps_item() {
        cart.addItem("Paint", 10.0, 1);
        boolean removed = cart.removeItem("paint");
        assertFalse(removed);
        assertEquals(10.0, cart.getSubtotal(), DELTA);
    }

    // getItemCount
    @Test
    void test_item_count_on_empty_cart_is_zero() {
        assertEquals(0, cart.getItemCount());
    }
    @Test
    void test_item_count_for_one_single_item_is_one() {
        cart.addItem("Paint", 10.0, 1);
        assertEquals(1, cart.getItemCount());
    }
    @Test
    void test_item_count_for_quantity_three_is_three() {
        cart.addItem("Paint", 10.0, 3);
        assertEquals(3, cart.getItemCount());
    }
    @Test
    void test_item_count_after_adding_same_item_twice_is_sum() {
        cart.addItem("Paint", 10.0, 2);
        cart.addItem("Paint", 10.0, 3);
        assertEquals(5, cart.getItemCount());
    }
    @Test
    void test_item_count_for_two_items_is_sum_of_quantities() {
        cart.addItem("Paint", 10.0, 2);
        cart.addItem("Tape", 4.0, 3);
        assertEquals(5, cart.getItemCount());
    }

    // getSubtotal
    @Test
    void test_subtotal_on_empty_cart_is_zero() {
        assertEquals(0.0, cart.getSubtotal(), DELTA);
    }
    @Test
    void test_subtotal_adds_up_each_price_times_quantity() {
        cart.addItem("Paint", 20.0, 2);
        cart.addItem("Tape", 4.0, 3);
        assertEquals(52.0, cart.getSubtotal(), DELTA);
    }
    @Test
    void test_subtotal_does_not_change_when_discount_is_applied() {
        cart.addItem("Paint", 50.0, 2);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        assertEquals(100.0, cart.getSubtotal(), DELTA);
    }

    // applyDiscountCode
    @Test
    void test_save10_takes_ten_percent_off_the_total() {
        cart.addItem("Paint", 100.0, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        assertEquals(90.0, cart.getTotal(), DELTA);
    }
    @Test
    void test_second_discount_code_replaces_the_first() {
        cart.addItem("Paint", 100.0, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        assertEquals(80.0, cart.getTotal(), DELTA);
    }
    @Test
    void test_halfoff_takes_fifty_percent_off_the_total() {
        cart.addItem("Paint", 80.0, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        assertEquals(40.0, cart.getTotal(), DELTA);
    }
    @Test
    void test_null_discount_code_throws() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(null));
    }
    @Test
    void test_unknown_discount_code_throws() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE15"));
    }
    @Test
    void test_lowercase_discount_code_throws() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("save10"));
    }

    // getTotal
    @Test
    void test_total_with_no_discount_equals_subtotal() {
        cart.addItem("Paint", 20.0, 2);
        assertEquals(40.0, cart.getTotal(), DELTA);
    }
    @Test
    void test_total_with_save20_is_eighty_percent() {
        cart.addItem("Paint", 50.0, 2);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        assertEquals(80.0, cart.getTotal(), DELTA);
    }
    @Test
    void test_total_on_empty_cart_with_discount_is_zero() {
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        assertEquals(0.0, cart.getTotal(), DELTA);
    }
}