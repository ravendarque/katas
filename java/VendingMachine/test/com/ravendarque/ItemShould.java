package com.ravendarque;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemShould {

    @Test
    void ProvideADisplayName() {

        String expectedDisplayName = "Test Item";
        int dummyPrice = 0;
        Item testItem = new Item(expectedDisplayName, dummyPrice);

        String actualDisplayName = testItem.getDisplayName();

        assertEquals(expectedDisplayName, actualDisplayName);
    }

    @Test
    void ProvideAPrice() {

        String dummyName = "Test Item";
        double expectedPrice = 1.00;
        Item item = new Item(dummyName, 1.00);

        double actualPrice = item.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void ThrowInvalidArgumentExceptionWhenNameIsEmpty() {

        String emptyDisplayName = "";
        double dummyPrice = 0;

        assertThrows(IllegalArgumentException.class, () -> new Item(emptyDisplayName, dummyPrice));
    }
}
