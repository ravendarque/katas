#include <iostream>
#include "../VendingMachine/VendingMachine.h"
#include <string>

int main()
{
	const auto initialInventory = 10;

	RailsConfiguration railsConfiguration;
	RailConfigurationSettings settings1("A1", 0.60, initialInventory, "Coke");
	railsConfiguration.Add(settings1);
	RailConfigurationSettings settings2("A2", 0.70, initialInventory, "Twix");
	railsConfiguration.Add(settings2);
	RailConfigurationSettings settings3("A3", 0.80, initialInventory, "Water");
	railsConfiguration.Add(settings3);
	RailConfigurationSettings settings4("A4", 0.90, initialInventory, "Hula hoops");
	railsConfiguration.Add(settings4);

	Rails rails(railsConfiguration);
	Credit credit;

	VendingMachine vendingMachine(rails, credit);
	for (const auto& summary : vendingMachine.GetRailsSummary())
		std::cout << summary.first + " " + summary.second + "\n";

	std::cout << "\n";
	std::cout << "Selection> ";
	std::string railCode;
	std::getline(std::cin, railCode);
	if (vendingMachine.CanSelectRail(railCode))
	{
		vendingMachine.SelectRail(railCode);
	}
	else
	{
		std::cout << "Invalid selection";
	}
}
