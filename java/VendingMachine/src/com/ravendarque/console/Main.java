package com.ravendarque.console;

import com.ravendarque.vendingMachine.credit.Credit;
import com.ravendarque.vendingMachine.rails.Rails;
import com.ravendarque.vendingMachine.rails.RailsConfiguration;
import com.ravendarque.vendingMachine.rails.RailsConfigurationBuilder;
import com.ravendarque.vendingMachine.rails.RailConfigurationSettings;
import com.ravendarque.vendingMachine.vending.VendingMachine;

import java.io.Console;
import java.util.Map;

import static java.lang.System.console;

public class Main {

    public static void main(String[] args) {

        Rails rails = new Rails(getRailConfiguration());
        Credit credit = new Credit();
        VendingMachine vendingMachine = new VendingMachine(rails, credit);

        displaySummary(vendingMachine.getRailsSummary());

        final Console console = console();
        final String choice = console.readLine();

        if (vendingMachine.canSelectRail(choice)) {
            vendingMachine.selectRail(choice);
        } else {
            System.out.println("Invalid selection");
        }

    }

    private static void displaySummary(Map<String, String> railsSummary) {

        railsSummary.forEach((key, value) -> System.out.println(key + " " + value));
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

        final int railCapacity = 10;
        final int initialInventory = 10;
        return new RailConfigurationSettings(railCode, railCapacity, price, initialInventory, label);
    }
}
