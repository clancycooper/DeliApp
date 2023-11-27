package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Toppings {

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

protected String toppingName;
protected boolean isMeat, isExtraMeat, isCheese, isExtraCheese, isMunchy, isExtraMunchy, isSauce;
protected double toppingPrice;

//ArrayList<Topping(regularToppings())>;
//ArrayList<Topping(premiumToppings())>;
//ArrayList<Topping(munchyToppings())>;
//toString


    public Toppings(String toppingName, boolean isMeat, boolean isExtraMeat, boolean isCheese, boolean isExtraCheese, boolean isMunchy, boolean isExtraMunchy, double toppingPrice) {
        this.toppingName = toppingName;
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
}

