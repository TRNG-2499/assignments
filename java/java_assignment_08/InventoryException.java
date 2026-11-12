public class InventoryException extends Exception {
    public InventoryException(String message, Throwable cause) {

        // Passes message and cause to parent's constructor
        super(message, cause);     
    }

    public InventoryException(Throwable cause) {
        String message = "Something";
        super(message, cause);
    }

    public InventoryException(String message) {
        super(message);
    }
}
