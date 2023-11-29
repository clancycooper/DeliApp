package com.pluralsight;

import java.util.ArrayList;

public class Sandwich extends Item {
    static String breadType;
    static String sandwichSize;
    static ArrayList<Toppings> sandwichToppings = new ArrayList<>();
    static boolean toasted;

    public Sandwich(String breadType, String sandwichSize, ArrayList<Toppings> sandwichToppings, boolean toasted) {
        this.breadType = breadType.trim().toUpperCase();
        this.sandwichSize = sandwichSize.trim().toUpperCase();
        this.sandwichToppings = sandwichToppings;
        this.toasted = toasted;
    }
    public Sandwich(){

    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public static void setSandwichToppings(ArrayList<Toppings> sandwichToppings) {
        Sandwich.sandwichToppings = sandwichToppings;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public static boolean isToasted() {
        return toasted;
    }

    public static boolean hasAnyMeat(ArrayList<Toppings> newToppings){
        if(newToppings.isEmpty())
            return false;
        else {
            int temp = newToppings.size();
            for (Toppings topping : newToppings) {
                if (topping.isMeat)
                    temp--;
            }
            if (temp == newToppings.size())
                return false;
            else
                return true;
        }
    }

    public static boolean hasAnyCheese(ArrayList<Toppings> newToppings){
        if(newToppings.isEmpty())
            return false;
        else {
            int temp = newToppings.size();
            for (Toppings topping : newToppings) {
                if (topping.isCheese)
                    temp--;
            }
            if (temp == newToppings.size())
                return false;
            else
                return true;
        }
    }

    public static boolean hasAnyMunchy(ArrayList<Toppings> newToppings){
        if(newToppings.isEmpty())
            return false;
        else {
            int temp = newToppings.size();
            for (Toppings topping : newToppings) {
                if (topping.isMunchy)
                    temp--;
            }
            if (temp == newToppings.size())
                return false;
            else
                return true;
        }
    }

    @Override
    public double getPrice() {
        double sandwichPrice = 0;
        switch (sandwichSize) {
            case "SMALL":
                sandwichPrice = 5.50;
                for (Toppings topping : sandwichToppings) {
                    sandwichPrice += topping.getPrice();
                }
            case "MEDIUM":
                sandwichPrice = 7.00;
                for (Toppings topping : sandwichToppings) {
                    sandwichPrice += topping.getPrice();
                }
            case "LARGE":
                sandwichPrice = 8.50;
                for (Toppings topping : sandwichToppings) {
                    sandwichPrice += topping.getPrice();
                }
        }
        return sandwichPrice;
    }

    public static String sandwichToString(Item sandwich) {
        if (isToasted()) {
            if (sandwichToppings.isEmpty()) {
                return "Bread: " + breadType + "\n\t" +
                        "Size: " + sandwichSize + "\n\t" +
                        "No Toppings" + "\n\t" +
                        "Toasted";
            } else {
                return "Bread: " + breadType + "\n\t" +
                        "Size: " + sandwichSize + "\n\t" +
                        "Toppings: " + sandwichToppings + "\n\t" +
                        "Toasted";
            }
        } else {
            if (sandwichToppings.isEmpty()) {
                return "Bread: " + breadType + "\n\t" +
                        "Size: " + sandwichSize + "\n\t" +
                        "No Toppings" + "\n\t" +
                        "Not Toasted";
            } else {
                return "Bread: " + breadType + "\n\t" +
                        "Size: " + sandwichSize + "\n\t" +
                        "Toppings: " + sandwichToppings + "\n\t" +
                        "Not Toasted";
            }

        }
    }
}