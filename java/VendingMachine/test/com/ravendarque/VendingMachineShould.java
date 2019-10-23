package com.ravendarque;

import com.ravendarque.credit.Credit;
import com.ravendarque.inventory.Inventory;
import com.ravendarque.items.Item;
import com.ravendarque.vend.NoItemsInVendException;
import com.ravendarque.vend.VendingMachine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineShould {

    @Test
    void calculateTotalPriceOfSelectedItemsAsZeroWithNoItemsSelected() {

        double expectedTotalPrice = 0;

        VendingMachine testVend = new VendingMachine(new Inventory());

        double actualTotalPrice = testVend.calculateTotalPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    void calculateTotalPriceOfSelectedItemsWithTwoItemsSelected() {

        double expectedTotalPrice = 2;

        String dummyItemName = "Test item";
        double testPrice = 1;

        VendingMachine vend = new VendingMachine(new Inventory());
        Item testItem1 = new Item(dummyItemName, testPrice);
        vend.addItem(testItem1);
        Item testItem2 = new Item(dummyItemName, testPrice);
        vend.addItem(testItem2);

        double actualTotalPrice = vend.calculateTotalPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    void throwExceptionWhenProcessingTransactionWithNoSelectedItems() {

        VendingMachine vend = new VendingMachine(new Inventory());

        Credit credit = new Credit();

        assertThrows(NoItemsInVendException.class, () -> vend.processTransaction(credit));
    }

    @Test
    void returnFalseWhenValidatingVendWithInsufficientCredit() {

        boolean expectedResult = false;

        Credit credit = new Credit();

        String dummyItemName = "Test item";
        double testPrice = 1;

        VendingMachine vend = new VendingMachine(new Inventory());
        vend.addItem(new Item(dummyItemName, testPrice));

        boolean actualResult = vend.validateTransaction(credit);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void returnFalseWhenValidatingVendWithNoItemsAdded() {

        boolean expectedResult = false;

        Credit credit = new Credit();

        VendingMachine vend = new VendingMachine(new Inventory());

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

        VendingMachine vend = new VendingMachine(new Inventory());
        vend.addItem(testItem);
        vend.processTransaction(credit);

        double actualRemainingCredit = credit.getValue();

        assertEquals(expectedRemainingCredit, actualRemainingCredit);
    }

    @Test
    void leaveCorrectCreditWhenTransactionValueIsLessThanCreditValue()
            throws Exception {

        double expectedRemainingCredit = 1.5;
        double testItemPrice = 1.5;
        double testCreditValue = 3;

        String dummyDisplayName = "Test item";
        Item testItem = new Item(dummyDisplayName, testItemPrice);

        Credit credit = new Credit();
        credit.add(testCreditValue);

        VendingMachine vend = new VendingMachine(new Inventory());
        vend.addItem(testItem);
        vend.processTransaction(credit);

        double actualRemainingCredit = credit.getValue();

        assertEquals(expectedRemainingCredit, actualRemainingCredit);
    }

    @Test
    void removeItemFromInventoryAfterSuccessfulTransaction()
            throws Exception {

        String dummyDisplayName = "Test item";
        double dummyPrice = 1;
        Item testItem = new Item(dummyDisplayName, dummyPrice);

        Inventory testInventory = new Inventory();
        testInventory.addItem(testItem);

        Credit credit = new Credit();
        double dummyCreditValue = 1;
        credit.add(dummyCreditValue);

        VendingMachine vend = new VendingMachine(testInventory);
        vend.addItem(testItem);
        vend.processTransaction(credit);

        List<Item> actualInventoryList = testInventory.getItems();

        assertTrue(actualInventoryList.isEmpty());
    }

    @Test
    void removeItemsFromInventoryAfterSuccessfulTransaction()
            throws Exception {

        String dummyDisplayName = "Test item";
        double dummyPrice = 1;
        Item testItem1 = new Item(dummyDisplayName, dummyPrice);
        Item testItem2 = new Item(dummyDisplayName, dummyPrice);

        Inventory testInventory = new Inventory();
        testInventory.addItem(testItem1);
        testInventory.addItem(testItem2);

        Credit credit = new Credit();
        double dummyCreditValue = 2;
        credit.add(dummyCreditValue);

        VendingMachine vend = new VendingMachine(testInventory);
        vend.addItem(testItem1);
        vend.addItem(testItem2);
        vend.processTransaction(credit);

        List<Item> actualInventoryList = testInventory.getItems();

        assertTrue(actualInventoryList.isEmpty());
    }

}
