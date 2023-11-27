package com.pluralsight;

import java.util.Scanner;

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
            case 2:
                //insert method to add drink
            case 3:
                //insert method to add chips

        }





    }

    public static void addSandwich(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What size sandwich in would you like; 4inch, 8inch, or 12 inch?");
        int sandwichSize = keyboard.nextInt();

        System.out.println("What type of bread would you like?");
        String breadType = keyboard.next().trim().toUpperCase();

        //Prompt user for toppings to use


        System.out.println("Would you like your sandwich toasted(Yes or No)?");
        String toasted = keyboard.next().trim().toUpperCase();

    }




    public static void addDrink(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What size drink would you like?");
        String drinkSize = keyboard.next().toUpperCase().trim();

        System.out.println("What flavor drink would you like?");
        String flavour = keyboard.next().toUpperCase().trim();

    }

    public static void addChips(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What kind of chips would you like?");
        String chipType = keyboard.next().toUpperCase().trim();



    }


    public static void checkOut(){


    }





}