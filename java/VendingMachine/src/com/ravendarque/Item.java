package com.ravendarque;

class Item {

    private final String displayName;
    private double price;

    Item(String displayName, double price) {

        validateDisplayName(displayName);

        this.displayName = displayName;
        this.price = price;
    }

    private void validateDisplayName(String displayName) {

        if (displayName.equals(""))
            throw new IllegalArgumentException("Display name cannot be empty");
    }

    double getPrice() {

        return price;
    }

    String getDisplayName() {

        return displayName;
    }
}
