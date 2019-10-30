package com.ravendarque.console;

import com.ravendarque.vendingMachine.credit.Credit;
import com.ravendarque.vendingMachine.rails.RailConfigurationSettings;
import com.ravendarque.vendingMachine.rails.Rails;
import com.ravendarque.vendingMachine.rails.RailsConfiguration;
import com.ravendarque.vendingMachine.rails.RailsConfigurationBuilder;
import com.ravendarque.vendingMachine.vending.VendingMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

class Main {

    public static void main(String[] args)
            throws IOException {

        Rails rails = new Rails(getRailConfiguration());
        Credit credit = new Credit();
        VendingMachine vendingMachine = new VendingMachine(rails, credit);

        displaySummary(vendingMachine.getRailsSummary());

        final String railCode = readLine();

        if (vendingMachine.canSelectRail(railCode)) {
            vendingMachine.selectRail(railCode);
        } else {
            System.out.println("Invalid selection");
        }

    }

    private static void displaySummary(Map<String, String> railsSummary) {

        railsSummary.forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println("\n");
        System.out.println("Selection> ");
    }

    private static RailsConfiguration getRailConfiguration() {

        return new RailsConfigurationBuilder()
                .add(getRailConfigurationSettings("A1", 0.60, "Coke"))
                .add(getRailConfigurationSettings("A2", 0.70, "Twix"))
                .add(getRailConfigurationSettings("A3", 0.80, "Water"))
                .add(getRailConfigurationSettings("A4", 0.90, "Hula hoops"))
                .build();
    }

    private static RailConfigurationSettings getRailConfigurationSettings(String railCode, double price, String label) {

        final int initialInventory = 10;
        return new RailConfigurationSettings(railCode, price, initialInventory, label);
    }

    private static String readLine()
            throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        }
    }
}
