package com.pluralsight;

import java.util.ArrayList;

public class Sandwich extends Item {
    String breadType;
    String sandwichSize;
    ArrayList<Toppings> sandwichToppings = new ArrayList<>();
    boolean toasted;

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

    public String getSandwichSize() {
        return sandwichSize;
    }

    public ArrayList<Toppings> getSandwichToppings() {
        return sandwichToppings;
    }

    public void setSandwichToppings(ArrayList<Toppings> sandwichToppings) {
        this.sandwichToppings = sandwichToppings;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public boolean isToasted() {
        return this.toasted;
    }

    public boolean hasAnyMeat(){
        if(sandwichToppings.isEmpty())
            return false;
        else {
            int temp = sandwichToppings.size();
            for (Toppings topping : sandwichToppings) {
                if (topping.isMeat)
                    temp--;
            }
            if (temp == sandwichToppings.size())
                return false;
            else
                return true;
        }
    }

    public boolean hasAnyCheese(){
        if(sandwichToppings.isEmpty())
            return false;
        else {
            int temp = sandwichToppings.size();
            for (Toppings topping : sandwichToppings) {
                if (topping.isCheese)
                    temp--;
            }
            if (temp == sandwichToppings.size())
                return false;
            else
                return true;
        }
    }

    public boolean hasAnyMunchy(){
        if(sandwichToppings.isEmpty())
            return false;
        else {
            int temp = sandwichToppings.size();
            for (Toppings topping : sandwichToppings) {
                if (topping.isMunchy)
                    temp--;
            }
            if (temp == sandwichToppings.size())
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
                    sandwichPrice += topping.getPrice(sandwichSize);
                }
            case "MEDIUM":
                sandwichPrice = 7.00;
                for (Toppings topping : sandwichToppings) {
                    sandwichPrice += topping.getPrice(sandwichSize);
                }
            case "LARGE":
                sandwichPrice = 8.50;
                for (Toppings topping : sandwichToppings) {
                    sandwichPrice += topping.getPrice(sandwichSize);
                }
        }
        return sandwichPrice;
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }

    @Override
    public String toString() {
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