import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//The incorrect method is getItemCount()
//Currently, it only counts unique items, not total amount of items.
//This means that having 2 of one named item only counts as 1 total item
//Failing Test: one_item_in_cart_with_quantity_2_returns_2_items()
public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp(){
        cart = new ShoppingCart();
    }

    //Example Test Case
    @Test
    void isEmpty_new_Cart_returnTrue(){
        boolean result = cart.isEmpty();
    }

    //Add Item Testing
    @Test
    void one_item_in_cart_with_quantity_1_returns_1_item(){
        cart.addItem("Bacon", 10.00, 1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void one_item_in_cart_with_quantity_2_returns_2_items(){
        cart.addItem("Bacon", 10.00, 2);
        assertEquals(2, cart.getItemCount());
    }

    @Test
    void adding_two_items_with_quantity_1_returns_two_items(){
        cart.addItem("Bacon", 10, 1);
        cart.addItem("Sausage", 5, 1);
        assertEquals(2, cart.getItemCount());
    }

    @Test
    void adding_an_item_without_a_name_throws_an_exception(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.addItem("", 10, 1));
        assertEquals("Item name must not be null or blank.", exception.getMessage());
    }

    @Test
    void adding_an_item_with_a_null_name_throws_an_exception(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 10, 1));
        assertEquals("Item name must not be null or blank.", exception.getMessage());
    }

    @Test
    void adding_an_item_with_a_negative_price_throws_an_exception(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.addItem("Dog Food", -10, 1));
        assertEquals("Price must not be negative.", exception.getMessage());
    }

    @Test
    void adding_an_item_with_a_negative_quantity_throws_an_exception(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.addItem("Dog Food", 10, -1));
        assertEquals("Quantity must be at least 1.", exception.getMessage());
    }

    //Remove Item Testing
    @Test
    void removing_item_from_empty_cart_returns_false(){
        boolean removed = cart.removeItem("Turkey");
        assertFalse(removed);
    }

    @Test
    void removing_item_that_is_in_cart_returns_true(){
        cart.addItem("Turkey", 10, 2);
        boolean removed = cart.removeItem("Turkey");
        assertTrue(removed);
    }

    @Test
    void removing_item_that_isnt_in_cart_returns_false(){
        cart.addItem("Turkey", 10, 2);
        boolean removed = cart.removeItem("Chicken");
        assertFalse(removed);
    }

    //Get Item Count Testing
    @Test
    void empty_cart_has_an_item_count_of_0(){
        int count = cart.getItemCount();
        assertEquals(count, 0);
    }

    @Test
    void cart_with_1_item_has_a_count_of_1(){
        cart.addItem("Turkey", 10, 2);
        int count = cart.getItemCount();
        assertEquals(count, 1);
    }

    @Test
    void cart_with_2_item_has_a_count_of_2(){
        cart.addItem("Turkey", 10, 2);
        cart.addItem("Chicken", 10, 2);
        int count = cart.getItemCount();
        assertEquals(count, 2);
    }

    //Get Subtotal Testing
    @Test
    void empty_cart_has_subtotal_of_0(){
        double subtotal = cart.getSubtotal();
        assertEquals(subtotal, 0, 0.1);
    }

    @Test
    void adding_one_item_yields_correct_subtotal(){
        cart.addItem("Cranberry Sauce", 10, 1);
        double subtotal = cart.getSubtotal();
        assertEquals(subtotal, 10, 0.1);
    }

    @Test
    void adding_one_item_with_quantity_2_yields_correct_subtotal(){
        cart.addItem("Cranberry Sauce", 10, 2);
        double subtotal = cart.getSubtotal();
        assertEquals(subtotal, 20, 0.1);
    }

    //Apply Discount Code Testing
    @Test
    void applying_null_discount_code_throws_exception(){
        String code = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(code));
        assertEquals("Discount code must not be null.", exception.getMessage());
    }

    @Test
    void applying_invalid_discount_code_throws_exception(){
        String code = "test123";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(code));
        assertEquals("Invalid discount code: " + code, exception.getMessage());
    }

    @Test
    void applying_valid_discount_code_yields_correct_total(){
        String code = "HALFOFF";
        cart.addItem("Apple Pie", 10, 1);
        cart.applyDiscountCode(code);
        double total = cart.getTotal();
        assertEquals(5, total, 0.1);
    }

    //Get Total Testing
    @Test
    void total_of_empty_cart_is_0(){
        double total = cart.getTotal();
        assertEquals(0, total, 0.1);
    }

    @Test
    void total_of_cart_with_1_item(){
        cart.addItem("Apple Pie", 10, 3);
        double total = cart.getTotal();
        assertEquals(30, total, 0.1);
    }

    @Test
    void total_of_cart_with_2_items(){
        cart.addItem("Apple Pie", 10, 3);
        cart.addItem("Cheese", 3, 2);
        double total = cart.getTotal();
        assertEquals(36, total, 0.1);
    }
}
