package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Toppings extends Item{

/*MUNCHY Toppings -
* Mac and Cheese
* Fried Chicken
* Cream  Cheese
* Chili
* Queso
* Fries
* Mashed Potatoes
* Deviled Eggs
* Spicy Lettuce
* Fried Pickles
* Potato Chips
* Mozzarella Sticks
* Omelette
* peanut butter
* jelly
* beef jerky
* boneless ribs
* Crab Rangoon
* Egg Rolls
* Extra Munchies

 */
    /*
* REGULAR Toppings
* lettuce
* green peppers
* banana peppers
* onions
* tomatoes
* jalapenos
* cucumbers
* pickles
* guacamole
* mushrooms
*
*
* PREMIUM Toppings
* Meats - 1.00, 2.00, 3.00
* steak
* ham
* salami
* roast beef
* grilled chicken
* bacon
* Extra Meat - .50, 1.00, 1.50

*
* Cheese - .75, 1.50, 2.25
* american
* provolone
* cheddar
* swiss
* Extra Cheese - .30, .60, .90
*
* Sauces
* mayo
* mustard
* ketchup
* ranch
* thousand islands
* vinaigrette
*  */

    protected String toppingName, size;
    protected boolean isMeat, isExtraMeat, isCheese, isExtraCheese, isMunchy, isExtraMunchy;
    protected double toppingPrice;

    ArrayList<Toppings> regularToppings;
    ArrayList<Toppings> premiumToppings;
    ArrayList<Toppings> munchyToppings;


    public Toppings(String toppingName, String size, boolean isMeat, boolean isExtraMeat, boolean isCheese, boolean isExtraCheese, boolean isMunchy, boolean isExtraMunchy, double toppingPrice) {
        this.toppingName = toppingName;
        this.size = size;
        this.isMeat = isMeat;
        this.isExtraMeat = isExtraMeat;
        this.isCheese = isCheese;
        this.isExtraCheese = isExtraCheese;
        this.isMunchy = isMunchy;
        this.isExtraMunchy = isExtraMunchy;
        this.toppingPrice = toppingPrice;
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

    public double getToppingPrice() {
        return this.toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
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

    public void toStringRegularToppings() {
        int temp = 1;
        System.out.println("List of Regular Toppings: ");
        for(Toppings topping: regularToppings){
            System.out.println(temp + ".) " + topping.getToppingName());
        }
    }

    public void toStringPremiumToppings() {
        int temp = 1;
        System.out.println("List of Premium Toppings: ");
        for(Toppings topping: premiumToppings){
            System.out.println(temp + ".) " + topping.getToppingName());
        }
    }

    public void toStringMunchyToppings() {
        int temp = 1;
        System.out.println("List of Munchy Toppings: ");
        for(Toppings topping: munchyToppings){
            System.out.println(temp + ".) " + topping.getToppingName());
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
}

