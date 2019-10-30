#include "pch.h"
#include "../VendingMachine/Item.h"
#include "../VendingMachine/VendingMachine.h"
#include "../VendingMachine/Credit.h"
#include "../VendingMachine/NoVendSelectionError.h"
#include "../VendingMachine/Rails.h"
#include "VendingMachineShould_F.h"

TEST_F(VendingMachineShould_F, ReturnZeroPriceWhenNoRailIsSelected)
{
	const double expectedPrice = 0;

	auto testVendingMachine = BuildTestVendingMachine();

	const auto actualPrice = testVendingMachine.GetSelectedRailPrice();

	EXPECT_EQ(actualPrice, expectedPrice);
}

TEST_F(VendingMachineShould_F, ReturnPriceOfSelectedRail)
{
	const double expectedPrice = 1;

	const std::string testRailCode = "T1";

	auto testVendingMachine = BuildTestVendingMachine();
	testVendingMachine.SelectRail(TEST_IN_STOCK_RAIL_CODE);

	const auto actualPrice = testVendingMachine.GetSelectedRailPrice();

	EXPECT_EQ(actualPrice, expectedPrice);
}

TEST_F(VendingMachineShould_F, ThrowExceptionOnVendWhenNoRailIsSelected)
{
	auto testVendingMachine = BuildTestVendingMachine();

	EXPECT_THROW(testVendingMachine.Vend(), NoVendSelectionError);
}

TEST_F(VendingMachineShould_F, ReturnFalseWhenCheckingIfCanVendWithNoRailSelected)
{
	auto testVendingMachine = BuildTestVendingMachine();

	const auto actualResult = testVendingMachine.CanVend();

	EXPECT_FALSE(actualResult);
}

TEST_F(VendingMachineShould_F, ReturnFalseWhenCheckingIfCanVendWithEmptySelectedRail)
{
	auto testVendingMachine = BuildTestVendingMachine();
	testVendingMachine.SelectRail(TEST_OUT_OF_STOCK_RAIL_CODE);

	const auto actualResult = testVendingMachine.CanVend();

	EXPECT_FALSE(actualResult);
}

TEST_F(VendingMachineShould_F, ReturnFalseWhenCheckingIfCanVendWithInsufficientCreditForSelectedRail)
{
	auto testVendingMachine = BuildTestVendingMachine();
	testVendingMachine.SelectRail(TEST_IN_STOCK_EXPENSIVE_RAIL_CODE);

	const auto actualResult = testVendingMachine.CanVend();

	EXPECT_FALSE(actualResult);
}

TEST_F(VendingMachineShould_F, LeaveZeroCreditValueWithExactCreditForVend)
{
	const double expectedRemainingCredit = 0;

	const double testCreditAmount = 1;

	auto testVendingMachine = BuildTestVendingMachine();
	testVendingMachine.SelectRail(TEST_IN_STOCK_RAIL_CODE);

	testVendingMachine.AddCredit(testCreditAmount);

	testVendingMachine.Vend();

	const auto actualRemainingCredit = testVendingMachine.GetCreditValue();

	EXPECT_EQ(actualRemainingCredit, expectedRemainingCredit);
}

TEST_F(VendingMachineShould_F, LeaveCorrectCreditWhenVendPriceIsLessThanCreditValue)
{
	const auto expectedRemainingCredit = 1;

	auto testVendingMachine = BuildTestVendingMachine();
	testVendingMachine.SelectRail(TEST_IN_STOCK_RAIL_CODE);

	const double testCreditAmount = 2;
	testVendingMachine.AddCredit(testCreditAmount);

	testVendingMachine.Vend();

	const auto actualRemainingCredit = testVendingMachine.GetCreditValue();

	EXPECT_EQ(actualRemainingCredit, expectedRemainingCredit);
}

TEST_F(VendingMachineShould_F, ClearRailSelectionAfterSuccessfulVend)
{
	const double expectedPriceWhenNoRailSelected = 0;

	auto testVendingMachine = BuildTestVendingMachine();
	testVendingMachine.SelectRail(TEST_IN_STOCK_RAIL_CODE);

	const double testCreditAmount = 1;
	testVendingMachine.AddCredit(testCreditAmount);

	testVendingMachine.Vend();

	const auto actualRailPrice = testVendingMachine.GetSelectedRailPrice();

	EXPECT_EQ(actualRailPrice, expectedPriceWhenNoRailSelected);
}

TEST_F(VendingMachineShould_F, DecrementRailInventoryAfterSuccessfulVend)
{
	const double expectedRemainingVendItemsSize = 0;

	auto testVendingMachine = BuildTestVendingMachine();
	testVendingMachine.SelectRail(TEST_IN_STOCK_RAIL_CODE);

	const double testCreditAmount = 2;
	testVendingMachine.AddCredit(testCreditAmount);

	testVendingMachine.Vend();

	testVendingMachine.SelectRail(TEST_IN_STOCK_RAIL_CODE);

	const auto actualResultAfterLastItemVended = testVendingMachine.CanVend();

	EXPECT_FALSE(actualResultAfterLastItemVended);
}

TEST_F(VendingMachineShould_F, ReturnFalseIfRailSelectionDoesNotExist)
{
	const std::string testNonExistentRailCode = "XX";

	const auto testVendingMachine = BuildTestVendingMachine();

	const auto actualResult = testVendingMachine.CanSelectRail(testNonExistentRailCode);

	EXPECT_FALSE(actualResult);
}

TEST_F(VendingMachineShould_F, ReturnTrueIfRailSelectionExists)
{
	const auto testVendingMachine = BuildTestVendingMachine();

	const auto actualResult = testVendingMachine.CanSelectRail(TEST_IN_STOCK_RAIL_CODE);

	EXPECT_TRUE(actualResult);
}

TEST_F(VendingMachineShould_F, ReturnRailsSummary)
{
	const auto testVendingMachine = BuildTestVendingMachine();
	
	auto actualRailsSummary = testVendingMachine.GetRailsSummary();
	
	EXPECT_EQ(actualRailsSummary.find(TEST_IN_STOCK_RAIL_CODE)->second, TEST_IN_STOCK_LABEL);
	EXPECT_EQ(actualRailsSummary.find(TEST_IN_STOCK_EXPENSIVE_RAIL_CODE)->second, TEST_IN_STOCK_EXPENSIVE_LABEL);
	EXPECT_EQ(actualRailsSummary.find(TEST_OUT_OF_STOCK_RAIL_CODE)->second, TEST_OUT_OF_STOCK_LABEL);
}
