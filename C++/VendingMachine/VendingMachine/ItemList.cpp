#include "pch.h"
#include "ItemList.h"
#include <vector>
#include <algorithm>

std::vector<Item> ItemList::GetItems() const
{
	return Items;
}

void ItemList::AddItem(const Item& item)
{
	Items.push_back(item);
}

void ItemList::RemoveItem(const Item& item)
{
	if (IsEmpty())
		return;
	
	Items.erase(std::remove(Items.begin(), Items.end(), item), Items.end());
}

bool ItemList::IsEmpty() const
{
	return Items.empty();
}

bool ItemList::operator==(const ItemList& rhs)
{
	if (Items.size() != rhs.GetItems().size())
		return false;

	for (auto i = 0U;i < Items.size();i++)
		if (&Items.at(i) != &rhs.GetItems().at(i)) return false;

	return true;
}
