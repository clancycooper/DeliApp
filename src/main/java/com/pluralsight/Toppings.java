package com.pluralsight;

import java.util.ArrayList;

public class Toppings extends Item{
    protected String toppingName, size;
    protected boolean isMeat, isExtraMeat, isCheese, isExtraCheese, isMunchy, isExtraMunchy;
    protected double toppingPrice;

    static ArrayList<Toppings> regularToppings = new ArrayList<Toppings>();
    static ArrayList<Toppings> premiumMeatToppings = new ArrayList<Toppings>();
    static ArrayList<Toppings> premiumCheeseToppings = new ArrayList<Toppings>();
    static ArrayList<Toppings> munchyToppings = new ArrayList<Toppings>();
    static ArrayList<Toppings> dressingToppings = new ArrayList<Toppings>();


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

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public boolean isMeat() {
        return isMeat;
    }

    public void setMeat(boolean meat) {
        isMeat = meat;
    }

    public boolean isExtraMeat() {
        return isExtraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        isExtraMeat = extraMeat;
    }

    public boolean isCheese() {
        return isCheese;
    }

    public void setCheese(boolean cheese) {
        isCheese = cheese;
    }

    public boolean isExtraCheese() {
        return isExtraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        isExtraCheese = extraCheese;
    }

    public boolean isMunchy() {
        return isMunchy;
    }

    public void setMunchy(boolean munchy) {
        isMunchy = munchy;
    }

    public boolean isExtraMunchy() {
        return isExtraMunchy;
    }

    public void setExtraMunchy(boolean extraMunchy) {
        isExtraMunchy = extraMunchy;
    }

    public double getPrice(String sandwichSize) {
        return 0;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public static void toStringRegularToppings() {
        int temp = 1;
        System.out.println("\nList of Regular Toppings: ");
        for(Toppings topping: regularToppings){
            System.out.println(temp + ".) " + topping.getToppingName());
            temp++;
        }
    }

    public static void toStringMeatToppings() {
        int temp = 1;
        System.out.println("\nList of Premium Meat Toppings: ");
        for(Toppings topping: premiumMeatToppings){
            System.out.println(temp + ".) " + topping.getToppingName());
            temp++;

        }
    }
    public static void toStringCheeseToppings() {
        int temp = 1;
        System.out.println("\nList of Premium Cheese Toppings: ");
        for(Toppings topping: premiumCheeseToppings){
            System.out.println(temp + ".) " + topping.getToppingName());
            temp++;

        }
    }

    public static void toStringMunchyToppings() {
        int temp = 1;
        System.out.println("\nList of Munchy Toppings: ");
        for(Toppings topping: munchyToppings){
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
                    return .50;
                else if (isCheese && !isExtraCheese)
                    return .75;
                else if (isExtraCheese)
                    return .30;
                else if (isMunchy && !isExtraMunchy)
                    return 1.25;
                else if (isExtraMunchy)
                    return .60;
            case "medium":
                if (isMeat && !isExtraMeat)
                    return 2.00;
                else if (isExtraMeat)
                    return 1.00;
                else if (isCheese && !isExtraCheese)
                    return 1.50;
                else if (isExtraCheese)
                    return .60;
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
                    return .90;
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

