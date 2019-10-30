#pragma once
#include "RailConfigurationSettings.h"
#include <list>

class RailsConfiguration
{
public:
	void Add(const RailConfigurationSettings& railConfigurationSettings);
	std::list<RailConfigurationSettings> GetSettings() const;
private:
	std::list<RailConfigurationSettings> Settings;
};

