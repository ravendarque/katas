#include "pch.h"
#include "../VendingMachine/RailsConfiguration.h"
#include "../VendingMachine/RailConfigurationSettings.h"

TEST(RailConfiguration, ReturnConfiguration)
{
	const std::string dummyRailCode = "D1";
	const unsigned dummyCapacity = 1;
	const double dummyPrice = 0;
	const unsigned dummyInitialInventory = 0;
	const std::string dummyLabel = "Dummy label";

	const RailConfigurationSettings testRailConfigurationSettings(
		dummyRailCode, dummyPrice, dummyInitialInventory, dummyLabel);

	RailsConfiguration testRailConfiguration;
	testRailConfiguration.Add(testRailConfigurationSettings);

	auto actualRailConfigurationSettings = testRailConfiguration.GetSettings().front();

	EXPECT_EQ(actualRailConfigurationSettings.GetRailCode(), testRailConfigurationSettings.GetRailCode());
	EXPECT_EQ(actualRailConfigurationSettings.GetPrice(), testRailConfigurationSettings.GetPrice());
	EXPECT_EQ(actualRailConfigurationSettings.GetInitialInventory(), testRailConfigurationSettings.GetInitialInventory());
	EXPECT_EQ(actualRailConfigurationSettings.GetLabel(), testRailConfigurationSettings.GetLabel());
}
