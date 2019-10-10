package com.ravendarque;

import com.ravendarque.items.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemShould {

    @Test
    void provideADisplayName() {

        String expectedDisplayName = "Test Item";
        int dummyPrice = 0;
        Item testItem = new Item(expectedDisplayName, dummyPrice);

        String actualDisplayName = testItem.getDisplayName();

        assertEquals(expectedDisplayName, actualDisplayName);
    }

    @Test
    void provideAPrice() {

        String dummyName = "Test Item";
        double expectedPrice = 1.00;
        Item item = new Item(dummyName, 1.00);

        double actualPrice = item.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void throwIllegalArgumentExceptionWhenNameIsEmpty() {

        String emptyDisplayName = "";
        double dummyPrice = 0;

        assertThrows(IllegalArgumentException.class, () -> new Item(emptyDisplayName, dummyPrice));
    }

    @Test
    void throwIllegalArgumentExceptionWhenNameIsNull() {

        String emptyDisplayName = null;
        double dummyPrice = 0;

        assertThrows(IllegalArgumentException.class, () -> new Item(emptyDisplayName, dummyPrice));
    }

    @Test
    void throwIllegalArgumentExceptionWhenPriceIsNegative() {

        String dummyDisplayName = "Test item";
        double negativePrice = -1;

        assertThrows(IllegalArgumentException.class, () -> new Item(dummyDisplayName, negativePrice));
    }
}
