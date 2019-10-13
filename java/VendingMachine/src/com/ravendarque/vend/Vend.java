package com.ravendarque.vend;

import com.ravendarque.credit.Credit;
import com.ravendarque.inventory.Inventory;
import com.ravendarque.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Vend {

    private List<Item> items = new ArrayList<>();
    private Inventory inventory;

    public Vend(Inventory inventory) {

        this.inventory = inventory;
    }

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

        credit.spend(calculateTotalPrice());
        inventory.removeItems(items);
        items.clear();
    }

    public boolean validateTransaction(Credit credit) {

        return itemsAreValidForTransaction() && credit.validateSpend(calculateTotalPrice());
    }

    private boolean itemsAreValidForTransaction() {

        return !items.isEmpty();
    }
}
