public class InventoryException extends Exception{
    public InventoryException(){
        super("There is something wrong with the inventory");
    }
    public InventoryException(String msg){
        super(msg);
    }
}

class OutOfStockException extends InventoryException{
    public OutOfStockException(){
        super("The requested item is out of stock");
    }
    public OutOfStockException(String msg){
        super(msg);
    }
}

class InvalidQuantityException extends InventoryException{
    public InvalidQuantityException(){
        super("You can't order 0 or negative quantity of an item");
    }
    public InvalidQuantityException(String msg){
        super(msg);
    }
}
