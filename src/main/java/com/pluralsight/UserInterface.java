package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.Chips.chipFlavors;
import static com.pluralsight.Chips.toStringChipFlavors;
import static com.pluralsight.Drink.drinkFlavors;
import static com.pluralsight.Drink.toStringDrinkFlavors;
import static com.pluralsight.Menu.*;
import static com.pluralsight.ReceiptManager.displayOrderDetails;
import static com.pluralsight.Sandwich.cart;
import static com.pluralsight.Toppings.*;

public class UserInterface {
    public static Scanner keyboard = new Scanner(System.in);

    public static void homeScreen() {
        System.out.println("\nWelcome to Scooby's Snack Shack! How may we serve you today?");
        System.out.print("\t[1] New order\n\t[2] Exit\nUser Input: ");
        String selection = keyboard.nextLine();

        switch (selection) {
            case "1" -> orderScreen();
            case "2" -> {
                System.out.println("\nHave a great day! Come back and see us!");
                System.exit(0);
            }
            default -> {
                System.out.println("\nZoinks! That's not a valid selection. Please select 1 or 2.");
                homeScreen();
            }
        }
    }

    public static void orderScreen() {
        System.out.println("\nWhat would you like to order?");
        System.out.print("\t[1] Add Custom Sandwich\n\t[2] Add Signature Sandwich" +
                "\n\t[3] Add Drink\n\t[4] Add Chips\n\t[5] Checkout\n\t[0] Cancel Order\nUser Input: ");
        String selection = keyboard.nextLine();

        switch (selection) {
            case "1" -> addSandwich();
            case "2" -> addSignatureSandwich();
            case "3" -> addDrink();
            case "4" -> addChips();
            case "5" -> checkOut();
            case "0" -> {
                cart.clear();
                homeScreen();
            }
            default -> {
                System.out.println("\nZoinks! That's not a valid selection.");
                orderScreen();
            }
        }
    }

    public static void addSignatureSandwich() {
        Sandwich signatureSandwich = new Sandwich();
        System.out.print("\nLike choose a signature Sub!" +
                "\n\t[1] Scooby Stack/All Bread and All Toppings - ($45.00)" +
                "\n\t[2] Mystery Sub/Staff Pick - ($45.00)" +
                "\nUser Input: ");
        String selection = keyboard.nextLine();
        switch (selection) {
            case "1" -> {
                signatureSandwich = scoobyStack;

            }
            case "2" -> {
                signatureSandwich = mysterySub;

            }
            default -> {
                System.out.println("\nJinkies! Please choose a valid option.");
                addSignatureSandwich();
            }
        }
        System.out.println("\nWould you like your sandwich toasted? (1 or 2)");
        System.out.print("\t[1] Toasted\n\t[2] Not Toasted\nUser Input: ");
        String toastedChoice = keyboard.nextLine().trim();
        boolean isToasted = true;

        switch (toastedChoice) {
            case "1" -> {
            }
            case "2" -> isToasted = false;
            default -> {
                System.out.println("\nRuh Roh! That's not a valid option. Please try again. ");
                addSignatureSandwich();
            }
        }
        signatureSandwich.setToasted(isToasted);
        addToCart(signatureSandwich);
        System.out.println("\nSandwich successfully added! Now returning to the Order Screen.");
        orderScreen();
    }

    public static void addSandwich() {
        Sandwich sandwich = new Sandwich();
        System.out.println("\nWhat size sandwich would you like? (1, 2, or 3)");
        System.out.print("\t[1] Small/4 Inch - ($5.50)\n\t[2] Medium/8 Inch - ($7.00)" +
                "\n\t[3] Large/12 Inch - ($8.50)" +
                "\nUser Input: ");
        String sizeChoice = keyboard.nextLine().trim();
        String size = "";

        switch (sizeChoice) {
            case "1" ->
                //small
                    size = "SMALL";
            case "2" ->
                //medium
                    size = "MEDIUM";
            case "3" ->
                //large
                    size = "LARGE";
            default -> {
                System.out.println("\nThat's not a valid size. Please try again.");
                addSandwich();
            }
        }

        sandwich.setSandwichSize(size);
        System.out.println("\nWhat type of bread would you like? (1, 2, 3, 4, or 5)");
        System.out.print("\t[1] White\n\t[2] Wheat\n\t[3] Ciabatta\n\t[4] Italian Herb and Cheese\n\t[5] Pumpernickel \nUser Input: ");
        String breadChoice = keyboard.nextLine().trim(), bread = "";

        switch (breadChoice) {
            case "1" -> bread = "WHITE";
            case "2" -> bread = "WHEAT";
            case "3" -> bread = "CIABATTA";
            case "4" -> bread = "ITALIAN HERB AND CHEESE";
            case "5" -> bread = "PUMPERNICKEL";
            default -> {
                System.out.println("\nRuh Roh! That's not a valid option. Please try again!");
                addSandwich();
            }
        }

        sandwich.setBreadType(bread);
        System.out.println("\nWould you like your sandwich toasted? (1 or 2)");
        System.out.print("\t[1] Toasted\n\t[2] Not Toasted\nUser Input: ");
        String toastedChoice = keyboard.nextLine().trim();
        boolean isToasted = true;

        switch (toastedChoice) {
            case "1" -> {
            }
            case "2" -> isToasted = false;
            default -> {
                System.out.println("\nRuh Roh! That's not a valid option. Please try again. ");
                addSandwich();
            }
        }

        sandwich.setToasted(isToasted);
        System.out.println("\nWould you like Toppings? (1 or 2)");
        System.out.print("\t[1] Toppings\n\t[2] No Toppings\nUser Input: ");
        String response = keyboard.nextLine().toUpperCase().trim();

        switch (response) {
            case "1" -> toppingsMenu(sandwich);
            case "2" -> System.out.println("\nProceeding with No Toppings.");
            default -> {
                System.out.println("\nJinkies! That's not a valid option. Please try again.");
                addSandwich();
            }
        }
        addToCart(sandwich);
        System.out.println("\nSandwich successfully added! Now returning to the Order Screen.");
        orderScreen();
    }

    public static void toppingsMenu(Sandwich sandwich) {
        try {
            System.out.println("\nWhich toppings would you like to view?");
            System.out.println("\t[1] Regular Toppings (Included)");
            switch (sandwich.getSandwichSize()) {
                case "SMALL" -> {
                    if (!sandwich.hasAnyMeat())
                        System.out.println("\t[2] Meat Toppings ($1.00)");
                    else
                        System.out.println("\t[2] Meat Toppings ($0.50)");
                    if (!sandwich.hasAnyCheese())
                        System.out.println("\t[3] Cheese Toppings ($0.75)");
                    else
                        System.out.println("\t[3] Cheese Toppings ($0.30)");
                    if (!sandwich.hasAnyMunchy())
                        System.out.println("\t[4] Munchy Toppings ($1.25)");
                    else
                        System.out.println("\t[4] Munchy Toppings ($0.60)");
                }
                case "MEDIUM" -> {
                    if (!sandwich.hasAnyMeat())
                        System.out.println("\t[2] Meat Toppings ($2.00)");
                    else
                        System.out.println("\t[2] Meat Toppings ($1.00)");
                    if (!sandwich.hasAnyCheese())
                        System.out.println("\t[3] Cheese Toppings ($1.50)");
                    else
                        System.out.println("\t[3] Cheese Toppings ($0.60)");
                    if (!sandwich.hasAnyMunchy())
                        System.out.println("\t[4] Munchy Toppings ($2.50)");
                    else
                        System.out.println("\t[4] Munchy Toppings ($1.20)");
                }
                case "LARGE" -> {
                    if (!sandwich.hasAnyMeat())
                        System.out.println("\t[2] Meat Toppings ($3.00)");
                    else
                        System.out.println("\t[2] Meat Toppings ($1.50)");
                    if (!sandwich.hasAnyCheese())
                        System.out.println("\t[3] Cheese Toppings ($2.25)");
                    else
                        System.out.println("\t[3] Cheese Toppings ($0.90)");
                    if (!sandwich.hasAnyMunchy())
                        System.out.println("\t[4] Munchy Toppings ($3.75)");
                    else
                        System.out.println("\t[4] Munchy Toppings ($1.80)");
                }
            }
            System.out.print("User Input: ");
            String choice = keyboard.nextLine().toUpperCase().trim();
            //Topping menu
            switch (choice) {
                case "1" -> {
                    toStringRegularToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int regToppingChoice = keyboard.nextInt();
                    sandwich.sandwichToppings.add(regularToppings.get(regToppingChoice - 1));
                    keyboard.nextLine();
                    anotherTopping(sandwich);
                }
                case "2" -> {
                    toStringMeatToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int meatToppingChoice = keyboard.nextInt();
                    for (Toppings toppings : sandwich.sandwichToppings) {
                        if (toppings.isMeat) {
                            premiumMeatToppings.get(meatToppingChoice - 1).setExtraMeat(true);
                            break;
                        }
                    }
                    sandwich.sandwichToppings.add((premiumMeatToppings.get(meatToppingChoice - 1)));
                    keyboard.nextLine();
                    anotherTopping(sandwich);
                }
                case "3" -> {
                    toStringCheeseToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int cheeseToppingChoice = keyboard.nextInt();
                    for (Toppings toppings : sandwich.sandwichToppings) {
                        if (toppings.isCheese) {
                            premiumCheeseToppings.get(cheeseToppingChoice - 1).setExtraCheese(true);
                            break;
                        }
                    }
                    sandwich.sandwichToppings.add((premiumCheeseToppings.get(cheeseToppingChoice - 1)));
                    keyboard.nextLine();
                    anotherTopping(sandwich);
                }
                case "4" -> {
                    toStringMunchyToppings();
                    System.out.print("\nPlease enter the # of your topping choice: ");
                    int munToppingChoice = keyboard.nextInt();
                    for (Toppings toppings : sandwich.sandwichToppings) {
                        if (toppings.isMunchy) {
                            munchyToppings.get(munToppingChoice - 1).setExtraMunchy(true);
                            break;
                        }
                    }
                    sandwich.sandwichToppings.add((munchyToppings.get(munToppingChoice - 1)));
                    keyboard.nextLine();
                    anotherTopping(sandwich);
                }
                case "5" -> System.out.println("\nExiting Toppings Selection.");
                default -> {
                    System.out.println("\nRuh-Roh! That's not a valid option. Please try again.");
                    toppingsMenu(sandwich);
                }
            }
        } catch (Exception inputError) {
            System.out.println("\nThere seems to have been an issue with your input, please try again!");
            inputError.printStackTrace();
            toppingsMenu(sandwich);
        }
    }

    public static void anotherTopping(Sandwich sandwich) {
        System.out.println("\nWould you like to add another topping? (1 or 2)");
        System.out.print("\t[1] Yes\n\t[2] No\nUser Input: ");
        String response = keyboard.nextLine();
        switch (response) {
            case "1" -> toppingsMenu(sandwich);
            case "2" -> {
            }
            default -> {
                System.out.println("\nZoinks! That's not a valid option. Please try again.");
                anotherTopping(sandwich);
            }
        }
    }

    public static void addDrink() {
        try {
            System.out.println("\nWhat size drink would you like? (1, 2, or 3)");
            System.out.print("\t[1] Small ($2.00)\n\t[2] Medium($2.50)\n\t[3] Large($3.00)\nUser Input: ");
            String drinkSizeChoice = keyboard.nextLine().trim(), size = "";
            switch (drinkSizeChoice) {
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
            String flavourChoice = (drinkFlavors.get((Integer.parseInt(keyboard.nextLine().trim())) - 1)).getDrinkFlavor();
            System.out.print("\nWould you like ice? (1 or 2)");
            System.out.print("\n\t[1] Yes\n\t[2] No\nUser Input: ");
            String iceChoice = keyboard.nextLine().trim();
            boolean hasIce = true;
            switch (iceChoice) {
                case "1" -> {
                }
                case "2" -> hasIce = false;
                default -> {
                    System.out.println("\nRuh-Roh! That's not a valid option. Please try again.");
                    addDrink();
                }
            }
            Drink newDrink = new Drink(size, flavourChoice, hasIce);
            addToCart(newDrink);
            System.out.println("\nDrink successfully added! Now returning to the main menu.");
            orderScreen();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid option! Returning to drink menu.");
            addDrink();
        }
    }

    public static void addChips() {
        try {
            toStringChipFlavors();
            System.out.print("\nPlease enter the # of your chip choice: ");
            String chipChoice = (chipFlavors.get((Integer.parseInt(keyboard.nextLine().trim())) - 1)).getChipType();
            Chips chips = new Chips(chipChoice);
            addToCart(chips);
            System.out.println("\nChips successfully added! Now returning to the main menu.");
            orderScreen();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid option! Returning to drink menu.");
            addDrink();
        }
    }

    public static void addToCart(Item newItem) {
        cart.add(newItem);
    }

    public static void checkOut() {
        displayOrderDetails(cart);
    }
}