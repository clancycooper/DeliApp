package com.pluralsight;

import static com.pluralsight.Menu.*;

public class Toppings extends Item {
    protected String toppingName;
    protected boolean isMeat, isExtraMeat, isCheese, isExtraCheese, isMunchy, isExtraMunchy;

    public Toppings(String toppingName, boolean isMeat, boolean isExtraMeat, boolean isCheese, boolean isExtraCheese, boolean isMunchy, boolean isExtraMunchy) {
        this.toppingName = toppingName;
        this.isMeat = isMeat;
        this.isExtraMeat = isExtraMeat;
        this.isCheese = isCheese;
        this.isExtraCheese = isExtraCheese;
        this.isMunchy = isMunchy;
        this.isExtraMunchy = isExtraMunchy;
    }

    public String getToppingName() {
        return this.toppingName;
    }

    public void setExtraMeat(boolean extraMeat) {
        isExtraMeat = extraMeat;
    }

    public void setExtraCheese(boolean extraCheese) {
        isExtraCheese = extraCheese;
    }

    public void setExtraMunchy(boolean extraMunchy) {
        isExtraMunchy = extraMunchy;
    }

    public static void toStringRegularToppings() {
        int temp = 1;
        System.out.println("\nList of Regular Toppings: ");
        for (Toppings topping : regularToppings) {
            System.out.println(temp + ".) " + topping.getToppingName());
            temp++;
        }
    }

    public static void toStringMeatToppings() {
        int temp = 1;
        System.out.println("\nList of Premium Meat Toppings: ");
        for (Toppings topping : premiumMeatToppings) {
            System.out.println(temp + ".) " + topping.getToppingName());
            temp++;

        }
    }

    public static void toStringCheeseToppings() {
        int temp = 1;
        System.out.println("\nList of Premium Cheese Toppings: ");
        for (Toppings topping : premiumCheeseToppings) {
            System.out.println(temp + ".) " + topping.getToppingName());
            temp++;

        }
    }

    public static void toStringMunchyToppings() {
        int temp = 1;
        System.out.println("\nList of Munchy Toppings: ");
        for (Toppings topping : munchyToppings) {
            System.out.println(temp + ".) " + topping.getToppingName());
            temp++;

        }
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return toppingName;
    }
}

