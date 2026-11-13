import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void freshShoppingCart() {
        cart = new ShoppingCart();
    }

    @Test
    void addToEmptyCart_doesNotThrow() {
        assertDoesNotThrow(() -> cart.addItem("Eggs", 6.99, 1));
    }
}
