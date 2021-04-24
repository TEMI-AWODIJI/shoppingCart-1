package com.cognizant;

import java.util.List;

public class Cart {

    private int subTotal;
    private List<Item> itemList;

    public Cart() {
    }

    public Cart(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public List<Item> getItemList() {
        return itemList;
    }


    public boolean isEmpty() {
        return true;
    }

    public void addItem(Item item) {
        boolean itemAlreadyInTheList = false;
        for (Item tempItem : itemList) {
            if (tempItem.getName().equalsIgnoreCase(item.getName())
                    && tempItem.getPrice() == item.getPrice()) {
                tempItem.setQuantity(tempItem.getQuantity() + 1);
                itemAlreadyInTheList = true;
            }
        }

        if (!itemAlreadyInTheList) itemList.add(item);
        this.subTotal += item.getPrice();
    }

    public void remove(Item item) {
        for (Item tempItem: itemList) {
            if (tempItem.equals(item)) {
                if (tempItem.getQuantity() <= 1) itemList.remove(item);
                else tempItem.setQuantity(tempItem.getQuantity() - 1);
            }
        }
    }
}
