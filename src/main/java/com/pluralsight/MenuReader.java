package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import static com.pluralsight.Toppings.*;
import static com.pluralsight.Drink.*;
import static com.pluralsight.Chips.*;
import static com.pluralsight.UserInterface.homeScreen;

public class MenuReader {
    public static void menuReader(){
        try{
            FileReader fr = new FileReader("src/main/resources/Menu.csv");
            BufferedReader br = new BufferedReader(fr);
            String tempInfo = "";
            boolean isFirst = true;
            int temp = 0;
            while((tempInfo = br.readLine()) != null){
                String[] splitLine = tempInfo.split("\\|");
                switch(temp){
                    case 0:
                        isFirst = true;
                        for(String newTopping: splitLine){
                            if(!isFirst){
                                Toppings newRegularTopping = new Toppings(newTopping, "small", false, false, false, false, false, false);
                                regularToppings.add(newRegularTopping);
                            }
                            else
                                isFirst = false;
                        }
                        temp++;
                        break;
                    case 1:
                        isFirst = true;
                        for(String newTopping: splitLine){
                            if(!isFirst){
                                Toppings newMeatTopping = new Toppings(newTopping, "small", true, false, false, false, false, false);
                                premiumMeatToppings.add(newMeatTopping);
                            }
                            else
                                isFirst = false;
                        }
                        temp++;
                        break;
                    case 2:
                        isFirst = true;
                        for(String newTopping: splitLine){
                            if(!isFirst){
                                Toppings newCheeseTopping = new Toppings(newTopping, "small", false, false, true, false, false, false);
                                premiumCheeseToppings.add(newCheeseTopping);
                            }
                            else
                                isFirst = false;
                        }
                        temp++;
                        break;
                    case 3:
                        isFirst = true;
                        for(String newTopping: splitLine){
                            if(!isFirst){
                                Toppings newMunchyTopping = new Toppings(newTopping, "small", false, false, false, false, true, false);
                                munchyToppings.add(newMunchyTopping);
                            }
                            else
                                isFirst = false;
                        }
                        temp++;
                        break;
                    case 4:
                        isFirst = true;
                        for(String drinkName: splitLine){
                            if(!isFirst){
                                Drink newDrink = new Drink(drinkName);
                                drinkFlavors.add(newDrink);
                            }
                            else
                                isFirst = false;
                        }
                        temp++;
                        break;
                    case 5:
                        isFirst = true;
                        for(String chipName: splitLine){
                            if(!isFirst){
                                Chips newChips = new Chips(chipName);
                                chipFlavors.add(newChips);
                            }
                            else
                                isFirst = false;
                        }
                        temp++;
                        break;
                }
            }
            homeScreen();
        }
        catch(Exception fileError){
            System.out.println("There seems to have been an issue with the current file path. Please try again.");
            fileError.printStackTrace();
        }
    }
}
