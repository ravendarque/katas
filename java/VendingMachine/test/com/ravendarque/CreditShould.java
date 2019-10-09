package com.ravendarque;

import javafx.scene.chart.Axis;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
