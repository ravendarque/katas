#include "pch.h"
#include "../VendingMachine/Item.h"

TEST(ItemShould, ProvideADisplayName)
{
	const std::string expected_display_name = "Test Item";
	const double dummy_price = 0;
	const Item item(expected_display_name, dummy_price);

	const auto actual_display_name = item.GetDisplayName();

	EXPECT_EQ(expected_display_name, actual_display_name);
}

TEST(ItemShould, ProvideAPrice)
{
	const double expected_price = 1;

	const std::string dummy_display_name = "Test Item";
	const double test_price = 1;
	const Item item(dummy_display_name, test_price);

	const auto actual_price = item.GetPrice();

	EXPECT_EQ(expected_price, actual_price);
}