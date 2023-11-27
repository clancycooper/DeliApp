package com.pluralsight;

public class Chips implements ItemFunctions {
    protected String chipType;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
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
