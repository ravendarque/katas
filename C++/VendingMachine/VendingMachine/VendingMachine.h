#pragma once
#include "Item.h"
#include <vector>
#include "Credit.h"
#include "ItemList.h"

class VendingMachine
{
public:
	explicit VendingMachine(ItemList& inventory, ItemList& selection);
	double CalculateTotalPrice() const;
	void SelectItem(const Item& item);
	void ProcessTransaction(Credit& credit);
	bool ValidateTransaction(const Credit credit) const;
	std::vector<Item> GetSelectedItems() const;
	std::vector<Item> GetInventoryItems() const;
private:
	double TotalPrice = 0;
	ItemList Inventory;
	ItemList Selection;
};
