package com.pluralsight;

import java.util.ArrayList;

public class Menu {
    static ArrayList<Toppings> regularToppings = new ArrayList<>();
    static ArrayList<Toppings> premiumMeatToppings = new ArrayList<>();
    static ArrayList<Toppings> premiumCheeseToppings = new ArrayList<>();
    static ArrayList<Toppings> munchyToppings = new ArrayList<>();
    static ArrayList<Toppings> allToppings = new ArrayList<>();
    static ArrayList<Toppings> staffChoice = new ArrayList<>();
    static Sandwich scoobyStack = new Sandwich("ALL BREAD", "EXTRA LARGE", allToppings, true);
    static Sandwich mysterySub = new Sandwich("?", "EXTRA LARGE", staffChoice, false);
}
