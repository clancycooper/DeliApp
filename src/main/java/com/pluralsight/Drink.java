package com.pluralsight;

import java.util.ArrayList;

//Clancy
//Steven added toStrings

public class Drink extends Item {
    protected String drinkSize, drinkFlavor;
    protected boolean hasIce;

    static ArrayList<Drink> drinkFlavors = new ArrayList<>();

    public Drink(String drinkSize, String drinkFlavor, boolean hasIce) {
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
        this.hasIce = hasIce;
    }

    public Drink(String drinkFlavor) {
        this.drinkFlavor = drinkFlavor;
    }

    public String getDrinkFlavor() {
        return drinkFlavor;
    }

    public static void toStringDrinkFlavors() {
        int temp = 1;
        System.out.println("\nList of Drink Flavors: ");
        for (Drink flavors : drinkFlavors) {
            System.out.println(temp + ".) " + flavors.getDrinkFlavor());
            temp++;
        }
    }

    @Override
    public double getPrice() {
        switch (drinkSize) {
            case "SMALL" -> {
                return 2.00;
            }
            case "MEDIUM" -> {
                return 2.50;
            }
            case "LARGE" -> {
                return 3.00;
            }
            default -> {
                return 0.0; //default for if user chooses no drink option
            }
        }
    }

    @Override
    public String toString() {
        if (hasIce) {
            return drinkSize + ", " +
                    drinkFlavor + ", " +
                    "On The Rocks(Ice)";
        } else {
            return drinkSize + ", " +
                    drinkFlavor + ", " +
                    "No Ice";
        }
    }
}
