package com.ravendarque.vendingMachine.rails;

public class RailsConfigurationBuilder {

    private final RailsConfiguration railConfiguration = new RailsConfiguration();

    public RailsConfigurationBuilder add(RailConfigurationSettings railConfigurationSettings) {

        railConfiguration.add(railConfigurationSettings);

        return this;
    }

    public RailsConfiguration build() {

        return railConfiguration;
    }
}
