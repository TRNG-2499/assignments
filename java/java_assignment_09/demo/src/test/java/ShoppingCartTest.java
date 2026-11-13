/*

## Example Interactions

A sample test for a method that you are not required to test, shown for reference. Notice the **Arrange / Act / Assert** structure, which is a useful pattern for organizing any unit test:

```java
@Test
void isEmpty_newCart_returnsTrue() {
    // Arrange: set up the objects and data the test needs.
    //          Here, we create a brand-new cart with nothing in it.
    ShoppingCart cart = new ShoppingCart();

    // Act: perform the single action being tested.
    //      Keep this to one call to the method under test.
    boolean result = cart.isEmpty();

    // Assert: verify the outcome is what you expect.
    //         A test should fail clearly if the behavior is wrong.
    assertTrue(result);
}
```

## Requirements Checklist

- [ ] A `ShoppingCartTest` class exists and uses JUnit 5 (Jupiter)
- [ ] The provided `ShoppingCart` class has not been modified
- [ ] At least three tests are written for each of `addItem`, `removeItem`, `getItemCount`, `getSubtotal`, `applyDiscountCode`, and `getTotal` (18 or more tests total)
- [ ] Tests cover typical usage, edge cases, and invalid input across the methods
- [ ] `assertThrows` is used to verify the expected exceptions
- [ ] Each test starts from a fresh cart, and tests do not depend on one another or on execution order
- [ ] Test names clearly describe the scenario and expected outcome
- [ ] `double` comparisons use a delta
- [ ] Tests follow a clear Arrange / Act / Assert structure
- [ ] A code comment at the top of `ShoppingCartTest` identifies the method containing incorrect logic, the failing test(s), and what the method does wrong
- [ ] The incorrect method has been identified only — it has not been fixed

*/

/*
- Write **at least three unit tests per method** for each of the following six methods: `addItem`, `removeItem`, 
`getItemCount`, `getSubtotal`, 
`applyDiscountCode`, and `getTotal`. Across each method's tests, cover a mix of:
  - Typical, expected usage
  - Edge cases (such as an empty cart, boundary values, or repeated calls)
  - Invalid input, using `assertThrows` where an exception is expected
- Each test should start from a fresh `ShoppingCart` (for example, by using `@BeforeEach`), and tests must not depend on each other or on the order they run in.
- Give each test a name that clearly describes the scenario being tested and the expected outcome.
- When comparing `double` values, use the version of `assertEquals` that accepts a delta.
- **Note:** at least one method in the provided `ShoppingCart` class contains incorrect logic. 
Do not assume the code behaves as described above — your tests should be thorough enough to catch the problem. 
Which method is incorrect is not revealed.
- Run your tests. You are **not** asked to fix the incorrect method — only to identify it. 
Add a code comment at the top of your `ShoppingCartTest` class that names the method you 
believe contains the incorrect logic, lists the test(s) that failed because of it, and 
explains in a sentence or two what the method does wrong. */


//The method that doesn't work properly is getItemCount, because it tracks the unique items
//Within each cart, but it doesn't apply the quantity of each unique item

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class ShoppingCartTest {

    @Test
    void isEmpty_newCart_returnsTrue() {
    // Arrange: set up the objects and data the test needs.
    //          Here, we create a brand-new cart with nothing in it.
    ShoppingCart cart = new ShoppingCart();

    // Act: perform the single action being tested.
    //      Keep this to one call to the method under test.
    boolean result = cart.isEmpty();

    // Assert: verify the outcome is what you expect.
    //         A test should fail clearly if the behavior is wrong.
    assertTrue(result);
    }

    /*@Test
    void cart1_returnsTrue(){

        ShoppingCart cart1 = new ShoppingCart();

        cart1.addItem("Banana", 2.99, 3);
        assertEquals(3, cart1.getItemCount()); //Should be 3

        assertEquals(8.97, cart1.getSubtotal(), 0.001);

        boolean removed_pear = cart1.removeItem("Pear");
        assertFalse(removed_pear); //Pear doesn't exist, should be false

        assertThrows(
            IllegalArgumentException.class,
            () -> cart1.applyDiscountCode("100% off!")
        );

        assertEquals(8.97, cart1.getTotal(), 0.001);
        
    }*/

    ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }
    
    //addItem
    @Test
    void addItem(){
        cart.addItem("Banana", 2.99, 1);
        assertEquals(2.99, cart.getSubtotal(), 0);
    }

    @Test
    void addSameItem(){
        cart.addItem("Banana", 2.99, 1);
        cart.addItem("Banana", 2.99, 1);
        assertEquals(5.98, cart.getSubtotal(), 0);
    }

    @Test
    void addInvalidItem(){
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem(null, 2.99, 1));
    }

    @Test
    void addItemInvalidPrice(){
        assertThrows(IllegalArgumentException.class,
            () -> cart.addItem("Banana", -1, 1));
    }

    @Test
    void addItemInvalidAmount(){
        assertThrows(IllegalArgumentException.class,
            () -> cart.addItem("Banana", 2.99, -1));
    }

    // removeItem
    @Test
    void removeItem() {
        cart.addItem("Banana", 2.99, 1);
        assertTrue(cart.removeItem("Banana"));
    }

    @Test
    void removeMissingItem() {
        assertFalse(cart.removeItem("Banana"));
    }

    @Test
    void removeItemFromEmptyCart() {
        assertFalse(cart.removeItem("Apple"));
    }

    // getItemCount
    @Test
    void getItemCountEmpty() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void getItemCountSingleItem() {
        cart.addItem("Banana", 2.99, 3);
        assertEquals(3, cart.getItemCount());
    }

    @Test
    void getItemCountMultipleItems() {
        cart.addItem("Banana", 2.99, 3);
        cart.addItem("Apple", 1.99, 2);
        assertEquals(5, cart.getItemCount());
    }

    @Test
    void getItemCountSameItem() {
        cart.addItem("Banana", 2.99, 2);
        cart.addItem("Banana", 2.99, 3);
        assertEquals(5, cart.getItemCount());
    }

    // getSubtotal
    @Test
    void getSubtotalEmpty() {
        assertEquals(0.0, cart.getSubtotal(), 0);
    }

    @Test
    void getSubtotalSingleItem() {
        cart.addItem("Banana", 2.99, 3);
        assertEquals(8.97, cart.getSubtotal(), 0);
    }

    @Test
    void getSubtotalMultipleItems() {
        cart.addItem("Banana", 2.99, 2);
        cart.addItem("Apple", 1.99, 3);
        assertEquals(11.95, cart.getSubtotal(), 0);
    }

    // applyDiscountCode
    @Test
    void applySave10() {
        assertDoesNotThrow(() -> cart.applyDiscountCode("SAVE10"));
    }

    @Test
    void applySave20() {
        assertDoesNotThrow(() -> cart.applyDiscountCode("SAVE20"));
    }

    @Test
    void applyInvalidDiscount() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.applyDiscountCode("INVALID"));
    }

    @Test
    void applyNullDiscount() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.applyDiscountCode(null));
    }

    // getTotal
    @Test
    void getTotalNoDiscount() {
        cart.addItem("Banana", 10.00, 2);
        assertEquals(20.00, cart.getTotal(), 0);
    }

    @Test
    void getTotalSave10() {
        cart.addItem("Banana", 10.00, 2);
        cart.applyDiscountCode("SAVE10");
        assertEquals(18.00, cart.getTotal(), 0);
    }

    @Test
    void getTotalHalfOff() {
        cart.addItem("Banana", 10.00, 2);
        cart.applyDiscountCode("HALFOFF");
        assertEquals(10.00, cart.getTotal(), 0);
    }

    @Test
    void getTotalCurrentDiscount() {
        cart.addItem("Banana", 100.00, 1);
        cart.applyDiscountCode("SAVE10");
        cart.applyDiscountCode("SAVE20");
        assertEquals(80.00, cart.getTotal(), 0);
    }
    
}
