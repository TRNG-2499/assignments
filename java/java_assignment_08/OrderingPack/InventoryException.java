package OrderingPack;

public class InventoryException extends Exception{
    public InventoryException(String message) {
        super(message);
    }

}
class OutOfStockException extends InventoryException{

    public OutOfStockException(String message) {
    super(message);
    }
}
class InvalidQuantityException extends InventoryException {

    public InvalidQuantityException(String message) {
        super(message);
    }
}