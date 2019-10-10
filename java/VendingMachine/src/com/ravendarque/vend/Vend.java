package com.ravendarque.vend;

import com.ravendarque.credit.Credit;
import com.ravendarque.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Vend {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {

        items.add(item);
    }

    public double calculateTotalPrice() {

        return items.stream()
                    .mapToDouble(Item::getPrice)
                    .sum();
    }

    public void processTransaction(Credit credit)
            throws Exception {

        if (!itemsAreValidForTransaction())
            throw new NoItemsInVendException();

        if (!creditIsValidForTransaction(credit))
            throw new InsufficientCreditException();
    }

    public boolean validateTransaction(Credit credit) {

        return itemsAreValidForTransaction() && creditIsValidForTransaction(credit);
    }

    private boolean creditIsValidForTransaction(Credit credit) {

        return credit.getValue() >= calculateTotalPrice();
    }

    private boolean itemsAreValidForTransaction() {

        return !items.isEmpty();
    }
}
