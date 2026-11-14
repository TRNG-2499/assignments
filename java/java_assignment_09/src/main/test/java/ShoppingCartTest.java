import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ShoppingCartTest {
    private ShoppingCart cart;

    /// Tests for
    /// void addItem(String name,
    ///              double price,
    ///              int quantity)
    @Test
    void test_AddItem() {
        cart = new ShoppingCart();
        int currCount = cart.getItemCount();
        cart.addItem("someItem", 17.29, 89);
        assertEquals(currCount+1, cart.getItemCount());
    }

    @Test
    void test_IllegalArgumentException() {
        cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("", 17.7, 29);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("something", -0.01, 29);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("null", 17.7, 0);
        });
    }

    @Test
    void test_AddItemWithEdgeCase() {
        cart = new ShoppingCart();
        String name = "null'null''return'whatdoiputhere?'qwertyuiop[]asdfghjkl;'zxcvbnm,./1234567890-=`~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:ZXCVBNM<>?///////";
        cart.addItem(name, Integer.MAX_VALUE, Integer.MAX_VALUE);

        assertEquals(cart.getItemCount(), 1);
    }

    /// tests for
    /// boolean removeItem(String name)

    @Test
    void test_RemoveItemFromCart() {
        cart = new ShoppingCart();
        String name = "name";

        cart.addItem(name, Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(cart.getItemCount(), 1);

        cart.removeItem(name);
        assertEquals(cart.getItemCount(), 0);
    }

    @Test
    void test_RemoveItemWithInvalidItem() {
        cart = new ShoppingCart();
        String name = "name";

        cart.addItem(name, Integer.MAX_VALUE, Integer.MAX_VALUE);
        boolean isNull = cart.removeItem("otherName");
        assertEquals(isNull, false);
    }

    @Test
    void test_RemoveItemWithMultipleItems() {
        cart = new ShoppingCart();
        String[] arr = {"item_1", "item_2", "item_3", "item_4", "item_5", "lAst-IteM"};
        int i = 0;

        for(String curr : arr) {
            cart.addItem(curr, Integer.MAX_VALUE, Integer.MAX_VALUE);
            i++;
        }
        for(String curr : arr) {
            boolean isRemoved = cart.removeItem(curr);
            assertEquals(isRemoved, true);
            assertEquals(cart.getItemCount(), --i);
        }
        assertEquals(0, i);
    }

    /// tests for
    /// int getItemCount()
    @Test
    void test_getItemCountWithCountIncrease() {
        cart = new ShoppingCart();
        String name = "thisIsAnItemName";
        cart.addItem(name, Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(cart.isEmpty(), false);
        assertEquals(cart.getItemCount(), 1);
    }
    @Test
    void test_getItemCountWithCountDecrease() {
        cart = new ShoppingCart();
        String name = "thisIsAnItemName";
        cart.addItem(name, Integer.MAX_VALUE, Integer.MAX_VALUE);

        int size = cart.getItemCount();
        assertEquals(size, 1);

        cart.removeItem(name);
        size = cart.getItemCount();
        assertEquals(size, 0);
    }

    @Test
    void test_getItemCountWithLoop() {
        cart = new ShoppingCart();
        String[] arr = {"item_1", "item_2", "item_3", "item_4", "item_5", "lAst-IteM"};
        int i = 0;

        for(String curr : arr) {
            cart.addItem(curr, Integer.MAX_VALUE, Integer.MAX_VALUE);
            assertEquals(cart.getItemCount(), ++i);
        } // test for increases in loop

        for(String curr : arr) {
            cart.removeItem(curr);
            assertEquals(cart.getItemCount(), --i);
        } // test for increases in loop
       // assertEquals(cart.getItemCount(), 0);
    }

    /// tests for
    /// double getSubtotal()
    @Test
    void test_getSubtotalWithMultipleItems() {
        cart = new ShoppingCart();
        String[] arr = {"item_1", "item_2", "item_3", "item_4", "item_5", "lAst-IteM"};
        double i = 0.0;
        int qty = 1;
        for(String curr : arr) {
            cart.addItem(curr, arr.length, qty);
            i += arr.length * qty;
        }

        assertEquals(cart.getSubtotal(), i);
    }

    @Test
    void test_getSubtotalWithEdgeCase() {
        cart = new ShoppingCart();
        String[] arr = {"item_1", "item_2", "item_3", "item_4", "item_5", "lAst-IteM"};
        double price = 1.000001;
        int qty = Integer.MAX_VALUE;

        for(String curr : arr) {
            cart.addItem(curr, price, qty);
        }

        assertEquals(cart.getSubtotal(), arr.length*price*qty);
    }

    @Test
    void test_getSubtotalWithRepeatedCalls() {
        cart = new ShoppingCart();

    }
}