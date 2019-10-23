package com.ravendarque.credit;

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

        if (!validateSpend(value))
            throw new InsufficientCreditException();

        totalValue -= value;
    }

    public boolean validateSpend(double amount) {

        return totalValue >= amount;
    }
}
