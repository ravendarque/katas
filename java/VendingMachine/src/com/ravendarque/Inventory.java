package com.ravendarque;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Inventory {

    private final ArrayList<Item> items = new ArrayList<>();

    List<Item> getItems() {

        return items;
    }

    List<Item> getItemsByType(Class clazz) {

        return items.stream()
                    .filter(item -> item.getClass() == clazz)
                    .collect(Collectors.toList());
    }

    void removeItem(Item item) {

        items.remove(item);
    }

    void addItem(Item testItem) {

        items.add(testItem);
    }
}
