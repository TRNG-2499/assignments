class Main {
    String foo(double item_price, double cash_inserted) {
        if (item_price < 0 || cash_inserted < 0) {
            return "one or more inputs are negative and cannot be used";
        } else if (cash_inserted < item_price) {
            return "cash amount inserted is less than the item price, please insert $" + (double) (item_price - cash_inserted);
        } else if (cash_inserted >= item_price) {
            return "purchase successful, change due: $" + (double) (cash_inserted - item_price) + ".";
        } else {
            return "unknown error occured";
        }
    }

    public static void main(String[] args) {
        double ex_item, ex_cash_amount;

        // change these examples to whatever you'd like
        ex_item = 4.5;
        ex_cash_amount = 3.5;
        Main obj = new Main();
        System.out.println((obj.foo(ex_item, ex_cash_amount)));
    }
}