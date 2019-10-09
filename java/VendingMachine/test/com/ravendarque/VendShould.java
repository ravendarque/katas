package com.ravendarque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VendShould {

    @Test
    void CalculateTotalPriceOfSelectedItemsAsZeroWithNoItemsSelected() {

        double expectedTotalPrice = 0;

        Vend testVend = new Vend();

        double actualTotalPrice = testVend.calculateTotalPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    void CalculateTotalPriceOfSelectedItemsWithTwoItemsSelected() {

        double expectedTotalPrice = 2;

        String dummyItemName = "Test item";
        double testPrice = 1;

        Vend vend = new Vend();
        Item testItem1 = new Item(dummyItemName, testPrice);
        vend.addItem(testItem1);
        Item testItem2 = new Item(dummyItemName, testPrice);
        vend.addItem(testItem2);

        double actualTotalPrice = vend.calculateTotalPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }
}
