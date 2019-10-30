#include "pch.h"
#include "VendingMachine.h"
#include "NoVendSelectionError.h"
#include <algorithm>
#include <utility>

VendingMachine::VendingMachine(Rails& rails, const Credit& credit)
	: VendingMachineRails(std::move(rails)), VendingMachineCredit(credit)
{
}

double VendingMachine::GetSelectedRailPrice()
{
	return VendingMachineRails.HasSelectedRail()
		       ? VendingMachineRails.GetSelectedRail()->GetPrice()
		       : 0;
}

void VendingMachine::SelectRail(const std::string& railCode)
{
	if (VendingMachineRails.CanSelectRail(railCode))
		VendingMachineRails.SelectRail(railCode);
}

void VendingMachine::Vend()
{
	if (!VendingMachineRails.HasSelectedRail())
		throw NoVendSelectionError();

	auto selectedRail = VendingMachineRails.GetSelectedRail();
	VendingMachineCredit.Spend(selectedRail->GetPrice());
	selectedRail->Vend();
	VendingMachineRails.ClearRailSelection();
}

bool VendingMachine::CanVend()
{
	if (!VendingMachineRails.HasSelectedRail())
		return false;
	
	const auto selectedRail = VendingMachineRails.GetSelectedRail();
	return selectedRail->CanVend()
		&& VendingMachineCredit.CanSpend(selectedRail->GetPrice());
}

void VendingMachine::AddCredit(const double amount)
{
	VendingMachineCredit.Add(amount);
}

double VendingMachine::GetCreditValue() const
{
	return VendingMachineCredit.GetValue();
}

bool VendingMachine::CanSelectRail(const std::string& railCode) const
{
	return VendingMachineRails.CanSelectRail(railCode);
}

std::map<std::string, std::string> VendingMachine::GetRailsSummary() const
{
	return VendingMachineRails.GetRailsSummary();
}
