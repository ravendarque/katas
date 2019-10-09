package com.ravendarque;

class Item {
    private final String displayName;
    private double price;

    Item(String displayName, double price) {

        this.displayName = displayName;
        this.price = price;
    }

    double getPrice() {

        return price;
    }

    String getDisplayName() {

        return displayName;
    }
}
