package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;


import static com.pluralsight.Toppings.*;

public class UserInterface {

    public static void main(String[] args) {
        homeScreen();
    }
    public static Scanner keyboard = new Scanner(System.in);

    public static void homeScreen(){
        System.out.println("Welcome to Scooby's Snack Shack! How may we serve you today?" );
        System.out.print("\t[1] New order\n\t[2] Exit\nUser Input: ");
        String selection = keyboard.nextLine();

        switch (selection) {
            case "1":
                orderScreen();
                break;
            case "2":
                System.out.println("\nHave a great day! Come back and see us!");
                break;
            default:
                System.out.println("\nZoinks! That's not a valid selection. Please select 1 or 2.");
                homeScreen();
                break;
        }
    }

    public static void orderScreen(){
        System.out.println("\nWhat would you like to order?");
        System.out.print("\t[1] Add Sandwich\n\t[2] Add Drink\n\t[3] Add Chips\n\t[4] Checkout\n\t[0] Cancel Order\nUser Input: ");
        String selection = keyboard.nextLine();

        switch (selection) {
            case "1":
                addSandwich();
                break;
            case "2":
                addDrink();
                break;
            case "3":
                addChips();
                break;
            case "4":
                checkOut();
                break;
            case "0":
                cart.clear();
                homeScreen();
                break;
            default:
                System.out.println("\nZoinks! That's not a valid selection.");
                orderScreen();
                break;
        }
    }

    public static void addSandwich(){
        ArrayList<Toppings> toppings = new ArrayList<>();
        System.out.println("\nWhat size sandwich would you like? (1, 2, or 3)");
        System.out.print("\t[1] Small/4 Inch - ($5.50)\n\t[2] Medium/8 Inch - ($7.00)\n\t[3] Large/12 Inch - ($8.50)\nUser Input: ");
        String sizeChoice = keyboard.nextLine();
        String size = "";

            switch(sizeChoice){
                case "1":
                    //small
                    size = "SMALL";
                    break;
                case "2":
                    //medium
                    size = "MEDIUM";
                    break;
                case "3":
                    //large
                    size ="LARGE";
                    break;
                default:
                    System.out.println("\nThat's not a valid size. Please try again.");
                    addSandwich();
                    break;
            }

        System.out.print("\nWhat type of bread would you like?\nUser Input: ");
        String breadChoice = keyboard.nextLine().trim().toUpperCase();
        System.out.println("\nWould you like your sandwich toasted? (1 or 2)");
        System.out.print("\t[1] Toasted\n\t[2] Not Toasted\nUser Input: ");
        String toastedChoice = keyboard.nextLine().trim();
        boolean isToasted = true;

        switch(toastedChoice){
            case "1":
                break;
            case "2":
                isToasted = false;
                break;
            default:
                System.out.println("\nRuh Roh! That's not a valid option. Please try again. ");
                addSandwich();
                break;
        }

        //Prompt user for toppings to use
        System.out.println("\nWould you like Toppings? (1 or 2)");
        System.out.print("\t[1] Toppings\n\t[2] No Toppings\nUser Input: ");
        String response = keyboard.nextLine().toUpperCase().trim();

        switch(response){
            case "1":
                toppingsMenu(toppings);
                break;
            case "2":
                System.out.println("\nProceeding with No Toppings.");
                break;
            default:
                System.out.println("\nJinkies! That's not a valid option. Please try again.");
                addSandwich();
                break;
        }

        Sandwich sandwich = new Sandwich(breadChoice,size,toppings, isToasted);
        addToCart(sandwich);
        System.out.println("\nSandwich successfully added! Now returning to the Order Screen.");
        orderScreen();
    }

     public static void toppingsMenu(ArrayList<Toppings> newToppings){
        try{
            System.out.println("\nWhich toppings would you like to view?");
            System.out.print("\t[1] Regular Toppings (No Upcharge)\n\t[2] Premium Toppings (Small Upcharge)\n\t[3] Munchy Toppings (Large Upcharge)\n\t[4] Exit Toppings Screen\nUser Input: ");
            String choice = keyboard.nextLine().toUpperCase().trim();
            //Topping menu
            switch(choice){
                case "1":
                    toStringRegularToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int regToppingChoice = keyboard.nextInt();
                    newToppings.add(regularToppings.get(regToppingChoice-1));
                    break;
                case "2":
                    toStringPremiumToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int PremToppingChoice = keyboard.nextInt();
                    newToppings.add((premiumToppings.get(PremToppingChoice-1)));
                    break;
                case "3":
                    toStringMunchyToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int MunToppingChoice = keyboard.nextInt();
                    newToppings.add((munchyToppings.get(MunToppingChoice-1)));
                    break;
                case"4":
                    System.out.println("\nExiting Toppings Selection.");
                    break;
                default:
                    System.out.println("\nRuh-Roh! That's not a valid option. Please try again.");
                    toppingsMenu(newToppings);
            }
            anotherTopping(newToppings);
        }
        catch(Exception inputError){
            System.out.println("\nThere seems to have been an issue with your input, please try again!");
            inputError.printStackTrace();
            toppingsMenu(newToppings);
        }
     }

    public static void anotherTopping(ArrayList<Toppings> anotherTopping) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nWould you like to add another topping? (1 or 2)");
        System.out.print("\t[1] Yes\n\t[2] No\nUser Input: ");
        String response = keyboard.nextLine();
        switch (response) {
            case "1":
                toppingsMenu(anotherTopping);
                break;
            case "2":
                break;
            default:
                System.out.println("\nZoinks! That's not a valid option. Please try again.");
                anotherTopping(anotherTopping);
        }
    }

    public static void addDrink(){
        System.out.println("\nWhat size drink would you like? (1, 2, or 3)");
        System.out.print("\t[1] Small ($2.00)\n\t[2] Medium($2.50)\n\t[3] Large($3.00)\nUser Input: ");
        String drinkSizeChoice = keyboard.nextLine().toUpperCase().trim();
        System.out.print("\nWhat flavor drink would you like?\nUser Input: ");
        String flavourChoice = keyboard.nextLine().toUpperCase().trim();
        System.out.print("\nWould you like ice? (1 or 2)\nUser Input: ");
        String iceChoice = keyboard.nextLine().trim();
        boolean hasIce = true;
        switch(iceChoice){
            case"1":
                break;
            case "2":
                hasIce = false;
            default:
                System.out.println("\nRuh-Roh! That's not a valid option. Please try again.");
                addDrink();
        }
        // Drink newDrink = new Drink(flavour,drinkSize, ice, )
        // addToCart(newDrink);
        //Add Options for Drink Flavors and Chip Flavors
    }

    public static void addChips(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nWhat kind of chips would you like?\nUser Input: ");
        String chipChoice = keyboard.nextLine().toUpperCase().trim();
        Chips chips = new Chips(chipChoice);
        addToCart(chips);
    }

    public static void addToCart(Item newItem){
        cart.add(newItem);
    }

    public static void checkOut(){


    }
}