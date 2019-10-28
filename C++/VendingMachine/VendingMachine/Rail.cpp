#include "pch.h"
#include "Rail.h"
#include <utility>
#include "RailEmptyError.h"

Rail::Rail(const unsigned int capacity, const unsigned int initialInventory, const double price, std::string label):
	Capacity(capacity), Inventory(initialInventory), Price(price), Label(std::move(label))
{
	ValidateInitialInventory(capacity, initialInventory);
	ValidatePrice(price);
}

std::string Rail::GetLabel() const
{
	return Label;
}

double Rail::GetPrice() const
{
	return Price;
}

bool Rail::IsEmpty() const
{
	return Inventory == 0;
}

void Rail::Vend()
{
	if (IsEmpty())
		throw RailEmptyError();

	Inventory--;
}

void Rail::ValidateInitialInventory(const unsigned int capacity, const unsigned int initialInventory)
{
	if (initialInventory > capacity)
		throw std::invalid_argument("Initial inventory cannot be greater than rail capacity");
}

void Rail::ValidatePrice(const double price)
{
	if (price < 0)
		throw std::invalid_argument("Price cannot be negative");
}

