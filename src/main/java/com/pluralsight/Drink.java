package com.pluralsight;

import java.util.ArrayList;

public class Drink extends Item {
    protected String drinkSize, drinkFlavor;
    protected boolean hasIce;
    protected double drinkCost;

    ArrayList<Drink> drinkFlavors;

    public Drink(String drinkSize, String drinkFlavor, boolean hasIce, double drinkCost) {
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
        this.hasIce = hasIce;
        this.drinkCost = drinkCost;
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

    public double getDrinkCost() {
        return drinkCost;
    }

    public void setDrinkCost(double drinkCost) {
        this.drinkCost = drinkCost;
    }

    public void toStringDrinkFlavors() {
        int temp = 1;
        System.out.println("List of Drink Flavors: ");
        for(Drink flavors: drinkFlavors){
            System.out.println(temp + ".) " + flavors.getDrinkFlavor());
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
}
