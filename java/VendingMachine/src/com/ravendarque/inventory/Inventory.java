package com.ravendarque.inventory;

import com.ravendarque.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

    private final ArrayList<Item> items = new ArrayList<>();

    public List<Item> getItems() {

        return items;
    }

    public List<Item> getItemsByType(Class clazz) {

        return items.stream()
                    .filter(item -> item.getClass() == clazz)
                    .collect(Collectors.toList());
    }

    public void removeItems(List<Item> items) {

        this.items.removeAll(items);

    }

    public void removeItem(Item item) {

        items.remove(item);
    }

    public void addItem(Item testItem) {

        items.add(testItem);
    }
}
