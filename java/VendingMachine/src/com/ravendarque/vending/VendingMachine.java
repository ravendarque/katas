package com.ravendarque.vending;

import com.ravendarque.credit.Credit;
import com.ravendarque.rails.Rail;
import com.ravendarque.rails.RailConfiguration;
import com.ravendarque.rails.Rails;

public class VendingMachine {

    private final Rails rails;
    private final Credit credit;

    public VendingMachine(RailConfiguration railConfiguration) {

        this.rails = new Rails(railConfiguration);
        this.credit = new Credit();
    }

    public void addCredit(double creditValue) {

        credit.add(creditValue);
    }

    public boolean canPurchaseSelectedItems() {

        return rails.hasSelectedRail()
                && rails.getSelectedRail()
                        .canVendItem()
                && credit.canSpend(getSelectedRailPrice());

    }

    public double getCreditValue() {

        return credit.getValue();
    }

    public double getSelectedRailPrice() {

        return !rails.hasSelectedRail()
               ? 0
               : rails.getSelectedRail()
                      .getPrice();
    }

    public void vend()
            throws Exception {

        if (!rails.hasSelectedRail())
            throw new NoVendSelectionException();

        final Rail selectedRail = rails.getSelectedRail();
        credit.spend(selectedRail.getPrice());
        selectedRail.vendItem();
        rails.clearSelection();
    }

    public void selectRail(String railCode) {

        rails.selectRail(railCode);
    }
}
