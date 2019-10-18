#include "pch.h"
#include "../VendingMachine/Credit.h"
#include "../VendingMachine/InsufficientCreditException.h"

TEST(CreditShould, ProvideZeroValueWithNoCreditAdded)
{
	Credit credit;

	EXPECT_EQ(credit.GetValue(), 0);
}

TEST(CreditShould, ProvideValueEqualToSingleCreditAdded)
{
	Credit credit;
	const double expectedTotalCredit = 1;
	const double testCreditValue = 1;

	credit.Add(testCreditValue);

	EXPECT_EQ(credit.GetValue(), expectedTotalCredit);
}

TEST(CreditShould, ProvideValueEqualToSumOfMultipleCreditsAdded)
{
	Credit credit;
	const double expectedTotalCredit = 2;
	const double testCreditValue = 1;

	credit.Add(testCreditValue);
	credit.Add(testCreditValue);

	EXPECT_EQ(credit.GetValue(), expectedTotalCredit);
}

TEST(CreditShould, ThrowInsufficientCreditExceptionIfSpendIsGreaterThanTotalValue)
{
	Credit credit;
	
	const double testSpendAmount = 1;

	EXPECT_THROW(credit.Spend(testSpendAmount), InsufficientCreditException);
}

TEST(CreditShould, ReturnFalseWhenValidatingVendWithInsufficientCredit)
{
	const Credit credit;
	const double testSpendAmount  =1;

	const auto actualResult = credit.ValidateSpend(testSpendAmount);

	EXPECT_FALSE(actualResult);
}

TEST(CreditShould, LeaveZeroCreditAfterSpendEqualToTotalValue)
{
	Credit credit;
	const double testCreditAmount = 1;
	const double testSpendAmount = 1;

	credit.Add(testCreditAmount);
	credit.Spend(testSpendAmount);

	auto actualRemainingCredit = credit.GetValue();

	EXPECT_EQ(actualRemainingCredit, 0);
}

TEST(CreditShould, LeaveCorrectCreditAfterSpendLessThanTotalValue)
{
	const double testCreditValue = 2;
	const double testSpendAmount = 1;
	const double expectedRemainingCredit = 1;

	Credit credit;
	credit.Add(testCreditValue);
	credit.Spend(testSpendAmount);

	auto actualRemainingCredit = credit.GetValue();

	EXPECT_EQ(actualRemainingCredit, expectedRemainingCredit);
}
