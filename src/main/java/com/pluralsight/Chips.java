package com.pluralsight;

import java.util.ArrayList;

public class Chips extends Item {
    protected String chipType;

    ArrayList<Chips> chipFlavors;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    public void toStringChipFlavors() {
        int temp = 1;
        System.out.println("List of Chip Flavors: ");
        for(Chips flavors: chipFlavors){
            System.out.println(temp + ".) " + flavors.getChipType());
        }
    }

    @Override
    public double getPrice() {
        if (chipType != null && !chipType.isEmpty()) {
                return 1.50;
        } else {
        return 0.0;
        }
    }
}