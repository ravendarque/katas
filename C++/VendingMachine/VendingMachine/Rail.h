#pragma once
#include <xstring>

class Rail
{
public:
	bool IsEmpty() const;
	double GetPrice() const;
	std::string GetLabel() const;
	void Vend();
	static void ValidateInitialInventory(unsigned int capacity, unsigned int initialInventory);
	static void ValidatePrice(double price);
	Rail(unsigned int capacity, unsigned int initialInventory, double price, std::string label);
private:
	const unsigned int Capacity;
	unsigned int Inventory;
	const double Price;
	const std::string Label;
};
