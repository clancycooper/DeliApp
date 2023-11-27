package com.pluralsight;

public class Chips extends Item {
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
