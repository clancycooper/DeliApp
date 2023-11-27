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
        int size = keyboard.nextInt();

        System.out.println("What type of bread would you like?");
        String breadType = keyboard.next().trim().toLowerCase();





    }




    public static void addDrink(){



    }

    public static void addChips(){


    }


    public static void checkOut(){


    }





}