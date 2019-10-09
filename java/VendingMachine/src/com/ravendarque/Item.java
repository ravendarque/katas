package com.ravendarque;

class Item {

    private final String displayName;
    private double price;

    Item(String displayName, double price) {

        validateDisplayName(displayName);

        this.displayName = displayName;
        this.price = price;
    }

    double getPrice() {

        return price;
    }

    String getDisplayName() {

        return displayName;
    }

    private void validateDisplayName(String displayName) {

        if (displayName == null)
            throw new IllegalArgumentException("Display name cannot be null");

        if (displayName.equals(""))
            throw new IllegalArgumentException("Display name cannot be empty");
    }
}
