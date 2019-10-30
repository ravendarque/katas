#pragma once
#include <string>

class Rail
{
public:
	Rail(unsigned int initialInventory, double price, std::string label);
	bool IsEmpty() const;
	double GetPrice() const;
	std::string GetLabel() const;
	void Vend();
	bool CanVend() const;
private:
	static void ValidatePrice(double price);
	unsigned int Inventory;
	const double Price;
	const std::string Label;
};
