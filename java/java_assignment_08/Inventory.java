public class Inventory {
    
    public void checkInventory(int req_quantity, int stock) throws InventoryException{
            if(req_quantity > stock){
                throw new OutOfStockException("Out of Stock. Requested " + req_quantity + " but only " + stock + " in stock.");
            }
            if(req_quantity <= 0){
                throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0");
            }
        }
    }

