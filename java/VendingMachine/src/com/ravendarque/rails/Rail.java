package com.ravendarque.rails;

public class Rail {

    private final double railPrice;
    private final String label;
    private int inventory;

    public Rail(int capacity, int initialInventory, double price, String label) {

        validateInitialInventory(capacity, initialInventory);
        validatePrice(price);

        this.inventory = initialInventory;
        this.railPrice = price;
        this.label = label;
    }

    public boolean canVendItem() {

        return !isEmpty();
    }

    public String getLabel() {

        return label;
    }

    public double getPrice() {

        return railPrice;
    }

    public boolean isEmpty() {

        return inventory == 0;
    }

    public void vendItem()
            throws RailEmptyException {

        if (!canVendItem())
            throw new RailEmptyException();

        inventory--;
    }

    private void validateInitialInventory(int railCapacity, int initialInventory) {

        if (initialInventory > railCapacity)
            throw new IllegalArgumentException("Initial inventory cannot be greater than rails capacity");
    }

    private void validatePrice(double price) {

        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");

    }
}
