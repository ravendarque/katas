#pragma once

class Credit
{
public:
	double GetValue() const;
	void Add(double value);
	void Spend(double amount);
	bool ValidateSpend(double amount) const;
private:
	double TotalValue = 0;
};
