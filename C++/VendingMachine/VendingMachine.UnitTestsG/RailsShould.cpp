#include "pch.h"
#include "../VendingMachine/Rails.h"
#include "../VendingMachine/RailsConfiguration.h"

TEST(RailsShould, ReturnFalseWhenCheckingIfNonexistentRailCanBeSelected)
{
	const std::string testNonExistentRailCode = "XX";

	const RailsConfiguration testRailsConfiguration;

	const Rails rails(testRailsConfiguration);
	const auto actualResult = rails.CanSelectRail(testNonExistentRailCode);

	EXPECT_FALSE(actualResult);
}

TEST(RailsShould, ReturnTrueWhenCheckingIfExistentRailCanBeSelected)
{
	const std::string testRailCode = "T1";
	const unsigned int dummyCapacity = 0;
	const double dummyPrice = 0;
	const unsigned int dummyInitialInventory = 0;
	const std::string dummyLabel = "Dummy label";
	const RailConfigurationSettings testRailConfigurationSettings(testRailCode, dummyPrice,
	                                                              dummyInitialInventory, dummyLabel);

	RailsConfiguration testRailsConfiguration;
	testRailsConfiguration.Add(testRailConfigurationSettings);

	const Rails rails(testRailsConfiguration);

	const auto actualResult = rails.CanSelectRail(testRailCode);

	EXPECT_TRUE(actualResult);
}

TEST(RailsShould, SelectRailByRailCode)
{
	const std::string testRailCode = "T1";
	const unsigned int dummyCapacity = 0;
	const double dummyPrice = 0;
	const unsigned int dummyInitialInventory = 0;
	const std::string testLabel = "Test label";
	const RailConfigurationSettings testRailConfigurationSettings(testRailCode, dummyPrice,
	                                                              dummyInitialInventory, testLabel);

	RailsConfiguration testRailsConfiguration;
	testRailsConfiguration.Add(testRailConfigurationSettings);

	Rails testRails(testRailsConfiguration);
	testRails.SelectRail(testRailCode);

	const auto actualSelectedRail = testRails.GetSelectedRail();

	EXPECT_EQ(actualSelectedRail->GetLabel(), testLabel);
}

TEST(RailsShould, ReturnRailsSummary)
{
	const std::string testRailCode = "T1";
	const unsigned int dummyCapacity = 0;
	const double dummyPrice = 0;
	const unsigned int dummyInitialInventory = 0;
	const std::string testLabel = "Test label";
	const RailConfigurationSettings testRailConfigurationSettings(testRailCode, dummyPrice,
	                                                              dummyInitialInventory, testLabel);

	RailsConfiguration testRailsConfiguration;
	testRailsConfiguration.Add(testRailConfigurationSettings);

	const Rails testRails(testRailsConfiguration);

	auto actualRailsSummary = testRails.GetRailsSummary();

	for (const auto& railSummary : actualRailsSummary)
	{
		EXPECT_EQ(railSummary.first, testRailCode);
		EXPECT_EQ(railSummary.second, testLabel);
	}
}

TEST(RailsShould, ReturnFalseWhenCheckingIfARailHasBeenSelectedButNoneHas)
{
	const RailsConfiguration dummyRailsConfiguration;
	const Rails testRails(dummyRailsConfiguration);

	ASSERT_FALSE(testRails.HasSelectedRail());
}
