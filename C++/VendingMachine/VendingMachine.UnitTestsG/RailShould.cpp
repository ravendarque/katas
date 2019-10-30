#include "pch.h"
#include "../VendingMachine/Rail.h"
#include "../VendingMachine/RailEmptyError.h"

static const int DUMMY_CAPACITY_1 = 1;
static const int DUMMY_INITIAL_INVENTORY_0 = 0;
static const double DUMMY_PRICE_0 = 0;
static const std::string DUMMY_LABEL = "Dummy label";

TEST(RailShould, ReturnTrueWhenCheckingIfRailWithNoItemsIsEmpty)
{
	const Rail testRail(DUMMY_INITIAL_INVENTORY_0, DUMMY_PRICE_0, DUMMY_LABEL);

	EXPECT_TRUE(testRail.IsEmpty());
}

TEST(RailShould, ReturnFalseWhenCheckingIfRailWithOneItemIsEmpty)
{
	const auto testInitialInventory = 1;

	const Rail testRail(testInitialInventory, DUMMY_PRICE_0, DUMMY_LABEL);

	EXPECT_FALSE(testRail.IsEmpty());
}

TEST(RailShould, ProvideAPrice)
{
	const auto expectedPrice = 1;

	const auto testPrice = 1;

	const Rail testRail(DUMMY_INITIAL_INVENTORY_0, testPrice, DUMMY_LABEL);

	const auto actualPrice = testRail.GetPrice();

	EXPECT_EQ(actualPrice, expectedPrice);
}

TEST(RailShould, ProvideALabel)
{
	const auto expectedLabel = "Test label";

	const std::string testLabel = "Test label";

	const Rail testRail(DUMMY_INITIAL_INVENTORY_0, DUMMY_PRICE_0, testLabel);

	const auto actualLabel = testRail.GetLabel();

	EXPECT_EQ(actualLabel, expectedLabel);
}

TEST(RailShould, ReturnTrueWhenCheckingIfRailIsEmptyAfterLastItemHasBeenVended)
{
	const auto testInitialInventory = 1;

	Rail testRail(testInitialInventory, DUMMY_PRICE_0, DUMMY_LABEL);
	testRail.Vend();

	EXPECT_TRUE(testRail.IsEmpty());
}

TEST(RailShould, ThrowErrorOnVendWhenRailIsEmpty)
{
	Rail testRail(DUMMY_INITIAL_INVENTORY_0, DUMMY_PRICE_0, DUMMY_LABEL);

	EXPECT_THROW(testRail.Vend(), RailEmptyError);
}

TEST(RailShould, ThrowErrorWhenPriceIsNegative)
{
	const auto testPrice = -1;

	EXPECT_THROW(
		Rail testRail(DUMMY_INITIAL_INVENTORY_0, testPrice, DUMMY_LABEL);,
		std::invalid_argument);
}
