#pragma once
#include <xstring>
#include "RailsConfiguration.h"
#include "Rail.h"
#include <map>

class Rails
{
public:
	explicit Rails(const RailsConfiguration& railsConfiguration);
	bool CanSelectRail(const std::string& railCode) const;
	void SelectRail(const std::string& railCode);
	Rail* GetSelectedRail();
	std::map<std::string, std::string> GetRailsSummary() const;
	bool HasSelectedRail() const;
	void ClearRailSelection();
private:
	std::map<std::string, Rail*> RailMap;
	std::map<std::string, std::string> RailsSummaryMap;
	std::string SelectedRail = "";
};

