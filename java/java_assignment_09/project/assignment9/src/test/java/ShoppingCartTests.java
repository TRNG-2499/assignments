import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTests {

    private ShoppingCart testCart;

    @BeforeEach
    public void initialize(){
        testCart = new ShoppingCart();
    }

    @Test
    public void addItemTest1(){
        testCart.addItem("Orange", 0.5, 1);
        testCart.addItem("Orange", 0.5, 1);
        int newQuantity = testCart.getItemCount();

        assertEquals(2, newQuantity);
    }

    @Test
    public void addItemTest2(){
        testCart.addItem("Orange", 0.5, 2);
        testCart.addItem("Apple", 0.2, 1);

        double actualSubtotal = testCart.getSubtotal();

        assertEquals(1.2, actualSubtotal, 0.005);
    }

    @Test
    public void addItemTest3(){
        assertThrows(IllegalArgumentException.class, () -> testCart.addItem(null, 0.6, 1));
    }
}