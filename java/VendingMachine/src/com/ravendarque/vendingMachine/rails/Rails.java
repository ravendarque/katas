package com.ravendarque.vendingMachine.rails;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Rails {

    private static final String NO_SELECTION = "";

    private final Map<String, Rail> rails;
    private final Map<String, String> railsSummary;
    private String selectedRail = NO_SELECTION;

    public Rails(RailsConfiguration railConfiguration) {

        Map<String, Rail> configuredRails = new HashMap<>();
        Map<String, String> configuredRailsSummary = new HashMap<>();
        for (RailConfigurationSettings settings : railConfiguration.getConfigurations()) {

            final Rail rail = new Rail(
                    settings.getInitialInventory(),
                    settings.getPrice(),
                    settings.getLabel());

            configuredRails.put(settings.getRailCode(), rail);
            configuredRailsSummary.put(settings.getRailCode(), settings.getLabel());
        }

        this.rails = Collections.unmodifiableMap(configuredRails);
        this.railsSummary = Collections.unmodifiableMap(configuredRailsSummary);

    }

    public boolean canSelectRail(String railCode) {

        return rails.containsKey(railCode);
    }

    public void clearSelection() {

        selectedRail = NO_SELECTION;
    }

    public Map<String, String> getRailsSummary() {

        return railsSummary;
    }

    public Rail getSelectedRail() {

        return rails.get(selectedRail);
    }

    public boolean hasSelectedRail() {

        return !selectedRail.isEmpty();
    }

    public void selectRail(String railCode) {

        if (canSelectRail(railCode))
            selectedRail = railCode;
    }
}
