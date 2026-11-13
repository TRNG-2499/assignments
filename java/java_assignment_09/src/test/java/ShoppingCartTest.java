//There is no logic for if the price is 0 in ShoppingCart.java for
//the addItem throws. Failing test is priceAndQuantityCannotBeLessThanZero()
//because 0 is used, as an item was free, but the addItem method doesn't account
//for that

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;

// Static import for assertions (allows calling assertEquals() directly)
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class ShoppingCartTest {

    private ShoppingCart shopping;

    @BeforeEach
    void setUp(){
        shopping = new ShoppingCart();
    }


    //addItemTests
    @Test
    void addsItemToCart(){
        //Arrange
        //Act
        shopping.addItem("Orange", 2.00, 2);
        //Assert
        assertEquals(1, shopping.getItemCount());
    }    

    @Test
    void priceAndQuantityCannotBeLessThanZero(){
        //Arrange
        //Act
        //Assert
        assertAll(
          () -> assertThrows(IllegalArgumentException.class, () -> {shopping.addItem("Soap", 0.00, 2);}),
          () -> assertThrows(IllegalArgumentException.class, () -> {shopping.addItem("Feathers", 1.00, -2);})
        );
    }

    @Test
    void noNameAddedToCart(){
        //Arrange
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> {shopping.addItem(null, 2.00, 3);});
    }


    //removeItemTesting
    @ParameterizedTest
    @ValueSource(strings = "Orange")
    void successfullyRemovedItem(String item){
        //Arrange
        shopping.addItem(item, 2.00, 8);
        //Act
        shopping.removeItem("Orange");
        //Assert
        assertTrue(shopping.isEmpty());
    }

    @Test 
    void handlesWrongItem(){
        //Arrange
        shopping.addItem("Potato", 4.00, 3);
        //Act
        boolean result = shopping.removeItem("Tomato");
        //Assert
        assertFalse(result);
    }

    @Test 
    void handlesNoItem(){
        //Arrange 
        //Act
        boolean result = shopping.removeItem(null);
        //Assert
        assertFalse(result);
    }


    //getItemCount Tests
    @Test 
    void totalQuantityOfCartedItems() {
        //Arrange
        shopping.addItem("Pear", 2.00, 4);
        shopping.addItem("Tomato", 2.00, 5);
        //Act
        int total = shopping.getItemCount();
        //Assert
        assertEquals(2, total);
    }

    @Test
    void handleWrongCount(){
        //Arrange
        shopping.addItem("Green Pepper", 2.30, 4);
        //Act
        int total = shopping.getItemCount();
        //Assert
        assertNotEquals(3, total);
    }

    @Test
    void handleNullCount() {
        //Arrange
        //Act
        assertThrows(IllegalArgumentException.class, () -> {shopping.addItem(null, 2.00, 8);});
        //Assert
        assertEquals(0, shopping.getItemCount());
    }
    
    
    //getSubtotal Tests
    @Test 
    void getTotalPrice() {
        //Arrange
        shopping.addItem("Potato", 2.00, 4);
        //Act
        double total = shopping.getSubtotal();
        //Assert
        assertEquals(8.00, total, 0.001);
    }

    @Test 
    void testEmptyCartError(){
        //Arrange
        //Act
        assertThrows(IllegalArgumentException.class, () -> {shopping.addItem(null, 0, 5);});
        //Assert
        assertEquals(0, shopping.getItemCount());
        assertTrue(shopping.isEmpty());
    }

    @Test 
    void testMultipleUniqueItems() {
        //Arrange
        shopping.addItem("Tomato", 5.00, 8);
        shopping.addItem("Green Beans", 2.00, 3);
        shopping.addItem("Potato", 3.00, 4);
        //Act
        double total = shopping.getSubtotal();
        //Assert
        assertEquals(58, total, 0.001);
    }


    //applyDiscountCode tests
    @ParameterizedTest
    @ValueSource(strings = {"SAVE10", "SAVE20", "HALFOFF"})
    void applyingAllDiscountCodesToTestIfTheyWork(String code){
        //Arrange
        //Act
        //Assert
        assertDoesNotThrow(() -> shopping.applyDiscountCode(code));
    } 

    @Test 
    void canOnlyApplyOneDiscount() {
        //Arrange
        shopping.addItem("Potato", 100.00, 40);
        //Act
        shopping.applyDiscountCode("SAVE10");
        shopping.applyDiscountCode("SAVE20");
        double total = shopping.getTotal();
        //Assert
        assertEquals(3200.00, total, 0.001);
    }

    @Test 
    void codeIsNullorNotAValidCode(){
        //Arrange
        //Act
        assertThrows(IllegalArgumentException.class, () -> {shopping.applyDiscountCode(null);});
        //Assert
    }


    //getTotal Tests
    @Test 
    void totalAfterAppliedDiscount() {
        //Arrange
        shopping.addItem("Grapes", 1.00, 20);
        shopping.applyDiscountCode("SAVE10");
        //Act
        double total = shopping.getTotal();
        //Assert
        assertEquals(18.00, total, 0.001);
    }

    @Test 
    void emptyCartTest() {
        //Arrange
        //Act
        double total = shopping.getTotal();
        //Assert
        assertEquals(0.0, total, 0.001);
    }

    @Test 
    void discountCodeSetAsNull() {
        //Arrange
        shopping.addItem("Potato", 10.00, 2);
        //Act
        assertThrows(IllegalArgumentException.class, () -> {shopping.applyDiscountCode(null);});
        //Assert
        assertEquals(20.00, shopping.getTotal(), 0.001);
    }









}
