#include "pch.h"
#include "Credit.h"
#include "InsufficientCreditException.h"

double Credit::GetValue() const
{
	return TotalValue;
}

void Credit::Add(const double value)
{
	TotalValue += value;;
}

void Credit::Spend(const double amount)
{
	if (amount > TotalValue)
		throw InsufficientCreditException();

	TotalValue -= amount;
}

bool Credit::ValidateSpend(const double amount) const
{
	return amount <= TotalValue;
}
