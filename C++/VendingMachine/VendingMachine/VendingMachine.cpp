#include "pch.h"
#include "VendingMachine.h"
#include "NoItemsInVendException.h"
#include <algorithm>

VendingMachine::VendingMachine(ItemList& inventory, ItemList& selection)
	: Inventory(inventory), Selection(selection)
{
}

double VendingMachine::CalculateTotalPrice() const
{
	return TotalPrice;
}

void VendingMachine::SelectItem(const Item& item)
{
	TotalPrice += item.GetPrice();
	Selection.AddItem(item);
}

void VendingMachine::ProcessTransaction(Credit& credit)
{
	if (Selection.IsEmpty())
		throw NoItemsInVendException();

	credit.Spend(TotalPrice);
	TotalPrice = 0;
	for (auto& item : Selection.GetItems())
	{
		Inventory.RemoveItem(item);
		Selection.RemoveItem(item);
	}
}

bool VendingMachine::ValidateTransaction(const Credit credit) const
{
	return credit.ValidateSpend(TotalPrice) && !Selection.IsEmpty();
}

std::vector<Item> VendingMachine::GetSelectedItems() const
{
	return Selection.GetItems();
}

std::vector<Item> VendingMachine::GetInventoryItems() const
{
	return Inventory.GetItems();
}
