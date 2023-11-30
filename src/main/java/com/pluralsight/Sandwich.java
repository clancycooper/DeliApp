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

    public Sandwich() {

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

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public boolean isToasted() {
        return this.toasted;
    }

    public boolean hasAnyMeat() {
        if (sandwichToppings.isEmpty())
            return false;
        else {
            int temp = sandwichToppings.size();
            for (Toppings topping : sandwichToppings) {
                if (topping.isMeat)
                    temp--;
            }
            return temp != sandwichToppings.size();
        }
    }

    public boolean hasAnyCheese() {
        if (sandwichToppings.isEmpty())
            return false;
        else {
            int temp = sandwichToppings.size();
            for (Toppings topping : sandwichToppings) {
                if (topping.isCheese)
                    temp--;
            }
            return temp != sandwichToppings.size();
        }
    }

    public boolean hasAnyMunchy() {
        if (sandwichToppings.isEmpty())
            return false;
        else {
            int temp = sandwichToppings.size();
            for (Toppings topping : sandwichToppings) {
                if (topping.isMunchy)
                    temp--;
            }
            return temp != sandwichToppings.size();
        }
    }

    @Override
    public double getPrice() {
        double sandwichPrice = 0;
        switch (sandwichSize) {
            case "SMALL":
                sandwichPrice = 5.50;
                for (Toppings topping : sandwichToppings) {
                    if (topping.isMeat && !topping.isExtraMeat)
                        sandwichPrice += 1.00;
                    else if (topping.isExtraMeat)
                        sandwichPrice += 0.50;
                    else if (topping.isCheese && !topping.isExtraCheese)
                        sandwichPrice += 0.75;
                    else if (topping.isExtraCheese)
                        sandwichPrice += 0.30;
                    else if (topping.isMunchy && !topping.isExtraMunchy)
                        sandwichPrice += 1.25;
                    else if (topping.isExtraMunchy)
                        sandwichPrice += 0.60;
                }
            case "MEDIUM":
                sandwichPrice = 7.00;
                for (Toppings topping : sandwichToppings) {
                    if (topping.isMeat && !topping.isExtraMeat)
                        sandwichPrice += 2.00;
                    else if (topping.isExtraMeat)
                        sandwichPrice += 1.00;
                    else if (topping.isCheese && !topping.isExtraCheese)
                        sandwichPrice += 1.50;
                    else if (topping.isExtraCheese)
                        sandwichPrice += 0.60;
                    else if (topping.isMunchy && !topping.isExtraMunchy)
                        sandwichPrice += 2.50;
                    else if (topping.isExtraMunchy)
                        sandwichPrice += 1.20;
                }
            case "LARGE":
                sandwichPrice = 8.50;
                for (Toppings topping : sandwichToppings) {
                    if (topping.isMeat && !topping.isExtraMeat)
                        sandwichPrice += 3.00;
                    else if (topping.isExtraMeat)
                        sandwichPrice += 1.50;
                    else if (topping.isCheese && !topping.isExtraCheese)
                        sandwichPrice += 2.25;
                    else if (topping.isExtraCheese)
                        sandwichPrice += 0.90;
                    else if (topping.isMunchy && !topping.isExtraMunchy)
                        sandwichPrice += 3.75;
                    else if (topping.isExtraMunchy)
                        sandwichPrice += 1.80;
                }
            case "EXTRA LARGE":
                sandwichPrice = 45.00;
        }
        return sandwichPrice;
    }

    @Override
    public String toString() {
        if (isToasted()) {
            if (sandwichToppings.isEmpty() && sandwichSize.equals("EXTRA LARGE")) {
                return "Signature: Mystery Sub" + "\n\t" +
                        "Size: DOUBLE STACK\n\t" +
                        "Bread: " + breadType + "\n\t" +
                        "Toasted\n\t" +
                        "Toppings: ?" + "\n\t";
            } else if (!sandwichToppings.isEmpty() && sandwichSize.equals("EXTRA LARGE")) {
                return "Signature: Scooby Stack" + "\n\t" +
                        "Size: DOUBLE STACK\n\t" +
                        "Bread: " + breadType + "\n\t" +
                        "Toasted\n\t" +
                        "Toppings: " + sandwichToppings + "\n";
            } else {
                if (sandwichToppings.isEmpty()) {
                    return "Size: " + sandwichSize + "\n\t" +
                            "Bread: " + breadType + "\n\t" +
                            "Toasted\n\t" +
                            "No Toppings" + "\n\t";
                } else {
                    return "Size: " + sandwichSize + "\n\t" +
                            "Bread: " + breadType + "\n\t" +
                            "Toasted\n\t" + "Toppings: " + sandwichToppings + "\n";
                }
            }
        } else {
            if (sandwichToppings.isEmpty() && sandwichSize.equals("EXTRA LARGE")) {
                return "Signature: Mystery Sub" + "\n\t" +
                        "Size: DOUBLE STACK\n\t" +
                        "Bread: " + breadType + "\n\t" +
                        "Not Toasted\n\t" +
                        "Toppings: ?" + "\n\t";
            } else if (!sandwichToppings.isEmpty() && sandwichSize.equals("EXTRA LARGE")) {
                return "Signature: Scooby Stack" + "\n\t" +
                        "Size: DOUBLE STACK\n\t" +
                        "Bread: " + breadType + "\n\t" +
                        "Not Toasted\n\t" +
                        "Toppings: " + sandwichToppings + "\n";
            } else {
                if (sandwichToppings.isEmpty()) {
                    return "Size: " + sandwichSize + "\n\t" +
                            "Bread: " + breadType + "\n\t" +
                            "Not Toasted\n\t" +
                            "No Toppings" + "\n\t";
                } else {
                    return "Size: " + sandwichSize + "\n\t" +
                            "Bread: " + breadType + "\n\t" +
                            "Not Toasted\n\t" +
                            "Toppings: " + sandwichToppings + "\n\t";
                }
            }
        }
    }
}