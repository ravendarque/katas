#include "pch.h"
#include "Item.h"
#include <utility>

Item::Item(std::string displayName, const double price): DisplayName(std::move(displayName)), Price(price)
{
}

std::string Item::GetDisplayName() const
{
	return DisplayName;
}

double Item::GetPrice() const
{
	return Price;
}

bool Item::operator==(Item& rhs) const
{
	return (GetDisplayName() == rhs.GetDisplayName() &&
		GetPrice() == rhs.GetPrice());
}

bool Item::operator==(const Item& rhs) const
{
	return (GetDisplayName() == rhs.GetDisplayName() &&
		GetPrice() == rhs.GetPrice());
}
