package assignments.java.java_assignment_08.exceptions;

public class OutOfStockException extends InventoryException {

    private final int quantity;
    private final int stock;

    public OutOfStockException(int quantity, int stock) {
        super("- Out Of Stock — The order requests more of an item than is currently available in stock. Current stock: "
                + stock + " Current requested quantity: " + quantity);

        this.quantity = quantity;
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStock() {
        return stock;
    }
}