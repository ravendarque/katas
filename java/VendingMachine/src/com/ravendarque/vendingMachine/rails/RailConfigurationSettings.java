package com.ravendarque.vendingMachine.rails;

public class RailConfigurationSettings {

    private final String railCode;
    private final double price;
    private final int initialInventory;
    private final String label;

    public RailConfigurationSettings(
            String railCode, double price, int initialInventory, String label) {

        this.railCode = railCode;
        this.price = price;
        this.initialInventory = initialInventory;
        this.label = label;
    }

    String getLabel() {

        return label;
    }

    int getInitialInventory() {

        return initialInventory;
    }

    String getRailCode() {

        return railCode;
    }

    double getPrice() {

        return price;
    }

}
