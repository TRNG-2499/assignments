package java.java_assignment_08;

public class OutofStockException extends Inventoryexception {
    private final String itemName;
    private final int requested;
    private final int avaliable;

    public OutofStockException(String itemName, int requested, int avaliable){
        super("Not enough stock for\"" + itemName + "\": requested " + requested + ", but only " + avaliable + " avaliable.");
        this.itemName = itemName;
        this.requested = requested;
        this.avaliable = avaliable;
    }

    public String getItemName(){
        return itemName;
    }

    public int getRequested(){
        return requested;
    }

    public int getAvaliable(){
        return avaliable;
    }
}
