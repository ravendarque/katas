#pragma once
#include "Item.h"
#include <vector>
#include "credit.h"

class VendingMachine
{
public:
	double CalculateTotalPrice() const;
	void AddItem(const Item& item);
	void ProcessTransaction(Credit& credit);
	bool ValidateTransaction(const Credit& credit) const;
private:
	std::vector<Item> Items;
	double TotalPrice = 0;
};
