package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import static com.pluralsight.Sandwich.sandwichToString;
import static com.pluralsight.Item.getTotal;
import static com.pluralsight.UserInterface.homeScreen;

public class ReceiptManager {
    private static final String FILE_DIRECTORY = "src/main/resources/Receipts/";

    public static void displayOrderDetails(ArrayList<Item> cart) {
        //confirm order and save receipt
        //or cancel order and return to homeScreen
        Collections.sort(cart, (Item i1, Item i2) ->{
            return i1.getClass().toString().compareToIgnoreCase(i2.getClass().toString());
        });
        ArrayList<Item> order = cart;
        int sandTemp = 1, drinkTemp = 1, chipsTemp = 1;
        System.out.println("\nPlease review your order, and type CONFIRM or CANCEL below.");
        System.out.println("\nYour Order: ");
        for (Item item : order) {
            if(item.getClass().toString().equals("class com.pluralsight.Sandwich")){
                System.out.println("\nSandwich " + sandTemp + ".) \n\t" + sandwichToString(item));
                sandTemp++;
            }
            else if(item.getClass().toString().equals("class com.pluralsight.Drink")){
                System.out.println("\nDrink " + drinkTemp + ".) \n\t" + item.toString());
                drinkTemp++;
            }
            else{
                System.out.println("\nChips " + chipsTemp + ".) \n\t" + item.toString());
                chipsTemp++;
            }

        }
        System.out.println("Your Order Total $" + getTotal());
        Scanner scanner = new Scanner(System.in);
        String checkoutChoice = scanner.nextLine().toUpperCase().trim();
        if (checkoutChoice.equals("CONFIRM")) {
            saveReceipt(cart);
        } else if (checkoutChoice.equals("CANCEL")) {
            System.out.println("Thank you for visiting Scooby's Snack Shack! Like come back again real soon! Scooby Dooby Doo!~ ");
            homeScreen();
        } else {
            System.out.println("Zoinks! Could not process entry, please try again.");
            displayOrderDetails(cart);
        }
    }

    public static void saveReceipt(ArrayList<Item> cart) {
        //getCart method in Item class
        ArrayList<Item> receipt = cart;
        // Generate timestamp for the filename
        String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String fileName = FILE_DIRECTORY + timeStamp + ".txt";
        int sandTemp = 1, drinkTemp = 1, chipsTemp = 1;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Order Receipt");
            writer.newLine();
            writer.write("Date: " + timeStamp);
            writer.newLine();
            writer.newLine();
            writer.write("Your Order: ");
            for (Item item : receipt) {
                if(item.getClass().toString().equals("class com.pluralsight.Sandwich")){
                    writer.newLine();
                    writer.write("Sandwich " + sandTemp + ".) \n\t" + sandwichToString(item));
                    sandTemp++;
                }
                else if(item.getClass().toString().equals("class com.pluralsight.Drink")){
                    writer.newLine();
                    writer.write("Drink " + drinkTemp + ".) \n\t" + item.toString());
                    drinkTemp++;
                }
                else{
                    writer.newLine();
                    writer.write("Chips " + chipsTemp + ".) \n\t" + item.toString());
                    chipsTemp++;
                }

            }
            writer.newLine();
            writer.newLine();
            writer.write("Your Order Total $" + getTotal());
            System.out.println("Receipt generated successfully: " + fileName);
        } catch (IOException e) {
            System.err.println("Error generating receipt: " + e.getMessage());
        }
        homeScreen();
    }
}