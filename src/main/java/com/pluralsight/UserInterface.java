package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;


import static com.pluralsight.ReceiptManager.displayOrderDetails;
import static com.pluralsight.Toppings.*;
import static com.pluralsight.Drink.*;
import static com.pluralsight.Chips.*;

public class UserInterface {
    public static Scanner keyboard = new Scanner(System.in);

    public static void homeScreen(){
        System.out.println("\nWelcome to Scooby's Snack Shack! How may we serve you today?" );
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

        System.out.print("\nWhat type of bread would you like? \n\tWhite, Wheat, Ciabatta, Italian Herb and Cheese, Pumpernickel \nUser Input: ");
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
                toppingsMenu(toppings, size);
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

     public static void toppingsMenu(ArrayList<Toppings> newToppings, String size){
        try{
            System.out.println("\nWhich toppings would you like to view?");
            switch (size) {
                case "SMAll" :
                    System.out.print("\t[1] Regular Toppings (Included)" +
                            "\n\t[2] Meat Toppings ($1.00)" +
                            "\n\t[3] Cheese Toppings ($ .75)" +
                            "\n\t[4] Munchy Toppings ($1.25)" +
                            "\n\t[5] Exit Toppings Screen" +
                            "\nUser Input: ");
                    break;

                case "MEDIUM" :
                    System.out.print("\t[1] Regular Toppings (Included)" +
                            "\n\t[2] Meat Toppings ($2.00)" +
                            "\n\t[3] Cheese Toppings ($1.50)" +
                            "\n\t[4] Munchy Toppings ($2.50)" +
                            "\n\t[5] Exit Toppings Screen" +
                            "\nUser Input: ");
                    break;

                case "LARGE" :
                    System.out.print("\t[1] Regular Toppings (Included)" +
                            "\n\t[2] Meat Toppings ($3.00)" +
                            "\n\t[3] Cheese Toppings ($2.25)" +
                            "\n\t[4] Munchy Toppings ($3.75)" +
                            "\n\t[5] Exit Toppings Screen" +
                            "\nUser Input: ");
                    break;
            }

            String choice = keyboard.nextLine().toUpperCase().trim();
            //Topping menu
            switch(choice){
                case "1":
                    toStringRegularToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int regToppingChoice = keyboard.nextInt();
                    regularToppings.get(regToppingChoice-1).setSize(size);
                    newToppings.add(regularToppings.get(regToppingChoice-1));
                    keyboard.nextLine();
                    anotherTopping(newToppings, size);
                    break;
                case "2":
                    toStringMeatToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int meatToppingChoice = keyboard.nextInt();
                    for(Toppings toppings: newToppings){
                        if(toppings.isMeat){
                            premiumMeatToppings.get(meatToppingChoice-1).setExtraMeat(true);
                            break;
                        }
                    }
                    newToppings.add((premiumMeatToppings.get(meatToppingChoice-1)));
                    keyboard.nextLine();
                    anotherTopping(newToppings, size);
                    break;
                case "3":
                    toStringCheeseToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int cheeseToppingChoice = keyboard.nextInt();
                    for(Toppings toppings: newToppings){
                        if(toppings.isCheese){
                            premiumMeatToppings.get(cheeseToppingChoice-1).setExtraCheese(true);
                            break;
                        }
                    }
                    newToppings.add((premiumMeatToppings.get(cheeseToppingChoice-1)));
                    keyboard.nextLine();
                    anotherTopping(newToppings, size);
                    break;
                case "4":
                    toStringMunchyToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int MunToppingChoice = keyboard.nextInt();
                    newToppings.add((munchyToppings.get(MunToppingChoice-1)));
                    keyboard.nextLine();
                    anotherTopping(newToppings, size);
                    break;
                case"5":
                    System.out.println("\nExiting Toppings Selection.");
                    break;
                default:
                    System.out.println("\nRuh-Roh! That's not a valid option. Please try again.");
                    toppingsMenu(newToppings, size);
            }
        }
        catch(Exception inputError){
            System.out.println("\nThere seems to have been an issue with your input, please try again!");
            inputError.printStackTrace();
            toppingsMenu(newToppings, size);
        }
     }

    public static void anotherTopping(ArrayList<Toppings> anotherTopping, String size) {
        System.out.println("\nWould you like to add another topping? (1 or 2)");
        System.out.print("\t[1] Yes\n\t[2] No\nUser Input: ");
        String response = keyboard.nextLine();
        switch (response) {
            case "1":
                toppingsMenu(anotherTopping, size);
                break;
            case "2":
                break;
            default:
                System.out.println("\nZoinks! That's not a valid option. Please try again.");
                anotherTopping(anotherTopping, size);
        }
    }

    public static void addDrink(){
        try{
            System.out.println("\nWhat size drink would you like? (1, 2, or 3)");
            System.out.print("\t[1] Small ($2.00)\n\t[2] Medium($2.50)\n\t[3] Large($3.00)\nUser Input: ");
            String drinkSizeChoice = keyboard.nextLine().trim(), size="";
            switch(drinkSizeChoice){
                case "1":
                    size = "SMALL";
                    break;
                case "2":
                    size = "MEDIUM";
                    break;
                case "3":
                    size = "LARGE";
                    break;
                default:
                    System.out.println("\nZoinks! That's not a valid option. Please try again.");
                    addDrink();
            }
            toStringDrinkFlavors();
            System.out.print("\nPlease enter the # of your drink choice: ");
            String flavourChoice = (drinkFlavors.get((Integer.parseInt(keyboard.nextLine().trim()))-1)).getDrinkFlavor();
            System.out.print("\nWould you like ice? (1 or 2)");
            System.out.print("\n\t[1] Yes\n\t[2] No\nUser Input: ");
            String iceChoice = keyboard.nextLine().trim();
            boolean hasIce = true;
            switch(iceChoice){
                case"1":
                    break;
                case "2":
                    hasIce = false;
                    break;
                default:
                    System.out.println("\nRuh-Roh! That's not a valid option. Please try again.");
                    addDrink();
            }
            Drink newDrink = new Drink(size, flavourChoice, hasIce);
            addToCart(newDrink);
            System.out.println("\nDrink successfully added! Now returning to the main menu.");
            orderScreen();
        }
        catch(Exception inputError){
            System.out.println("\nPlease enter a valid option! Returning to drink menu.");
            addDrink();
        }
    }

    public static void addChips(){
        try{
            toStringChipFlavors();
            System.out.print("\nPlease enter the # of your chip choice: ");
            String chipChoice = (chipFlavors.get((Integer.parseInt(keyboard.nextLine().trim()))-1)).getChipType();
            Chips chips = new Chips(chipChoice);
            addToCart(chips);
            System.out.println("\nChips successfully added! Now returning to the main menu.");
            orderScreen();
        }
        catch(Exception inputError){
            System.out.println("\nPlease enter a valid option! Returning to drink menu.");
            addDrink();
        }
    }

    public static void addToCart(Item newItem){
        cart.add(newItem);
    }

    public static void checkOut(){
        displayOrderDetails(cart);
    }
}