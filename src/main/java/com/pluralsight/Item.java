package com.pluralsight;


import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Item implements ItemFunctions{
     static DecimalFormat df = new DecimalFormat("#,##0.00");
    static ArrayList<Item> cart = new ArrayList<Item>();

    public Item() {
    }

    public static double getTotal() {
        double total = 0.00;
        for (Item item : cart){
            total += item.getPrice();
        }
        return Double.parseDouble(df.format(total));
    }


}
