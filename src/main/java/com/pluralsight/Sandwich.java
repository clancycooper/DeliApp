package com.pluralsight;

import java.util.ArrayList;

public class Sandwich extends Item{
    String breadType, sandwichSize;
    ArrayList<Toppings> sandwichToppings;
    boolean toasted;

    public Sandwich(String breadType, String sandwichSize, ArrayList<Toppings> sandwichToppings, boolean toasted) {
        this.breadType = breadType.trim().toLowerCase();
        this.sandwichSize = sandwichSize.trim().toLowerCase();
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
                        if(topping.isMeat && !isExtraMeat)
                            sandwichPrice += 1.00;
                        else if(topping.isExtraMeat)
                            sandwichPrice += .50;
                        else if(topping.isCheese && !isExtraCheese)
                            sandwichPrice += .75;
                        else if(topping.isExtraCheese)
                            sandwichPrice += .30;
                        else if(topping.isMunchy && !isExtraMunchy)
                            sandwichPrice += 1.25;
                        else if(isExtraMunchy)
                            sandwichPrice += .60;
                    }
                case "medium":
                    sandwichPrice = 7.00;
                    for(Toppings topping: sandwichToppings) {
                        if(topping.isMeat && !isExtraMeat)
                            sandwichPrice += 2.00;
                        else if(topping.isExtraMeat)
                            sandwichPrice += 1.00;
                        else if(topping.isCheese && !isExtraCheese)
                            sandwichPrice += 1.50;
                        else if(topping.isExtraCheese)
                            sandwichPrice += .60;
                        else if(topping.isMunchy && !isExtraMunchy)
                            sandwichPrice += 2.50;
                        else if(isExtraMunchy)
                            sandwichPrice += 1.20;
                    }
                case "large":
                    sandwichPrice = 8.50;
                    for(Toppings topping: sandwichToppings) {
                        if(topping.isMeat && !isExtraMeat)
                            sandwichPrice += 3.00;
                        else if(topping.isExtraMeat)
                            sandwichPrice += 1.50;
                        else if(topping.isCheese && !isExtraCheese)
                            sandwichPrice += 2.25;
                        else if(topping.isExtraCheese)
                            sandwichPrice += .90;
                        else if(topping.isMunchy && !isExtraMunchy)
                            sandwichPrice += 3.75;
                        else if(isExtraMunchy)
                            sandwichPrice += 1.80;
                    }
            }
        return sandwichPrice;
    }
}
