#include "pch.h"
#include "../VendingMachine/Item.h"

TEST(ItemShould, ProvideADisplayName)
{
	const std::string expectedDisplayName = "Test Item";
	const double dummyPrice = 0;
	const Item item(expectedDisplayName, dummyPrice);

	const auto actualDisplayName = item.GetDisplayName();

	EXPECT_EQ(expectedDisplayName, actualDisplayName);
}

TEST(ItemShould, ProvideAPrice)
{
	const double expectedPrice = 1;

	const std::string dummyDisplayName = "Test Item";
	const double testPrice = 1;
	const Item item(dummyDisplayName, testPrice);

	const auto actualPrice = item.GetPrice();

	EXPECT_EQ(expectedPrice, actualPrice);
}