#pragma once
#include <string>

class RailConfigurationSettings
{
public:
	RailConfigurationSettings(
		std::string railCode, 
		double price, 
		unsigned int initialInventory, 
		std::string label);
	std::string GetRailCode() const;
	double GetPrice() const;
	unsigned int GetInitialInventory() const;
	std::string GetLabel() const;
private:
	const std::string RailCode;
	const double Price;
	const unsigned int InitialInventory;
	const std::string Label;
};

