package com.ravendarque.unitTests;

import com.ravendarque.vendingMachine.rails.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RailsShould {

    private static final String TEST_RAIL_CODE = "T1";

    @Test
    void returnFalseWhenCheckingIfNonexistentRailCanBeSelected() {

        final String testNonExistentRailCode = "XX";

        assertFalse(getTestRails().canSelectRail(testNonExistentRailCode));
    }

    @Test
    void returnTrueWhenCheckingIfExistentRailCanBeSelected() {

        assertTrue(getTestRails().canSelectRail(TEST_RAIL_CODE));
    }

    @Test
    void selectRailByRailCode() {

        final String expectedLabel = "Test label";

        final Rails testRails = getTestRails();
        testRails.selectRail(TEST_RAIL_CODE);

        final Rail actualSelectedRail = testRails.getSelectedRail();

        assertEquals(expectedLabel, actualSelectedRail.getLabel());
    }

    @Test
    void returnRailsSummary() {

        final String expectedRailLabel = "Test label";

        Rails testRails = getTestRails();
        Map<String, String> actualRailsSummary = testRails.getRailsSummary();

        assertEquals(actualRailsSummary.get(TEST_RAIL_CODE), expectedRailLabel);
    }

    private Rails getTestRails() {

        final int testPrice = 1;
        final int dummyInitialInventory = 1;
        final String testLabel = "Test label";

        final RailsConfiguration railConfiguration = new RailsConfigurationBuilder()
                .add(new RailConfigurationSettings(
                        TEST_RAIL_CODE,
                        testPrice,
                        dummyInitialInventory,
                        testLabel))
                .build();

        return new Rails(railConfiguration);
    }
}
