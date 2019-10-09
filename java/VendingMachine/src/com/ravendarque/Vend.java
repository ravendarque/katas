package com.ravendarque;

import java.util.ArrayList;
import java.util.List;

class Vend {

    private List<Item> items = new ArrayList<>();

    boolean validateTransaction(Credit credit) {

        return itemsAreValidForTransaction() && creditIsValidForTransaction(credit);
    }

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

        if (!itemsAreValidForTransaction())
            throw new NoItemsInVendException();

        if (!creditIsValidForTransaction(credit))
            throw new InsufficientCreditException();
    }

    private boolean creditIsValidForTransaction(Credit credit) {

        return credit.getValue() >= calculateTotalPrice();
    }

    private boolean itemsAreValidForTransaction() {

        return !items.isEmpty();
    }
}
