public class Order {
    private String itemName;
    private int quantityRequested;
    private int stockAvailable;
    private double paymentAmount;
    private double totalCost;
    private boolean cardExpired;

    public Order(String itemName, int quantityRequested, int stockAvailable,
                 double paymentAmount, double totalCost, boolean cardExpired) {
        this.itemName = itemName;
        this.quantityRequested = quantityRequested;
        this.stockAvailable = stockAvailable;
        this.paymentAmount = paymentAmount;
        this.totalCost = totalCost;
        this.cardExpired = cardExpired;
    }

    public String getItemName() { return itemName; }
    public int getQuantityRequested() { return quantityRequested; }
    public int getStockAvailable() { return stockAvailable; }
    public double getPaymentAmount() { return paymentAmount; }
    public double getTotalCost() { return totalCost; }
    public boolean isCardExpired() { return cardExpired; }
}