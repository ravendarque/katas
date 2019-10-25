package com.ravendarque.unitTests;

import com.ravendarque.rails.Rail;
import com.ravendarque.rails.RailEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RailShould {

    private static final double DUMMY_PRICE_1 = 1;
    private static final int DUMMY_CAPACITY_1 = 1;
    private static final int DUMMY_INVENTORY_0 = 0;
    private static final String DUMMY_LABEL = "Dummy label";

    private static final int TEST_INVENTORY_0 = 0;
    private static final int TEST_INVENTORY_1 = 1;

    @Test
    void returnTrueWhenCheckingIfRailWithNoItemsIsEmpty() {

        final Rail testRail = new Rail(DUMMY_CAPACITY_1, DUMMY_INVENTORY_0, DUMMY_PRICE_1, DUMMY_LABEL);

        final boolean railIsEmpty = testRail.isEmpty();

        assertTrue(railIsEmpty);
    }

    @Test
    void returnFalseWhenCheckingIfRailWithNoItemsCanVend() {

        final Rail testRail = new Rail(DUMMY_CAPACITY_1, DUMMY_INVENTORY_0, DUMMY_PRICE_1, DUMMY_LABEL);

        final boolean railIsEmpty = testRail.canVendItem();

        assertFalse(railIsEmpty);
    }

    @Test
    void returnFalseWhenCheckingIfRailWithOneItemIsEmpty() {

        final Rail testRail = new Rail(DUMMY_CAPACITY_1, TEST_INVENTORY_1, DUMMY_PRICE_1, DUMMY_LABEL);

        final boolean railIsEmpty = testRail.isEmpty();

        assertFalse(railIsEmpty);
    }

    @Test
    void returnTrueWhenCheckingIfRailIsEmptyAfterLastItemHasBeenVended()
            throws RailEmptyException {

        final Rail testRail = new Rail(DUMMY_CAPACITY_1, TEST_INVENTORY_1, DUMMY_PRICE_1, DUMMY_LABEL);
        testRail.vendItem();

        final boolean railIsEmpty = testRail.isEmpty();

        assertTrue(railIsEmpty);
    }

    @Test
    void provideAPrice() {

        final double expectedRailPrice = 1;

        final double testRailPrice = 1;
        final Rail testRail = new Rail(DUMMY_CAPACITY_1, DUMMY_INVENTORY_0, testRailPrice, DUMMY_LABEL);

        final double actualRailPrice = testRail.getPrice();

        assertEquals(expectedRailPrice, actualRailPrice);
    }

    @Test
    void vendItemAndDecrementRailInventory()
            throws RailEmptyException {

        final Rail testRail = new Rail(DUMMY_CAPACITY_1, TEST_INVENTORY_1, DUMMY_PRICE_1, DUMMY_LABEL);
        testRail.vendItem();

        final boolean railIsEmpty = testRail.isEmpty();

        assertTrue(railIsEmpty);
    }

    @Test
    void throwExceptionOnVendWhenRailIsEmpty() {

        final Rail rail = new Rail(DUMMY_CAPACITY_1, TEST_INVENTORY_0, DUMMY_PRICE_1, DUMMY_LABEL);

        assertThrows(RailEmptyException.class, rail::vendItem);
    }

    @Test
    void returnFalseWhenCheckingIfARailWithNoItemsCanVend() {

        final Rail rail = new Rail(DUMMY_CAPACITY_1, TEST_INVENTORY_0, DUMMY_PRICE_1, DUMMY_LABEL);

        final boolean actualResult = rail.canVendItem();

        assertFalse(actualResult);
    }

    @Test
    void returnTrueWhenCheckingIfARailWithOneItemCanVend() {

        final Rail rail = new Rail(DUMMY_CAPACITY_1, TEST_INVENTORY_1, DUMMY_PRICE_1, DUMMY_LABEL);

        final boolean actualResult = rail.canVendItem();

        assertTrue(actualResult);
    }

    @Test
    void provideALabel() {

        final String expectedLabel = "Test label";

        final String testLabel = "Test label";
        final Rail testRail = new Rail(DUMMY_CAPACITY_1, DUMMY_INVENTORY_0, DUMMY_PRICE_1, testLabel);

        final String actualLabel = testRail.getLabel();

        assertEquals(expectedLabel, actualLabel);
    }

    @Test
    void throwExceptionWhenInitialInventoryIsGreaterThanRailCapacity() {

        final int testCapacity = 1;
        final int testInitialInventory = 2;

        assertThrows(IllegalArgumentException.class, () -> new Rail(
                testCapacity, testInitialInventory, DUMMY_PRICE_1, DUMMY_LABEL));
    }

    @Test
    void throwExceptionWhenPriceIsNegative() {

        final double testPrice = -1;

        assertThrows(IllegalArgumentException.class, () -> new Rail(
                DUMMY_CAPACITY_1, DUMMY_INVENTORY_0, testPrice, DUMMY_LABEL));
    }
}