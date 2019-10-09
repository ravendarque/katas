package com.ravendarque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VendShould {

    @Test
    void calculateTotalPriceOfSelectedItemsAsZeroWithNoItemsSelected() {

        double expectedTotalPrice = 0;

        Vend testVend = new Vend();

        double actualTotalPrice = testVend.calculateTotalPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    void calculateTotalPriceOfSelectedItemsWithTwoItemsSelected() {

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

    @Test
    void throwExceptionWhenProcessingTransactionWithCreditLessThanSelectedItems() {

        Vend vend = new Vend();
        String dummyItemName = "Test item";
        double testPrice = 1;

        Item testItem = new Item(dummyItemName, testPrice);
        vend.addItem(testItem);

        Credit credit = new Credit();

        assertThrows(InsufficientCreditException.class, () -> vend.processTransaction(credit));
    }

    @Test
    void throwExceptionWhenProcessingTransactionWithNoSelectedItems() {

        Vend vend = new Vend();

        Credit credit = new Credit();

        assertThrows(NoItemsInVendException.class, () -> vend.processTransaction(credit));
    }
}
