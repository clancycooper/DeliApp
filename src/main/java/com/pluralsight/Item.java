package com.pluralsight;

import java.util.ArrayList;

public abstract class Item implements ItemFunctions{
    static ArrayList<Item> cart;
    public Item() {
        this.cart = new ArrayList<>();
    }
    public static ArrayList<Item> getCart() {
        return cart;
    }
    public static double getTotal() {
        double total = 0.0;
        for (Item item : cart){
            total += item.getPrice();
        }
        return total;
    }
}
