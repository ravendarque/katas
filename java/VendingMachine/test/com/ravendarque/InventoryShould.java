package com.ravendarque;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InventoryShould {

    @Test
    void provideEmptyInventoryListWhenNoItemsInInventory() {

        Inventory inventory = new Inventory();
        List<Item> actualInventoryList = inventory.getItems();

        assertTrue(actualInventoryList.isEmpty());
    }

    @Test
    void provideOneItemInInventoryListWhenOneItemIsInInventory() {

        String dummyName = "Test item";
        double dummyPrice = 0;
        Item testItem = new Item(dummyName, dummyPrice);

        List<Item> expectedInventoryList = new ArrayList<>();
        expectedInventoryList.add(testItem);

        Inventory inventory = new Inventory();
        inventory.addItem(testItem);
        List<Item> actualInventoryList = inventory.getItems();

        assertEquals(expectedInventoryList, actualInventoryList);
    }

    @Test
    void provideEmptyInventoryListWhenOneItemIsAddedThenRemoved() {

        String dummyName = "Test item";
        double dummyPrice = 0;
        Item testItem = new Item(dummyName, dummyPrice);

        Inventory inventory = new Inventory();
        inventory.addItem(testItem);
        inventory.removeItem(testItem);

        List<Item> actualInventoryList = inventory.getItems();

        assertTrue(actualInventoryList.isEmpty());
    }

    @Test
    void returnOnlyDrinkItemsWhenQueriedForDrinkItems() {

        String testDrinkItemDisplayName = "Test drink item";
        double dummyDrinkItemPrice = 0;
        Drink testDrinkItem = new Drink(testDrinkItemDisplayName, dummyDrinkItemPrice);

        String testOtherItemDisplayName = "Test other item";
        double dummyOtherItemPrice = 0;
        Item testOtherItem = new Item(testOtherItemDisplayName, dummyOtherItemPrice);

        List<Item> expectedInventoryList = new ArrayList<>();
        expectedInventoryList.add(testDrinkItem);

        Inventory testInventory = new Inventory();
        testInventory.addItem(testDrinkItem);
        testInventory.addItem(testOtherItem);

        List<Item> actualInventoryList = testInventory.getItemsByType(Drink.class);

        assertEquals(expectedInventoryList, actualInventoryList);
    }
}
