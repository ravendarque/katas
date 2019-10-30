package com.ravendarque.unitTests;

import com.ravendarque.vendingMachine.rails.Rail;
import com.ravendarque.vendingMachine.rails.RailEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RailShould {

    private static final double DUMMY_PRICE_1 = 1;
    private static final int DUMMY_INVENTORY_0 = 0;
    private static final String DUMMY_LABEL = "Dummy label";

    private static final int TEST_INVENTORY_0 = 0;
    private static final int TEST_INVENTORY_1 = 1;

    @Test
    void returnTrueWhenCheckingIfRailWithNoItemsIsEmpty() {

        final Rail testRail = new Rail(DUMMY_INVENTORY_0, DUMMY_PRICE_1, DUMMY_LABEL);

        final boolean railIsEmpty = testRail.isEmpty();

        assertTrue(railIsEmpty);
    }

    @Test
    void returnFalseWhenCheckingIfRailWithOneItemIsEmpty() {

        final Rail testRail = new Rail(TEST_INVENTORY_1, DUMMY_PRICE_1, DUMMY_LABEL);

        final boolean railIsEmpty = testRail.isEmpty();

        assertFalse(railIsEmpty);
    }

    @Test
    void returnTrueWhenCheckingIfRailIsEmptyAfterLastItemHasBeenVended()
            throws RailEmptyException {

        final Rail testRail = new Rail(TEST_INVENTORY_1, DUMMY_PRICE_1, DUMMY_LABEL);
        testRail.vend();

        final boolean railIsEmpty = testRail.isEmpty();

        assertTrue(railIsEmpty);
    }

    @Test
    void provideAPrice() {

        final double expectedRailPrice = 1;

        final double testRailPrice = 1;
        final Rail testRail = new Rail(DUMMY_INVENTORY_0, testRailPrice, DUMMY_LABEL);

        final double actualRailPrice = testRail.getPrice();

        assertEquals(expectedRailPrice, actualRailPrice);
    }

    @Test
    void throwExceptionOnVendWhenRailIsEmpty() {

        final Rail rail = new Rail(TEST_INVENTORY_0, DUMMY_PRICE_1, DUMMY_LABEL);

        assertThrows(RailEmptyException.class, rail::vend);
    }

    @Test
    void provideALabel() {

        final String expectedLabel = "Test label";

        final String testLabel = "Test label";
        final Rail testRail = new Rail(DUMMY_INVENTORY_0, DUMMY_PRICE_1, testLabel);

        final String actualLabel = testRail.getLabel();

        assertEquals(expectedLabel, actualLabel);
    }

    @Test
    void throwExceptionWhenPriceIsNegative() {

        final double testPrice = -1;

        assertThrows(IllegalArgumentException.class, () -> new Rail(
                DUMMY_INVENTORY_0, testPrice, DUMMY_LABEL));
    }
}
