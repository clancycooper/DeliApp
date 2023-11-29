package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Sandwich extends Item {
    String breadType, sandwichSize;
    ArrayList<Toppings> sandwichToppings;
    boolean toasted;

    public Sandwich(String breadType, String sandwichSize, ArrayList<Toppings> sandwichToppings, boolean toasted) {
        this.breadType = breadType.trim().toUpperCase();
        this.sandwichSize = sandwichSize.trim().toUpperCase();
        this.sandwichToppings = sandwichToppings;
        this.toasted = toasted;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public ArrayList<Toppings> getSandwichToppings() {
        return sandwichToppings;
    }

    public void setSandwichToppings(ArrayList<Toppings> sandwichToppings) {
        this.sandwichToppings = sandwichToppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
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

    @Override
    public String toString() {
        if (isToasted()) {
            if (sandwichToppings.isEmpty()) {
                return "Your Order:" + "\n" +
                        "Bread: " + breadType + "\n" +
                        "Size: " + sandwichSize + "\n" +
                        "No Toppings" + "\n" +
                        "Toasted";
            } else {
                return "Your Order:" + "\n" +
                        "Bread: " + breadType + "\n" +
                        "Size: " + sandwichSize + "\n" +
                        "Toppings: " + sandwichToppings + "\n" +
                        "Toasted";

            }

        } else {
            if (sandwichToppings.isEmpty()) {

                return "Your Order:" + "\n" +
                        "Bread: " + breadType + "\n" +
                        "Size: " + sandwichSize + "\n" +
                        "No Toppings" + "\n" +
                        "Not Toasted";

            } else {


                return "Your Order:" + "\n" +
                        "Bread: " + breadType + "\n" +
                        "Size: " + sandwichSize + "\n" +
                        "Toppings: " + sandwichToppings.toString() + "\n" +
                        "Not Toasted";

            }

        }
    }
}