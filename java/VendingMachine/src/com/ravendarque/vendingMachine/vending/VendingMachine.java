package com.ravendarque.vendingMachine.vending;

import com.ravendarque.vendingMachine.credit.Credit;
import com.ravendarque.vendingMachine.rails.Rail;
import com.ravendarque.vendingMachine.rails.Rails;

import java.util.Map;

public class VendingMachine {

    private final Rails rails;
    private final Credit credit;

    public VendingMachine(Rails rails, Credit credit) {

        this.rails = rails;
        this.credit = credit;
    }

    public void addCredit(double creditValue) {

        credit.add(creditValue);
    }

    public boolean canVend() {

        return rails.hasSelectedRail()
                && !rails.getSelectedRail()
                         .isEmpty()
                && credit.canSpend(getSelectedRailPrice());

    }

    public boolean canSelectRail(String railCode) {

        return rails.canSelectRail(railCode);
    }

    public double getCreditValue() {

        return credit.getValue();
    }

    public Map<String, String> getRailsSummary() {

        return rails.getRailsSummary();
    }

    public double getSelectedRailPrice() {

        return !rails.hasSelectedRail()
               ? 0
               : rails.getSelectedRail()
                      .getPrice();
    }

    public void selectRail(String railCode) {

        rails.selectRail(railCode);
    }

    public void vend()
            throws Exception {

        if (!rails.hasSelectedRail())
            throw new NoVendSelectionException();

        final Rail selectedRail = rails.getSelectedRail();
        credit.spend(selectedRail.getPrice());
        selectedRail.vend();
        rails.clearSelection();
    }
}
