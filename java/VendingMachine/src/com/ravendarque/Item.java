package com.ravendarque;

class Item {

    private final String displayName;
    private double price;

    Item(String displayName, double price) {

        validateDisplayName(displayName);
        validatePrice(price);

        this.displayName = displayName;
        this.price = price;
    }

    private void validatePrice(double price) {

        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");

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
