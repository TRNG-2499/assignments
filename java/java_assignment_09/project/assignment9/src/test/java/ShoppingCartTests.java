import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTests {

    private ShoppingCart testCart = new ShoppingCart();

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

    @Test 
    public void addItemTest4(){
        assertThrows(IllegalArgumentException.class, () -> testCart.addItem("Orange", -1.0, 90));
    }

    @Test
    public void addItemTest5(){
        assertThrows(IllegalArgumentException.class, () -> testCart.addItem("Orange", 9.0, 0));
    }

    @Test 
    public void addItemTest6(){
        assertThrows(IllegalArgumentException.class, () -> testCart.addItem("Orange", 1.0, -1));
    }

    @Test 
    public void removeItemTest1(){
        assertFalse(testCart.removeItem("Apple"));
    }

    @Test
    public void removeItemTest2(){
        testCart.addItem("Apple", 2.0, 1);
        assertTrue(testCart.removeItem("Apple"));
    }

    @Test
    public void removeItemTest3(){
        testCart.addItem("Kiwi", 0.75, 1);
        assertFalse(testCart.removeItem("Banana"));
    }

    @Test
    public void testGetItemCount1(){
        assertEquals(0, testCart.getItemCount());
    }

    @Test
    public void testGetItemCount2(){
        testCart.addItem("Apple", 0.5, 5);
        assertEquals(5, testCart.getItemCount());
    }

    @Test
    public void testGetItemCount3(){
        testCart.addItem("Grapes", 0.25, 10);
        testCart.removeItem("Grapes");
        testCart.removeItem("Grapes");
        assertEquals(8, testCart.getItemCount());
    }

    @Test
    public void testGetSubtotal1(){
        assertEquals(0, testCart.getSubtotal(), 0.005);
    }

    @Test
    public void testGetSubtotal2(){
        testCart.addItem("Apple", 1.0, 12);
        assertEquals(12, testCart.getSubtotal(), 0.005);
    }

    @Test
    public void testGetSubtotal3(){
        testCart.addItem("Apple", 1.0, 15);
        testCart.addItem("Orange", 0.5, 4);

        assertEquals(17, testCart.getSubtotal(), 0.005);
    }

    @Test
    public void testApplyDiscountCode1(){
        testCart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        testCart.addItem("Apple", 1.0, 10);

        assertEquals(9, testCart.getTotal(), 0.005);
    }

    @Test
    public void testApplyDiscountCode2(){
        testCart.applyDiscountCode(ShoppingCart.CODE_SAVE20);
        testCart.addItem("Apple", 1.0, 10);

        assertEquals(8, testCart.getTotal(), 0.005);
    }

    @Test 
    public void testApplyDiscountCode3(){
        testCart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);
        testCart.addItem("Apple", 1.0, 10);

        assertEquals(5, testCart.getTotal(), 0.005);
    }

    @Test
    public void testGetTotal1(){
        assertEquals(0, testCart.getTotal(), 0.005);
    }

    @Test
    public void testGetTotal2(){
        testCart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        
        testCart.addItem("Apple", 1.0, 10);
        testCart.addItem("Orange", 0.5, 10);

        assertEquals(13.5, testCart.getTotal(), 0.005);
    }

    @Test
    public void testGetTotal3(){
        testCart.addItem("Apple", 1.0, 10);
        testCart.addItem("Orange", 0.5, 10);

        assertEquals(15, testCart.getTotal(), 0.005);
    }

    @Test
    public void testGetTotal4(){
        testCart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        testCart.addItem("Apple", 1.0, 10);
        testCart.removeItem("Apple");

        assertEquals(8.1, testCart.getTotal(), 0.005);
    }

    @Test
    public void testGetTotal5(){
        testCart.addItem("Apple", 1.0, 5);
        while(testCart.getItemCount() > 0){
            testCart.removeItem("Apple");
        }

        assertEquals(0, testCart.getTotal(), 0.005);
    }
}