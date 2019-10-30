package com.ravendarque.vendingMachine.rails;

public class Rail {

    private final double railPrice;
    private final String label;
    private int inventory;

    public Rail(int initialInventory, double price, String label) {

        validatePrice(price);

        this.inventory = initialInventory;
        this.railPrice = price;
        this.label = label;
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

    public void vend()
            throws RailEmptyException {

        if (isEmpty())
            throw new RailEmptyException();

        inventory--;
    }

    private static void validatePrice(double price) {

        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");

    }
}
