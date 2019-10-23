#pragma once
#include "Item.h"
#include <vector>

class ItemList
{
public:
	std::vector<Item> GetItems() const;
	void AddItem(const Item& item);
	void RemoveItem(const Item& item);
	bool IsEmpty() const;
	bool operator==(const ItemList& rhs);
	bool operator==(ItemList& rhs);
private:
	std::vector<Item> Items;
};
