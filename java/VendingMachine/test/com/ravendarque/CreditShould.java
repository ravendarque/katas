package com.ravendarque;

import com.ravendarque.credit.Credit;
import com.ravendarque.credit.InsufficientCreditException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreditShould {

    @Test
    void provideZeroValueWithNoCreditAdded() {

        double expectedCreditValue = 0;

        Credit credit = new Credit();

        double actualCreditValue = credit.getValue();

        assertEquals(expectedCreditValue, actualCreditValue);
    }

    @Test
    void provideValueEqualToSingleCreditAdded() {

        double expectedCreditValue = 2;
        double creditToAdd = 2;

        Credit credit = new Credit();
        credit.add(creditToAdd);

        double actualCreditValue = credit.getValue();

        assertEquals(expectedCreditValue, actualCreditValue);
    }

    @Test
    void provideValueEqualToSumOfMultipleCreditsAdded() {

        double expectedCreditValue = 4;
        double creditToAdd = 2;

        Credit credit = new Credit();
        credit.add(creditToAdd);
        credit.add(creditToAdd);

        double actualCreditValue = credit.getValue();

        assertEquals(expectedCreditValue, actualCreditValue);
    }

    @Test
    void throwInsufficientCreditExceptionIfSpendIsGreaterThanTotalValue() {

        double testSpendAmount = 2;
        double testCreditValue = 1;

        Credit credit = new Credit();
        credit.add(testCreditValue);

        assertThrows(InsufficientCreditException.class, () -> credit.spend(testSpendAmount));
    }

    @Test
    void returnFalseWhenValidatingVendWithInsufficientCredit() {

        boolean expectedResult = false;
        int testSpendAmount = 2;

        Credit credit = new Credit();

        boolean actualResult = credit.validateSpend(testSpendAmount);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void leaveZeroCreditAfterSpendEqualToTotalValue()
            throws InsufficientCreditException {

        double expectedRemainingValue = 0;

        int testCreditValue = 1;
        Credit credit = new Credit();
        credit.add(testCreditValue);
        credit.spend(1);

        double actualRemainingValue = credit.getValue();

        assertEquals(expectedRemainingValue, actualRemainingValue);
    }

    @Test
    void leaveCorrectCreditAfterSpendLessThanTotalValue()
            throws InsufficientCreditException {

        double expectedRemainingValue = 1.5;
        int testCreditValue = 3;
        double testSpendAmount = 1.5;

        Credit credit = new Credit();
        credit.add(testCreditValue);
        credit.spend(testSpendAmount);

        double actualRemainingValue = credit.getValue();

        assertEquals(expectedRemainingValue, actualRemainingValue);
    }
}