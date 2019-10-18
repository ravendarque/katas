#include "pch.h"
#include "../VendingMachine/Item.h"
#include "../VendingMachine/VendingMachine.h"
#include "../VendingMachine/Credit.h"
#include "../VendingMachine/NoItemsInVendException.h"

TEST(VendingMachineShould, CalculateTotalPriceOfSelectedItemsAsZeroWithNoItemsSelected)
{
	const double expectedTotalPrice = 0;
	const VendingMachine testVendingMachine;

	const auto actualTotalPrice = testVendingMachine.CalculateTotalPrice();

	EXPECT_EQ(actualTotalPrice, expectedTotalPrice);
}

TEST(VendingMachineShould, CalculateTotalPriceOfSelectedItemsWithTwoItemsSelected)
{
	const double expectedTotalPrice = 2;

	const std::string dummyDisplayName = "Test item";
	const double testPrice = 1;
	const Item item1(dummyDisplayName, testPrice);
	const Item item2(dummyDisplayName, testPrice);

	VendingMachine testVendingMachine;
	testVendingMachine.AddItem(item1);
	testVendingMachine.AddItem(item2);

	const auto actualTotalPrice = testVendingMachine.CalculateTotalPrice();

	EXPECT_EQ(actualTotalPrice, expectedTotalPrice);
}

TEST(VendingMachineShould, ThrowExceptionWhenProcessingTransactionWithNoSelectedItems)
{
	Credit dummyCredit;
	VendingMachine testVendingMachine;

	EXPECT_THROW(testVendingMachine.ProcessTransaction(dummyCredit), NoItemsInVendException);
}

TEST(VendingMachineShould, ReturnFalseWhenValidatingVendWithNoSelectedItems)
{
	const Credit dummyCredit;
	const VendingMachine testVendingMachine;

	const auto actualResult = testVendingMachine.ValidateTransaction(dummyCredit);

	EXPECT_FALSE(actualResult);
}

TEST(VendingMachineShould, LeaveZeroCreditWithExactCreditForTransaction)
{
	const double expectedRemainingCredit = 0;

	const std::string dummyDisplayName = "Test item";
	const double testPrice = 1;
	const Item testItem(dummyDisplayName, testPrice);

	VendingMachine testVendingMachine;
	testVendingMachine.AddItem(testItem);

	Credit testCredit;
	const double testCreditAmount = 1;
	testCredit.Add(testCreditAmount);

	testVendingMachine.ProcessTransaction(testCredit);

	const auto actualRemainingCredit = testCredit.GetValue();

	EXPECT_EQ(actualRemainingCredit, expectedRemainingCredit);
}

TEST(VendingMachineShould, LeaveCorrectCreditWhenTransactionValueIsLessThanCreditValue)
{
}

TEST(VendingMachineShould, RemoveItemsFromInventoryAfterSuccessfulTransaction)
{
}
