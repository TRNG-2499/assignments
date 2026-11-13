package com.revature;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple shopping cart that tracks items, quantities, and an optional
 * percentage discount.
 */
public class ShoppingCart {

    /** Valid discount codes (case-sensitive). */
    public static final String CODE_SAVE10 = "SAVE10";
    public static final String CODE_SAVE20 = "SAVE20";
    public static final String CODE_HALF_OFF = "HALFOFF";

    /** Represents a single line in the cart. */
    private static class CartItem {
        private final double price;
        private int quantity;

        private CartItem(double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }
    }

    private final Map<String, CartItem> items = new LinkedHashMap<>();

    // Percentage discount currently applied (0 means no discount).
    private double discountPercent = 0.0;

    /**
     * Adds an item to the cart. If an item with the same name (matched exactly,
     * including casing) is already in the cart, its quantity is increased instead.
     *
     * @throws IllegalArgumentException if the name is null or blank, the price is
     *                                  negative, or the quantity is less than 1
     */
    public void addItem(String name, double price, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Item name must not be null or blank.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative.");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1.");
        }

        CartItem existing = items.get(name);
        if (existing != null) {
            existing.quantity += quantity;
        } else {
            items.put(name, new CartItem(price, quantity));
        }
    }

    /**
     * Removes the item with the given name from the cart entirely.
     *
     * @return true if the item was in the cart, false otherwise
     */
    public boolean removeItem(String name) {
        return items.remove(name) != null;
    }

    /**
     * Returns the total quantity of all items in the cart.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Returns the sum of price multiplied by quantity for every item in the
     * cart, before any discount. An empty cart has a subtotal of 0.0.
     */
    public double getSubtotal() {
        double subtotal = 0.0;
        for (CartItem item : items.values()) {
            subtotal += item.price * item.quantity;
        }
        return subtotal;
    }

    /**
     * Applies a percentage discount to the cart. Only one discount can be active
     * at a time; applying a new valid code replaces any previously applied code.
     *
     * @throws IllegalArgumentException if the code is null or not a valid code
     */
    public void applyDiscountCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Discount code must not be null.");
        }

        switch (code) {
            case CODE_SAVE10:
                discountPercent = 10.0;
                break;
            case CODE_SAVE20:
                discountPercent = 20.0;
                break;
            case CODE_HALF_OFF:
                discountPercent = 50.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code: " + code);
        }
    }

    /**
     * Returns the subtotal with the currently applied discount (if any) taken
     * off. If no discount has been applied, returns the subtotal. No rounding
     * is applied.
     */
    public double getTotal() {
        double subtotal = getSubtotal();
        return subtotal - (subtotal * discountPercent / 100.0);
    }

    /**
     * Returns whether the cart contains no items.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
