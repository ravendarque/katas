#include "pch.h"
#include "VendingMachine.h"
#include "NoItemsInVendException.h"

double VendingMachine::CalculateTotalPrice() const
{
	return TotalPrice;
}

void VendingMachine::AddItem(const Item& item)
{
	TotalPrice += item.GetPrice();
	Items.push_back(item);
}

void VendingMachine::ProcessTransaction(Credit& credit)
{
	if (Items.empty())
		throw NoItemsInVendException();

	credit.Spend(TotalPrice);
	TotalPrice = 0;
}

bool VendingMachine::ValidateTransaction(const Credit& credit) const
{
	return (credit.ValidateSpend(TotalPrice)) && !Items.empty();
}
