import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.concurrent.ThreadLocalRandom;

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

        for (String curr : arr) {
            cart.addItem(curr, price, qty);
        }

        assertEquals(cart.getSubtotal(), arr.length * price * qty);
    }
        @Test
        void test_getSubtotalWithRepeatedCalls() {
            cart = new ShoppingCart();
            String[] arr = {"item_1", "item_2", "item_3", "item_4", "item_5", "lAst-IteM"};
            double price = 1.000001;
            int qty = Integer.MAX_VALUE;
            double subttl = 0.0;

            for(String curr : arr) {
                cart.addItem(curr, price, qty);
                subttl += price * qty;
                assertEquals(cart.getSubtotal(), subttl);
            }
        }


        /// Tests for
        /// void applyDiscountCode()
        double DELTA = 0.0001;

        @Test
        void testApplyDiscountCode() {
            cart = new ShoppingCart();
            cart.addItem("Item", 25.55, 10);
            cart.addItem("item232", 30.67, 10);
            double subtotal = cart.getSubtotal();   // 562.20

            assertEquals(subtotal, cart.getTotal(), DELTA);

            cart.applyDiscountCode("SAVE10");
            assertEquals(subtotal * 0.90, cart.getTotal(), DELTA);

            cart.applyDiscountCode("SAVE20");
            assertEquals(subtotal * 0.80, cart.getTotal(), DELTA);   // 449.76

            cart.applyDiscountCode("HALFOFF");
            assertEquals(subtotal * 0.50, cart.getTotal(), DELTA);

            assertEquals(subtotal, cart.getSubtotal(), DELTA);
        }

        @Test
        void testApplyDiscountWithBadArgs() {
            cart = new ShoppingCart();
            cart.addItem("Item", 25.55, 10);
            cart.addItem("item232", 30.67, 10);
            assertThrows(IllegalArgumentException.class, () -> {
                        cart.applyDiscountCode("SAVE_20");
            });
            assertThrows(IllegalArgumentException.class, () -> {
                cart.applyDiscountCode("SAVE100");
            });
            assertThrows(IllegalArgumentException.class, () -> {
                cart.applyDiscountCode("HIMOM");
            });
        }

        @Test
        void test_applyDiscountCodeWithRepeatedCalls() {
            cart = new ShoppingCart();
            String[] names = {
                    "exampleName",
                    "deskLamp", "waterBottle", "notebook", "phoneStand", "mousePad",
                    "chargingCable", "coffeeMug", "penSet", "deskOrganizer", "laptopSleeve",
                    "usbHub", "wirelessMouse", "keyboardCover", "bookLight", "travelPouch",
                    "stickyNotes", "screenCloth", "cableClips", "headphoneStand", "monitorRiser"
            },
                     discountCodes = {
                    "SAVE10", "SAVE20", "HALFOFF"
                     };

            double[] prices = {
                    29.22,
                    24.99, 18.50, 6.75, 12.49, 9.99,
                    14.25, 11.50, 8.95, 19.99, 27.50,
                    22.95, 34.99, 13.75, 16.49, 10.25,
                    4.99, 5.50, 7.49, 21.75, 45.99
            };
            int[] discounts = {10, 20, 50};
            String code;
            for(int i = 0; i < prices.length; i++) {
                double price = prices[ThreadLocalRandom.current().nextInt(0, 20 + 1)];
                int discount = discounts[ThreadLocalRandom.current().nextInt(0, 2 + 1)];
                String name = names[ThreadLocalRandom.current().nextInt(0, 20 + 1)];

                cart.addItem(name, price, discount);
                code = switch(discount) {
                    case 10 -> discountCodes[0];
                    case 20 -> discountCodes[1];
                    case 50 -> discountCodes[2];
                    default -> null;
                };

                cart.applyDiscountCode(code);
                switch(code) {
                    case "SAVE10" -> assertEquals(cart.getSubtotal() * 0.90, cart.getTotal(), DELTA);
                    case "SAVE20" -> assertEquals(cart.getSubtotal() * 0.80, cart.getTotal(), DELTA);
                    case "HALFOFF" -> assertEquals(cart.getSubtotal() * 0.50, cart.getTotal(), DELTA);
                }
            }
        }

    /// Tests for
    /// double getTotal()
    @Test
    void test_getTotalWithOneItem() {
        cart = new ShoppingCart();
        cart.addItem("name", 25.33, 10);
        System.out.println(cart.getTotal());
        assertEquals(25.33 * 10, cart.getTotal());
    }

    @Test
    void test_getTotalWithRepeatedCalls() {
        cart = new ShoppingCart();
        String[] names  = {"deskLamp", "waterBottle", "notebook", "phoneStand", "mousePad"};
        double[] prices = {24.99, 18.50, 6.75, 12.49, 9.99};
        int[]    qtys   = {2, 1, 4, 3, 5};
        double expected = 0.0;

        for (int i = 0; i < names.length; i++) {
            cart.addItem(names[i], prices[i], qtys[i]);
            expected += prices[i] * qtys[i];          // add only the new item
            assertEquals(expected, cart.getTotal(), DELTA);   // no discount yet
        }

        cart.applyDiscountCode("SAVE20");
        assertEquals(expected * 0.80, cart.getTotal(), DELTA);
    }

    @Test
    void test_getTotalWithDiscountAppliedBeforeItems() {
        cart = new ShoppingCart();

        cart.applyDiscountCode("HALFOFF");
        assertEquals(0.0, cart.getTotal(), DELTA);      // empty cart, discount active

        cart.addItem("coffeeMug", 11.50, 2);            // subtotal 23.00
        assertEquals(11.50, cart.getTotal(), DELTA);    // 50% off still applies
    }



}