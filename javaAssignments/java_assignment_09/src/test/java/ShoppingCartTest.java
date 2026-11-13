import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The addItem method appears to fail when interacting with items with the same name.
 * It will overwrite any change to the price of an item with the same name as a previous item and instead update the quantity.
 * It appears to fail when adding duplicate items as well
 * looking through the logic it appears to update the temporary "Existing" item instead of creating a new entry.
 */
public class ShoppingCartTest {

     private ShoppingCart shoppingCart;
    //initialize a fresh shoppingCart object before each test
    @BeforeEach 
    public void setUp() {
        // Initialize a fresh shoppingCart object
        shoppingCart = new ShoppingCart();
    }
    //3 tests per method
     // `addItem`, 
     @Test
     public void addItem_validItem() {
         shoppingCart.addItem("Item1", 19.99, 1);
         assertEquals(1, shoppingCart.getItemCount());
         assertEquals(19.99, shoppingCart.getSubtotal(), .01);
     }

     @Test 
     public void addItem_invalidPrice() {
         assertThrows(IllegalArgumentException.class, () -> shoppingCart.addItem("Item2", -5.00, 1));
         assertEquals(0, shoppingCart.getItemCount());
         assertEquals(0, shoppingCart.getSubtotal(), .01);
     }

     @Test 
     public void addItem_multipleItems() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.addItem("Item2", 10.00, 1);
         assertEquals(2, shoppingCart.getItemCount());
         assertEquals(29.99, shoppingCart.getSubtotal(), .01);
         assertEquals(29.99, shoppingCart.getTotal(), .01);
     }

     @Test 
     public void addItem_invalidQuantity() {
         assertThrows(IllegalArgumentException.class, () -> shoppingCart.addItem("Item3", 10.00, 0));
         assertEquals(0, shoppingCart.getItemCount());
         assertEquals(0, shoppingCart.getSubtotal(), .01);
     }

     //this is my point of failure
     @Test 
     public void addItem_sameItemName() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.addItem("Item1", 19.99, 2);
         assertEquals(59.97, shoppingCart.getSubtotal(), .01);
         assertEquals(59.97, shoppingCart.getTotal(), .01);
         assertEquals(3, shoppingCart.getItemCount());
     }

     @Test 
     public void addItem_sameNameDifferentPrice() {
         shoppingCart.addItem("Item1", 9.99, 1);
         shoppingCart.addItem("Item1", 20.00, 1);
         assertEquals(29.99, shoppingCart.getSubtotal(), .01);
         assertEquals(29.99, shoppingCart.getTotal(), .01);
         assertEquals(2, shoppingCart.getItemCount());
     }
     // `removeItem`
     @Test
     public void removeItem_validItem() {
         shoppingCart.addItem("Item1", 19.99, 1);
         assertEquals(true, shoppingCart.removeItem("Item1"));
         shoppingCart.removeItem("Item1");
         assertEquals(0, shoppingCart.getSubtotal(), .01);
     }

     @Test
     public void removeItem_invalidItem() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.removeItem("Item2");
         assertEquals(false, shoppingCart.removeItem("Item2"));
         assertEquals(19.99, shoppingCart.getSubtotal(), .01);
     }

     @Test
     public void removeItem_lastItem() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.addItem("Item2", 10.00, 1);
         assertEquals(true, shoppingCart.removeItem("Item2"));
         assertEquals(1, shoppingCart.getItemCount());
     }

     @Test 
     public void removeItem_afterAddingMultipleItems() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.addItem("Item2", 10.00, 1);
         shoppingCart.removeItem("Item1");
         assertEquals(1, shoppingCart.getItemCount());
         assertEquals(10.00, shoppingCart.getSubtotal(), .01);
     }
     // `getItemCount`, 
     @Test
     public void getItemCount_valid() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.addItem("Item2", 10.00, 1);
         assertEquals(2, shoppingCart.getItemCount());
     }

     @Test
     public void getItemCount_empty() {
         assertEquals(0, shoppingCart.getItemCount());
     }

     @Test
     public void getItemCount_afterRemoval() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.addItem("Item2", 10.00, 1);
         shoppingCart.removeItem("Item1");
         assertEquals(1, shoppingCart.getItemCount());
     }
     // `getSubtotal`, 
     @Test 
     public void getSubtotal_valid() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.addItem("Item2", 10.00, 1);
         assertEquals(29.99, shoppingCart.getSubtotal(), .01);
     }

     @Test
     public void getSubtotal_empty() {
         assertEquals(0, shoppingCart.getSubtotal());
     }

     @Test
     public void getSubtotal_With_Discount() {
         shoppingCart.addItem("Item1", 19.99, 3);
         shoppingCart.addItem("Item2", 10.00, 1);
         shoppingCart.applyDiscountCode("SAVE10");
         assertEquals(69.97, shoppingCart.getSubtotal(), .01);
     }
     // `applyDiscountCode`,
     @Test
     public void applyDiscountCode_valid() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.applyDiscountCode("SAVE10");
         assertEquals(17.99, shoppingCart.getTotal(), .01);
     }

     @Test
     public void applyDiscountCode_invalid() {
         shoppingCart.addItem("Item1", 19.99, 1);
         assertThrows(Exception.class, () -> shoppingCart.applyDiscountCode("INVALID"));
         assertEquals(19.99, shoppingCart.getTotal(), .01);
     }

     @Test 
     public void applyDiscountCodes_Multiple() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.applyDiscountCode("SAVE10");
         shoppingCart.applyDiscountCode("SAVE20");
         assertEquals(15.99, shoppingCart.getTotal(), .01);
     }
     // `getTotal`
     @Test
     public void getTotal_valid() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.addItem("Item2", 10.00, 1);
         assertEquals(29.99, shoppingCart.getTotal(), .01);
     }

     @Test
     public void getTotal_empty() {
         assertEquals(0, shoppingCart.getTotal(), .01);
     }

     @Test
     public void getTotal_afterRemoval() {
         shoppingCart.addItem("Item1", 19.99, 1);
         shoppingCart.addItem("Item2", 10.00, 1);
         shoppingCart.removeItem("Item1");
         assertEquals(10.00, shoppingCart.getTotal(), .01);
     }
}