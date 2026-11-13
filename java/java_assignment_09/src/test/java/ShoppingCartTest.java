import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ShoppingCartTest {
    private ShoppingCart cart = new ShoppingCart();

    @Test
    void testAddItem() {
        int currCount = cart.getItemCount();
        cart.addItem("someItem", 17.29, 89);git
        assertEquals(currCount+1, cart.getItemCount());
    }
}