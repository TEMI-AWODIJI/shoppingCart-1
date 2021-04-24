package com.cognizant;

import java.util.Objects;

public class Item {
    private final int price;
    private final String name;
    private int quantity;
    private boolean onSale;

    public Item(int price, String name) {
        this.price = price;
        this.name = name;
        this.quantity = 1;
    }

    public Item(int price, String name, boolean onSale) {
        this.price = price;
        this.name = name;
        this.onSale = onSale;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOnSale() {
        return onSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (price != item.price) return false;
        if (quantity != item.quantity) return false;
        if (onSale != item.onSale) return false;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (onSale ? 1 : 0);
        return result;
    }
}
