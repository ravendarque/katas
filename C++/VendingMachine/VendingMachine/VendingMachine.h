#pragma once
#include "Credit.h"
#include "Rails.h"

class VendingMachine
{
public:
	VendingMachine(Rails& rails, const Credit& credit);
	double GetSelectedRailPrice();
	void SelectRail(const std::string& railCode);
	void Vend();
	bool CanVend();
	void AddCredit(const double amount);
	double GetCreditValue() const;
	bool CanSelectRail(const std::string& railCode) const;
	std::map<std::string, std::string> GetRailsSummary() const;
private:
	Rails VendingMachineRails;
	Credit VendingMachineCredit;
};
