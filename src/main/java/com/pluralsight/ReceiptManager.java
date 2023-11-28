package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.UserInterface.homeScreen;

public class ReceiptManager {
    private static final String FILE_DIRECTORY = "src/main/resources/Receipts/";

    public static void displayOrderDetails(ArrayList<Item> cart) {
        //confirm order and save receipt
        //or cancel order and return to homeScreen
        ArrayList<Item> order = cart;
        System.out.println("Please review your order, and type CONFIRM or CANCEL below.");
        for (Item item : order) {
            System.out.println("- " + item.toString());
        }
        Scanner scanner = new Scanner(System.in);
        String checkoutChoice = scanner.nextLine().toUpperCase().trim();
        if (checkoutChoice.equals("CONFIRM")) {
            saveReceipt(cart);
        }
        else if (checkoutChoice.equals("CANCEL")){
            System.out.println("Thank you for visiting Scooby's Snack Shack! Like come back again real soon! Scooby Dooby Doo!~ ");
            homeScreen();
        }
        else {
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write header and order details to the receipt file
            writer.write("Order Receipt");
            writer.newLine();
            writer.write("Date: " + timeStamp);
            writer.newLine();
            writer.newLine();
            //need a getTotal Method in Item class

            for (Item item : receipt) {
                writer.write("- " + item.toString());
                writer.newLine();
            }

            System.out.println("Receipt generated successfully: " + fileName);
        } catch (IOException e) {
            System.err.println("Error generating receipt: " + e.getMessage());
        }
        homeScreen();
    }

}