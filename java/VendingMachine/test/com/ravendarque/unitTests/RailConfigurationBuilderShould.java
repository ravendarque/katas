package com.ravendarque.unitTests;

import com.ravendarque.vendingMachine.rails.RailsConfiguration;
import com.ravendarque.vendingMachine.rails.RailsConfigurationBuilder;
import com.ravendarque.vendingMachine.rails.RailConfigurationSettings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RailConfigurationBuilderShould {

    @Test
    void buildConfiguration() {

        String dummyRailCode = "T1";
        int dummyCapacity = 10;
        double dummyPrice = 1;
        int dummyInitialInventory = 10;
        String dummyLabel = "Dummy label";

        RailConfigurationSettings railConfigurationSettings = new RailConfigurationSettings(
                dummyRailCode, dummyCapacity, dummyPrice, dummyInitialInventory, dummyLabel);

        RailsConfiguration railConfiguration = new RailsConfigurationBuilder()
                .add(railConfigurationSettings)
                .build();

        assertEquals(railConfigurationSettings, railConfiguration.getConfigurations()
                                                                 .get(0));
    }

}
