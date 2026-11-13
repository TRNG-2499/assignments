import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach //It creates a new shopping cart before every test. This ensures that one test does not affect another.
    void setUp(){
        //ShoppingCart carts = new ShoppingCart(); //Instead of doing this in every methond, we are declaring the class obj and then having this method run before any other test case run.
        cart = new ShoppingCart();
    }

    @Test
    void addItem_validItem_addsItemToCart() {
        //Follow 3A (A = Arrange, A = Act, A = Asset
        //Arrange
        String name = "Book";
        double price = 50.00;
        int quantity = 2;

        //Act
        cart.addItem(name, price, quantity);

        //Assert
        assertEquals(100.00, cart.getSubtotal());
    }

    //Let's add same item
    @Test
    void addItem_existingItem_IncreaseQuanity() {
        //Arrange
        cart.addItem("Pen", 5.00, 4);
        //Act
        cart.addItem("Pen", 5.00, 6);
        //Assert
        assertEquals(50, cart.getSubtotal());
    }

    @Test
    void addItem_nullName_throwsException(){
        //Arrange, Act, Assert
    assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 10, 1) );

    }

    @Test
    void shouldThrowExceptionWhenDiscountCountIsZer0(){
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(String.valueOf(0)));
    }

    @Test
    void addTwoDifferentItems(){
        cart.addItem("Apple", 5, 5);
        cart.addItem("Banana", 3, 10);

       // assertEquals(55, cart.getSubtotal());

        double subTotal = cart.getSubtotal();
        assertEquals(55, subTotal);
    }


}
