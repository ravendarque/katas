package com.ravendarque.rails;

import java.util.*;

public class RailConfiguration {

    private final List<RailConfigurationSettings> railConfigurationSettingsList = new ArrayList<>();

    public void addRailConfigurationSettings(RailConfigurationSettings settings) {

        Objects.requireNonNull(settings, "Cannot add null RailConfigurationSettings");
        railConfigurationSettingsList.add(settings);
    }

    public List<RailConfigurationSettings> getConfigurations() {

        return Collections.unmodifiableList(railConfigurationSettingsList);
    }
}
