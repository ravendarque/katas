package com.ravendarque;

import com.ravendarque.credit.Credit;
import com.ravendarque.items.Item;
import com.ravendarque.credit.InsufficientCreditException;
import com.ravendarque.vend.NoItemsInVendException;
import com.ravendarque.vend.Vend;
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
    void throwExceptionWhenProcessingTransactionWithNoSelectedItems() {

        Vend vend = new Vend();

        Credit credit = new Credit();

        assertThrows(NoItemsInVendException.class, () -> vend.processTransaction(credit));
    }

    @Test
    void returnFalseWhenValidatingVendWithInsufficientCredit() {

        boolean expectedResult = false;

        Credit credit = new Credit();

        String dummyItemName = "Test item";
        double testPrice = 1;

        Vend vend = new Vend();
        vend.addItem(new Item(dummyItemName, testPrice));

        boolean actualResult = vend.validateTransaction(credit);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void returnFalseWhenValidatingVendWithNoItemsAdded() {

        boolean expectedResult = false;

        Credit credit = new Credit();

        Vend vend = new Vend();

        boolean actualResult = vend.validateTransaction(credit);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void leaveZeroCreditWithExactCreditForTransaction()
            throws Exception {

        double expectedRemainingCredit = 0;

        double testPrice = 1;
        String dummyDisplayName = "Test item";
        Item testItem = new Item(dummyDisplayName, testPrice);

        double testCreditValue = 1;
        Credit credit = new Credit();
        credit.add(testCreditValue);

        Vend vend = new Vend();
        vend.addItem(testItem);
        vend.processTransaction(credit);

        double actualRemainingCredit = credit.getValue();

        assertEquals(expectedRemainingCredit, actualRemainingCredit);
    }

    @Test
    void leaveCorrectCreditWhenCreditIsGreaterThanTransactionValue() {

    }

}
