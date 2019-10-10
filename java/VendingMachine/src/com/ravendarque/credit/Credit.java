package com.ravendarque.credit;

public class Credit {

    private double totalValue;

    public double getValue() {

        return totalValue;
    }

    public void add(double value) {

        totalValue += value;
    }
}
