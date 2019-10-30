#include "pch.h"
#include "RailsConfiguration.h"
#include <list>

void RailsConfiguration::Add(const RailConfigurationSettings& railConfigurationSettings)
{
	Settings.push_back(railConfigurationSettings);
}

std::list<RailConfigurationSettings> RailsConfiguration::GetSettings() const
{
	return Settings;
}
