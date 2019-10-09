package com.ravendarque;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryShould {

    @Test
    void ProvideEmptyInventoryListWhenNoItemsInInventory() {

        List<Item> expectedInventoryList = new ArrayList<>();

        Inventory inventory = new Inventory();
        List<Item> actualInventoryList = inventory.getItems();

        assertEquals(expectedInventoryList, actualInventoryList);
    }

    @Test
    void ProvideOneItemInInventoryListWhenOneItemIsInInventory() {

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
}
