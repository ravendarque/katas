package com.ravendarque;

import java.util.ArrayList;
import java.util.List;

class Inventory {

    private final ArrayList<Item> items = new ArrayList<>();

    void addItem(Item testItem) {

        items.add(testItem);
    }

    List<Item> getItems() {

        return items;
    }
}
