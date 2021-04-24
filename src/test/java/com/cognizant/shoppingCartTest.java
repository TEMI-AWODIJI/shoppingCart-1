package com.cognizant;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class shoppingCartTest {

    @Test
    void emptyCartTest() {
        Cart cart = new Cart();
        assertTrue(cart.isEmpty());
    }

    @Test
    void subTotalOfItemTestWhenAddingOneItem() {
        List<Item> itemList = new ArrayList<>();
        Cart cart = new Cart(itemList);

        Item item = new Item(100, "Orange");
        cart.addItem(item);

        assertEquals(cart.getSubTotal(), 100);
    }

    @Test
    void subTotalOfItemTestWhenAddingMultipleItems() {
        List<Item> itemList = new ArrayList<>();
        Cart cart = new Cart(itemList);

        Item item1 = new Item(100, "Orange");
        Item item2 = new Item(200, "Orange");

        cart.addItem(item1);
        cart.addItem(item2);

        assertEquals(cart.getSubTotal(), 300);
    }

    @Test
    void quantityUpdateOnCartTest() {
        List<Item> itemList = new ArrayList<>();
        Cart cart = new Cart(itemList);

        Item item1 = new Item(100, "Orange");
        Item item2 = new Item(100, "Orange");
        Item item3 = new Item(100, "Orange");
        Item item4 = new Item(200, "Banana");

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);

        int expectedQuantity = 0;
        for (Item temp : cart.getItemList()) {
            if (temp.getName().equalsIgnoreCase("Orange")
                    && temp.getPrice() == 100) {
                expectedQuantity = temp.getQuantity();
            }
        }

        assertEquals(expectedQuantity, 3);
    }

    @Test
    void seeTheListOfItemWithItsPriceAndQuantity() {
        List<Item> itemList = new ArrayList<>();
        Cart cart = new Cart(itemList);

        Item item1 = new Item(100, "Orange");
        Item item2 = new Item(100, "Orange");
        Item item3 = new Item(100, "Orange");
        Item item4 = new Item(200, "Banana");

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);

        Item expectedItem1 = new Item(100, "Orange");
        expectedItem1.setQuantity(3);
        Item expectedItem2 = new Item(200, "Banana");
        expectedItem2.setQuantity(1);
        List<Item> expectedItemList = Arrays.asList(expectedItem1, expectedItem2);
        Cart expectedCart = new Cart(expectedItemList);

        assertEquals(cart.getItemList().get(0).getPrice(), expectedCart.getItemList().get(0).getPrice());
        assertEquals(cart.getItemList().get(0).getQuantity(), expectedCart.getItemList().get(0).getQuantity());

        assertEquals(cart.getItemList().get(1).getPrice(), expectedCart.getItemList().get(1).getPrice());
        assertEquals(cart.getItemList().get(1).getQuantity(), expectedCart.getItemList().get(1).getQuantity());
    }

    @Test
    void highlightedTheItemIfItIsOnSale() {
        List<Item> itemList = new ArrayList<>();
        Cart cart = new Cart(itemList);

        Item item1 = new Item(100, "Orange", true);
        Item item2 = new Item(100, "Banana", false);

        cart.addItem(item1);
        cart.addItem(item2);

        assertTrue(cart.getItemList().get(0).isOnSale());
        assertFalse(cart.getItemList().get(1).isOnSale());
    }

    @Test
    void removeItemFromTheCart() {
        List<Item> itemList = new ArrayList<>();
        Cart cart = new Cart(itemList);

        Item item1 = new Item(100, "Orange", true);
        Item item2 = new Item(100, "Banana", false);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.remove(item1);

        assertEquals(cart.getItemList().size(), 1);
    }

    @Test
    void adjustQuantityOfAnItemFromTheCart() {
        List<Item> itemList = new ArrayList<>();
        Cart cart = new Cart(itemList);

        Item item1 = new Item(100, "Orange", true);
        Item item2 = new Item(100, "Orange", true);
        Item item3 = new Item(100, "Orange", true);
        Item item4 = new Item(100, "Banana", false);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);

        cart.remove(item1);

        assertEquals(cart.getItemList().size(), 2);
    }
}
