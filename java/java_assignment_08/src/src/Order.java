public record Order(String item, int quantity, int stock, double payment, double total, boolean isExpired) {
    public String getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getStock() {
        return stock;
    }
    public double getPayment() {
        return payment;
    }
    public double getTotal() {
        return total;
    }
    public boolean isExpired() {
        return isExpired;
    }
}
