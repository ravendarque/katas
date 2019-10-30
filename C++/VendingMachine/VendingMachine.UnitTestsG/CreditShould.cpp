#include "pch.h"
#include "../VendingMachine/Credit.h"
#include "../VendingMachine/InsufficientCreditError.h"

TEST(CreditShould, ReturnZeroValueWithNoCreditAdded)
{
	Credit credit;

	EXPECT_EQ(credit.GetValue(), 0);
}

TEST(CreditShould, ReturnValueEqualToSingleCreditAdded)
{
	const double expectedCreditValue = 1;

	const double testCreditValue = 1;

	Credit credit;
	credit.Add(testCreditValue);

	const auto actualCreditValue = credit.GetValue();
	
	EXPECT_EQ(actualCreditValue, expectedCreditValue);
}

TEST(CreditShould, ReturnValueEqualToSumOfMultipleCreditsAdded)
{
	const double expectedCreditValue = 2;

	const double testCreditValue = 1;

	Credit credit;
	credit.Add(testCreditValue);
	credit.Add(testCreditValue);

	const auto actualCreditValue = credit.GetValue();
	
	EXPECT_EQ(actualCreditValue, expectedCreditValue);
}

TEST(CreditShould, ThrowExceptionIfSpendIsGreaterThanTotalValue)
{
	const double testSpendAmount = 1;

	Credit credit;

	EXPECT_THROW(credit.Spend(testSpendAmount), InsufficientCreditError);
}

TEST(CreditShould, ReturnFalseWhenValidatingSpendWithInsufficientCredit)
{
	const double testSpendAmount = 1;

	const Credit credit;
	const auto actualResult = credit.CanSpend(testSpendAmount);

	EXPECT_FALSE(actualResult);
}

TEST(CreditShould, ReturnZeroValueAfterSpendEqualToTotalValue)
{
	const double expectedRemainingValue = 0;

	const double testCreditValue = 1;
	const double testSpendValue = 1;

	Credit credit;
	credit.Add(testCreditValue);
	credit.Spend(testSpendValue);

	auto actualRemainingValue = credit.GetValue();

	EXPECT_EQ(actualRemainingValue, expectedRemainingValue);
}

TEST(CreditShould, ReturnRemainingValueAfterSpendLessThanTotalValue)
{
	const double expectedRemainingValue = 1;

	const double testCreditValue = 2;
	const double testSpendValue = 1;

	Credit credit;
	credit.Add(testCreditValue);
	credit.Spend(testSpendValue);

	auto actualRemainingValue = credit.GetValue();

	EXPECT_EQ(actualRemainingValue, expectedRemainingValue);
}
