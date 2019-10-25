package com.ravendarque.unitTests;

import com.ravendarque.rails.Rail;
import com.ravendarque.rails.RailConfiguration;
import com.ravendarque.rails.RailConfigurationSettings;
import com.ravendarque.rails.Rails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RailsShould {

    private static final String TEST_RAIL_CODE = "T1";

    @Test
    void selectRailByRailCode() {

        final int expectedPrice = 1;
        final String expectedLabel = "Test label";

        final Rails testRails = getTestRails();
        testRails.selectRail(TEST_RAIL_CODE);

        final Rail actualSelectedRail = testRails.getSelectedRail();

        assertEquals(expectedPrice, actualSelectedRail.getPrice());
        assertEquals(expectedLabel, actualSelectedRail.getLabel());
    }

    private Rails getTestRails() {

        final int dummyCapacity = 1;
        final int testPrice = 1;
        final int dummyInitialInventory = 1;
        final String testLabel = "Test label";

        final RailConfigurationSettings testRailConfigurationSettings = new RailConfigurationSettings(
                TEST_RAIL_CODE, dummyCapacity, testPrice, dummyInitialInventory, testLabel);

        final RailConfiguration railConfiguration = new RailConfiguration();
        railConfiguration.addRailConfigurationSettings(testRailConfigurationSettings);

        return new Rails(railConfiguration);
    }
}
