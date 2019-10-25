package com.ravendarque.unitTests;

import com.ravendarque.rails.RailConfiguration;
import com.ravendarque.rails.RailConfigurationSettings;
import com.ravendarque.vending.NoVendSelectionException;
import com.ravendarque.vending.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineShould {

    private static final int DUMMY_CAPACITY_1 = 1;
    private static final double DUMMY_PRICE_1 = 1;
    private static final int DUMMY_INITIAL_INVENTORY_1 = 1;
    private static final String DUMMY_LABEL = "Dummy label";

    private static final String TEST_RAIL_CODE_T1 = "T1";

    @Test
    void returnZeroPriceWhenNoRailIsSelected() {

        final double expectedPrice = 0;

        final VendingMachine testVendingMachine = getTestVendingMachine();

        final double actualTotalPrice = testVendingMachine.getSelectedRailPrice();

        assertEquals(expectedPrice, actualTotalPrice);
    }

    @Test
    void returnPriceOfSelectedRail() {

        final double expectedPrice = 1;

        final VendingMachine testVendingMachine = getTestVendingMachine();
        testVendingMachine.selectRail(TEST_RAIL_CODE_T1);

        final double actualPrice = testVendingMachine.getSelectedRailPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void throwExceptionWhenProcessingTransactionWithNoSelectedRail() {

        final VendingMachine testVendingMachine = getTestVendingMachine();

        assertThrows(NoVendSelectionException.class, testVendingMachine::vend);
    }

    @Test
    void returnFalseWhenValidatingVendWithInsufficientCredit() {

        final VendingMachine testVendingMachine = getTestVendingMachine();
        testVendingMachine.selectRail(TEST_RAIL_CODE_T1);

        final boolean actualResult = testVendingMachine.canPurchaseSelectedItems();

        assertFalse(actualResult);
    }

    @Test
    void returnFalseWhenValidatingVendWithNoItemsAdded() {

        final VendingMachine testVendingMachine = getTestVendingMachine();

        final boolean actualResult = testVendingMachine.canPurchaseSelectedItems();

        assertFalse(actualResult);
    }

    @Test
    void leaveZeroCreditValueWithExactCreditValueForVend()
            throws Exception {

        final double expectedRemainingCredit = 0;

        final double testCreditValue = 1;

        final VendingMachine testVendingMachine = getTestVendingMachine();
        testVendingMachine.addCredit(testCreditValue);
        testVendingMachine.selectRail(TEST_RAIL_CODE_T1);
        testVendingMachine.vend();

        final double actualRemainingCredit = testVendingMachine.getCreditValue();

        assertEquals(expectedRemainingCredit, actualRemainingCredit);
    }

    @Test
    void leaveCorrectCreditWhenVendPriceIsLessThanCreditValue()
            throws Exception {

        final double expectedRemainingCredit = 1;

        final double testCreditValue = 2;

        final VendingMachine testVendingMachine = getTestVendingMachine();
        testVendingMachine.addCredit(testCreditValue);
        testVendingMachine.selectRail(TEST_RAIL_CODE_T1);
        testVendingMachine.vend();

        final double actualRemainingCredit = testVendingMachine.getCreditValue();

        assertEquals(expectedRemainingCredit, actualRemainingCredit);
    }

    @Test
    void decrementRailInventoryAfterSuccessfulVend()
            throws Exception {

        final double dummyCreditValue = 2;

        final VendingMachine testVendingMachine = getTestVendingMachine();
        testVendingMachine.addCredit(dummyCreditValue);
        testVendingMachine.selectRail(TEST_RAIL_CODE_T1);
        testVendingMachine.vend();
        testVendingMachine.selectRail(TEST_RAIL_CODE_T1);

        assertFalse(testVendingMachine.canPurchaseSelectedItems());
    }

    private VendingMachine getTestVendingMachine() {

        final RailConfiguration testRailConfiguration = new RailConfiguration();
        final RailConfigurationSettings testRailConfigurationSettings = new RailConfigurationSettings(
                TEST_RAIL_CODE_T1, DUMMY_CAPACITY_1, DUMMY_PRICE_1, DUMMY_INITIAL_INVENTORY_1, DUMMY_LABEL);
        testRailConfiguration.addRailConfigurationSettings(testRailConfigurationSettings);

        return new VendingMachine(testRailConfiguration);
    }

}
