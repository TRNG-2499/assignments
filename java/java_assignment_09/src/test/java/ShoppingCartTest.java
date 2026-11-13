package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java_assignment_09.src.main.java.ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;

// in java_assignment_09 run mvn clean test
// this is on jdk 25
class ShoppingCartTest {

    //getitemCount fails two tests
    //getItemCount_oneItemWithMultipleQuantity_returnsTotalQuantity()
    //getItemCount_multipleItems_returnsSumOfAllQuantities()

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void addItem_validItem_addsItemToCart() {

        // Arrange
        String itemName = "Widget";
        double price = 10.00;
        int quantity = 2;

        // Act
        cart.addItem(itemName, price, quantity);

        // Assert
        assertEquals(20.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItem_existingItem_increasesQuantity() {

        cart.addItem("Widget", 10.00, 2);

        cart.addItem("Widget", 10.00, 3);

        assertEquals(50.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItem_sameNameDifferentCasing_addsSeparateItems() {

        cart.addItem("Widget", 10.00, 2);

        cart.addItem("widget", 5.00, 1);

        assertEquals(25.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void addItem_invalidInputs_throwsIllegalArgumentException() {

        assertAll(
            () -> assertThrows(IllegalArgumentException.class,
                () -> cart.addItem(null, 10.00, 1)),

            () -> assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("   ", 10.00, 1)),

            () -> assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Widget", -1.00, 1)),

            () -> assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Widget", 10.00, 0))
        );
    }


    @Test
    void removeItem_existingItem_returnsTrue() {

        cart.addItem("Widget", 10.00, 2);

        boolean result = cart.removeItem("Widget");

        assertTrue(result);
        assertEquals(0.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void removeItem_nonExistingItem_returnsFalse() {

        cart.addItem("Widget", 10.00, 2);

        boolean result = cart.removeItem("Laptop");

        assertFalse(result);
        assertEquals(20.00, cart.getSubtotal(), 0.001);
    }

    @Test
    void removeItem_calledTwice_returnsTrueThenFalse() {

        cart.addItem("Widget", 10.00, 1);

        boolean firstResult = cart.removeItem("Widget");
        boolean secondResult = cart.removeItem("Widget");

        assertAll(
            () -> assertTrue(firstResult),
            () -> assertFalse(secondResult),
            () -> assertEquals(0.00, cart.getSubtotal(), 0.001)
        );
    }


    @Test
    void getItemCount_emptyCart_returnsZero() {

        int result = cart.getItemCount();
        assertEquals(0, result);
    }

    @Test
    void getItemCount_oneItemWithMultipleQuantity_returnsTotalQuantity() {

        cart.addItem("Widget", 10.00, 3);

        int result = cart.getItemCount();

        assertEquals(3, result);
    }

    @Test
    void getItemCount_multipleItems_returnsSumOfAllQuantities() {

        cart.addItem("Widget", 10.00, 3);
        cart.addItem("Laptop", 500.00, 2);
        cart.addItem("Phone", 200.00, 4);

        int result = cart.getItemCount();

        assertEquals(9, result);
    }



    @Test
    void getSubtotal_emptyCart_returnsZero() {


        double result = cart.getSubtotal();


        assertEquals(0.0, result, 0.001);
    }

    @Test
    void getSubtotal_singleItem_returnsPriceTimesQuantity() {


        cart.addItem("Widget", 10.00, 3);


        double result = cart.getSubtotal();


        assertEquals(30.00, result, 0.001);
    }

    @Test
    void getSubtotal_multipleItems_returnsCombinedSubtotal() {


        cart.addItem("Widget", 10.00, 2);
        cart.addItem("Laptop", 500.00, 1);
        cart.addItem("Phone", 200.00, 3);


        double result = cart.getSubtotal();

        assertEquals(1120.00, result, 0.001);
    }

    @Test
    void getSubtotal_afterAddingItems_assertsMultipleValues() {

  
        cart.addItem("Widget", 10.00, 2);
        cart.addItem("Laptop", 100.00, 1);

        assertAll(
            () -> assertEquals(120.00, cart.getSubtotal(), 0.001),
            () -> assertEquals(120.00, cart.getTotal(), 0.001)
        );
    }



    @Test
    void applyDiscountCode_validSave10_appliesTenPercentDiscount() {


        cart.addItem("Widget", 100.00, 1);


        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);

        assertEquals(90.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCode_newCode_replacesPreviousDiscount() {


        cart.addItem("Widget", 100.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);


        cart.applyDiscountCode(ShoppingCart.CODE_SAVE20);


        assertEquals(80.00, cart.getTotal(), 0.001);
    }

    @Test
    void applyDiscountCode_nullCode_throwsIllegalArgumentException() {


        assertThrows(
            IllegalArgumentException.class,
            () -> cart.applyDiscountCode(null)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"INVALID", "save10", "Save10", "", "HALFOFF "})
    void applyDiscountCode_invalidCode_throwsIllegalArgumentException(String code) {


        assertThrows(
            IllegalArgumentException.class,
            () -> cart.applyDiscountCode(code)
        );
    }


    @Test
    void getTotal_noDiscountApplied_returnsSubtotal() {


        cart.addItem("Widget", 100.00, 2);


        double result = cart.getTotal();


        assertEquals(200.00, result, 0.001);
    }

    @ParameterizedTest
    @CsvSource({
        "SAVE10, 90.00",
        "SAVE20, 80.00",
        "HALFOFF, 50.00"
    })
    void getTotal_validDiscountCode_returnsDiscountedTotal(
            String code, double expectedTotal) {

        cart.addItem("Widget", 100.00, 1);

        cart.applyDiscountCode(code);
        double result = cart.getTotal();

        assertEquals(expectedTotal, result, 0.001);
    }

    @Test
    void getTotal_emptyCart_returnsZero() {

        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);

        double result = cart.getTotal();

        assertEquals(0.0, result, 0.001);
    }

    @Test
    void getTotal_afterReplacingDiscount_usesOnlyLatestDiscount() {


        cart.addItem("Widget", 200.00, 1);
        cart.applyDiscountCode(ShoppingCart.CODE_HALF_OFF);


        cart.applyDiscountCode(ShoppingCart.CODE_SAVE10);
        double result = cart.getTotal();

        assertEquals(180.00, result, 0.001);
    }

}
