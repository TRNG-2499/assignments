
public class InvalidQuantityException extends InventoryException{
    public InvalidQuantityException()
    {
        super("Invalid Quantity. Quantity must be greater than 0.");
    }
}
