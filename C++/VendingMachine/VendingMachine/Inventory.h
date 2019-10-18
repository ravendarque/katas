#pragma once
#include "Item.h"
#include <vector>

class Inventory
{
public:
	std::vector<Item*> GetItems() const;
	void AddItem(Item& item);
	bool operator==(const Inventory& rhs) const;
	void RemoveItem(Item& item);
private:
	std::vector<Item*> Items;
};
