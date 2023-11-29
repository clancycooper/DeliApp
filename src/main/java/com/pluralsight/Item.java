package com.pluralsight;

import java.util.ArrayList;

public abstract class Item implements ItemFunctions{
    static ArrayList<Item> cart = new ArrayList<Item>();
    public Item() {
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
