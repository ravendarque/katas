#include "pch.h"
#include "Inventory.h"
#include <vector>
#include <algorithm>

std::vector<Item*> Inventory::GetItems() const
{
	return Items;
}

void Inventory::AddItem(Item& item)
{
	Items.push_back(&item);
}

bool Inventory::operator==(const Inventory& rhs) const
{
	if (Items.size() != rhs.GetItems().size())
		return false;

	for (auto i = 0U;i < Items.size();i++)
		if (&Items.at(i) != &rhs.GetItems().at(i)) return false;

	return true;
}

void Inventory::RemoveItem(Item& item)
{
	Items.erase(std::remove(Items.begin(), Items.end(), &item), Items.end());
}
