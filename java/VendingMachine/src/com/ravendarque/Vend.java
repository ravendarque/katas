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

    void processTransaction(Credit credit)
            throws Exception {

        if (items.isEmpty())
            throw new Exception("No items selected");

        if (credit.getValue() < calculateTotalPrice())
            throw new Exception("Insufficient credit for transaction");
    }
}
