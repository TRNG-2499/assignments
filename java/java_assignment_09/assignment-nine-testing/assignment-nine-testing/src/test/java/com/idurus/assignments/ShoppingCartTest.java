package com.idurus.assignments;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ShoppingCartTest {
    
    private ShoppingCart cart;

    @BeforeEach 
    public void setUp() {
        cart = new ShoppingCart();
    }

    // 1. Testing addItem()
    
    @Test
    public void addingShoppingUpdatesCount() {

        //Arrange
        //Act
        cart.addItem("T-shirt", 19.99, 3);

        //Assert
        assertEquals(3, cart.getItemCount())
    }
}
