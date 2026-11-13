import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    // the incorrect method appears to be getItemCount. does not count quantity, but the # of unique items instead.
    // addItem_valid_increaseCount is wrong, getItemCount_working is also wrong due to this.
    // getItemCount_afterRemove works through sheer coincidence, though if the values are altered it could also be wrong.
    
    @Test
    void addItem_valid_increaseCount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",5.99,2);
        cart.addItem("orange",5.99,3);
        cart.addItem("pear",5.99,4);
        cart.addItem("pear",5.99,5);
        assertEquals(14,cart.getItemCount());
    }

    @Test
    void addItem_negativePrice(){
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("apple",-4.00,2));
    }

    @Test
    void addItem_nullName(){
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null,5.99,5));
    }

    @Test
    void removeItem_working(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",5.99,2);
        assertTrue(cart.removeItem("apple"));
    }

    @Test
    void removeItem_withoutItem(){
        ShoppingCart cart = new ShoppingCart();
        assertFalse(cart.removeItem("apple"));
    }

    @Test
    void removeItem_multi(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",5.99,2);
        cart.addItem("orange",2.99,1);
        cart.addItem("banana",1.99,5);
        assertTrue(cart.removeItem("orange"));
    }

    @Test
    void getItemCount_working(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",5.99,2);
        cart.addItem("orange",2.99,1);
        cart.addItem("banana",1.99,5);
        assertEquals(8, cart.getItemCount());
    }

    @Test
    void getItemCount_afterRemove(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",5.99,2);
        cart.addItem("orange",2.99,1);
        cart.removeItem("apple");
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void getItemCount_empty(){
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void getSubtotal_working(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",5.00,2);
        cart.addItem("orange",2.00,1);
        assertEquals(12.00, cart.getSubtotal());
    }

    @Test
    void getSubtotal_afterRemove(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",5.00,2);
        cart.addItem("orange",2.00,1);
        cart.removeItem("apple");
        assertEquals(2.00, cart.getSubtotal());
    }

    @Test
    void getSubtotal_empty(){
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.00, cart.getSubtotal());
    }

    @Test
    void applyDiscount_working(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",10.00,1);
        cart.applyDiscountCode("HALFOFF");
        assertEquals(5.00, cart.getTotal());
    }

    @Test
    void applyDiscount_empty(){
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(""));
    }

    @Test
    void applyDiscount_invalid(){
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("100OFFRealDiscount"));
    }

    @Test
    void getTotal_working_noDiscount(){
        ShoppingCart cart =  new ShoppingCart();
        cart.addItem("apple",10.00,1);
        cart.addItem("orange",2.00,1);
        cart.addItem("banana",3.00,5);
        assertEquals(27.00, cart.getTotal());
    }

    @Test
    void getTotal_working_afterDiscount_Remove(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",10.00,1);
        cart.addItem("orange",2.00,1);
        cart.addItem("banana",3.00,5);
        cart.removeItem("apple");
        cart.applyDiscountCode("HALFOFF");
        assertEquals(8.50, cart.getTotal());
    }

    @Test
    void getTotal_multipleDiscounts(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("apple",10.00,1);
        cart.applyDiscountCode("HALFOFF");
        cart.applyDiscountCode("SAVE10");
        cart.applyDiscountCode("SAVE20");
        assertEquals(8.00, cart.getTotal());
    }

}
