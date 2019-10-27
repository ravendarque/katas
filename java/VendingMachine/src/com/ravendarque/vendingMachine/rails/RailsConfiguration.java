package com.ravendarque.vendingMachine.rails;

import java.util.*;

public class RailsConfiguration {

    private final List<RailConfigurationSettings> railConfigurationSettingsList = new ArrayList<>();

    public void add(RailConfigurationSettings settings) {

        Objects.requireNonNull(settings, "Cannot add null RailConfigurationSettings");
        railConfigurationSettingsList.add(settings);
    }

    public List<RailConfigurationSettings> getConfigurations() {

        return Collections.unmodifiableList(railConfigurationSettingsList);
    }
}
