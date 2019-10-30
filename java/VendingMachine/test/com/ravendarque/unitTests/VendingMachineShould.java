package com.ravendarque.unitTests;

import com.ravendarque.vendingMachine.credit.Credit;
import com.ravendarque.vendingMachine.rails.RailConfigurationSettings;
import com.ravendarque.vendingMachine.rails.Rails;
import com.ravendarque.vendingMachine.rails.RailsConfiguration;
import com.ravendarque.vendingMachine.rails.RailsConfigurationBuilder;
import com.ravendarque.vendingMachine.vending.NoVendSelectionException;
import com.ravendarque.vendingMachine.vending.VendingMachine;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineShould {

    private static final String TEST_IN_STOCK_RAIL_CODE = "T1";
    private static final String TEST_IN_STOCK_LABEL = "In stock";

    private static final String TEST_IN_STOCK_EXPENSIVE_RAIL_CODE = "T2";
    private static final String TEST_IN_STOCK_EXPENSIVE_LABEL = "Expensive";

    private static final String TEST_OUT_OF_STOCK_RAIL_CODE = "T3";
    private static final String TEST_OUT_OF_STOCK_LABEL = "Out of stock";

    @Test
    void returnZeroPriceWhenNoRailIsSelected() {

        final double expectedPrice = 0;

        final VendingMachine testVendingMachine = buildTestVendingMachine();

        final double actualTotalPrice = testVendingMachine.getSelectedRailPrice();

        assertEquals(expectedPrice, actualTotalPrice);
    }

    @Test
    void returnPriceOfSelectedRail() {

        final double expectedPrice = 1;

        final VendingMachine testVendingMachine = buildTestVendingMachine();
        testVendingMachine.selectRail(TEST_IN_STOCK_RAIL_CODE);

        final double actualPrice = testVendingMachine.getSelectedRailPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void throwExceptionOnVendWithNoRailIsSelected() {

        final VendingMachine testVendingMachine = buildTestVendingMachine();

        assertThrows(NoVendSelectionException.class, testVendingMachine::vend);
    }

    @Test
    void returnFalseWhenCheckingIfCanVendWithNoRailSelected() {

        final VendingMachine testVendingMachine = buildTestVendingMachine();

        final boolean actualResult = testVendingMachine.canVend();

        assertFalse(actualResult);
    }

    @Test
    void returnFalseWhenCheckingIfCanVendWithEmptySelectedRail() {

        final VendingMachine testVendingMachine = buildTestVendingMachine();
        testVendingMachine.selectRail(TEST_OUT_OF_STOCK_RAIL_CODE);

        final boolean actualResult = testVendingMachine.canVend();

        assertFalse(actualResult);
    }

    @Test
    void returnFalseWhenCheckingIfCanVendWithInsufficientCreditForSelectedRail() {

        final VendingMachine testVendingMachine = buildTestVendingMachine();
        testVendingMachine.selectRail(TEST_IN_STOCK_EXPENSIVE_RAIL_CODE);

        final boolean actualResult = testVendingMachine.canVend();

        assertFalse(actualResult);
    }

    @Test
    void leaveZeroCreditValueWithExactCreditValueForVend()
            throws Exception {

        final double expectedRemainingCredit = 0;

        final double testCreditValue = 1;

        final VendingMachine testVendingMachine = buildTestVendingMachine();
        testVendingMachine.addCredit(testCreditValue);
        testVendingMachine.selectRail(TEST_IN_STOCK_RAIL_CODE);
        testVendingMachine.vend();

        final double actualRemainingCredit = testVendingMachine.getCreditValue();

        assertEquals(expectedRemainingCredit, actualRemainingCredit);
    }

    @Test
    void leaveCorrectCreditWhenVendPriceIsLessThanCreditValue()
            throws Exception {

        final double expectedRemainingCredit = 1;

        final double testCreditValue = 2;

        final VendingMachine testVendingMachine = buildTestVendingMachine();
        testVendingMachine.addCredit(testCreditValue);
        testVendingMachine.selectRail(TEST_IN_STOCK_RAIL_CODE);
        testVendingMachine.vend();

        final double actualRemainingCredit = testVendingMachine.getCreditValue();

        assertEquals(expectedRemainingCredit, actualRemainingCredit);
    }

    @Test
    void clearRailSelectionAfterSuccessfulVend()
            throws Exception {

        final double expectedPriceWhenNoRailSelected = 0;

        final VendingMachine testVendingMachine = buildTestVendingMachine();
        testVendingMachine.selectRail(TEST_IN_STOCK_RAIL_CODE);

        final double testCreditValue = 1;
        testVendingMachine.addCredit(testCreditValue);

        testVendingMachine.vend();

        final double actualRailPrice = testVendingMachine.getSelectedRailPrice();

        assertEquals(actualRailPrice, expectedPriceWhenNoRailSelected);
    }

    @Test
    void decrementRailInventoryAfterSuccessfulVend()
            throws Exception {

        final double dummyCreditValue = 2;

        final VendingMachine testVendingMachine = buildTestVendingMachine();
        testVendingMachine.addCredit(dummyCreditValue);
        testVendingMachine.selectRail(TEST_IN_STOCK_RAIL_CODE);
        testVendingMachine.vend();
        testVendingMachine.selectRail(TEST_IN_STOCK_RAIL_CODE);

        assertFalse(testVendingMachine.canVend());
    }

    @Test
    void returnRailsSummary() {

        VendingMachine testVendingMachine = buildTestVendingMachine();

        Map<String, String> actualRailsSummary = testVendingMachine.getRailsSummary();

        assertEquals(actualRailsSummary.get(TEST_IN_STOCK_RAIL_CODE), TEST_IN_STOCK_LABEL);
        assertEquals(actualRailsSummary.get(TEST_IN_STOCK_EXPENSIVE_RAIL_CODE), TEST_IN_STOCK_EXPENSIVE_LABEL);
        assertEquals(actualRailsSummary.get(TEST_OUT_OF_STOCK_RAIL_CODE), TEST_OUT_OF_STOCK_LABEL);
    }

    @Test
    void returnFalseIfRailSelectionDoesNotExist() {

        final String testNonExistentRailCode = "XX";

        VendingMachine vendingMachine = buildTestVendingMachine();

        assertFalse(vendingMachine.canSelectRail(testNonExistentRailCode));
    }

    @Test
    void returnTrueIfRailSelectionExists() {

        VendingMachine vendingMachine = buildTestVendingMachine();

        assertTrue(vendingMachine.canSelectRail(TEST_IN_STOCK_RAIL_CODE));
    }

    private VendingMachine buildTestVendingMachine() {

        final double testInStockPrice = 1;
        final int testInStockInventory = 1;

        final double testInStockExpensivePrice = 2;
        final int testInStockExpensiveInventory = 1;

        final double testOutOfStockPrice = 1;
        final int testOutOfStockInventory = 0;

        final RailsConfiguration testRailConfiguration = new RailsConfigurationBuilder()
                .add(new RailConfigurationSettings(
                        TEST_IN_STOCK_RAIL_CODE,
                        testInStockPrice,
                        testInStockInventory,
                        TEST_IN_STOCK_LABEL))
                .add(new RailConfigurationSettings(
                        TEST_IN_STOCK_EXPENSIVE_RAIL_CODE,
                        testInStockExpensivePrice,
                        testInStockExpensiveInventory,
                        TEST_IN_STOCK_EXPENSIVE_LABEL))
                .add(new RailConfigurationSettings(
                        TEST_OUT_OF_STOCK_RAIL_CODE,
                        testOutOfStockPrice,
                        testOutOfStockInventory,
                        TEST_OUT_OF_STOCK_LABEL))
                .build();

        Rails rails = new Rails(testRailConfiguration);
        Credit credit = new Credit();

        return new VendingMachine(rails, credit);
    }

}
