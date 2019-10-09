package com.ravendarque;

import java.util.ArrayList;
import java.util.List;

class Vend {

    private List<Item> items = new ArrayList<>();

    void addItem(Item item) {

        items.add(item);
    }

    double calculateTotalPrice() {

        return items.stream()
                    .mapToDouble(Item::getPrice)
                    .sum();
    }
}
