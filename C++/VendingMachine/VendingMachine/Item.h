#pragma once
#include <xstring>

class Item
{
public:
	Item(std::string displayName, double price);
	std::string GetDisplayName() const;
	double GetPrice() const;
	bool operator==(const Item& rhs) const;
private:
	std::string DisplayName;
	double Price;
};