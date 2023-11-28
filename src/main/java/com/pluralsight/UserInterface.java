package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;


import static com.pluralsight.Toppings.*;

public class UserInterface {
    public static void main(String[] args) {

    }

    public static void homeScreen(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Scooby's Snack Shack! How may we serve you today?" );
        System.out.println("[1] New order");
        System.out.println("[2] Exit");

        int selection = keyboard.nextInt();

        switch (selection) {
            case 1:
                orderScreen();
                break;
            case 2:
                System.out.println("Have a great day! Come back and see us!");
                System.exit(0);
                break;

            default:
                System.out.println("Zoinks! That's not a valid selection. Please select 1 or 2.");
        }



    }


    public static void orderScreen(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What would you like to order?");
        System.out.println("[1] add sandwich");
        System.out.println("[2] add drink");
        System.out.println("[3] add chips");
        System.out.println("[4] checkout");
        System.out.println("[0] cancel order");

        int selection = keyboard.nextInt();


        switch (selection) {
            case 1:
                //insert method to add sandwich
                addSandwich();
                break;
            case 2:
                //insert method to add drink
                addDrink();
                break;
            case 3:
                addChips();
                //insert method to add chips
            case 4:
                checkOut();
                break;

            case 0:
                homeScreen();
                break;
            default:
                System.out.println("Zoinks! That's not a valid selection.");
        }





    }

    public static void addSandwich(){
        ArrayList<Toppings> toppings = new ArrayList<>();

        Scanner keyboard = new Scanner(System.in);

        System.out.println(" What size sandwich in would you like; small(4inch), medium(8inch), or 12 inch?");
        System.out.println(" 1) small (4 inch)");
        System.out.println(" 2) medium (8 inch)");
        System.out.println(" 3) large (12 inch)");

        int sandwichSize = keyboard.nextInt();
        String size = "";
            switch(sandwichSize){
                case 1:
                    //small
                    size = "small";
                    break;
                case 2:
                    //medium
                    size = "medium";
                    break;
                case 3:
                    //large
                    size ="large";
                    break;

                default:
                    System.out.println("That's not a valid size. Please try again.");
            }


        System.out.println("What type of bread would you like?");
        String breadType = keyboard.next().trim().toUpperCase();

        System.out.println("Would you like your sandwich toasted([1]Yes or [2]No)?");
        String toasted = keyboard.next().trim().toUpperCase();
        boolean isToasted = true;
        switch(toasted){
            case "1":
                break;
            case "2":
                isToasted = false;
            default:
                System.out.println("Please enter 1 or 2.");
        }



        //Prompt user for toppings to use
        System.out.println("Would you like Toppings([1]Yes or [2]No)?");
        String response = keyboard.nextLine().toUpperCase().trim();

        switch(response){
            case "1":
                ToppingsMenu(toppings);
                break;
            case "2":
                System.out.println("Proceeding with no toppings.");
                break;

            default:
                System.out.println("Jinkies! That's not a valid option.");
        }

        Sandwich sandwich = new Sandwich(breadType,size,toppings, isToasted);

        addToCart(sandwich);

    }

     public static void ToppingsMenu(ArrayList<Toppings> newToppings){

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        String choice = keyboard.nextLine().toUpperCase().trim();
        //Topping menu

        switch(choice){
            case "1":

                toStringRegularToppings();
                System.out.println("Please enter # of topping choice: ");
                int regToppingChoice = keyboard.nextInt();
                newToppings.add(regularToppings.get(regToppingChoice-1));
                break;

            case "2":

                toStringPremiumToppings();
                System.out.println("Please enter # of topping choice: ");
                int PremToppingChoice = keyboard.nextInt();
                newToppings.add((premiumToppings.get(PremToppingChoice-1)));
                break;

            case "3":

                toStringMunchyToppings();
                System.out.println("Please enter # of topping choice: ");
                int MunToppingChoice = keyboard.nextInt();
                newToppings.add((munchyToppings.get(MunToppingChoice-1)));
                break;

            case"4":
                System.out.println("Exiting Toppings Selection.");
                break;


            default:
                System.out.println("Ruh-Roh! That's not a valid option.");

        }


            anotherTopping(newToppings);



     }

    public static void anotherTopping(ArrayList<Toppings> anotherTopping) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to add another topping? ([1]Yes or [2]No)");
        String response = keyboard.nextLine();


        switch (response) {
            case "1":
                ToppingsMenu(anotherTopping);
                break;
            case "2":
                break;

            default:
                System.out.println("Please enter valid selection.");
        }


    }






    public static void addDrink(){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("What size drink would you like?");
        String drinkSize = keyboard.next().toUpperCase().trim();

        System.out.println("What flavor drink would you like?");
        String flavour = keyboard.next().toUpperCase().trim();

        System.out.println("Would you like ice?([1]Yes or [2]No)");
        String response = keyboard.nextLine().toUpperCase().trim();
        boolean ice = true;
        switch(response){
            case"1":
                break;
            case "2":
                ice = false;
            default:
                System.out.println("Please enter 1 or 2.");
        }


       // Drink drink = new Drink(flavour,drinkSize, ice, )
        // addToCart(drink);
    }

    public static void addChips(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What kind of chips would you like?");
        String chipType = keyboard.next().toUpperCase().trim();


        Chips chips = new Chips(chipType);

        addToCart(chips);

    }

    public static void addToCart(Item newItem){
        cart.add(newItem);


    }


    public static void checkOut(){


    }





}