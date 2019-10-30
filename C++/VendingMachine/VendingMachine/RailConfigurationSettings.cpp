#include "pch.h"
#include "RailConfigurationSettings.h"
#include <utility>

RailConfigurationSettings::RailConfigurationSettings(
	std::string railCode, const double price, const unsigned int initialInventory, std::string label)
	: RailCode(std::move(railCode)), Price(price), InitialInventory(initialInventory), Label(std::move(label))
{
}

std::string RailConfigurationSettings::GetRailCode() const
{
	return RailCode;
}

double RailConfigurationSettings::GetPrice() const
{
	return Price;
}

unsigned int RailConfigurationSettings::GetInitialInventory() const
{
	return InitialInventory;
}

std::string RailConfigurationSettings::GetLabel() const
{
	return Label;
}
