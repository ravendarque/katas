package com.ravendarque.items;

public class Item {

    private final String displayName;
    private double price;

    public Item(String displayName, double price) {

        validateDisplayName(displayName);
        validatePrice(price);

        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {

        return displayName;
    }

    public double getPrice() {

        return price;
    }

    private void validateDisplayName(String displayName) {

        if (displayName == null)
            throw new IllegalArgumentException("Display name cannot be null");

        if (displayName.equals(""))
            throw new IllegalArgumentException("Display name cannot be empty");
    }

    private void validatePrice(double price) {

        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");

    }
}
