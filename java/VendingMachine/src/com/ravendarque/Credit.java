package com.ravendarque;

class Credit {

    private double totalValue;

    void add(double value) {

        totalValue += value;
    }

    double getValue() {

        return totalValue;
    }
}
