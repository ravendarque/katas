package com.ravendarque.rails;

public class RailConfigurationSettings {

    private final String railCode;
    private final int railCapacity;
    private final double railPrice;
    private final int initialInventory;
    private final String label;

    public RailConfigurationSettings(
            String railCode, int railCapacity, double railPrice, int initialInventory, String label) {

        this.railCode = railCode;
        this.railCapacity = railCapacity;
        this.railPrice = railPrice;
        this.initialInventory = initialInventory;
        this.label = label;
    }

    String getLabel() {

        return label;
    }

    int getInitialInventory() {

        return initialInventory;
    }

    int getCapacity() {

        return railCapacity;
    }

    String getRailCode() {

        return railCode;
    }

    double getPrice() {

        return railPrice;
    }

}
