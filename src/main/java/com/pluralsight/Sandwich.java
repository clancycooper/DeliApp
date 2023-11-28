package com.pluralsight;

import java.util.ArrayList;

public class Sandwich extends Item{
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
            switch(sandwichSize){
                case "small":
                    sandwichPrice = 5.50;
                    for(Toppings topping: sandwichToppings) {
                       sandwichPrice += topping.getPrice();
                    }
                case "medium":
                    sandwichPrice = 7.00;
                    for(Toppings topping: sandwichToppings) {
                        sandwichPrice += topping.getPrice();
                    }
                case "large":
                    sandwichPrice = 8.50;
                    for(Toppings topping: sandwichToppings) {
                        sandwichPrice += topping.getPrice();
                    }
            }
        return sandwichPrice;
    }
}
