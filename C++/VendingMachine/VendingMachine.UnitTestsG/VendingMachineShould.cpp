#include "pch.h"
#include "../VendingMachine/Item.h"
#include "../VendingMachine/VendingMachine.h"
#include "../VendingMachine/Credit.h"
#include "../VendingMachine/NoItemsInVendException.h"

TEST(VendingMachineShould, CalculateTotalPriceOfSelectedItemsAsZeroWithNoItemsSelected)
{
	const double expectedTotalPrice = 0;
	ItemList testInventory;
	ItemList testSelection;

	const VendingMachine testVendingMachine(testInventory, testSelection);

	const auto actualTotalPrice = testVendingMachine.CalculateTotalPrice();

	EXPECT_EQ(actualTotalPrice, expectedTotalPrice);
}

TEST(VendingMachineShould, CalculateTotalPriceOfSelectedItemsWithTwoItemsSelected)
{
	const double expectedTotalPrice = 2;

	const std::string dummyDisplayName = "Test item";
	const double testPrice = 1;
	const Item testItem1(dummyDisplayName, testPrice);
	const Item testItem2(dummyDisplayName, testPrice);

	ItemList testInventory;
	testInventory.AddItem(testItem1);
	testInventory.AddItem(testItem2);

	ItemList testSelection;

	VendingMachine testVendingMachine(testInventory, testSelection);
	testVendingMachine.SelectItem(testItem1);
	testVendingMachine.SelectItem(testItem2);

	const auto actualTotalPrice = testVendingMachine.CalculateTotalPrice();

	EXPECT_EQ(actualTotalPrice, expectedTotalPrice);
}

TEST(VendingMachineShould, ThrowExceptionWhenProcessingTransactionWithNoSelectedItems)
{
	Credit dummyCredit;
	ItemList testInventory;
	ItemList testSelection;

	VendingMachine testVendingMachine(testInventory, testSelection);

	EXPECT_THROW(testVendingMachine.ProcessTransaction(dummyCredit), NoItemsInVendException);
}

TEST(VendingMachineShould, ReturnFalseWhenValidatingVendWithNoSelectedItems)
{
	const Credit dummyCredit;
	ItemList testInventory;
	ItemList testSelection;

	const VendingMachine testVendingMachine(testInventory, testSelection);

	const auto actualResult = testVendingMachine.ValidateTransaction(dummyCredit);

	EXPECT_FALSE(actualResult);
}

TEST(VendingMachineShould, LeaveZeroCreditWithExactCreditForTransaction)
{
	const double expectedRemainingCredit = 0;

	const std::string dummyDisplayName = "Test item";
	const double testPrice = 1;
	const Item testItem(dummyDisplayName, testPrice);

	ItemList testInventory;
	testInventory.AddItem(testItem);

	ItemList testSelection;

	VendingMachine testVendingMachine(testInventory, testSelection);
	testVendingMachine.SelectItem(testItem);

	Credit testCredit;
	const double testCreditAmount = 1;
	testCredit.Add(testCreditAmount);

	testVendingMachine.ProcessTransaction(testCredit);

	const auto actualRemainingCredit = testCredit.GetValue();

	EXPECT_EQ(actualRemainingCredit, expectedRemainingCredit);
}

TEST(VendingMachineShould, LeaveCorrectCreditWhenTransactionValueIsLessThanCreditValue)
{
	const double expectedRemainingCredit = 1.5;

	const std::string dummyDisplayName = "Test item";
	const double testPrice = 1.5;
	const Item testItem(dummyDisplayName, testPrice);

	ItemList testInventory;
	testInventory.AddItem(testItem);

	ItemList testSelection;

	VendingMachine testVendingMachine(testInventory, testSelection);
	testVendingMachine.SelectItem(testItem);

	Credit testCredit;
	const double testCreditAmount = 3;
	testCredit.Add(testCreditAmount);

	testVendingMachine.ProcessTransaction(testCredit);

	const auto actualRemainingCredit = testCredit.GetValue();

	EXPECT_EQ(actualRemainingCredit, expectedRemainingCredit);
}

TEST(VendingMachineShould, RemoveItemsFromVendAfterSuccessfulTransaction)
{
	const double expectedRemainingVendItemsSize = 0;

	const std::string dummyDisplayName = "Test item";
	const double testPrice = 1;
	const Item testItem(dummyDisplayName, testPrice);

	ItemList testInventory;
	testInventory.AddItem(testItem);

	ItemList testSelection;

	VendingMachine testVendingMachine(testInventory, testSelection);
	testVendingMachine.SelectItem(testItem);

	Credit testCredit;
	const double testCreditAmount = 1;
	testCredit.Add(testCreditAmount);

	testVendingMachine.ProcessTransaction(testCredit);

	const auto actualRemainingVendItemsSize = testVendingMachine.GetSelectedItems().size();

	EXPECT_EQ(actualRemainingVendItemsSize, expectedRemainingVendItemsSize);
}

TEST(VendingMachineShould, RemoveItemsFromInventoryAfterSuccessfulTransaction)
{
	const double expectedRemainingInventorySize = 0;

	const std::string dummyDisplayName = "Test item";
	const double testPrice = 1;
	const Item testItem(dummyDisplayName, testPrice);

	ItemList testInventory;
	testInventory.AddItem(testItem);

	ItemList testSelection;

	VendingMachine testVendingMachine(testInventory, testSelection);
	testVendingMachine.SelectItem(testItem);

	Credit testCredit;
	const double testCreditAmount = 1;
	testCredit.Add(testCreditAmount);

	testVendingMachine.ProcessTransaction(testCredit);

	const auto actualRemainingInventorySize = testVendingMachine.GetInventoryItems().size();

	EXPECT_EQ(actualRemainingInventorySize, expectedRemainingInventorySize);
}
