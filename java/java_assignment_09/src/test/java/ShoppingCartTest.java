/* getItemCount() incorrectly returns items.size(),
*   which just returns the quantity of keys (unique items)
*   in the items map. getItemCount_twoSame_diffCase() fails
*  because of this.
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setup(){
        shoppingCart = new ShoppingCart();
    }

    /*addItem*/
    // Typ
    @Test 
    void addItem_to_newCart_returnsTrue(){
        
        int preQty = shoppingCart.getItemCount();
        shoppingCart.addItem("item", 10.00, 1);
        int postQty = shoppingCart.getItemCount();
        boolean result = (postQty == preQty + 1);

        assertTrue(result);
    }
    // Edge
    @Test 
    void addItem_caseSensitivity(){
        shoppingCart.addItem("pizza", 1000.00, 1);
        assertFalse(shoppingCart.removeItem("Pizza"));
    }
    // Invalid
    @Test 
    void addItem_zeroQty_throwsIAE(){
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.addItem("item", 10.00, 0));
    }

    /*removeItem*/
    // Typ
    @Test 
    void removeItem_returnsTrue(){
        shoppingCart.addItem("pizza", 1000.00, 1);
        assertTrue(shoppingCart.removeItem("pizza"));
    }
    // Edge
    @Test 
    void removeItem_twice_returnsTF(){
        shoppingCart.addItem("pizza", 1000.00, 1);
        assertTrue(shoppingCart.removeItem("pizza"));
        assertFalse(shoppingCart.removeItem("pizza"));
    }

    // Invalid
    @Test
    void removeItem_nonexistant_returnsTrue(){
        assertFalse(shoppingCart.removeItem("orca"));
    }
    /*getItemCount*/
    // Typ
    @Test 
    void getItemCount_twoSame_diffCase(){
        shoppingCart.addItem("pizza", 1000.00, 1);
        shoppingCart.addItem("Pizza", 50000.00, 3);
        assertEquals(4, shoppingCart.getItemCount());
    }
    // Edge
    @Test 
    void getItemcount_max(){
        shoppingCart.addItem("pizza", 1000.00, Integer.MAX_VALUE);
        
        assertNotEquals(Integer.MAX_VALUE, shoppingCart.getItemCount());
    }
    // Invalid (basically another edge case)
    @Test 
    void getItemCount_emptyCart(){
        assertEquals(0, shoppingCart.getItemCount());
    }

    /*getSubtotal*/
    // Typ
    @Test 
    void getSubtotal_oneItem(){
        shoppingCart.addItem("pizza", 1000.00, 1);
        assertEquals(1000.00, shoppingCart.getSubtotal());
    }
    // Edge
    @Test 
    void getSubtotal_afterDuplicateRemoval(){
        shoppingCart.addItem("pizza", 1000.00, 1);
        shoppingCart.removeItem("pizza");
        shoppingCart.removeItem("pizza");
        assertEquals(0.00, shoppingCart.getSubtotal());
    }
    // Invalid (not possible; another edge)
    @Test
    void getSubtotal_freeItem(){
        shoppingCart.addItem("breadsticks", 0.00, 10000);
        assertEquals(0.00, shoppingCart.getSubtotal());
    }
    /*applyDiscountCode*/
    // Typ
    @Test
    void applyDiscountCode_SAVE10(){
        shoppingCart.addItem("pizza", 1000.00, 1);
        shoppingCart.applyDiscountCode("SAVE10");
        assertEquals(900.00, shoppingCart.getTotal());
    }
    // Edge
    @Test 
    void applyDiscountCode_stacking(){
        shoppingCart.addItem("pizza", 100.00, 1);
        shoppingCart.applyDiscountCode("HALFOFF");
        shoppingCart.applyDiscountCode("HALFOFF");

        assertEquals(50.00, shoppingCart.getTotal());
    }
    // Invalid
    @Test 
    void applyDiscountCode_wrongCode(){
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.applyDiscountCode("SAVE100"));
    }
    /*getTotal*/
    // Typ
    @Test 
    void getTotal_oneItem(){
        shoppingCart.addItem("pizza", 100.00, 1);
        assertEquals(100.00, shoppingCart.getTotal());
    }
    // Edge
    @Test 
    void getTotal_fractionalCents(){
        shoppingCart.addItem("gasoline", 6.495, 1);
        assertEquals(6.495, shoppingCart.getTotal());
    }
    // Invalid (not possible; another edge case)
    @Test 
    void getTotal_removal_after_discount(){
        shoppingCart.addItem("pizza", 100.00, 1);
        shoppingCart.applyDiscountCode("HALFOFF");
        shoppingCart.removeItem("pizza");
        assertEquals(0.00, shoppingCart.getTotal());
    }
}
