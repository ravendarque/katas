package com.ravendarque;

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
}
