package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import static com.pluralsight.Item.getTotal;
import static com.pluralsight.UserInterface.homeScreen;

//Clancy and Andi
//Erik added temp++ and collections.sort

public class ReceiptManager {
    private static final String FILE_DIRECTORY = "src/main/resources/Receipts/";
    static DecimalFormat df = new DecimalFormat("#.00");

    public static void displayOrderDetails(ArrayList<Item> cart) {
        Collections.sort(cart, (Item i1, Item i2) -> {
            return i1.getClass().toString().compareToIgnoreCase(i2.getClass().toString());
        });
        int sandTemp = 1, drinkTemp = 1, chipsTemp = 1;
        System.out.println("\nPlease review your order, and type CONFIRM or CANCEL below.");
        System.out.println("\nYour Order: ");
        for (Item item : cart) {
            if (item.getClass().toString().equals("class com.pluralsight.Sandwich")) {
                System.out.println("\nSandwich " + sandTemp + ".) \n\t" + item);
                sandTemp++;
            } else if (item.getClass().toString().equals("class com.pluralsight.Drink")) {
                System.out.println("\nDrink " + drinkTemp + ".) \n\t" + item);
                drinkTemp++;
            } else {
                System.out.println("\nChips " + chipsTemp + ".) \n\t" + item);
                chipsTemp++;
            }

        }
        System.out.print("Your Order Total $" + df.format(getTotal()) + "\nUser Input:");
        Scanner scanner = new Scanner(System.in);
        String checkoutChoice = scanner.nextLine().toUpperCase().trim();
        if (checkoutChoice.equals("CONFIRM")) {
            saveReceipt(cart);
        } else if (checkoutChoice.equals("CANCEL")) {
            System.out.println("\nThank you for visiting Scooby's Snack Shack! Like come back again real soon! Scooby Dooby Doo!~ ");
            homeScreen();
        } else {
            System.out.println("\nZoinks! Could not process entry, please try again.");
            displayOrderDetails(cart);
        }
    }

    public static void saveReceipt(ArrayList<Item> cart) {
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
            writer.newLine();
            for (Item item : cart) {
                if (item.getClass().toString().equals("class com.pluralsight.Sandwich")) {
                    writer.newLine();
                    writer.write("Sandwich " + sandTemp + ".) \n\t" + item);
                    sandTemp++;
                } else if (item.getClass().toString().equals("class com.pluralsight.Drink")) {
                    writer.newLine();
                    writer.write("Drink " + drinkTemp + ".) \n\t" + item);
                    drinkTemp++;
                } else {
                    writer.newLine();
                    writer.write("Chips " + chipsTemp + ".) \n\t" + item);
                    chipsTemp++;
                }

            }
            writer.newLine();
            writer.write("Your Order Total $" + df.format(getTotal()));
            writer.newLine();
            writer.write("Thank you for shopping at Scooby's Snack Shack! Please come again soon!");
            System.out.println("\nLike thank you for your purchase!\n\nReceipt generated successfully: " + fileName);
        } catch (IOException e) {
            System.err.println("\nError generating receipt: " + e.getMessage());
        }
        homeScreen();
    }
}