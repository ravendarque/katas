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
	Credit credit;
	const double expectedTotalCredit = 1;
	const double testCreditValue = 1;

	credit.Add(testCreditValue);

	EXPECT_EQ(credit.GetValue(), expectedTotalCredit);
}

TEST(CreditShould, ReturnValueEqualToSumOfMultipleCreditsAdded)
{
	Credit credit;
	const double expectedTotalCredit = 2;
	const double testCreditValue = 1;

	credit.Add(testCreditValue);
	credit.Add(testCreditValue);

	EXPECT_EQ(credit.GetValue(), expectedTotalCredit);
}

TEST(CreditShould, ThrowExceptionIfSpendIsGreaterThanTotalValue)
{
	Credit credit;
	
	const double testSpendAmount = 1;

	EXPECT_THROW(credit.Spend(testSpendAmount), InsufficientCreditError);
}

TEST(CreditShould, ReturnFalseWhenValidatingSpendWithInsufficientCredit)
{
	const Credit credit;
	const double testSpendAmount  =1;

	const auto actualResult = credit.ValidateSpend(testSpendAmount);

	EXPECT_FALSE(actualResult);
}

TEST(CreditShould, ReturnZeroValueAfterSpendEqualToTotalValue)
{
	Credit credit;
	const double testCreditAmount = 1;
	const double testSpendAmount = 1;

	credit.Add(testCreditAmount);
	credit.Spend(testSpendAmount);

	auto actualRemainingCredit = credit.GetValue();

	EXPECT_EQ(actualRemainingCredit, 0);
}

TEST(CreditShould, ReturnRemainingValueAfterSpendLessThanTotalValue)
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
