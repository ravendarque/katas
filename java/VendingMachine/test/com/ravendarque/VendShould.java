package com.ravendarque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VendShould {

    @Test
    void CalculateTotalPriceOfSelectedItemsAsZeroWithNoItemsSelected() {

        double expectedTotalPrice = 0;

        Vend testVend = new Vend();

        double actualTotalPrice = testVend.calculateTotal();

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }
}
