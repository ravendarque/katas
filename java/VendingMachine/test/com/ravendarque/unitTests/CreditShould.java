package com.ravendarque.unitTests;

import com.ravendarque.vendingMachine.credit.Credit;
import com.ravendarque.vendingMachine.credit.InsufficientCreditException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreditShould {

    @Test
    void returnZeroValueWithNoCreditAdded() {

        final double expectedCreditValue = 0;

        final Credit credit = new Credit();

        final double actualCreditValue = credit.getValue();

        assertEquals(expectedCreditValue, actualCreditValue);
    }

    @Test
    void returnValueEqualToSingleCreditAdded() {

        final double expectedCreditValue = 2;
        final double creditToAdd = 2;

        final Credit credit = new Credit();
        credit.add(creditToAdd);

        final double actualCreditValue = credit.getValue();

        assertEquals(expectedCreditValue, actualCreditValue);
    }

    @Test
    void returnValueEqualToSumOfMultipleCreditsAdded() {

        final double expectedCreditValue = 4;
        final double creditToAdd = 2;

        final Credit credit = new Credit();
        credit.add(creditToAdd);
        credit.add(creditToAdd);

        final double actualCreditValue = credit.getValue();

        assertEquals(expectedCreditValue, actualCreditValue);
    }

    @Test
    void throwExceptionIfSpendIsGreaterThanTotalValue() {

        final double testSpendAmount = 2;
        final double testCreditValue = 1;

        final Credit credit = new Credit();
        credit.add(testCreditValue);

        assertThrows(InsufficientCreditException.class, () -> credit.spend(testSpendAmount));
    }

    @Test
    void returnFalseWhenValidatingSpendWithInsufficientCredit() {

        final boolean expectedResult = false;
        final int testSpendAmount = 2;

        final Credit credit = new Credit();

        final boolean actualResult = credit.canSpend(testSpendAmount);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void returnZeroValueAfterSpendEqualToTotalValue()
            throws InsufficientCreditException {

        final double expectedRemainingValue = 0;

        final int testCreditValue = 1;
        final int testSpend = 1;
        final Credit credit = new Credit();
        credit.add(testCreditValue);
        credit.spend(testSpend);

        final double actualRemainingValue = credit.getValue();

        assertEquals(expectedRemainingValue, actualRemainingValue);
    }

    @Test
    void returnRemainingCreditAfterSpendLessThanTotalValue()
            throws InsufficientCreditException {

        final double expectedRemainingValue = 1.5;
        final int testCreditValue = 3;
        final double testSpendAmount = 1.5;

        final Credit credit = new Credit();
        credit.add(testCreditValue);
        credit.spend(testSpendAmount);

        final double actualRemainingValue = credit.getValue();

        assertEquals(expectedRemainingValue, actualRemainingValue);
    }
}
