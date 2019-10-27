package com.ravendarque.unitTests;

import com.ravendarque.vendingMachine.rails.*;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Map.Entry;

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

    @Test
    void returnAllRailCodesAndLabels() {

        final String expectedRailLabel = "Test label";

        Rails testRails = getTestRails();
        Map<String, String> actualRailsSummary = testRails.getRailsSummary();

        for (Entry<String, String> summaryEntry : actualRailsSummary.entrySet()) {
            assertEquals(TEST_RAIL_CODE, summaryEntry.getKey());
            assertEquals(expectedRailLabel, summaryEntry.getValue());
        }
    }

    private Rails getTestRails() {

        final int dummyCapacity = 1;
        final int testPrice = 1;
        final int dummyInitialInventory = 1;
        final String testLabel = "Test label";

        final RailsConfiguration railConfiguration = new RailsConfigurationBuilder()
                .add(new RailConfigurationSettings(
                        TEST_RAIL_CODE,
                        dummyCapacity,
                        testPrice,
                        dummyInitialInventory,
                        testLabel))
                .build();

        return new Rails(railConfiguration);
    }
}
