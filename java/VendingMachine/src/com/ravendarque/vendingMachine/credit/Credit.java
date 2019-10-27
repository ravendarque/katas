package com.ravendarque.vendingMachine.credit;

public class Credit {

    private double totalValue;

    public double getValue() {

        return totalValue;
    }

    public void add(double value) {

        totalValue += value;
    }

    public void spend(double value)
            throws InsufficientCreditException {

        if (!canSpend(value))
            throw new InsufficientCreditException();

        totalValue -= value;
    }

    public boolean canSpend(double amount) {

        return totalValue >= amount;
    }
}
