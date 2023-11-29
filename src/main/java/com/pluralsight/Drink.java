package com.pluralsight;

import java.util.ArrayList;

public class Drink extends Item {
    protected String drinkSize, drinkFlavor;
    protected boolean hasIce;

    static ArrayList<Drink> drinkFlavors = new ArrayList<Drink>();

    public Drink(String drinkSize, String drinkFlavor, boolean hasIce) {
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
        this.hasIce = hasIce;
    }

    public Drink(String drinkFlavor){
        this.drinkFlavor = drinkFlavor;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getDrinkFlavor() {
        return drinkFlavor;
    }

    public void setDrinkFlavor(String drinkFlavor) {
        this.drinkFlavor = drinkFlavor;
    }

    public boolean isHasIce() {
        return hasIce;
    }

    public void setHasIce(boolean hasIce) {
        this.hasIce = hasIce;
    }


    public static void toStringDrinkFlavors() {
        int temp = 1;
        System.out.println("\nList of Drink Flavors: ");
        for(Drink flavors: drinkFlavors){
            System.out.println(temp + ".) " + flavors.getDrinkFlavor());
            temp++;
        }
    }

    @Override
    public double getPrice() {
        switch (drinkSize) {
            case "SMALL":
                return 2.00;
            case "MEDIUM":
                return 2.50;
            case "LARGE":
                return 3.00;
            default:
                return 0.0; //default for if user chooses no drink option
        }
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkSize='" + drinkSize + '\'' +
                ", drinkFlavor='" + drinkFlavor + '\'' +
                ", hasIce=" + hasIce +
                '}';
    }
}
