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
}
