package com.ravendarque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemShould {

    @Test
    void ProvideADisplayName() {

        String expectedItemName = "Test Item";
        Item testItem = new Item(expectedItemName);

        String actualItemName = testItem.getDisplayName();

        assertEquals(expectedItemName, actualItemName);
    }
}
