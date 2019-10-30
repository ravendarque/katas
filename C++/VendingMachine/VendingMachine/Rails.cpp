#include "pch.h"
#include "Rails.h"
#include <map>
#include "Rail.h"

Rails::Rails(const RailsConfiguration& railsConfiguration)
{
	for (const auto& settings : railsConfiguration.GetSettings())
	{
		auto configuredRail = new Rail(settings.GetInitialInventory(), settings.GetPrice(), settings.GetLabel());

		RailMap.insert(std::make_pair(settings.GetRailCode(), configuredRail));
		RailsSummaryMap.insert(std::make_pair(settings.GetRailCode(), settings.GetLabel()));
	}
}

bool Rails::CanSelectRail(const std::string& railCode) const
{
	return RailMap.find(railCode) != RailMap.end();
}

void Rails::SelectRail(const std::string& railCode)
{
	if (CanSelectRail(railCode))
		SelectedRail = railCode;
}

Rail* Rails::GetSelectedRail()
{
	return RailMap.find(SelectedRail)->second;
}

std::map<std::string, std::string> Rails::GetRailsSummary() const
{
	return RailsSummaryMap;
}

bool Rails::HasSelectedRail() const
{
	return !SelectedRail.empty();
}

void Rails::ClearRailSelection()
{
	SelectedRail.clear();
}
