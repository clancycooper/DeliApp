package com.pluralsight;

import java.util.ArrayList;

public class Toppings extends Item {
    protected String toppingName, size;
    protected boolean isMeat, isExtraMeat, isCheese, isExtraCheese, isMunchy, isExtraMunchy;

    static ArrayList<Toppings> regularToppings = new ArrayList<>();
    static ArrayList<Toppings> premiumMeatToppings = new ArrayList<>();
    static ArrayList<Toppings> premiumCheeseToppings = new ArrayList<>();
    static ArrayList<Toppings> munchyToppings = new ArrayList<>();

    public Toppings(String toppingName, String size, boolean isMeat, boolean isExtraMeat, boolean isCheese, boolean isExtraCheese, boolean isMunchy, boolean isExtraMunchy) {
        this.toppingName = toppingName;
        this.size = size;
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

    public void setSize(String size) {
        this.size = size;
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
        switch (size) {
            case "small":
                if (isMeat && !isExtraMeat)
                    return 1.00;
                else if (isExtraMeat)
                    return 0.50;
                else if (isCheese && !isExtraCheese)
                    return 0.75;
                else if (isExtraCheese)
                    return 0.30;
                else if (isMunchy && !isExtraMunchy)
                    return 1.25;
                else if (isExtraMunchy)
                    return 0.60;
            case "medium":
                if (isMeat && !isExtraMeat)
                    return 2.00;
                else if (isExtraMeat)
                    return 1.00;
                else if (isCheese && !isExtraCheese)
                    return 1.50;
                else if (isExtraCheese)
                    return 0.60;
                else if (isMunchy && !isExtraMunchy)
                    return 2.50;
                else if (isExtraMunchy)
                    return 1.20;
            case "large":
                if (isMeat && !isExtraMeat)
                    return 3.00;
                else if (isExtraMeat)
                    return 1.50;
                else if (isCheese && !isExtraCheese)
                    return 2.25;
                else if (isExtraCheese)
                    return 0.90;
                else if (isMunchy && !isExtraMunchy)
                    return 3.75;
                else if (isExtraMunchy)
                    return 1.80;
        }
        return 0;
    }

    @Override
    public String toString() {
        return toppingName;
    }
}

