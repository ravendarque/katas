package com.ravendarque.rails;

import java.util.HashMap;

public class Rails {

    private static final String NO_SELECTION = "";

    private final HashMap<String, Rail> rails = new HashMap<>();
    private String selectedRail = NO_SELECTION;

    public Rails(RailConfiguration railConfiguration) {

        railConfiguration.getConfigurations()
                         .forEach(settings -> rails.put(
                                 settings.getRailCode(),
                                 new Rail(
                                         settings.getCapacity(),
                                         settings.getInitialInventory(),
                                         settings.getPrice(),
                                         settings.getLabel())));

    }

    public void clearSelection() {

        selectedRail = NO_SELECTION;
    }

    public Rail getSelectedRail() {

        return rails.get(selectedRail);
    }

    public boolean hasSelectedRail() {

        return !selectedRail.isEmpty();
    }

    public void selectRail(String railCode) {

        if (rails.containsKey(railCode))
            selectedRail = railCode;
    }
}
